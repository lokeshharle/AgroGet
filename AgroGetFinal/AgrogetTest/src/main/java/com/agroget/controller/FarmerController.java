package com.agroget.controller;

import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
import com.agroget.dao.RenterDao;
import com.agroget.entity.EquipmentInfoTable;
import com.agroget.entity.*;
import com.agroget.entity.OrderEquipmentTable;
import com.agroget.entity.OrderInfoTable;
import com.iet.sender.EmailSender;


@Controller
@SessionAttributes("farmer")
public class FarmerController {
	
	@Autowired
	FarmerDao farmerDao;

	@Autowired
	RenterDao renterdao;
	
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
	
	@GetMapping("/order")
	public String order() {
		return "order";
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
		System.out.println("inside login farmer");
		
		HttpSession session = request.getSession();
		
		// @ModelAttribute ("farmerLogin")
		ModelAndView mv = null;
		if(toggle==null)
		{
			mv = new ModelAndView();
			
			FarmerEntity farmer = farmerDao.loginFarmer(username, password);
			
			
			
			if (Objects.isNull(farmer)) {
				mv.setViewName("login");
				return mv;
			} 
			
			else {
					System.out.println("Session Id " + session.getId());
					mv.addObject("farmer", farmer);
					mv.setViewName("profilesearch");
			}
		}
		else
			{
			mv = new ModelAndView();
			
			RenterEntity renter = renterdao.loginRenter(username, password);
			
		
			
			
			if (Objects.isNull(renter)) {
				mv.setViewName("login");
				return mv;
			} 
			
			else {
					
					mv.addObject("renter", renter);
					session.setAttribute("renter", renter);
					
					mv.setViewName("ProfileRenter");
			}
			}
		return mv;
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
	
//	@GetMapping("/profilesearchid")
//	public ModelAndView srch(@RequestParam int farmerid)
//	{
//		ModelAndView mv = new ModelAndView();
//		FarmerEntity farmer = farmerDao.findById(farmerid);
//		 mv.addObject("farmer", farmer);
//		 mv.setViewName("profilesearch");
//		return mv;
//	}
	
	//use this later
	@GetMapping("profilesearch")
	public ModelAndView srch2(@RequestParam int farmerid)
	{
	System.out.println("inside profilesearch");
		ModelAndView mv = new ModelAndView();
		FarmerEntity farmer = farmerDao.findById(farmerid);
		 mv.addObject("farmer", farmer);
		 mv.setViewName("profilesearch");
		return mv;
	}
	
//	@GetMapping("profilesearch")
//	public String srch2()
//	{
//	System.out.println("inside profilesearch");
//		return "profilesearch";
//	}
//	
//	
//	
//	
//	@PostMapping("/searchmyeq")
//	public ModelAndView searchEquipmentsType(@RequestParam String type) {
//		ModelAndView mv = new ModelAndView();
//		String[] s = type.split(",");
//
//		System.out.println(s[0]);
//		// http://localhost:9090/search?type=seeding
//
//		List<EquipmentInfoTable> equipmentTypesList = equipmentDao.findByEquipmentType(s[0]);
//		mv.addObject("equipmentTypes", equipmentTypesList);
//
//		mv.setViewName("profilesearch");
//		return mv;
//	}
	
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
	
	
	
	@GetMapping("/searchequipment")
	//@PostMapping("choices-single-defaul=")
	public ModelAndView searchEquipmentsType(@RequestParam String type) {
		ModelAndView mv = new ModelAndView();
		String[] s = type.split(",");
		
		System.out.println(s[0]);
		// http://localhost:9090/search?type=seeding
		
List<EquipmentInfoTable> equipmentTypesList = equipmentDao.findByEquipmentType(s[0]);
		
		if(equipmentTypesList != null && equipmentTypesList.size()!=0)
		{
			mv.addObject("equipmentTypes", equipmentTypesList);
		}
		else
		{
			mv.addObject("equipmentTypes",null);
		}
		mv.setViewName("profilesearch");
		return mv;
		
		
		
		
		
		
		  }
	
	

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
	
	@PostMapping("/updatefarmer") 
	public ModelAndView updateProfile(@RequestParam String fname,
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
	/*
	 * @GetMapping("/showorder") public ModelAndView showOrder(@RequestParam int
	 * farmerid) {
	 * 
	 * ModelAndView mv = new ModelAndView(); FarmerEntity farmer =
	 * farmerDao.findById(farmerid); List<OrderInfoTable> orderInfoList =
	 * orderInfoDao.findByFarmerId(farmer.getFarmerId()); OrderInfoTable orderInfo =
	 * orderInfoList.get(0); // here there will be exception if no order is placed
	 * // akashj@gmail.com akashj@gmail.com List<OrderEquipmentTable>
	 * orderEquipmentList = orderEquipmentDao.findByOrderId(orderInfo.getOrderId());
	 * mv.addObject("farmer", farmer); System.out.println(farmer.getFarmerLname());
	 * mv.addObject("orderInfoList", orderInfoList);
	 * 
	 * mv.addObject("orderEquipmentList", orderEquipmentList);
	 * 
	 * //we are going to Myorder Page mv.setViewName("myorder"); return mv; }
	 */
	
//	@GetMapping("/showorder")
//	public ModelAndView showOrder(HttpServletRequest request)
//	{
//
//		ModelAndView mv = new ModelAndView();
//		FarmerEntity farmer = (FarmerEntity) request.getSession().getAttribute("farmer");
//		List<OrderInfoTable> orderInfoList = orderInfoDao.findByFarmerId(farmer.getFarmerId());
//
//		orderInfoList.get(0).getOrderId();
//		//	OrderInfoTable orderInfo =null;
//		if(orderInfoList!=null && orderInfoList.size()!=0) {
//
//			ArrayList<ArrayList<OrderEquipmentTable>> orders=new ArrayList<ArrayList<OrderEquipmentTable>>();
//			for (OrderInfoTable order : orderInfoList) {
//
//				ArrayList<OrderEquipmentTable> orderEquipmentList = orderEquipmentDao.findByOrderId2(order.getOrderId());
//				orders.add(orderEquipmentList);
//
//			}
//
//			mv.addObject("orderinfolist",orderInfoList);
//			mv.addObject("orderEquipmentList", orders);
//		}
//
//
//		else{
//			mv.addObject("orderEquipmentList", null);
//		}
//		mv.addObject("farmer", farmer);
//		System.out.println(farmer.getFarmerLname());
//		mv.addObject("orderInfoList", orderInfoList); 
//		mv.setViewName("myorder");
//		return mv;
//	}
//	
//	@GetMapping("/showorder")
//	public ModelAndView showOrder(@RequestParam int farmerid)
//	{
//
//		ModelAndView mv = new ModelAndView();
//		FarmerEntity farmer = farmerDao.findById(farmerid);
//		List<OrderInfoTable> orderInfoList = orderInfoDao.findByFarmerId(farmer.getFarmerId());
//		if(orderInfoList!=null && orderInfoList.size()!=0)
//		{
//			
//		OrderInfoTable orderInfo = orderInfoList.get(0);
//		// here there will be exception if no order is placed
//		// akashj@gmail.com           akashj@gmail.com
//		List<OrderEquipmentTable> orderEquipmentList = orderEquipmentDao.findByOrderId(orderInfo.getOrderId());
//		mv.addObject("farmer", farmer);
//		mv.addObject("orderInfoList", orderInfoList);
//		mv.addObject("orderEquipmentList", orderEquipmentList);
//		}
//		else
//		{
//			mv.addObject("orderInfoList", null);
//		}
//		mv.setViewName("myorder");
//		return mv;
//	}
	
	@GetMapping("/showorder")
	public ModelAndView showOrder(@RequestParam int farmerid)
	{

		ModelAndView mv = new ModelAndView();
		FarmerEntity farmer = farmerDao.findById(farmerid);
		System.out.println("farmer"+farmer.getFarmerFname());
		List<OrderInfoTable> orderInfoList = orderInfoDao.findByFarmerId(farmer.getFarmerId());
		OrderInfoTable orderInfo = orderInfoList.get(0);
		// here there will be exception if no order is placed
		// akashj@gmail.com           akashj@gmail.com
		List<OrderEquipmentTable> orderEquipmentList = orderEquipmentDao.findByOrderId(orderInfo.getOrderId());
		mv.addObject("farmer", farmer);
		System.out.println(farmer.getFarmerLname());
		mv.addObject("orderInfoList", orderInfoList);
		
		mv.addObject("orderEquipmentList", orderEquipmentList);

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
	
//	@GetMapping("/orderEquipment/{id}")
//	public void orderEquipment(@PathVariable int id )
//	{
//		System.out.println("successfull!!!");
//		OrderEquipmentTable oe =  orderEquipmentDao.getById(id);
//		orderEquipmentDao.saveOrderEquipment(oe);
//		System.out.println("22222successfull!!!");
//		
//	}
	
	@GetMapping("/orderEquipment")
	public ModelAndView orderEquipment(@RequestParam int equipmentid )
	{
		System.out.println("inside order equipment");
		ModelAndView mv = new ModelAndView();
		EquipmentInfoTable equipment = equipmentDao.findByEquipmentId(equipmentid);
		mv.addObject("equipment", equipment);
		mv.setViewName("order");
		return mv;
	}
	
	@PostMapping("conformorder")
	public ModelAndView cnford(@RequestParam int equipmentid,@RequestParam int farmerid,
			@RequestParam String fromdate,@RequestParam String todate,
			@RequestParam String fromtime,@RequestParam String totime,
			@RequestParam String address) throws ParseException 
	{
		//-------------------\\
		System.out.println("inside conform order");
		System.out.println(fromdate);
		System.out.println(fromtime);
		
		
		
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date fdate = dateFormat.parse(fromdate);
		Date tdate = dateFormat.parse(todate);
		
		int ftime = Integer.parseInt(fromtime);
		int ttime=Integer.parseInt(totime);
		
		// changing time as integer in the database instead of time
			
	

//		float ftime = Float.parseFloat(fromtime);
		
		//int ttime=Integer.parseInt(totime);
		//-------------------\\
		
		System.out.println(farmerid);
		
		FarmerEntity farmer = farmerDao.findById(farmerid);
		
		EquipmentInfoTable equipment = equipmentDao.findByEquipmentId(equipmentid);
		
		OrderInfoTable orderInfoTable = new OrderInfoTable(farmer);
		
		orderInfoDao.saveOI(orderInfoTable);
		// saving cost and status as null
		
		//cant get context as soon as saved so fining by farmerid
		// filling first null orderinfotable
		OrderInfoTable orderInfoTableFound = orderInfoDao.findByFarmerIdCostStatus(farmerid);
		
//		System.out.println(oifc.getOrderDate());
		
		System.out.println(orderInfoTableFound.getOrderId());
		
		//orderInfoDao.saveOI(oifc);
		
		OrderEquipmentTable orderEquipmentTable = new OrderEquipmentTable(fdate, tdate, ftime, ttime, address, equipment, orderInfoTableFound);
		
		double equipmentRate = equipment.getEquipment_rate();
		int equipmentStatus = equipment.getEquipment_status();
		int hrDiff = ttime - ftime;
		String rateType = equipment.getEquipment_rate_type();
		double totalCost = 0.0;
		if(rateType=="hr")
		{
			totalCost = equipmentRate * hrDiff;
		}
		else
		{
			double differenceInTime  = tdate.getTime() - fdate.getTime();
			
			double differenceInDays  = (differenceInTime  / (1000 * 60 * 60 * 24))  % 365;
			
			totalCost = equipmentRate * differenceInDays;
			
		}
		
		orderInfoTableFound.setOrderTotalCost(totalCost);
		
		orderInfoTableFound.setOrderStatus(equipmentStatus);
		
		//OrderEquipmentTable oet = new OrderEquipmentTable(date1, date2, equipmentid, farmerid, address, equipment, oifc);
		
		orderEquipmentDao.saveOrderEquipment(orderEquipmentTable);
		
		//OrderEquipmentTable ordEq1 = orderEquipmentDao.findByOrderEquipment(oifc.getOrderId(),equipment.getEquipment_id());
		
		
		
		System.out.println("before update");
		
		//System.out.println(oifc.getOrderTotalCost());
		
		orderInfoDao.updateOI(orderInfoTableFound.getOrderId(),farmer.getFarmerId(),totalCost,equipmentStatus);
		
		System.out.println("after update");
		
		//System.out.println(oifc.getOrderTotalCost());
		
		ModelAndView mv = new ModelAndView();
		
		//mv.addObject("orderInfo",oifc);
		
		mv.addObject("orderInfo", orderInfoTableFound);
		
		mv.setViewName("test");
		
		return mv;
		
		
		//going to bill
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
	
	

	//---> testing forgot password ---->
	
	
	@GetMapping("/verifypassword")
	public String verifypassword() {
		return "verifypassword";
		
	}

	@GetMapping("/resetpassword")
	public String resetpassword() {
		return "resetpassword";
		
	}
		@GetMapping("/forgotpassword")
		public String forgotpassword() {

			return "sendmail";
		}

		@PostMapping("/sendmail")
		public String sendmail(@RequestParam String email) {

			try {
				EmailSender mail = new EmailSender("agrogetdemo@gmail.com","dqccbgkyaoakufmu");
				mail.sendEmail(email, "http://localhost:9090/resetpassword","Use this link to login/change password by Agroget");
			} 
			catch (Exception e) {
				e.printStackTrace();
			}
			return "login";
		}

		


		@PostMapping("/resetpassword2")
		public ModelAndView resetpassword2(@RequestParam String username, @RequestParam String password) {

			FarmerEntity farmer = farmerDao.directLogin(username);
			ModelAndView mv = new ModelAndView();
			farmer.setFarmerPassword(password);
			farmerDao.updateFarmer(farmer); 
			mv.addObject("farmer", farmer);
			mv.setViewName("login");
			return mv;
		}
		//<-------
	

}
