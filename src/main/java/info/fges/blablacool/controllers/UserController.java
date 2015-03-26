package info.fges.blablacool.controllers;

import info.fges.blablacool.models.User;
import info.fges.blablacool.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Nicolas on 3/25/2015.
 */
@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/update", method = RequestMethod.GET)
    public ModelAndView getUserSettings(ModelAndView modelAndView)
    {
        modelAndView.setViewName("user/settings");
        return modelAndView;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ModelAndView getUser(ModelAndView modelAndView , @PathVariable("id") Integer id )
    {
        modelAndView.setViewName("user/profile");
        return modelAndView;
    }

    @RequestMapping(value = "/{id}/history", method = RequestMethod.GET)
    public ModelAndView getUserPastTrips(ModelAndView modelAndView , @PathVariable("id") Integer id )
    {
        modelAndView.setViewName("user/trip-history");
        return modelAndView;
    }


}
