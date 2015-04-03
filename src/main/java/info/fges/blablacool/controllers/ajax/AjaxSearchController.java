package info.fges.blablacool.controllers.ajax;

import info.fges.blablacool.models.Search;
import info.fges.blablacool.models.SearchPoint;
import info.fges.blablacool.models.Trip;
import info.fges.blablacool.services.SearchService;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by Valentin on 02/04/15.
 */
@Controller
@RequestMapping("/ajax/search")
public class AjaxSearchController
{
    @Autowired
    private SearchService searchService;

    @RequestMapping(value = {"", "/"}, method = RequestMethod.POST)
    @ResponseBody
    public String postSearch(@RequestParam(value = "infos", required = true) String stringifiedJsonInfos,
                             @RequestParam(value = "departure", required = true) String stringifiedJsonDeparture,
                             @RequestParam(value = "arrival", required = true) String stringifiedJsonArrival,
                             @RequestParam(value = "geolocation", required = true) String stringifiedJsonGeolocation)
    {
        JSONObject jsonObject = (JSONObject) JSONValue.parse(stringifiedJsonInfos);

        // Checking if Geolocation is enabled
        if (jsonObject.containsKey("enableGeolocation"))
        {
            List<Trip> trips = searchService.findTripsNearbyLocation(stringifiedJsonGeolocation, stringifiedJsonArrival, stringifiedJsonInfos);

            for (Trip trip : trips)
            {
                System.out.println(trip.getDepartureStep().getPlace().getCity() + " --> " + trip.getArrivalStep().getPlace().getCity());
            }
        }
        else
        {
            System.out.println(searchService.findTripsWithAddresses(stringifiedJsonDeparture, stringifiedJsonArrival, stringifiedJsonInfos));
        }

        return "ok";
    }
}
