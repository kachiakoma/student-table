package com.kachi.studentinfo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("")
public class HomepageController {
	
	@RequestMapping(method = RequestMethod.GET)
	public String homepage() {
		return "home";
	}

}
