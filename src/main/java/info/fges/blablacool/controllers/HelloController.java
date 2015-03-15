package info.fges.blablacool.controllers;

import info.fges.blablacool.models.TripHasPlaces;
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
        System.out.println(tripService.findById(1).getTripHasPlaces());
        for(TripHasPlaces thp : tripService.findById(1).getTripHasPlaces())
        {
            System.out.println(thp.getPlace().getLatitude());
        }

        model.addAttribute("message", "Hello world!");
		return "hello";
	}
}