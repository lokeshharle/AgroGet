package com.agroget.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.agroget.entity.EquipmentInfoTable;
import com.agroget.entity.RenterEntity;
import com.agroget.rerpository.EquipmentRespository;
import com.agroget.rerpository.RenterRepository;


@Repository
public class RenterDao {
	@Autowired
	RenterRepository RenterRepo;
	@Autowired
	EquipmentRespository euipmentRepo;
	
	public void addRenterDetails(RenterEntity Renter)
	{
		RenterRepo.save(Renter);
		
	}
	
	public RenterEntity loginRenter(String username,String password)
	{
		RenterEntity RenterEntity = RenterRepo.loginRenter(username, password);
		return RenterEntity;
		
	}

	public RenterEntity findById(int Renterid) {
		Optional<RenterEntity> op = RenterRepo.findById(Renterid);
		RenterEntity Renter = op.get();
		return Renter;
	}

	public void updateRenter(RenterEntity Renter) {
		RenterRepo.save(Renter);
		
	}
	

	
	

	
	public void deleteEquipment(int equipmentId) {
		Optional<EquipmentInfoTable> op = euipmentRepo.findById(equipmentId);
		EquipmentInfoTable equipment=op.get();
		euipmentRepo.delete(equipment);
	}
	
	

}
