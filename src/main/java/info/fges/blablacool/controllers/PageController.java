package info.fges.blablacool.controllers;

import info.fges.blablacool.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
	@ResponseBody
	public String getIndex()
    {
		return "home";
	}

	@RequestMapping(value = "test", method = RequestMethod.GET)
	@ResponseBody
	public String getIndex2()
	{

		return "home";
	}

}