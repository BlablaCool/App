package info.fges.blablacool.controllers;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Valentin on 23/03/15.
 */
@Controller
@RequestMapping("/trips")
public class TripController
{
    @Secured("USER")
    @RequestMapping(value = {"", "/"}, method = RequestMethod.GET)
    @ResponseBody
    public String getIndex()
    {
        return "Index Trips";
    }
}
