package com.agroget.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agroget.entity.EquipmentInfoTable;
import com.agroget.entity.FarmerEntity;
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

	public List<EquipmentInfoTable> equipmentTypeList()
	{
		return equipRepo.equipmentTypeList();
	}
	
	public void addEquipmentDetails(EquipmentInfoTable equipment)
	{
		equipRepo.save(equipment);
		
	}
	public EquipmentInfoTable findById(int equipmentid) {
		Optional<EquipmentInfoTable> op = equipRepo.findById(equipmentid);
		EquipmentInfoTable equipments=op.get();
		return equipments;
	}
	public EquipmentInfoTable updateEquipments(EquipmentInfoTable equip) {
		return equipRepo.save(equip);
	}

	public void saveEquipment(EquipmentInfoTable equipment) {
		equipRepo.save(equipment);
	}
	public List<EquipmentInfoTable> getEquipmentList(int renterId){
		return equipRepo.getEquipmentList(renterId);
	}

	public EquipmentInfoTable findByEquipmentId(int equipmentid) {
		Optional<EquipmentInfoTable> op = equipRepo.findById(equipmentid);
		EquipmentInfoTable equipment = op.get();
		return equipment;
	}
	
}
