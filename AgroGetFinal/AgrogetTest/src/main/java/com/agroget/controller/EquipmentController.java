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
import com.agroget.dao.RenterDao;
import com.agroget.entity.EquipmentInfoTable;
import com.agroget.entity.FarmerEntity;
import com.agroget.entity.OrderEquipmentTable;
import com.agroget.entity.OrderInfoTable;
import com.agroget.entity.RenterEntity;
import com.agroget.entity.FarmerEntity;

@Controller
@SessionAttributes("equipment")
public class EquipmentController {
	
	
	
	@Autowired
	ImageInfoDao imageInfoDo;

	
	@Autowired
	EquipmentDao equipmentdao;


	@PostMapping("/addEquipment")
	public String addEquipment(@RequestParam String ename,@RequestParam String etype,@RequestParam String eratetype,@RequestParam double rate,@RequestParam String desc,HttpServletRequest request)
	{
		HttpSession session = request.getSession();
		
		RenterEntity renterentity=(RenterEntity) session.getAttribute("renter");
		EquipmentInfoTable equipmentEntity = new EquipmentInfoTable(ename,etype,eratetype,rate,desc,renterentity);
		equipmentdao.addEquipmentDetails(equipmentEntity);
		
		
//		if(equipmentEntity!=null) {
//	    	return "ProfileRenter";
//	    }
//		byte[] byteArr;
//		Blob blob;
//		try 
//		{
//			byteArr = file.getBytes();
//			blob = new SerialBlob(byteArr);
//			imageInfoDo.addImageE(blob, equipmentEntity,"equipment");
//			
//		}
//		catch (SQLException e) 
//		{	
//			e.printStackTrace();
//			
//		}
//		catch (IOException e1)
//		{
//			e1.printStackTrace();
//			
//		}
//		
//		
//		if(equipmentEntity!=null) {
//	    	return "ProfileRenter";
//	    }
		return "ProfileRenter";
	    
	}
	
	
	
	
	@GetMapping("/editequipment")
	public ModelAndView editEquipment(@RequestParam int equipmentid)
	{
		ModelAndView mv = new ModelAndView();
		EquipmentInfoTable equipment = equipmentdao.findById(equipmentid);
		
		mv.addObject("equipment", equipment);
		mv.setViewName("ProfileEditEquipment");
		return mv;	
	}
	
	
	 @PostMapping("/saveequip")
		public ModelAndView updateEquipments(@RequestParam String equipment_name,
				@RequestParam String equipment_description, @RequestParam double equipment_rate,
				@RequestParam String equipment_rate_type, @RequestParam String equipment_type,
				@RequestParam int equipmId)
		{  
		   String[] s = equipment_rate_type.split(",");
			EquipmentInfoTable equip=equipmentdao.findById(equipmId);
			equip.setEquipment_name(equipment_name);
			equip.setEquipment_description(equipment_description);
			equip.setEquipment_rate(equipment_rate);
			equip.setEquipment_rate_type(s[0]);
			equip.setEquipment_type(equipment_type);
			equipmentdao.updateEquipments(equip);
			ModelAndView mv = new ModelAndView();
			//mv.addObject("renter", equip);
			mv.setViewName("ProfileRenter");
			return mv; 
		}
	
	
}
