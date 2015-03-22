package info.fges.blablacool.controllers;

import info.fges.blablacool.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

/**
 * Created by Valentin on 22/03/15.
 */
@Controller
@RequestMapping("/auth")
public class AuthController
{
    @RequestMapping(value = "/login-register", method = RequestMethod.GET)
    public ModelAndView getLoginRegister(ModelAndView modelAndView)
    {
        modelAndView.setViewName("auth/login-register");
        modelAndView.addObject("newUser", new User());

        return modelAndView;
    }

    @RequestMapping(value = "/login-register", method = RequestMethod.POST)
    public String postRegister(@Valid @ModelAttribute("newUser") User user,
                                     BindingResult bindingResult)
    {
        if (bindingResult.hasErrors())
        {
            return "auth/login-register";
        }

        return "redirect:/";
    }
}
