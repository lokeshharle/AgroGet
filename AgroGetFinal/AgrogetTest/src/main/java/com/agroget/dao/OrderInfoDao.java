package com.agroget.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import com.agroget.entity.OrderInfoTable;
import com.agroget.rerpository.OrderInfoRepository;

@Service
public class OrderInfoDao {
	
	@Autowired
	OrderInfoRepository orderInfoRepo;
	
	public void saveOI(OrderInfoTable oi) {
		orderInfoRepo.save(oi);
	}
	
	public OrderInfoTable findById(int id)
	{
		Optional<OrderInfoTable> o = orderInfoRepo.findById(id);
		OrderInfoTable oi = o.get();
		return oi;
	}
	
	public List<OrderInfoTable> findByFarmerId(int farmerId)
	{
		return orderInfoRepo.findByFarmerId(farmerId);
	}
	
	public  OrderInfoTable findByFarmerIdCostStatus(int farmerId)
	{
		List<OrderInfoTable> oiList = orderInfoRepo.findByFarmerIdCostStatus(farmerId,0,0);
		return oiList.get(0);
	}
	
	public void updateOI( int orderId, int farmerId,double ordercost, int orderstatus)
	{
		orderInfoRepo.updateOI(orderId, farmerId, ordercost, 1);
	}

}
