package info.fges.blablacool.controllers;

import info.fges.blablacool.helpers.ReadFileHelper;
import info.fges.blablacool.services.SearchService;
import info.fges.blablacool.services.UserService;
import org.apache.commons.lang3.text.StrSubstitutor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/")
public class PageController
{
	@Autowired
    private UserService uS;

	@Autowired
	SearchService searchService;

    /**
     *
     * @param modelAndView
     * @return the index page
     */
    @RequestMapping(method = RequestMethod.GET)
	public ModelAndView getIndex(ModelAndView modelAndView)
    {
		modelAndView.setViewName("home");

		return modelAndView;
	}


}