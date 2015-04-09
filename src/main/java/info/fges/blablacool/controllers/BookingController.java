package info.fges.blablacool.controllers;

import info.fges.blablacool.exceptions.AccessForbiddenException;
import info.fges.blablacool.exceptions.ResourceNotFoundException;
import info.fges.blablacool.models.Booking;
import info.fges.blablacool.models.Review;
import info.fges.blablacool.models.User;
import info.fges.blablacool.services.BookingService;
import info.fges.blablacool.services.ReviewService;
import info.fges.blablacool.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import java.awt.print.Book;

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

    @Autowired
    private ReviewService reviewService;

    @Autowired
    private ServletContext servletContext;

    /**+
     *
     * @param principal
     * @param idBooking
     * @param modelAndView
     * @return the booking confirmation page
     * @throws ResourceNotFoundException
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
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
        else if (booking.isAccepted())
        {
            modelAndView.setViewName("booking/accepted");
        }
        else if (booking.isPending())
        {
            modelAndView.setViewName("booking/pending");
        }
        else if (booking.isDeclined())
        {
            modelAndView.setViewName("booking/declined");
        }
        else if (booking.isCancelled())
        {
            modelAndView.setViewName("booking/cancelled");
        }

        modelAndView.addObject("booking", booking);
        modelAndView.addObject("user", user);
        modelAndView.addObject("stripePublicKey", servletContext.getInitParameter("stripePublicKey"));

        return modelAndView;
    }

    /**
     * deletes a booking
     * @param principal
     * @param idBooking
     * @param cancelBooking
     * @param modelAndView
     * @return the booking page
     * @throws ResourceNotFoundException
     */
    @RequestMapping(value = "/{id}/delete", method = RequestMethod.POST)
    public String postDeleteBooking(@AuthenticationPrincipal User principal,
                                    @PathVariable("id") Integer idBooking,
                                    @RequestParam(value = "cancelBooking", required = true) String cancelBooking,
                                    ModelAndView modelAndView) throws ResourceNotFoundException
    {
        Booking booking = bookingService.findById(idBooking);

        if (booking == null)
        {
            throw new ResourceNotFoundException();
        }
        else if (booking.getUser().getId() != principal.getId())
        {
            throw new AccessForbiddenException();
        }

        bookingService.cancelBooking(booking);

        return "redirect:/booking/" + booking.getId();
    }

    /**
     *
     * @param user
     * @param idBooking
     * @param modelAndView
     * @return the review page for a booking
     */
    @RequestMapping(value = "/{id}/review", method = RequestMethod.GET)
    public ModelAndView getReview(@AuthenticationPrincipal User user,
                                  @PathVariable("id") Integer idBooking,
                                  ModelAndView modelAndView)
    {
        Booking booking = bookingService.findById(idBooking);

        if (booking.getUser().getId() != user.getId() || booking.hasBeenReviewedByUser(user.getId()))
        {
            throw new AccessForbiddenException();
        }

        modelAndView.setViewName("booking/review");
        modelAndView.addObject("booking", bookingService.findById(idBooking));

        return modelAndView;
    }

    /**
     * Create a review for a booking
     * @param user
     * @param idBooking
     * @param rating
     * @param comment
     * @param modelAndView
     * @return the review success page
     */
    @RequestMapping(value = "/{id}/review", method = RequestMethod.POST)
    public ModelAndView postReview(@AuthenticationPrincipal User user,
                                   @PathVariable("id") Integer idBooking,
                                   @RequestParam(value = "rating", required = true) Integer rating,
                                   @RequestParam(value = "comment", required = false) String comment,
                                   ModelAndView modelAndView)
    {
        Booking booking = bookingService.findById(idBooking);

        if (booking.getUser().getId() != user.getId() || booking.hasBeenReviewedByUser(user.getId()))
        {
            throw new AccessForbiddenException();
        }

        if (comment.contentEquals(""))
        {
            comment = null;
        }

        reviewService.create(new Review(rating, comment, user, booking));

        modelAndView.setViewName("booking/review-success");

        return modelAndView;
    }
}
