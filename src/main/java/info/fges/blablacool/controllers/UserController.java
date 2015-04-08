package info.fges.blablacool.controllers;

import info.fges.blablacool.models.*;
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
import java.util.List;

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

    @Autowired
    private UserPreferenceService userPreferenceService;

    @Secured("ROLE_USER")
    @RequestMapping(value = "/settings", method = RequestMethod.GET)
    public ModelAndView getUserSettings(@AuthenticationPrincipal User user,
                                        ModelAndView modelAndView)
    {
        User userToEdit = userService.findById(user.getId());

        modelAndView.setViewName("users/settings");
        modelAndView.addObject("user", userToEdit); // We can't just use the User from Spring Security as it is not refreshed!
        modelAndView.addObject("userPreferences", userToEdit.getPreferences());
        modelAndView.addObject("musicStyles", UserPreference.getMusicStyles());
        modelAndView.addObject("temperaments", UserPreference.getTemperaments());
        modelAndView.addObject("talkingLevels", UserPreference.getTalkingLevels());
        modelAndView.addObject("drivingStyles", UserPreference.getDrivingStyles());

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
        modelAndView.addObject("viewedUser", userService.findById(id));

        return modelAndView;
    }

    @Secured("ROLE_USER")
    @RequestMapping(value = "/me", method = RequestMethod.GET)
    public ModelAndView getLoggedInUser(@AuthenticationPrincipal User principal,
                                        ModelAndView modelAndView)
    {
        User user = userService.findById(principal.getId());

        modelAndView.setViewName("users/profile");
        modelAndView.addObject("user", user);
        modelAndView.addObject("viewedUser", user);

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
    public ModelAndView getDriver(@AuthenticationPrincipal User user,
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
        List<Booking> bookingList = bookingService.findToReviewForUser(user.getId());

        System.out.println(bookingList);

        modelAndView.setViewName("users/passenger");
        modelAndView.addObject("user", userService.findById(user.getId()));
        modelAndView.addObject("bookingWaitingReviews", bookingService.findToReviewForUser(user.getId()));

        return modelAndView;
    }

    @Secured("ROLE_USER")
    @RequestMapping(value = "/updateUser", method = RequestMethod.POST)
    public String postUpdateUser(@AuthenticationPrincipal User authenticatedUser,
                                 @ModelAttribute("user") User updatedUser)
    {
        authenticatedUser = userService.findById(authenticatedUser.getId());

        authenticatedUser.setFirstname(updatedUser.getFirstname());
        authenticatedUser.setLastname(updatedUser.getLastname());
        authenticatedUser.setEmail(updatedUser.getEmail());
        authenticatedUser.setPhoneNumber(updatedUser.getPhoneNumber());
        authenticatedUser.setAddress(updatedUser.getAddress());
        authenticatedUser.setPostcode(updatedUser.getPostcode());
        authenticatedUser.setCity(updatedUser.getCity());
        authenticatedUser.setState(updatedUser.getState());
        authenticatedUser.setCountry(updatedUser.getCountry());

        userService.update(authenticatedUser);

        return "redirect:/users/settings";
    }

    @Secured("ROLE_USER")
    @RequestMapping(value = "/updateUserPreferences", method = RequestMethod.POST)
    public String postUpdateUserPreferences(@AuthenticationPrincipal User authenticatedUser,
                                            @ModelAttribute("userPreferences") UserPreference updatedUserPreferences)
    {
        UserPreference originalUserPreferences = userPreferenceService.findById(updatedUserPreferences.getIdUserPreference());

        originalUserPreferences.setLikeAnimals(updatedUserPreferences.getLikeAnimals());
        originalUserPreferences.setLikeSmoking(updatedUserPreferences.getLikeSmoking());
        originalUserPreferences.setDrivingStyle(updatedUserPreferences.getDrivingStyle());
        originalUserPreferences.setMusicStyle(updatedUserPreferences.getMusicStyle());
        originalUserPreferences.setOthers(updatedUserPreferences.getOthers());
        originalUserPreferences.setTalkingLevel(updatedUserPreferences.getTalkingLevel());
        originalUserPreferences.setTemperament(updatedUserPreferences.getTemperament());

        userPreferenceService.update(originalUserPreferences);

        return "redirect:/users/settings";
    }

}
