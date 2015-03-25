package info.fges.blablacool.controllers;

import info.fges.blablacool.models.User;
import info.fges.blablacool.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Nicolas on 3/25/2015.
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/view/{id}", method = RequestMethod.GET)
    public ModelAndView getProfile(ModelAndView modelAndView , @PathVariable("id") Integer id )
    {
        modelAndView.setViewName("user/user-profile");
        return modelAndView;
    }


}
