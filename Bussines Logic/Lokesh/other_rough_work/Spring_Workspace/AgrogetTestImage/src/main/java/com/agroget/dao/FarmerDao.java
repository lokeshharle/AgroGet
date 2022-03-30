package com.agroget.dao;

import java.sql.Blob;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.agroget.entity.FarmerEntity;
import com.agroget.rerpository.FarmerRespository;



@Repository
public class FarmerDao {
	
	@Autowired
	FarmerRespository farmerRepo;
	
	/*
	 * public void addFarmerDetails(FarmerEntity farmer) {
	 * 
	 * farmerRepo.save(farmer);
	 * 
	 * }
	 */
	
			
	/*
	 * public FarmerEntity loginFarmer(String username,String password) {
	 * FarmerEntity farmerEntity = farmerRepo.loginFarmer(username, password);
	 * return farmerEntity;
	 * 
	 * }
	 */

	/*
	 * public FarmerEntity findById(int farmerid) { Optional<FarmerEntity> op =
	 * farmerRepo.findById(farmerid); FarmerEntity farmer = op.get(); return farmer;
	 * }
	 * 
	 * public void updateFarmer(FarmerEntity farmer) { farmerRepo.save(farmer);
	 * 
	 * }
	 */
	
	public void addVendor(String Vendor_FirstName,String Vendor_LastName,
			String Vendor_MobileNo, String Vendor_EmailId, 
			String Vendor_UserName, String Vendor_Password,
			String Vendor_Address,  String Vendor_State,
			 String Vendor_City,  int Vendor_Pincode,
			Blob image )
	{
		FarmerEntity object = new FarmerEntity(Vendor_LastName, Vendor_MobileNo, Vendor_EmailId, Vendor_UserName, Vendor_Password, Vendor_Address, Vendor_State, Vendor_City, image);
		farmerRepo.save(object);
		
	}

}
