package com.agroget.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.agroget.dao.EquipmentDao;
import com.agroget.dao.FarmerDao;
import com.agroget.dao.OrderEquipmentDao;

@Controller
public class HomeController {

	@Autowired 
	FarmerDao farmerDao;
	
	@Autowired
	EquipmentDao equipmentDao;
	
	@Autowired
	OrderEquipmentDao orderEquipmentDao;
	
//	@GetMapping("/index")
//	public String home() {
//		return "index";
//	}
//	
//	@GetMapping("/contact")
//	public String contact() {
//		return "contact";
//	}
//	
//	@GetMapping("/feedback")
//	public String feedback() {
//		return "feedback";
//	}
//	
//	@GetMapping("/aboutus")
//	public String aboutus() {
//		return "aboutus";
//	}
//	
//	@GetMapping("/login")
//	public String login() {
//		return "login";
//	}
//	
//	@GetMapping("/farmer")
//	public String farmer() {
//		return "farmerregistration";
//		}
//	@GetMapping("/renter")
//	public String renter() {
//		return "renterregistration";
//		
//}
}

