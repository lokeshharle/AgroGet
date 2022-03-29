package com.agroget.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agroget.entity.EquipmentInfoTable;
import com.agroget.rerpository.EquipmentRespository;

@Service
public class EquipmentDao {
	
	@Autowired
	private EquipmentRespository equipRepo;
	
	public List<EquipmentInfoTable> getAllEquipment()
	{
		return equipRepo.findAll();
		
	}
	
	public List<EquipmentInfoTable> findByEquipmentType(String type)
	{
		return equipRepo.findByEquipmentType(type);
	}

	
	
	
}
