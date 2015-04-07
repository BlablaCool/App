package info.fges.blablacool.controllers;

import com.stripe.Stripe;
import com.stripe.exception.*;
import com.stripe.model.Charge;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
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

    @RequestMapping(value = "/charge", method=RequestMethod.POST,
            consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public ResponseEntity<String> setPayment(HttpServletRequest request) throws CardException, APIException, AuthenticationException, InvalidRequestException, APIConnectionException {
        Stripe.apiKey = servletContext.getInitParameter("stripeSecretKey");

        Map<String, String[]> parameterMap = request.getParameterMap();
        Map<String, Object> chargeParams = new HashMap<String, Object>();
        chargeParams.put("amount", 400);
        chargeParams.put("currency", "usd");
        chargeParams.put("source", parameterMap.get("stripeToken")[0]);
        chargeParams.put("description", "Charge for test@example.com");
        Map<String, String> initialMetadata = new HashMap<String, String>();
        initialMetadata.put("order_id", "6735");
        chargeParams.put("metadata", initialMetadata);

        Charge.create(chargeParams);
        return new ResponseEntity<String>(HttpStatus.OK);
    }


}
