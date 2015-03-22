package info.fges.blablacool.controllers;

import info.fges.blablacool.models.Role;
import info.fges.blablacool.models.User;
import info.fges.blablacool.services.RoleService;
import info.fges.blablacool.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Valentin on 22/03/15.
 */
@Controller
@RequestMapping("/auth")
public class AuthController
{
    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

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

        /**
         * Hashing the password...
         */
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String hashedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(hashedPassword);

        /**
         * We persist the validated User...
         */
        userService.create(user);

        /**
         * Adding a role...
         */
        List<Role> roleList = new ArrayList<Role>();
        roleList.add(roleService.findById(2));
        user.setRoles(roleList);

        /**
         * We persist the validated User's roles
         */
        userService.create(user);

        return "redirect:/auth/registered";
    }

    @RequestMapping("/registered")
    public String getRegistered()
    {
        return "auth/registered";
    }
}
