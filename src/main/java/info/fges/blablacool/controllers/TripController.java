package info.fges.blablacool.controllers;

import info.fges.blablacool.models.Place;
import info.fges.blablacool.models.Step;
import info.fges.blablacool.models.Trip;
import info.fges.blablacool.models.User;
import info.fges.blablacool.services.PlaceService;
import info.fges.blablacool.services.StepService;
import info.fges.blablacool.services.TripService;
import info.fges.blablacool.services.UserService;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.text.DateFormat;
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
    private PlaceService placeService;

    @Autowired
    private StepService stepService;

    @Secured("ROLE_USER")
    @RequestMapping(value = {"", "/"}, method = RequestMethod.GET)
    @ResponseBody
    public String getIndex()
    {
        return "Index Trips";
    }

    @Secured("ROLE_SUBSCRIBED")
    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public ModelAndView getNew(@AuthenticationPrincipal User user, ModelAndView modelAndView)
    {
        modelAndView.setViewName("trips/new");
        modelAndView.addObject("departureAddress", new Place());
        modelAndView.addObject("arrivalAddress", new Place());
        modelAndView.addObject("driver", user);

        return modelAndView;
    }

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public ModelAndView getSearch()
    {
        ModelAndView mv = new ModelAndView("trips/search");

        List<Trip> trips;
        trips = tripService.findAll();

        /*for (Trip trip : trips) {
            trip.getTripHasPlaces().get().getPlace().getPublicName()
            /*User user = trip.getDriver();
            Car car = trip.;
        }*/

        mv.addObject("lTrips", trips);

        return mv;
    }

}
