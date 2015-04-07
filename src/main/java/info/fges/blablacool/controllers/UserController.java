package info.fges.blablacool.controllers;

import info.fges.blablacool.models.Subscription;
import info.fges.blablacool.models.User;
import info.fges.blablacool.models.UserPreference;
import info.fges.blablacool.services.BookingService;
import info.fges.blablacool.services.UserPreferenceService;
import info.fges.blablacool.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

/**
 * Created by Nicolas on 3/25/2015.
 */
@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserPreferenceService userPreferenceService;

    @Autowired
    private BookingService bookingService;

    @Secured("ROLE_USER")
    @RequestMapping(value = "/update", method = RequestMethod.GET)
    public ModelAndView getUserSettings(@AuthenticationPrincipal User user,
                                        ModelAndView modelAndView)
    {
        User userToUpdate = userService.findById(user.getId());
        modelAndView.setViewName("users/settings");
        modelAndView.addObject("user",userToUpdate); // We can't just use the User from Spring Security as it is not refreshed!
        modelAndView.addObject("preferences", userPreferenceService.findById(userToUpdate.getPreferences().getIdUserPreference()));
        modelAndView.addObject("musicStyles", UserPreference.getMusicStyles());

        return modelAndView;
    }

    @Secured("ROLE_USER")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ModelAndView getUser(@AuthenticationPrincipal User user,
                                @PathVariable("id") Integer id,
                                ModelAndView modelAndView)
    {
        modelAndView.setViewName("users/profile");
        modelAndView.addObject("user", user);
        modelAndView.addObject("viewedUser", userService.findById(1));

        return modelAndView;
    }

    @Secured("ROLE_USER")
    @RequestMapping(value = "/me", method = RequestMethod.GET)
    public ModelAndView getLoggedInUser(@AuthenticationPrincipal User principal,
                                        ModelAndView modelAndView)
    {
        modelAndView.setViewName("users/profile");
        return modelAndView;
    }

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

    @Secured("ROLE_USER")
    @RequestMapping(value = "/passenger", method = RequestMethod.GET)
    public ModelAndView getPassenger(@AuthenticationPrincipal User user,
                                     ModelAndView modelAndView)
    {
        modelAndView.setViewName("users/passenger");
        modelAndView.addObject("user", userService.findById(user.getId()));
        modelAndView.addObject("bookingWaitingReviews", bookingService.findToReviewForUser(user.getId()));

        return modelAndView;
    }

    @Secured("ROLE_USER")
    @RequestMapping(value = "/updateUser", method = RequestMethod.POST)
    public String getUserUpdate(@AuthenticationPrincipal User loggedUser,@Valid @ModelAttribute("user") User user, BindingResult bindingResult,ModelAndView modelAndView)
    {
        User userToUpdate = userService.findById(loggedUser.getId());
        userToUpdate.setFirstname(user.getFirstname());
        userToUpdate.setLastname(user.getLastname());
        userToUpdate.setAge(user.getAge());
        userToUpdate.setCity(user.getCity());
        userToUpdate.setCountry(user.getCountry());
        userToUpdate.setEmail(user.getEmail());
        userToUpdate.setPhoneNumber(user.getPhoneNumber());
        userToUpdate.setState(user.getState());
        userToUpdate.setPostcode(user.getPostcode());
        userToUpdate.setAddress(user.getAddress());
        userToUpdate.setRoles(user.getRoles());
        userToUpdate.setPassword(loggedUser.getPassword());
        userToUpdate.setPasswordConfirmation(loggedUser.getPasswordConfirmation());
        // System.out.println(userToUpdate.getPassword());
        userService.update(userToUpdate);
       // Authentication authentication = new UsernamePasswordAuthenticationToken(user,user.getPassword(),user.getAuthorities());
       // SecurityContextHolder.getContext().setAuthentication(authentication);
        return "redirect:/users/me";
    }

    @Secured("ROLE_USER")
    @RequestMapping(value = "/updateUserPreferences", method = RequestMethod.POST)
    public String getUserUpdatePreferences(@AuthenticationPrincipal User user,@Valid @ModelAttribute("preferences") UserPreference preferences, BindingResult bindingResult,ModelAndView modelAndView)
    {
        System.out.println(preferences.getTemperament());
        preferences.setIdUserPreference(user.getPreferences().getIdUserPreference());
        preferences.setUser(user);
        userPreferenceService.update(preferences);
        return "redirect:/users/me";
    }

}
