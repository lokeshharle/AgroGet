package com.agroget.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agroget.entity.OrderEquipmentTable;
import com.agroget.rerpository.OrderEquipmentRepository;

@Service
public class OrderEquipmentDao {
	
	@Autowired
	OrderEquipmentRepository orderEquipmentRepo;
	
	public OrderEquipmentTable getById(int id)
	{
		Optional<OrderEquipmentTable> optEnt = orderEquipmentRepo.findById(id);
		OrderEquipmentTable oe = optEnt.get();
		return oe;
	}
	
	public void saveOrderEquipment(OrderEquipmentTable oe)
	{
		orderEquipmentRepo.save(oe);
	}

}
