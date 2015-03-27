package info.fges.blablacool.controllers;

import info.fges.blablacool.models.User;
import info.fges.blablacool.models.UserPreference;
import info.fges.blablacool.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;
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

    @Secured("ROLE_USER")
    @RequestMapping(value = "/update", method = RequestMethod.GET)
    public ModelAndView getUserSettings(@AuthenticationPrincipal User user,
                                        ModelAndView modelAndView)
    {
        modelAndView.setViewName("user/settings");
        modelAndView.addObject("user", userService.findById(user.getId())); // We can't just use the User from Spring Security as it is not refreshed!
        modelAndView.addObject("musicStyles", UserPreference.getMusicStyles());

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
