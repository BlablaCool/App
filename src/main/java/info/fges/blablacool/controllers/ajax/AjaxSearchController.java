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

import java.util.HashMap;
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

    /**
     * Creates a search from addresses and geolocation
     * @param stringifiedJsonInfos
     * @param stringifiedJsonDeparture
     * @param stringifiedJsonArrival
     * @param stringifiedJsonGeolocation
     * @return JSON list of trips
     */
    @RequestMapping(value = {"", "/"}, method = RequestMethod.POST)
    @ResponseBody
    public String postSearch(@RequestParam(value = "infos", required = true) String stringifiedJsonInfos,
                             @RequestParam(value = "departure", required = true) String stringifiedJsonDeparture,
                             @RequestParam(value = "arrival", required = true) String stringifiedJsonArrival,
                             @RequestParam(value = "geolocation", required = true) String stringifiedJsonGeolocation)
    {
        JSONObject jsonObject = (JSONObject) JSONValue.parse(stringifiedJsonInfos);

        if (jsonObject.containsKey("enableGeolocation"))
        {
            return JSONValue.toJSONString(searchService.getSearchUrlForTripsNearbyLocation(stringifiedJsonGeolocation, stringifiedJsonArrival, stringifiedJsonInfos));
        }
        else
        {
            return JSONValue.toJSONString(searchService.getSearchUrlForTripsWithAddresses(stringifiedJsonDeparture, stringifiedJsonArrival, stringifiedJsonInfos));
        }
    }
}
