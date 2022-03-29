package com.agroget.controller;

import java.util.Date;
import java.util.List;
import java.util.Objects;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.agroget.dao.EquipmentDao;
import com.agroget.dao.FarmerDao;
import com.agroget.dao.OrderEquipmentDao;
import com.agroget.dao.OrderInfoDao;
import com.agroget.entity.EquipmentInfoTable;
import com.agroget.entity.FarmerEntity;
import com.agroget.entity.OrderEquipmentTable;
import com.agroget.entity.OrderInfoTable;

@Controller
public class FarmerController {
	
	@Autowired 
	FarmerDao farmerDao;
	
	@Autowired
	EquipmentDao equipmentDao;
	
	@Autowired
	OrderEquipmentDao orderEquipmentDao;
	
	@Autowired
	OrderInfoDao orderInfoDao;
	
	
	@GetMapping("/index")
	public String index() {
		return "index";
	}
	
	@GetMapping("/home")
	public String home() {
		return "farmer";
	}
	
	@GetMapping("/login")
	public String login() {
		return "Login";
	}
	
	@GetMapping("/home/login1")
	public String login1() {
		return "login1";
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
	
	@PostMapping("/home/loginFarmer")
	public ModelAndView loginFarmer(@RequestParam String username,@RequestParam String password,HttpServletRequest request)
	{
		HttpSession session = request.getSession();
		ModelAndView mv = new ModelAndView();
		FarmerEntity farmer = farmerDao.loginFarmer(username, password);
		if(Objects.isNull(farmer))
		{
			mv.setViewName("login");
		}
		else
		{
			System.out.println("Session Id " +   session.getId());
			mv.addObject("farmer",farmer);
			mv.setViewName("profile");
		}
		return mv;
		
	}
	
	@GetMapping("/home/logout")
	public ModelAndView logout(HttpSession session)
	{
		System.out.println("inside logout");
		session.invalidate();
		ModelAndView mv = new ModelAndView();
		mv.setViewName("login1");
		return mv;
	}

	@GetMapping("/home/showAllEquipments")
	public ModelAndView showAllEquipments()
	{
		ModelAndView mv = new ModelAndView();
		List<EquipmentInfoTable>  equipmentsList = equipmentDao.getAllEquipment();
		mv.addObject("equipments",equipmentsList);
		mv.setViewName("equipmentsView");
		return mv;
	}
	
	@GetMapping("/orderEquipment")
	public void orderEquipment(@RequestParam int id )
	{
		System.out.println("userid" + id);
		FarmerEntity farmerEntity = farmerDao.loginFarmer("prash@gmail.com", "prash");
		OrderInfoTable oi = new OrderInfoTable(new Date(), (byte) 1, 1230, farmerEntity);
		orderInfoDao.saveOI(oi);
		System.out.println(oi.getOrderId());
	}
	
	@GetMapping("/search")
	public String searchEquipment() {
		return "search";
	}
	
	@PostMapping("/searchme")
	public ModelAndView searchEquipments(@RequestParam String type)
	{
		String []s=type.split(",");
		
		System.out.println(s[0]);
		// http://localhost:9090/search?type=seeding
		ModelAndView mv = new ModelAndView();
		
		List<EquipmentInfoTable>  equipmentTypesList = equipmentDao.findByEquipmentType(s[0]);
		for (EquipmentInfoTable equipmentInfoTable : equipmentTypesList) {
			System.out.println(equipmentInfoTable.getEquipment_name());
		}
		mv.addObject("equipmentTypes",equipmentTypesList);
		
		
		List<EquipmentInfoTable>  equipmentsList = equipmentDao.getAllEquipment();
		mv.addObject("equipments",equipmentsList);
		
		mv.setViewName("equipmentTypesView");
		return mv;
	}
	
	
}

// 
/*
 * @GetMapping("/orderEquipment") public void orderEquipment(@RequestParam int
 * id ) { System.out.println("yes "+id); OrderInfoTable oi = new
 * OrderInfoTable(); orderInfoDao.saveOI(oi); OrderInfoTable oii =
 * orderInfoDao.findById(oi.getOrderId()); System.out.println("oi" +
 * oii.getOrderId()); }
 */

