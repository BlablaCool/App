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
public class PageController
{
	@Autowired
    private UserService uS;

    @RequestMapping(method = RequestMethod.GET)
	public String printWelcome()
    {
		return "home";
	}
}