package info.fges.blablacool.controllers;

import info.fges.blablacool.models.Trip;
import info.fges.blablacool.services.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by Hugo on 24/03/2015.
 */
@Controller
@RequestMapping("/trips")
@Scope("request")
public class TripController {

    @Autowired
    private TripService tripService;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView getTrips()
    {
        ModelAndView mv = new ModelAndView("search/trip");

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
