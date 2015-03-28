package info.fges.blablacool.controllers;

import info.fges.blablacool.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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