package info.fges.blablacool.controllers.ajax;

import info.fges.blablacool.models.Place;
import info.fges.blablacool.models.Step;
import info.fges.blablacool.models.Trip;
import info.fges.blablacool.models.User;
import info.fges.blablacool.services.PlaceService;
import info.fges.blablacool.services.StepService;
import info.fges.blablacool.services.TripService;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.math.BigDecimal;

/**
 * Created by Valentin on 26/03/15.
 */
@Controller
@RequestMapping("/ajax/trips")
public class AjaxTripController
{
    @Autowired
    private TripService tripService;

    @Autowired
    private PlaceService placeService;

    @Autowired
    private StepService stepService;

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    @ResponseBody
    public String getTest()
    {
        return "test";
    }

    @Secured("ROLE_USER")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public String postAdd(@RequestParam(value = "infos", required = true) String stringifiedJsonInfos,
                          @RequestParam(value = "places", required = true) String stringifiedJsonPlaces,
                          @AuthenticationPrincipal User user)
    {
        /**
         * Creating the Trip with the dedicated data...
         */
        Trip trip = new Trip((JSONObject) JSONValue.parse(stringifiedJsonInfos), user);
        tripService.create(trip);

        JSONArray jsonPlaces = (JSONArray) JSONValue.parse(stringifiedJsonPlaces);
        for (int i = 0; i < jsonPlaces.size(); i++)
        {
            JSONObject jsonPlace = (JSONObject) jsonPlaces.get(i);

            /**
             * Creating the Place object...
             */
            Place place = new Place(jsonPlace, user);
            placeService.create(place);

            /**
             * Creating the Step object with Place saved before...
             */
            String dateTimeAsString = jsonPlace.get("date") + " " + jsonPlace.get("time");
            Step step = new Step(trip, place, i+1, DateTime.parse(dateTimeAsString, DateTimeFormat.forPattern("dd/MM/yyyy HH:mm")));
            stepService.create(step);
        }

        return JSONValue.toJSONString("/trips/" + trip.getIdTrip());
    }
}
