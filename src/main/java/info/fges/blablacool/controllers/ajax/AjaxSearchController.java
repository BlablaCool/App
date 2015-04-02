package info.fges.blablacool.controllers.ajax;

import info.fges.blablacool.models.Search;
import info.fges.blablacool.models.SearchPoint;
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
                             @RequestParam(value = "arrival", required = true) String stringifiedJsonArrival)
    {
        System.out.println(searchService.findTripsWithAddresses(stringifiedJsonDeparture, stringifiedJsonArrival, stringifiedJsonInfos));

        return "ok";
    }
}
