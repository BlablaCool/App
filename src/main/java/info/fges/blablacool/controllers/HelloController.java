package info.fges.blablacool.controllers;

import info.fges.blablacool.models.Trip;
import info.fges.blablacool.models.TripHasPlaces;
import info.fges.blablacool.models.User;
import info.fges.blablacool.services.TripService;
import info.fges.blablacool.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/")
public class HelloController
{
	@Autowired
    private UserService uS;

    @RequestMapping(method = RequestMethod.GET)
	public String printWelcome(ModelMap model)
    {
        String password = "polopolo";
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String hashedPassword = passwordEncoder.encode(password);
        System.out.println(hashedPassword);

        model.addAttribute("message", hashedPassword);
		return "home";
	}

    @RequestMapping({"test", "test1", "test2"})
    @ResponseBody
    public String getTest()
    {
        return "<h2>Test</h2>";
    }

    @RequestMapping({"login"})
    public String getLogin()
    {
        return "auth/login";
    }

    @RequestMapping({"logout"})
    @ResponseBody
    public String getLogout()
    {
        return "<h2>Logout</h2>";
    }
}