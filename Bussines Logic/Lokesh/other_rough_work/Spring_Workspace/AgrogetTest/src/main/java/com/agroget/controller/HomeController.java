package com.agroget.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@GetMapping("/index") public String index() {
		return "index"; 
	}

	@GetMapping("/Login") public String login() { 
		return "Login"; 
	}
	
	@GetMapping("/Aboutus") public String aboutus() {
		return "Aboutus";
	}
	
	@GetMapping("feedback") public String feedback() {
		return "feedback";
	}
	
	@GetMapping("contact") public String contactUs() {
		return "contact";
	}
	
	
	
	
}
