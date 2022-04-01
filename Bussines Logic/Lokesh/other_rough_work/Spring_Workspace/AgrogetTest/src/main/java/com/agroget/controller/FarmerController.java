package com.agroget.controller;

import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;
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



	/*
	 * @GetMapping("/index") public String index() { return "index"; }
	 */

	@GetMapping("/home")
	public String home() {
		return "farmer";
	}

	/*
	 * @GetMapping("/login") public String login() { return "Login"; }
	 */
	@GetMapping("/home/login1")
	public String login1() {
		return "login1";
	}
	
	@GetMapping("/FarmerRegistration")
	public String farmerRegistration()
	{
		return "FarmerRegistration";
	}

	@PostMapping("/addFarmer")
	public String addFarmer(@RequestParam String fname, @RequestParam String lname,
			@RequestParam String mobile,@RequestParam String email,
			@RequestParam String password, @RequestParam String address,
			@RequestParam String pincode , @RequestParam("file") MultipartFile file) 
	{


		byte[] byteArr;
		Blob blob;
		try 
		{
			byteArr = file.getBytes();
			blob = new SerialBlob(byteArr);
			String username = email;
			FarmerEntity farmerEntity = new FarmerEntity(fname, lname, mobile, email, username, password, address, pincode);
			farmerDao.addFarmerDetails(farmerEntity);
			//vendorDao.addVendor(Vendor_FirstName, Vendor_LastName, Vendor_MobileNo, Vendor_EmailId, Vendor_UserName, Vendor_Password, Vendor_Address, Vendor_State, Vendor_City, Vendor_Pincode,blob);
		}
		catch (SQLException e) 
		{	
			e.printStackTrace();
			return "index";
		}
		catch (IOException e1)
		{
			e1.printStackTrace();
			return "index";
		}

		return "farmer";
	}

	@PostMapping("/loginFarmer")
	public ModelAndView loginFarmer(@RequestParam String username, @RequestParam String password,
			HttpServletRequest request) {
		System.out.println("inside login farmer");
		ModelAndView mv = new ModelAndView();
		HttpSession session = request.getSession();
		FarmerEntity farmer = farmerDao.loginFarmer(username, password);
		System.out.println(farmer.getFarmerFname());
		if (Objects.isNull(farmer)) {
			mv.setViewName("login1");
		} else {
			System.out.println("Session Id " + session.getId());
			mv.addObject("farmer", farmer);
			mv.setViewName("profile");
		}
		return mv;

	}

	@GetMapping("/home/logout")
	public ModelAndView logout(HttpSession session) {
		ModelAndView mv = new ModelAndView();
		System.out.println("inside logout");
		session.invalidate();
		mv.setViewName("login1");
		return mv;
	}

	@GetMapping("/home/showAllEquipments")
	public ModelAndView showAllEquipments() {
		ModelAndView mv = new ModelAndView();
		List<EquipmentInfoTable> equipmentsList = equipmentDao.getAllEquipment();
		mv.addObject("equipments", equipmentsList);
		mv.setViewName("equipmentsView");
		return mv;
	}

	@GetMapping("/orderEquipment")
	public void orderEquipment(@RequestParam int id) {
		System.out.println("userid" + id);
		FarmerEntity farmerEntity = farmerDao.loginFarmer("prash@gmail.com", "prash");
		OrderInfoTable oi = new OrderInfoTable(new Date(), (byte) 1, 8888, farmerEntity);
		orderInfoDao.saveOI(oi);
		// query on 
		System.out.println(oi.getOrderId());
	}


	@GetMapping("/search") public ModelAndView searchEquipment() 
	{ 
		ModelAndView mv = new ModelAndView();
		mv.setViewName("search");
		return mv;
	}


/*
	@GetMapping("/search") public ModelAndView searchEquipment() 
	{ 
		ModelAndView
		mv = new ModelAndView(); List<EquipmentInfoTable> equipmentTypesSelectList =
		equipmentDao.equipmentTypeList();

		mv.addObject("equipmentTypesSelectList",equipmentTypesSelectList);

		mv.setViewName("search");

		return mv;
		}
*/

	@PostMapping("/searchme")
	public ModelAndView searchEquipments(@RequestParam String type) {
		ModelAndView mv = new ModelAndView();
		String[] s = type.split(",");

		System.out.println(s[0]);
		// http://localhost:9090/search?type=seeding

		List<EquipmentInfoTable> equipmentTypesList = equipmentDao.findByEquipmentType(s[0]);
		mv.addObject("equipmentTypes", equipmentTypesList);

		mv.setViewName("equipmentTypesView");
		return mv;
	}

	@GetMapping("/home/editprofile")
	public ModelAndView editProfile(@RequestParam int farmerid)
	{
		ModelAndView mv = new ModelAndView();
		FarmerEntity farmer = farmerDao.findById(farmerid);
		mv.addObject("farmer", farmer);
		mv.setViewName("editprofile");
		return mv;
	}

	@PostMapping("/home/editfarmer")
	public ModelAndView editFarmer(@RequestParam int farmerid)
	{

		ModelAndView mv = new ModelAndView();
		FarmerEntity farmer = farmerDao.findById(farmerid);
		mv.addObject("farmer", farmer);
		mv.setViewName("editprofile");
		return mv;
	}


	@PostMapping("/home/updatefarmer") public String updateProfile(@RequestParam String fname,
			@RequestParam String lname, @RequestParam String mobile,
			@RequestParam String email, @RequestParam String password,
			@RequestParam String address,@RequestParam String pincode,
			@RequestParam int farmerid)
	{  
		FarmerEntity farmer = farmerDao.findById(farmerid); 
		farmer.setFarmerFname(fname);
		farmer.setFarmerLname(lname);
		farmer.setFarmerMobile(mobile);
		farmer.setFarmerEmail(email);
		farmer.setFarmerPassword(password);
		farmer.setFarmerAddress(address);
		farmer.setFarmerPincode(pincode);
		farmerDao.updateFarmer(farmer); 
		return "profile"; 
	}

	@GetMapping("/home/showorder")
	public ModelAndView showOrder(@RequestParam int farmerid)
	{

		ModelAndView mv = new ModelAndView();
		FarmerEntity farmer = farmerDao.findById(farmerid);
		List<OrderInfoTable> orderInfoList = orderInfoDao.findByFarmerId(farmer.getFarmerId());
		OrderInfoTable orderInfo = orderInfoList.get(0);
		List<OrderEquipmentTable> orderEquipmentList = orderEquipmentDao.findByOrderId(orderInfo.getOrderId());
		mv.addObject("farmer", farmer);
		System.out.println(farmer.getFarmerLname());
		mv.addObject("orderInfoList", orderInfoList);

		mv.addObject("orderEquipmentList", orderEquipmentList);

		mv.setViewName("orderhistory");
		return mv;
	}

	@GetMapping("/home/givefeedback")
	public ModelAndView feedback()
	{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("givefeedback");
		return mv;
	}

	@GetMapping("/home/enterfeedback")
	public ModelAndView enterFeedBack(@RequestParam int equipmentid )
	{
		System.out.println(equipmentid);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("givefeedback");
		return mv;
	}

	@PostMapping("/home/test")
	public String test()
	{
		return "test";
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
