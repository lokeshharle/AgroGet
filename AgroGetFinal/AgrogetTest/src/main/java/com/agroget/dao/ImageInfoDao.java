package com.agroget.dao;

import java.sql.Blob;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.agroget.entity.EquipmentInfoTable;
import com.agroget.entity.FarmerEntity;
import com.agroget.entity.ImageInfoTable;
import com.agroget.entity.RenterEntity;
import com.agroget.rerpository.ImageInfoRepository;



@Repository
public class ImageInfoDao {
	
	@Autowired
	ImageInfoRepository imageInfoTablRepo;
	
	public void addImageF(Blob imageData,  FarmerEntity farmerInfoTbl,String imageDescription) {
		ImageInfoTable imgf = new ImageInfoTable(imageData, farmerInfoTbl,imageDescription);
		imageInfoTablRepo.save(imgf);
	}
	
	public void addImageR(Blob imageData,  RenterEntity renterInfoTbl,String imageDescription) {
		ImageInfoTable imgf = new ImageInfoTable(imageData, renterInfoTbl,imageDescription);
		imageInfoTablRepo.save(imgf);
	}



	public void addImageE(Blob imageData, EquipmentInfoTable equipmentEntity, String imageDescription) {
		ImageInfoTable imgf = new ImageInfoTable(imageData, equipmentEntity,imageDescription);
		imageInfoTablRepo.save(imgf);
		
	}

}
