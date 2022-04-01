package com.agroget.controller;

import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.sql.rowset.serial.SerialBlob;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
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
	
	@GetMapping("/srch")
	public ModelAndView srch(@RequestParam int farmerid)
	{
		ModelAndView mv = new ModelAndView();
		FarmerEntity farmer = farmerDao.findById(farmerid);
		 mv.addObject("farmer", farmer);
		 mv.setViewName("searcheq");
		return mv;
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

		mv.setViewName("orderhistory");
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
	
	
	
	//----- show all equipment ---->
	@GetMapping("/home/showAllEquipments")
	public ModelAndView showAllEquipments()
	{
		ModelAndView mv = new ModelAndView();
		List<EquipmentInfoTable>  equipmentsList = equipmentDao.getAllEquipment();
		mv.addObject("equipments",equipmentsList);
		mv.setViewName("equipmentsView");
		return mv;
	}
	
	//<----
	
	// ----> testing ordering equipment 
	// coming here from showsearch
	
	@GetMapping("/orderEquipment")
	public ModelAndView orderEquipment(@RequestParam int equipmentid )
	{
		System.out.println("inside order equipment");
		ModelAndView mv = new ModelAndView();
		EquipmentInfoTable equipment = equipmentDao.findByEquipmentId(equipmentid);
		mv.addObject("equipment", equipment);
		mv.setViewName("gveorder");
		return mv;
	}
		
	@PostMapping("cnfrmord")
	public String cnford(@RequestParam int equipmentid,@RequestParam int farmerid,
			@RequestParam String fromdate,@RequestParam String todate,
			@RequestParam String fromtime,@RequestParam String totime,
			@RequestParam String address) throws ParseException 
	{
		//-------------------\\
		System.out.println("inside conform order");
		System.out.println(fromdate);
		System.out.println(fromtime);
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date1 = dateFormat.parse(fromdate);
		System.out.println("this is date "+date1);
		// changing time as integer in the database instead of time

		int ftime=Integer.parseInt(fromtime);
		int ttime=Integer.parseInt(totime);
		//-------------------\\
		
		
		
		
		
		return "test";
	}
	
	//<-------
	
	//-----> my account testing --->
	@PostMapping("/profile")
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
	//<-------
}
/*  
 		System.out.println("Passed :" + date);
		CustomerInfoTbl cust = customerDao.findById(custid);
		ServiceInfoTbl service = serviceDao.findById(serviceid);

		BookingInfoTbl defaults = new BookingInfoTbl();
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
		Date date1 = dateFormat.parse(date);
		BookingInfoTbl book = new BookingInfoTbl(new Date(), service.getService_Cost(),date1,defaults.getBooking_Status(), null, null,0, cust, service);
		bookingDao.saveBooking(book);
 
 		List<ServiceInfoTbl> services = (List<ServiceInfoTbl>) request.getAttribute("services");
	for(ServiceInfoTbl service : services )
	{
		%>
			<%= service.getService_Name() %>
			<%= service.getService_Cost() %>
			Booking Date : <input type="datetime-local" name="todate" id=todate value=""  required/>
			
			<a href = "javascript:;" onclick = "this.href='bookService?serviceid=<%=service.getService_Id()%>&custid=${customer.getCustomer_id()}&date='+ document.getElementById('todate').value">Book</a>
		
			<a href="feedback">Give Feedback</a>
		
		<%
	}
 	
 
 
 
 
 */


