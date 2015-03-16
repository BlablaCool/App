package info.fges.blablacool.controllers;

import info.fges.blablacool.models.Trip;
import info.fges.blablacool.models.TripHasPlaces;
import info.fges.blablacool.models.User;
import info.fges.blablacool.services.TripService;
import info.fges.blablacool.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
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
        User user = uS.findById(1);

        System.out.println(user.getRoles());

        model.addAttribute("message", "Hello world!");
		return "hello";
	}

    @RequestMapping({"test", "test1", "test2"})
    @ResponseBody
    public String getTest()
    {
        return "<h2>Test</h2>";
    }

    @RequestMapping({"login"})
    @ResponseBody
    public String getLogin()
    {
        return "<h2>Login</h2>";
    }

    @RequestMapping({"logout"})
    @ResponseBody
    public String getLogout()
    {
        return "<h2>Logout</h2>";
    }
}