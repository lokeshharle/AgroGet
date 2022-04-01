package com.agroget.controller;

import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.List;
import java.util.Objects;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.sql.rowset.serial.SerialBlob;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.agroget.dao.EquipmentDao;
import com.agroget.dao.FarmerDao;
import com.agroget.dao.FeedbackInfoDao;
import com.agroget.dao.ImageInfoDao;
import com.agroget.dao.OrderEquipmentDao;
import com.agroget.dao.OrderInfoDao;
import com.agroget.entity.EquipmentInfoTable;
import com.agroget.entity.FarmerEntity;
import com.agroget.entity.OrderEquipmentTable;
import com.agroget.entity.OrderInfoTable;


@Controller
@SessionAttributes("farmer")
public class FarmerController {
	
	@Autowired
	FarmerDao farmerDao;

	@Autowired
	EquipmentDao equipmentDao;

	@Autowired
	OrderEquipmentDao orderEquipmentDao;

	@Autowired
	OrderInfoDao orderInfoDao;

	@Autowired
	FeedbackInfoDao feedbackInfoDao;
	
	@Autowired
	ImageInfoDao imageInfoDo;
	
	@GetMapping("/index")
	public String index() {
		return "index";
	}
	
	@GetMapping("/contact")
	public String contact() {
		return "contact";
	}
	
	@GetMapping("/feedback")
	public String feedback() {
		return "feedback";
	}
	
	@GetMapping("/aboutus")
	public String aboutus() {
		return "aboutus";
	}
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@GetMapping("/farmer")
	public String farmer() {
		return "farmerregistration";
		}
	@GetMapping("/renter")
	public String renter() {
		return "renterregistration";
		
	}
	@GetMapping("/profileedit")
	public String profileedit() {
		return "profileedit";
		
	}
	
	@GetMapping("/harvestingequipment")
	public String harvestingequipment() {
		return "harvestingequipment";
		
	}
	
	@GetMapping("/plantingequipment")
	public String plantingequipment() {
		return "plantingequipment";
		
	}
	
	@GetMapping("/tillagequipment")
	public String tillagequipment() {
		return "tillagequipment";
		
	}
	
	@GetMapping("/seedingequipment")
	public String seedingequipment() {
		return "seedingequipment";
		
	}
	
	
	
	@PostMapping("/loginFarmer")
	public ModelAndView loginFarmer(@RequestParam String username, @RequestParam String password,
			@RequestParam(required=false,name="toggle") String []toggle,
			HttpServletRequest request) {
		
		
		// @ModelAttribute ("farmerLogin")
		ModelAndView mv = null;
		if(toggle==null)
		{
			mv = new ModelAndView();
			
			FarmerEntity farmer = farmerDao.loginFarmer(username, password);
			
			HttpSession session2 = request.getSession();
			
			if (Objects.isNull(farmer)) {
				mv.setViewName("login");
				return mv;
			} 
			
			else {
					System.out.println("Session Id " + session2.getId());
					mv.addObject("farmer", farmer);
					mv.setViewName("profilesearch");
			}
		}
		else
			{
				mv = new ModelAndView();
				mv.setViewName("index");
			// redirect to renter login
			}
		return mv;
	}
	
	
	
	
	@PostMapping("/addFarmer")
	public String addFarmer(@RequestParam String fname, @RequestParam String lname , 
			@RequestParam String mobile,  @RequestParam String email
			, @RequestParam String password ,
			 @RequestParam String address ,  @RequestParam String pincode,@RequestParam("file") MultipartFile file)
	{
		String username =  email;
		FarmerEntity farmerEntity = new FarmerEntity(fname, lname, mobile, email, username, password, address, pincode);
		farmerDao.addFarmerDetails(farmerEntity);
		FarmerEntity farmer = farmerDao.loginFarmer(username, password);
		System.out.println(farmer.getFarmerId() + farmer.getFarmerFname());
		if(farmerEntity!=null) {
	    	return "index";
	    }
		return "farmer";
	
	}
	
	//---- method for testing farmer register ----->
	
	@GetMapping("/frt")
	public String frt()
	{
		return "frt";
	}
	
	@PostMapping("/addFarmer1")
	public String addFarmer1(@RequestParam String fname, @RequestParam String lname , 
			@RequestParam String mobile,  @RequestParam String email
			, @RequestParam String password ,@RequestParam String address
			  ,  @RequestParam String pincode,@RequestParam("file") MultipartFile file) {
		String username =  email;
		FarmerEntity farmerEntity = new FarmerEntity(fname, lname, mobile, email, username, password, address, pincode);
		farmerDao.addFarmerDetails(farmerEntity);
		FarmerEntity farmer = farmerDao.loginFarmer(username, password);
		System.out.println(farmer.getFarmerId() + farmer.getFarmerFname());
		
		byte[] byteArr;
		Blob blob;
		try 
		{
			byteArr = file.getBytes();
			blob = new SerialBlob(byteArr);
			imageInfoDo.addImageF(blob, farmer,"farmer");
			
		}
		catch (SQLException e) 
		{	
			e.printStackTrace();
			
		}
		catch (IOException e1)
		{
			e1.printStackTrace();
			
		}
		
		if(farmerEntity!=null) {
	    	return "index";
	    }
		return "farmer";
	
	}
	
	//<------------
	
	
	//---- testing login and search---->
	
	@GetMapping("/log")
	public String log()
	{
		return "log";
	}
	
	@PostMapping("/logn")
	public ModelAndView logn(@RequestParam String username, @RequestParam String password,
			@RequestParam(required=false,name="toggle") String []toggle,
			HttpServletRequest request) {
		
		// @ModelAttribute ("farmerLogin")
		ModelAndView mv = null;
		if(toggle==null)
		{
			mv = new ModelAndView();
			
			FarmerEntity farmer = farmerDao.loginFarmer(username, password);
			
			HttpSession session2 = request.getSession();
					
			if (Objects.isNull(farmer)) {
				mv.setViewName("login");
				return mv;
			} 
			
			else {
					System.out.println("Session Id " + session2.getId());
					mv.addObject("farmer", farmer);
					mv.setViewName("farmerdash");
			}
		}
		else
			{
				mv = new ModelAndView();
				mv.setViewName("index");
			// redirect to renter login
			}
		return mv;
	}
	
	@GetMapping("/profilesearchid")
	public ModelAndView srch(@RequestParam int farmerid)
	{
		ModelAndView mv = new ModelAndView();
		FarmerEntity farmer = farmerDao.findById(farmerid);
		 mv.addObject("farmer", farmer);
		 mv.setViewName("profilesearch");
		return mv;
	}
	
	//use this later
//	@PostMapping("profilesearchidf")
//	public ModelAndView srch2(@RequestParam int farmerid)
//	{
//	System.out.println("inside profilesearch");
//		ModelAndView mv = new ModelAndView();
//		FarmerEntity farmer = farmerDao.findById(farmerid);
//		 mv.addObject("farmer", farmer);
//		 mv.setViewName("profilesearch");
//		return mv;
//	}
	
	@GetMapping("profilesearchidf")
	public String srch2()
	{
	System.out.println("inside profilesearch");
		return "profilesearch";
	}
	
	
	
	
	@PostMapping("/searchmyeq")
	public ModelAndView searchEquipmentsType(@RequestParam String type) {
		ModelAndView mv = new ModelAndView();
		String[] s = type.split(",");

		System.out.println(s[0]);
		// http://localhost:9090/search?type=seeding

		List<EquipmentInfoTable> equipmentTypesList = equipmentDao.findByEquipmentType(s[0]);
		mv.addObject("equipmentTypes", equipmentTypesList);

		mv.setViewName("showsearch");
		return mv;
	}
	
	// going till ordering but order not implemented yet
	
	//<----------------
	
	//------- testing edit profile --->
	
//	@GetMapping("/editfarmerprofilet")
//	public ModelAndView editProfile(@RequestParam int farmerid)
//	{
//		System.out.println("1");
//		ModelAndView mv = new ModelAndView();
//		FarmerEntity farmer = farmerDao.findById(farmerid);
//		mv.addObject("farmer", farmer);
//		mv.setViewName("editprofilet");
//		return mv;
//	}

	@PostMapping("/profileedit")
	public ModelAndView editFarmer(@RequestParam int farmerid)
	{
		System.out.println("2");
		ModelAndView mv = new ModelAndView();
		FarmerEntity farmer = farmerDao.findById(farmerid);
		mv.addObject("farmer", farmer);
		mv.setViewName("profileedit");
		return mv;	
	}
	
	@PostMapping("/updatefarmer") public ModelAndView updateProfile(@RequestParam String fname,
			@RequestParam String lname, @RequestParam String mobile,
			@RequestParam String email, @RequestParam String password,
			@RequestParam String address,@RequestParam String pincode,
			@RequestParam int farmerid)
	{  
		System.out.println("3");
		System.out.println("----->"+farmerid);
		FarmerEntity farmer = farmerDao.findById(farmerid); 
		farmer.setFarmerFname(fname);
		farmer.setFarmerLname(lname);
		farmer.setFarmerMobile(mobile);
		farmer.setFarmerEmail(email);
		farmer.setFarmerPassword(password);
		farmer.setFarmerAddress(address);
		farmer.setFarmerPincode(pincode);
		farmerDao.updateFarmer(farmer); 
		ModelAndView mv = new ModelAndView();
		mv.addObject("farmer", farmer);
		mv.setViewName("profilesearch");
		return mv; 
	}
	// having problem saving into database
	//<-------
	
	
	//-----testing logout----> 
	@GetMapping("/logout")
	public ModelAndView logout(HttpSession session) {
		ModelAndView mv = new ModelAndView();
		System.out.println("inside logout");
		session.invalidate();
		mv.setViewName("index");
		return mv;
	}
	//<-------
	
	
	
	//---> testing show order and rate equipment
	//show order is coming from button that is my order button
	@GetMapping("/showorder")
	public ModelAndView showOrder(@RequestParam int farmerid)
	{

		ModelAndView mv = new ModelAndView();
		FarmerEntity farmer = farmerDao.findById(farmerid);
		List<OrderInfoTable> orderInfoList = orderInfoDao.findByFarmerId(farmer.getFarmerId());
		OrderInfoTable orderInfo = orderInfoList.get(0);
		// here there will be exception if no order is placed
		// akashj@gmail.com           akashj@gmail.com
		List<OrderEquipmentTable> orderEquipmentList = orderEquipmentDao.findByOrderId(orderInfo.getOrderId());
		mv.addObject("farmer", farmer);
		System.out.println(farmer.getFarmerLname());
		mv.addObject("orderInfoList", orderInfoList);
		
		mv.addObject("orderEquipmentList", orderEquipmentList);

		//we are going to Myorder Page   
		mv.setViewName("myorder");
		return mv;
	}
	
	
	
	
	
	
	@GetMapping("/enterfeedback")
	public ModelAndView enterFeedBack(@RequestParam int equipmentid )
	{
		System.out.println(equipmentid);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("givefeedback");
		return mv;
	}
	// after giving take user to same page(my orders)
	//<--------
	
	
	
	
	@GetMapping("/home/showAllEquipments")
	public ModelAndView showAllEquipments()
	{
		ModelAndView mv = new ModelAndView();
		List<EquipmentInfoTable>  equipmentsList = equipmentDao.getAllEquipment();
		mv.addObject("equipments",equipmentsList);
		mv.setViewName("equipmentsView");
		return mv;
	}
	
	@GetMapping("/orderEquipment/{id}")
	public void orderEquipment(@PathVariable int id )
	{
		System.out.println("successfull!!!");
		OrderEquipmentTable oe =  orderEquipmentDao.getById(id);
		orderEquipmentDao.saveOrderEquipment(oe);
		System.out.println("22222successfull!!!");
		
	}
	
	@GetMapping("/farmerprofile")
	public ModelAndView farmerProfile(@RequestParam int farmerid)
	{
		System.out.println("inside farmer profile");
		ModelAndView mv = new ModelAndView();
		FarmerEntity farmer = farmerDao.findById(farmerid);
		List<OrderInfoTable> orderInfoList = orderInfoDao.findByFarmerId(farmer.getFarmerId());
		mv.addObject("orderInfoList", orderInfoList);
		mv.addObject("farmer", farmer);
		mv.setViewName("profile");
		return mv;	
	}
	//for my farmer account jsp
	/*
	 List<OrderInfoTable> orderInfoList = (List<OrderInfoTable>) request.getAttribute("orderInfoList");
	 int numberoforders = orderInfoList.size();
	 int lastorder = list.get(list.size() - 1);
	
	
	 */
	
	

}
