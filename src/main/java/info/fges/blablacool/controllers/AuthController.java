package info.fges.blablacool.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Valentin on 22/03/15.
 */
@Controller
@RequestMapping("/auth")
public class AuthController
{
    @RequestMapping(value = "/login-register", method = RequestMethod.GET)
    public String getLoginRegister()
    {
        return "auth/login-register";
    }
}
