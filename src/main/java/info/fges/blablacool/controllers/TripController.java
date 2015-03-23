package info.fges.blablacool.controllers;

import info.fges.blablacool.models.Place;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Valentin on 23/03/15.
 */
@Controller
@RequestMapping("/trips")
public class TripController
{
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
}
