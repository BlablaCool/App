package info.fges.blablacool.controllers.ajax;

import info.fges.blablacool.services.UserService;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Valentin on 22/03/15.
 */
@Controller
@RequestMapping("/ajax/auth")
public class AjaxAuthController
{
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/check-username", method = RequestMethod.POST)
    @ResponseBody
    public String postCheckUsername(@RequestParam("nickname") String nickname)
    {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("valid", !userService.nicknameAlreadyExists(nickname));

        return jsonObject.toString();
    }

    @RequestMapping(value = "/check-email", method = RequestMethod.POST)
    @ResponseBody
    public String postCheckEmail(@RequestParam("email") String email)
    {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("valid", !userService.emailAlreadyExists(email));

        return jsonObject.toString();
    }
}
