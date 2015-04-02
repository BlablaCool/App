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
import org.springframework.web.bind.annotation.*;
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

    @RequestMapping(value = {"", "/"}, method = RequestMethod.GET)
    public ModelAndView getIndex(ModelAndView modelAndView)
    {
        modelAndView.setViewName("trips/list");
        modelAndView.addObject("recentTrips", tripService.findRecents());

        for (Trip trip : tripService.findRecents())
        {
            System.out.println(trip.getDepartureStep().getPlace().getCity());
            trip.getCapacity();
            trip.getDriver().getNickname();
        }

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
