package com.agroget.dao;

import java.sql.Blob;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.agroget.entity.FarmerEntity;
import com.agroget.entity.ImageInfoTable;
import com.agroget.rerpository.ImageInfoRepository;



@Repository
public class ImageInfoDao {
	
	@Autowired
	ImageInfoRepository imageInfoTablRepo;
	
	public void addImageF(Blob imageData,  FarmerEntity farmerInfoTbl,String imageDescription) {
		ImageInfoTable imgf = new ImageInfoTable(imageData, farmerInfoTbl,imageDescription);
		imageInfoTablRepo.save(imgf);
	}

}
