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

    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public ModelAndView getNew(ModelAndView modelAndView)
    {
        modelAndView.setViewName("trips/new");
        modelAndView.addObject("departureAddress", new Place());
        modelAndView.addObject("arrivalAddress", new Place());

        return modelAndView;
    }

    @RequestMapping(value = "/new", method = RequestMethod.POST)
    @ResponseBody
    public String postNew(@ModelAttribute("departureAddress") Place departureAddress,
                          @ModelAttribute("arrivalAddress") Place arrivalAddress,
                          ModelAndView modelAndView)
    {
        System.out.println(departureAddress);

        return "Sumitted";
    }

    @Secured("ROLE_USER")
    @RequestMapping(value = "/test", method = RequestMethod.GET)
    @ResponseBody
    public String getTest(@AuthenticationPrincipal User user)
    {
        System.out.println(user);

        User driver = userService.findById(1);

        Trip trip = new Trip();
        trip.setDriver(driver);
        trip.setCapacity(Short.valueOf("5"));
        tripService.create(trip);

        Place place = new Place(driver);
        placeService.create(place);

        Step step = new Step();
        step.setPlace(place);
        step.setTrip(trip);
        step.setPosition(1);
        step.setEstimatedTime(DateTime.parse("01/01/1970 19:42", DateTimeFormat.forPattern("dd/MM/yyyy HH:mm")));
        stepService.create(step);

        System.out.println(trip.toString() + place.toString() + step.toString());


        return "Sumitted";
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
