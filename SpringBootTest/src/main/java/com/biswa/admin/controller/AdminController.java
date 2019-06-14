package com.biswa.admin.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
@RestController
public class AdminController {
	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public ModelAndView emp() {
		ModelAndView mv=new ModelAndView("admin");
		return mv;
	}
}
