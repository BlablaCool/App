package info.fges.blablacool.controllers;

import info.fges.blablacool.exceptions.AccessForbiddenException;
import info.fges.blablacool.exceptions.ResourceNotFoundException;
import info.fges.blablacool.models.Booking;
import info.fges.blablacool.models.User;
import info.fges.blablacool.services.BookingService;
import info.fges.blablacool.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Valentin on 29/03/15.
 */
@Controller
@RequestMapping("/booking")
@Secured("ROLE_USER")
public class BookingController
{
    @Autowired
    private BookingService bookingService;

    @Autowired
    private UserService userService;

    @RequestMapping("/{id}")
    public ModelAndView getConfirmationPage(@AuthenticationPrincipal User principal,
                                            @PathVariable("id") Integer idBooking,
                                            ModelAndView modelAndView) throws ResourceNotFoundException
    {
        Booking booking = bookingService.findById(idBooking);
        User user = userService.findById(principal.getId());

        if (booking == null)
        {
            throw new ResourceNotFoundException();
        }
        else if (booking.getUser().getId() != user.getId())
        {
            throw new AccessForbiddenException();
        }
        else if (booking.getStatus().contentEquals("PENDING"))
        {
            modelAndView.setViewName("booking/pending");
        }

        modelAndView.addObject("booking", booking);
        modelAndView.addObject("user", user);

        return modelAndView;
    }
}
