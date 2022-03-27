package com.agroget.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.agroget.dao.FarmerDao;
import com.agroget.entity.FarmerEntity;

@Controller
public class FarmerController {
	
	@Autowired 
	FarmerDao farmerDao;
	
	@GetMapping("/home")
	public String home() {
		return "farmer";
	}
	
	@GetMapping("/home/login")
	public String login() {
		return "login";
	}
	
	@PostMapping("/addFarmer")
	public String addFarmer(@RequestParam String fname, @RequestParam String lname , 
			@RequestParam String mobile,  @RequestParam String email
			, @RequestParam String password ,
			 @RequestParam String address ,  @RequestParam String pincode)
	{
		String username =  email;
		FarmerEntity farmerEntity = new FarmerEntity(fname, lname, mobile, email, username, password, address, pincode);
		farmerDao.addFarmerDetails(farmerEntity);
		if(farmerEntity!=null) {
	    	return "index";
	    }
		return "farmer";
	
	}
	
	//@PostMapping("/home/loginFarmer")
	public String loginFarmer(@RequestParam String username,@RequestParam String password)
	{
		FarmerEntity farmerEntity = farmerDao.loginFarmer(username, password);
		System.out.println(farmerEntity.getFarmerId() + " " + farmerEntity.getFarmerFname());
		if(farmerEntity!=null) {
	    	return "profile";
	    }
		return "login";
	}
	
	@PostMapping("/home/loginFarmer")
	public ModelAndView loginFarmer1(@RequestParam String username,@RequestParam String password)
	{
		ModelAndView mv = new ModelAndView();
		FarmerEntity farmerEntity = farmerDao.loginFarmer(username, password);
		mv.addObject("farmer",farmerEntity);
		mv.setViewName("profile");
		return mv;
		
	}
	
	
	
	

}
