package info.fges.blablacool.controllers;

import info.fges.blablacool.models.Subscription;
import info.fges.blablacool.models.User;
import info.fges.blablacool.models.UserPreference;
import info.fges.blablacool.services.BookingService;
import info.fges.blablacool.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Nicolas on 3/25/2015.
 */
@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private BookingService bookingService;

/*
    @ExceptionHandler(Throwable.class)
    public String handleException(Throwable t) {
        return "redirect:/errors/500.jsp";
    }
*/

    @Secured("ROLE_USER")
    @RequestMapping(value = "/update", method = RequestMethod.GET)
    public ModelAndView getUserSettings(@AuthenticationPrincipal User user,
                                        ModelAndView modelAndView)
    {
        modelAndView.setViewName("users/settings");
        modelAndView.addObject("user", userService.findById(user.getId())); // We can't just use the User from Spring Security as it is not refreshed!
        modelAndView.addObject("musicStyles", UserPreference.getMusicStyles());

        return modelAndView;
    }

    @Secured("ROLE_USER")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ModelAndView getUser(@AuthenticationPrincipal User user,
                                ModelAndView modelAndView, @PathVariable("id") Integer id )
    {
        modelAndView.setViewName("users/profile");
        modelAndView.addObject("user", user);
        modelAndView.addObject("viewedUser",userService.findById(id));
        return modelAndView;
    }

    @Secured("ROLE_USER")
    @RequestMapping(value = "/{id}/history", method = RequestMethod.GET)
    public ModelAndView getUserPastTrips(ModelAndView modelAndView , @PathVariable("id") Integer id )
    {
        modelAndView.setViewName("users/trip-history");
        return modelAndView;
    }

    @Secured("ROLE_USER")
    @RequestMapping(value = "/plans", method = RequestMethod.GET)
    public ModelAndView getPlans(@AuthenticationPrincipal User user,
                           ModelAndView modelAndView)
    {
        modelAndView.setViewName("users/plans");
        modelAndView.addObject("user", userService.findById(user.getId()));

        System.out.println(user.hasActiveSubscription());

        for(Subscription sub : user.getSubscriptions())
        {
            System.out.println(sub.getFrom());
        }

        return modelAndView;
    }

    @Secured("ROLE_USER")
    @RequestMapping(value = "/driver", method = RequestMethod.GET)
    public ModelAndView getPendingBooking(@AuthenticationPrincipal User user,
                                          ModelAndView modelAndView)
    {
        modelAndView.setViewName("users/driver");
        modelAndView.addObject("user", userService.findById(user.getId()));
        modelAndView.addObject("pendingBooking", bookingService.findPendingForUser(user.getId()));

        return modelAndView;
    }


}
