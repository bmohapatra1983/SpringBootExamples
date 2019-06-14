package com.biswa.login.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.biswa.login.daos.UserDao;
import com.biswa.login.entities.User;
import com.biswa.login.validators.MailValidator;

@Controller
public class UserController {
	private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);
	@Autowired
	private UserDao dao;

	@Autowired
	private MailValidator mailValidator;

	@Autowired
	private HttpSession session;

	// method to process the request for home page
	@RequestMapping("/")
	public String home() {
		LOGGER.info("--Entering into Index Page(Home--)");
		return "index";
	}

	// method to process the request for Profile page
	@RequestMapping("/logout")
	public String logout() {
		LOGGER.info("");
		return "index";
	}

	// method to process the request for Profile page
	@RequestMapping("/profile")
	public String profile() {
		LOGGER.info("--Entering into Profile Page");
		return "profile";
	}

	// method to serve registration form
	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public ModelAndView regForm() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("registerForm");
		mav.addObject("user", new User());
		return mav;
	}

	// method to process the register form
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ModelAndView register(@Valid @ModelAttribute User user, BindingResult br) throws Exception {
		LOGGER.info("--Entering into register Page");
		// custom validation is performed
		mailValidator.validate(user, br);
		ModelAndView mav = new ModelAndView();
		mav.addObject("user", user);
		if (br.hasErrors()) {
			mav.setViewName("registerForm");
		} else {
			dao.save(user);
			mav.setViewName("registered");

		}
		return mav;
	}

	// method to process the login request
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@RequestParam String mailId, @RequestParam String password) throws Exception {
		List<User> list = dao.findByMailId(mailId);
		if (!list.isEmpty()) {
			User user = list.get(0);
			if (user.getPassword().equals(password)) {
				session.setAttribute("user", user);
				return "dashboard";
			}
		}
		return "relogin";
	}
}
