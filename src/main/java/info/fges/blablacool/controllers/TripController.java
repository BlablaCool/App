package info.fges.blablacool.controllers;

import info.fges.blablacool.exceptions.AccessForbiddenException;
import info.fges.blablacool.models.*;
import info.fges.blablacool.services.*;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.security.Principal;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Valentin on 23/03/15.
 */
@Controller
@RequestMapping("/trips")
@SessionAttributes(value="user",types=User.class)
public class TripController
{
    @Autowired
    private TripService tripService;

    @Autowired
    private UserService userService;

    @Autowired
    private StepService stepService;

    @Autowired
    private ServletContext servletContext;

    @Autowired
    private MessageService messageService;

    /**
     *
     * @param modelAndView
     * @return the view containing all the unfiltered trips
     */
    @RequestMapping(value = {"", "/"}, method = RequestMethod.GET)
    public ModelAndView getIndex(ModelAndView modelAndView)
    {
        modelAndView.setViewName("trips/list");
        modelAndView.addObject("trips", tripService.findRecents());

        return modelAndView;
    }

    /**
     *
     * @param user
     * @param modelAndView
     * @return the view used to create a new trip
     */
    @Secured("ROLE_SUBSCRIBED")
    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public ModelAndView getNew(@AuthenticationPrincipal User user, ModelAndView modelAndView)
    {
        modelAndView.setViewName("trips/new");
        modelAndView.addObject("departureAddress", new Place());
        modelAndView.addObject("arrivalAddress", new Place());
        modelAndView.addObject("driver", userService.findById(user.getId()));

        return modelAndView;
    }

    /**
     *
     * @param user
     * @param id
     * @param modelAndView
     * @return the trip page
     */
    @Secured("ROLE_SUBSCRIBED")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ModelAndView getTrip(@AuthenticationPrincipal User user,
                                @PathVariable("id") Integer id,
                                ModelAndView modelAndView)
    {
        String stripeApiPublicKey = servletContext.getInitParameter("stripePublicKey");
        modelAndView.setViewName("trips/get");
        modelAndView.addObject("stripePublicKey",stripeApiPublicKey);
        modelAndView.addObject("trip", tripService.findById(id));

        return modelAndView;
    }

    /**
     * Adds a message to a trip and sends mail to creator
     * @param _user
     * @param _idTrip
     * @param _message
     * @param request
     * @param modelAndView
     * @return the trip page  with new messages
     */
    @Secured("ROLE_SUBSCRIBED")
    @RequestMapping(value = "/{id}/add-message", method = RequestMethod.POST)
    public String addMessageToTrip(@AuthenticationPrincipal User _user,
                                   @PathVariable("id") Integer _idTrip,
                                   @RequestParam("message") String _message,
                                   HttpServletRequest request,
                                   ModelAndView modelAndView)
    {
        try {
            request.setCharacterEncoding("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        if (!_message.contentEquals(""))
        {
            _message = _message.replaceAll("[\r\n]+", "\n");
            _message = _message.replaceAll("\n", "<br />");

            messageService.create(new Message(_message, tripService.findById(_idTrip), _user));
        }

        return "redirect:/trips/" + _idTrip + "#messagesList";
    }

    /**
     *
     * @param user
     * @param id
     * @param modelAndView
     * @return the new trip page, copied from a previously created trip
     */
    @Secured("ROLE_SUBSCRIBED")
    @RequestMapping(value = "/copy/{id}", method = RequestMethod.GET)
    public ModelAndView getCopyTrip(@AuthenticationPrincipal User user,
                              @PathVariable("id") Integer id,
                              ModelAndView modelAndView)
    {
        Trip tripToClone = tripService.findById(id);
        if (tripToClone.getDriver().getId() != user.getId())
        {
            throw new AccessForbiddenException();
        }
        // Creating architecture...
        Trip clonedTrip = new Trip(tripToClone);
        tripService.create(clonedTrip);

        // Adding Steps...
        for (Step stepToClone : tripToClone.getSteps())
        {
            stepService.create(new Step(stepToClone, clonedTrip));
        }
        modelAndView.setViewName("trips/copy");
        modelAndView.addObject("trip", tripToClone);

        return modelAndView;
    }
}
