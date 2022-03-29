package com.agroget.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agroget.entity.OrderInfoTable;
import com.agroget.rerpository.OrderInfoRepository;

@Service
public class OrderInfoDao {
	
	@Autowired
	OrderInfoRepository orderInfoRepo;
	
	public void saveOI(OrderInfoTable oi) {
		
		OrderInfoTable s =  orderInfoRepo.save(oi);
		System.out.println(s.getOrderId());
		
	}
	
	public OrderInfoTable findById(int id)
	{
		Optional<OrderInfoTable> o = orderInfoRepo.findById(id);
		OrderInfoTable oi = o.get();
		return oi;
	}

}
