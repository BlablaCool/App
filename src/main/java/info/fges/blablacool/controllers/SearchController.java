package info.fges.blablacool.controllers;

import org.joda.time.DateTime;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * Created by Valentin on 04/04/15.
 */
@Controller
@RequestMapping("/search")
public class SearchController
{
    @RequestMapping("/{departureLatitude}/{departureLongitude}/{arrivalCity}/{departureTime}")
    @ResponseBody
    public String getSearchWithGeolocation(@PathVariable String departureLatitude,
                                           @PathVariable String departureLongitude,
                                           @PathVariable String arrivalCity,
                                           @PathVariable String departureTime)
    {
        return departureLatitude + " " + departureLongitude + " " + URLDecoder.decode(arrivalCity) + " " + departureTime;
    }

    @RequestMapping("/{departureCity}/{arrivalCity}/{departureTime}")
    @ResponseBody
    public String getSearchWithAddresses(@PathVariable String departureCity,
                                         @PathVariable String arrivalCity,
                                         @PathVariable String departuretime)
    {
        return departureCity + " " + arrivalCity + " " + departuretime;
    }


}
