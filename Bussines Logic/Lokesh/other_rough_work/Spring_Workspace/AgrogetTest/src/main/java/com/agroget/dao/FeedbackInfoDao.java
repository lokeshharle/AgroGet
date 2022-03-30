package com.agroget.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.agroget.rerpository.FeedBackInfoRepo;

@Service
public class FeedbackInfoDao {
	
	@Autowired
	FeedBackInfoRepo feedBackInfoRepo;

}
