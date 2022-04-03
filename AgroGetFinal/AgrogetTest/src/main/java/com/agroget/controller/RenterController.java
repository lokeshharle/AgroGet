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
import com.agroget.dao.RenterDao;
import com.agroget.dao.FeedbackInfoDao;
import com.agroget.dao.ImageInfoDao;
import com.agroget.dao.OrderEquipmentDao;
import com.agroget.dao.OrderInfoDao;
import com.agroget.dao.RenterDao;
import com.agroget.entity.EquipmentInfoTable;
import com.agroget.entity.FarmerEntity;
import com.agroget.entity.RenterEntity;
import com.agroget.entity.RenterEntity;
import com.agroget.entity.RenterEntity;

@Controller
@SessionAttributes("currentrenter")
public class RenterController {
	
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
	ImageInfoDao imageInfoDao;

	
	@GetMapping("/ProfileAddEquipment")
	public String index() {
		return "ProfileAddEquipment";
	}
	
	@GetMapping("/ProfileRenter")
	public String profile() {
		return "ProfileRenter";
	}
	
	
	@GetMapping("/ProfileMyEquipment")
	public String View() {
		return "ProfileMyEquipment";
	}
	
	@GetMapping("/ProfileEditEquipment")
	public String Edit() {
		return "ProfileEditEquipment";
	}
	
	@GetMapping("/ProfileEditRenter")
	public String Editrenter() {
		return "ProfileEditRenter";
	}
	
	
	@PostMapping("/loginRenter")
	public ModelAndView loginRenter(@RequestParam String username, @RequestParam String password,
			@RequestParam(required=false,name="toggle") String []toggle,
			HttpServletRequest request,HttpSession session) {
		
		// @ModelAttribute ("renterLogin")
		ModelAndView mv = null;
		if(toggle==null)
		{
			mv = new ModelAndView();
			
			RenterEntity renter = renterdao.loginRenter(username, password);
			
		
			
			
			if (Objects.isNull(renter)) {
				mv.setViewName("login");
				return mv;
			} 
			
			else {
					
					mv.addObject("renter", renter);
					session.setAttribute("currentrenter", renter);
					
					mv.setViewName("sum");
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
	
	@PostMapping("/addRenter1")
	public ModelAndView addRenter1(@RequestParam String fname, @RequestParam String lname , 
			@RequestParam String mobile,  @RequestParam String email
			, @RequestParam String password ,
			 @RequestParam String address ,  @RequestParam String shopdetails,@RequestParam("file") MultipartFile file) {
		ModelAndView mv = null;
		try 
		{
		String username =  email;
		RenterEntity renterEntity = new RenterEntity(fname, lname, mobile, email, username, password, address,shopdetails);
		renterdao.addRenterDetails(renterEntity);
		RenterEntity renter = renterdao.loginRenter(username, password);
		//System.out.println(Renter.getRenterId() + Renter.getRenterFname());
		
		byte[] byteArr;
		Blob blob;
		mv = new ModelAndView();
			byteArr = file.getBytes();
			blob = new SerialBlob(byteArr);
			imageInfoDao.addImageR(blob, renter,"renter");
			mv.setViewName("login");
			
		}
		catch (Exception e) 
		{	
			e.printStackTrace();
			mv = new ModelAndView();
			mv.setViewName("renterregistration");
			
		}
		return mv;
	}
	
	
	

	@GetMapping("/editrentert")
	public ModelAndView editRenter(@RequestParam int renterid)
	{
		System.out.println("2");
		ModelAndView mv = new ModelAndView();
		RenterEntity renter = renterdao.findById(renterid);
		mv.addObject("renter", renter);
		mv.setViewName("ProfileRenterEdit");
		return mv;	
	}
	
	
	// having problem saving into database
	//<-------
	
	
	//-----testing logout----> 
	@GetMapping("/logoutt")
	public ModelAndView logout(HttpSession session) {
		ModelAndView mv = new ModelAndView();
		System.out.println("inside logout");
		session.invalidate();
		mv.setViewName("index");
		return mv;
	}
	@PostMapping("/uprenter") public String updateProfile(@RequestParam String fname,
			@RequestParam String lname, @RequestParam String mobile,
			@RequestParam String email, @RequestParam String password,
			@RequestParam String address,@RequestParam String ShopDetails,
			HttpServletRequest request)
	{  
		//System.out.println("3");
		
		RenterEntity renter=(RenterEntity) request.getSession().getAttribute("renter");
		renter.setRenterFname(fname);
		renter.setRenterLname(lname);
		renter.setRenterMobile(mobile);
	    renter.setRenterEmail(email);
	    renter.setRenterPassword(password);
	    renter.setRenterAddress(address);
	    renter.setRenterShopDetails(ShopDetails);
	    renterdao.updateRenter(renter); 
		return "ProfileRenter"; 
	}
	@GetMapping("/deleteequipment")
	public ModelAndView deleteEquipments(@RequestParam int equipmentid)
	{
		ModelAndView mv = new ModelAndView();
	    renterdao.deleteEquipment(equipmentid);
		mv.setViewName("ProfileMyEquipment");
		return mv;
	}
	
	@GetMapping("/rentershowlist")
	public ModelAndView searchEquipmentsType(HttpServletRequest request) {
		
		RenterEntity renter=(RenterEntity) request.getSession().getAttribute("renter");
		
		ModelAndView mv = new ModelAndView();
		// http://localhost:9090/search?type=seeding
		List<EquipmentInfoTable> equipmentRenterList =equipmentDao.getEquipmentList(renter.getRenterId());
		mv.addObject("equipmentRenterList", equipmentRenterList);
		mv.setViewName("ProfileMyEquipment");
		return mv;
	}
	
//	 @GetMapping("/editequipment")
//		public ModelAndView editEquipment(@RequestParam int equipmentid)
//		{
//			ModelAndView mv = new ModelAndView();
//			EquipmentInfoTable equipment = equipmentDao.findById(equipmentid);
//			
//			mv.addObject("equipment", equipment);
//			mv.setViewName("editEquipments");
//			return mv;	
//		}
	 // after edit need to be save the edited details 
	
}
