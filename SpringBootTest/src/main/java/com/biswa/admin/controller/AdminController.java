package com.biswa.admin.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.biswa.admin.bean.User;
@RestController
public class AdminController {
	@Autowired
	private JavaMailSender javaMailSender;
	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public ArrayList<User> admin() {
		System.out.println("----Admin-----");
		ArrayList<User> al=new ArrayList<>();
		al.add(new User(1,"Biswa","bbsr"));
		al.add(new User(2,"ssasa","hh"));
		al.add(new User(3,"Bisasaswa","rrtrt"));
		al.add(new User(4,"Bissssswa","rrer"));
		return al;
	}
	@RequestMapping(value="/hello", method= RequestMethod.GET)
	public ModelAndView showMessage() {
		System.out.println("/Hello-----------");
		ModelAndView mv=new ModelAndView();
		mv.addObject("abc");
		return mv;
	}
	@RequestMapping(value="/sendMail", method= RequestMethod.GET)
	void sendEmail() {
		SimpleMailMessage msg = new SimpleMailMessage();
		msg.setTo("bmohapatra1983@gmail.com");
		msg.setSubject("Testing from Spring Boot");
		String otp = "878787";
		msg.setText("Hello World \nSpring Boot Email\nYour OTP is: " + otp);
		javaMailSender.send(msg);
		System.out.println("Mail Send Successfully.");
	}
}
