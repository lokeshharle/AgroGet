package com.agroget.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agroget.rerpository.OrderInfoRepository;

@Service
public class OrderInfoDao {
	
	@Autowired
	OrderInfoRepository orderInfoRepo;
	
	

}
