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
public class TripController
{
    @Autowired
    private TripService tripService;

    @Autowired
    private UserService userService;

    @Autowired
    private StepService stepService;

    @Autowired
    private MessageService messageService;

    @RequestMapping(value = {"", "/"}, method = RequestMethod.GET)
    public ModelAndView getIndex(ModelAndView modelAndView)
    {
        modelAndView.setViewName("trips/list");
        modelAndView.addObject("trips", tripService.findRecents());

        return modelAndView;
    }

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

    @Secured("ROLE_SUBSCRIBED")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ModelAndView getTrip(@AuthenticationPrincipal User user,
                                @PathVariable("id") Integer id,
                                ModelAndView modelAndView)
    {
        modelAndView.setViewName("trips/get");
        modelAndView.addObject("trip", tripService.findById(id));

        return modelAndView;
    }

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
            System.out.println(_message);
            messageService.create(new Message(_message, tripService.findById(_idTrip), _user));
        }

        return "redirect:/trips/" + _idTrip + "#messagesList";
    }

    @Secured("ROLE_SUBSCRIBED")
    @RequestMapping(value = "/copy/{id}", method = RequestMethod.GET)
    public String getCopyTrip(@AuthenticationPrincipal User user,
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

        return "redirect:/trips/" + clonedTrip.getIdTrip() + "/edit";
    }
}
