package com.agroget.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.agroget.entity.FarmerEntity;
import com.agroget.rerpository.FarmerRespository;



@Repository
public class FarmerDao {
	
	@Autowired
	FarmerRespository farmerRepo;
	
	public void addFarmerDetails(FarmerEntity farmer)
	{
		farmerRepo.save(farmer);
		
	}
	
	public FarmerEntity loginFarmer(String username,String password)
	{
		FarmerEntity farmerEntity = farmerRepo.loginFarmer(username, password);
		return farmerEntity;
		
	}

	public FarmerEntity findById(int farmerid) {
		Optional<FarmerEntity> op = farmerRepo.findById(farmerid);
		FarmerEntity farmer = op.get();
		return farmer;
	}

	public void updateFarmer(FarmerEntity farmer) {
		farmerRepo.save(farmer);
		
	}
	
	
	

}
