package info.fges.blablacool.controllers.ajax;

import info.fges.blablacool.exceptions.AccessForbiddenException;
import info.fges.blablacool.exceptions.ResourceNotFoundException;
import info.fges.blablacool.models.Booking;
import info.fges.blablacool.models.Trip;
import info.fges.blablacool.models.User;
import info.fges.blablacool.services.BookingService;
import info.fges.blablacool.services.TripService;
import info.fges.blablacool.services.UserService;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.awt.print.Book;
import java.util.HashMap;

/**
 * Created by Valentin on 29/03/15.
 */
@Controller
@RequestMapping("/ajax/booking")
public class AjaxBookingController
{
    @Autowired
    private TripService tripService;

    @Autowired
    private BookingService bookingService;

    @Autowired
    private UserService userService;

    @Secured("ROLE_SUBSCRIBED")
    @RequestMapping(value = "/new/{id}")
    @ResponseBody
    public ResponseEntity<String> postNew(@PathVariable("id") Integer idTrip,
                          @AuthenticationPrincipal User loggedUser)
    {
        Trip trip = tripService.findById(idTrip);
        User user = userService.findById(loggedUser.getId());

        if (!bookingService.alreadyExists(trip.getIdTrip(), user.getId()))
        {
            Booking booking = new Booking(trip, user, "PENDING");
            bookingService.create(booking);

            HashMap<String, String> jsonContent = new HashMap<String, String>();
            jsonContent.put("created", String.valueOf(booking.getId()));

            return new ResponseEntity<String>(JSONObject.toJSONString(jsonContent), HttpStatus.OK);
        }

        return new ResponseEntity<String>(JSONObject.toString("created", false), HttpStatus.CONFLICT);
    }

    @Secured("ROLE_SUBSCRIBED")
    @RequestMapping(value = "/new/{id}")
    @ResponseBody
    public String postAccept(@PathVariable("id") Integer idBooking,
                                             @AuthenticationPrincipal User loggedUser)
    {
        Booking booking = bookingService.findById(idBooking);

        if (booking == null)
        {
            throw new ResourceNotFoundException();
        }
        else if (booking.getTrip().getDriver().getId() != loggedUser.getId())
        {
            throw new AccessForbiddenException();
        }

        booking.setStatus("ACCEPTED");
        bookingService.update(booking);

        return "UPDATED";
    }
}
