package info.fges.blablacool.controllers.ajax;

import info.fges.blablacool.models.Place;
import info.fges.blablacool.models.Step;
import info.fges.blablacool.models.Trip;
import info.fges.blablacool.models.User;
import info.fges.blablacool.services.PlaceService;
import info.fges.blablacool.services.StepService;
import info.fges.blablacool.services.TripService;
import info.fges.blablacool.services.UserService;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.math.BigDecimal;

/**
 * Created by Valentin on 23/03/15.
 */
@Controller
@RequestMapping("/ajax/places")
public class AjaxPlaceController
{
    @Autowired
    private TripService tripService;

    @Autowired
    private PlaceService placeService;

    @Autowired
    private UserService userService;

    @Autowired
    private StepService stepService;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public String postAdd(@RequestParam(value = "places", required = true) String stringifiedJsonPlaces)
    {
        User driver = userService.findById(1);

        Trip trip = new Trip();
        trip.setDriver(driver);
        trip.setCapacity(Short.valueOf("5"));
        tripService.create(trip);

        System.out.println(trip);

        JSONArray jsonPlaces = (JSONArray) JSONValue.parse(stringifiedJsonPlaces);

        for (int i = 0; i < jsonPlaces.size(); i++)
        {
            JSONObject jsonPlace = (JSONObject) jsonPlaces.get(i);

            Place place = new Place();
            place.setCountry((String) jsonPlace.get("country"));
            place.setCountryShort((String) jsonPlace.get("country_short"));
            place.setAddress((String) jsonPlace.get("formatted_address"));
            place.setLatitude(new BigDecimal((String) jsonPlace.get("lat")));
            place.setLongitude(new BigDecimal((String) jsonPlace.get("lng")));
            place.setLongitude(new BigDecimal((String) jsonPlace.get("lng")));
            place.setCity((String) jsonPlace.get("locality"));
            place.setLocation((String) jsonPlace.get("location"));
            place.setNamePublic((String) jsonPlace.get("name"));

            place.setPostalCode((String) jsonPlace.get("postal_code"));
            place.setStreetNumber((String) jsonPlace.get("street_number"));

            place.setNamePrivate("Private");
            place.setStreet("Street");

            placeService.create(place);
            System.out.println(place);

            Step step = new Step(trip, place, i+1);
            stepService.create(step);
            System.out.println(step);
        }

        return stringifiedJsonPlaces;
    }
}
