package com.biswa.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

	// method to process the request for home page
	@RequestMapping("/")
	public String home() {
		return "index";
	}

	@RequestMapping("/hello")
	public String sayHello() {
		return "Biswaranjan Mohapatra";
	}
}
