package info.fges.blablacool.controllers;

import info.fges.blablacool.models.Trip;
import info.fges.blablacool.models.TripHasPlaces;
import info.fges.blablacool.models.User;
import info.fges.blablacool.services.TripService;
import info.fges.blablacool.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class HelloController
{
	@Autowired
    private TripService tripService;

    @RequestMapping(method = RequestMethod.GET)
	public String printWelcome(ModelMap model)
    {
        Trip trip = tripService.findById(1);

        System.out.println(trip.getLeftSeats());

        for (User pass : trip.getPassengers())
        {
            System.out.println(pass.getFirstname() + " " + pass.getLastname());
        }

        for (TripHasPlaces thp : trip.getTripHasPlaces())
        {
            System.out.println(thp.getEstimatedTime());
        }

        model.addAttribute("message", "Hello world!");
		return "hello";
	}
}