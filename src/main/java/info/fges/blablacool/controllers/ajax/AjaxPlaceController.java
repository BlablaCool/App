package info.fges.blablacool.controllers.ajax;

import org.json.simple.JSONArray;
import org.json.simple.JSONValue;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Valentin on 23/03/15.
 */
@Controller
@RequestMapping("/ajax/places")
public class AjaxPlaceController
{
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public String postAdd(@RequestParam(value = "places", required = true) String stringifiedJsonPlaces)
    {
        JSONArray jsonPlaces = (JSONArray) JSONValue.parse(stringifiedJsonPlaces);
        System.out.println(jsonPlaces.size());

        return stringifiedJsonPlaces;
    }
}
