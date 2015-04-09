package info.fges.blablacool.controllers;

import com.stripe.Stripe;
import com.stripe.exception.*;
import com.stripe.model.Charge;
import info.fges.blablacool.models.Booking;
import info.fges.blablacool.models.Payment;
import info.fges.blablacool.models.User;
import info.fges.blablacool.services.BookingService;
import info.fges.blablacool.services.PaymentService;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Nicolas on 4/7/2015.
 */
@Controller
@RequestMapping("/payments")
public class PaymentController {

    @Autowired
    ServletContext servletContext;

    @Autowired
    private BookingService bookingService;

    @Autowired
    private PaymentService paymentService;

    /**
     * uses the payment token from Strip checkout to generate a charge using the Sripe Api (using testing keys)
     * @param authenticatedUser
     * @param idBooking
     * @param stripeToken
     * @param stripeEmail
     * @return the booking page
     * @throws CardException
     * @throws APIException
     * @throws AuthenticationException
     * @throws InvalidRequestException
     * @throws APIConnectionException
     */
    @RequestMapping("/charge-booking/{idBooking}")
    public String postReturnFromStripe(@AuthenticationPrincipal User authenticatedUser,
                                      @PathVariable Integer idBooking,
                                      @RequestParam String stripeToken,
                                      @RequestParam String stripeEmail)
            throws CardException, APIException, AuthenticationException, InvalidRequestException, APIConnectionException
    {
        Booking bookingPaying = bookingService.findById(idBooking);

        Stripe.apiKey = servletContext.getInitParameter("stripeSecretKey");
        Map<String, Object> chargeParameters = new HashMap<String, Object>();
        chargeParameters.put("amount", bookingPaying.getTrip().getPrice().multiply(new BigDecimal(100)).intValue());
        chargeParameters.put("currency", "EUR");
        chargeParameters.put("source", stripeToken);
        chargeParameters.put("description", "Covoiturage " + bookingPaying.getTrip().getDepartureStep().getPlace().getCity() + " > " + bookingPaying.getTrip().getArrivalStep().getPlace().getCity());

        Map<String, Object> initialMetadata = new HashMap<String, Object>();
        initialMetadata.put("idBooking", bookingPaying.getId());

        chargeParameters.put("metadata", initialMetadata);

        Charge charge = Charge.create(chargeParameters);

        if (charge.getPaid())
        {
            Payment payment = new Payment();
            payment.setAmount(bookingPaying.getTrip().getPrice());
            payment.setBooking(bookingPaying);
            payment.setPaymentMethod("STRIPE");
            payment.setCreatedAt(DateTime.now());
            payment.setReceipt(charge.toString());

            paymentService.create(payment);

            return "redirect:/booking/" + bookingPaying.getId();
        }
        else
        {
            return "redirect:/payment/error";
        }
    }


}
