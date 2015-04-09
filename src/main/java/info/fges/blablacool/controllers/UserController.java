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

import javax.servlet.ServletContext;
import javax.validation.Valid;
import java.util.List;

/**
 * Created by Nicolas on 3/25/2015.
 */
@Controller
@RequestMapping("/users")
@SessionAttributes(value="user",types=User.class)
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private BookingService bookingService;

    @Autowired
    private UserPreferenceService userPreferenceService;

    @Autowired
    private ServletContext servletContext;

    /**
     *
     * @param user
     * @param modelAndView
     * @return the user profile edit page
     */
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

    /**
     *
     * @param user 
     * @param id 
     * @param modelAndView 
     * @return the user profile page
     */
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

    /**
     *
     * @param principal 
     * @param modelAndView 
     * @return the 's own profile page
     */
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

    /**
     *
     * @param modelAndView 
     * @param id 
     * @return the page containing a user's past trips
     */
    @RequestMapping(value = "/{id}/history", method = RequestMethod.GET)
    public ModelAndView getUserPastTrips(ModelAndView modelAndView , @PathVariable("id") Integer id )
    {
        modelAndView.setViewName("users/trip-history");
        return modelAndView;
    }

    /**
     *
     * @param user 
     * @param modelAndView
     * @return the page listing the 's subscriptions
     */
    @Secured("ROLE_USER")
    @RequestMapping(value = "/plans", method = RequestMethod.GET)
    public ModelAndView getPlans(@AuthenticationPrincipal User user,
                           ModelAndView modelAndView)
    {
        String stripeApiPublicKey = servletContext.getInitParameter("stripePublicKey");

        modelAndView.setViewName("users/plans");
        modelAndView.addObject("user", userService.findById(user.getId()));
        modelAndView.addObject("stripePublicKey", stripeApiPublicKey);

        return modelAndView;
    }

    /**
     *
     * @param user 
     * @param modelAndView
     * @return the page listing the authenticated user's cars
     */
    @Secured("ROLE_USER")
    @RequestMapping(value = "/cars", method = RequestMethod.GET)
    public ModelAndView getCars(@AuthenticationPrincipal User user,
                                ModelAndView modelAndView)
    {
        modelAndView.setViewName("users/cars");
        modelAndView.addObject("user", userService.findById(user.getId()));

        return modelAndView;
    }

    /**
     *
     * @param user 
     * @param modelAndView
     * @return the page
     */
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


    /**
     *
     * @param user 
     * @param modelAndView
     * @return
     */
    @Secured("ROLE_USER")
    @RequestMapping(value = "/passenger", method = RequestMethod.GET)
    public ModelAndView getPassenger(@AuthenticationPrincipal User user,
                                     ModelAndView modelAndView)
    {
        List<Booking> bookingList = bookingService.findToReviewForUser(user.getId());

        modelAndView.setViewName("users/passenger");
        modelAndView.addObject("user", userService.findById(user.getId()));
        modelAndView.addObject("bookingWaitingReviews", bookingService.findToReviewForUser(user.getId()));

        return modelAndView;
    }

    /**
     * Updates a user, we can't user the form's user object since it is missing some parameters
     * @param authenticatedUser 
     * @param updatedUser
     * @return the user's settings page
     */
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

        // Updating Spring Security User's Details (thanks to Nico!)
        Authentication authentication = new UsernamePasswordAuthenticationToken(authenticatedUser, authenticatedUser.getPassword(), authenticatedUser.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authentication);

        return "redirect:/users/settings";
    }

    /**
     * Updates a user's preferences, we can't user the form's user object since it is missing some parameters
     * @param authenticatedUser 
     * @param updatedUserPreferences
     * @return the user's settings page
     */
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
