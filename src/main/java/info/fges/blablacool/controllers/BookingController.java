package info.fges.blablacool.controllers;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
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
    @RequestMapping("/{id}/confirm")
    public ModelAndView getConfirmationPage(ModelAndView modelAndView)
    {
        modelAndView.setViewName("booking/confirm");

        return modelAndView;
    }
}
