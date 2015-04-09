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
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.HashMap;

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

    /**
     * Creates a trip from a JSON structure
     * @param stringifiedJsonInfos
     * @param stringifiedJsonPlaces
     * @param user
     * @return the url of a created trip
     */
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

    /**
     * Creates a copied trip from an existent one
     * @param idTripToCopy
     * @param stringifiedJsonSteps
     * @param user
     * @return the url of the new trip
     */
    @Secured("ROLE_USER")
    @RequestMapping(value = "/copy/{idTripToCopy}", method = RequestMethod.POST)
    @ResponseBody
    public String postCopy(@PathVariable Integer idTripToCopy,
                           @RequestParam(value = "steps", required = true) String stringifiedJsonSteps,
                           @AuthenticationPrincipal User user)
    {
        Trip tripToClone = tripService.findById(idTripToCopy);

        // Parsing JSON...
        HashMap<Integer, DateTime> dateTimeHashMap = new HashMap<Integer, DateTime>();
        JSONArray jsonStepsArray = (JSONArray) JSONValue.parse(stringifiedJsonSteps);
        for (int i = 0; i < jsonStepsArray.size(); i++)
        {
            JSONObject jsonStep = (JSONObject) jsonStepsArray.get(i);
            dateTimeHashMap.put(Integer.valueOf((String) jsonStep.get("step")), DateTime.parse(((String) jsonStep.get("date") + " " + (String) jsonStep.get("time")), DateTimeFormat.forPattern("dd/MM/yyyy HH:mm")));
        }

        // Creating architecture...
        Trip clonedTrip = new Trip(tripToClone);
        tripService.create(clonedTrip);

        // Adding Steps...
        for (Step stepToClone : tripToClone.getSteps())
        {
            Step clonedStep = new Step(stepToClone, clonedTrip);
            clonedStep.setEstimatedTime(dateTimeHashMap.get(stepToClone.getIdStep()));

            stepService.create(clonedStep);
        }

        return JSONValue.toJSONString(clonedTrip.getIdTrip());
    }
}
