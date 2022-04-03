package com.agroget.entity;

import java.sql.Blob;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="image_info_tbl")
public class ImageInfoTable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="image_id")
	private int imageId;

	@Lob
	@Column(name="image_data",nullable = false)
	private Blob imageData;

	@Column(name="image_description",length = 50)
	private String imageDescription;
	
	@ManyToOne
	@JoinColumn(name="farmer_id")
	private FarmerEntity farmerInfoTbl;
	
	@ManyToOne
	@JoinColumn(name="renter_id")
	private RenterEntity renterInfoTbl;
	
	@ManyToOne
	@JoinColumn(name="equipment_id")
	private EquipmentInfoTable equipmentInfoTbl;

	public Blob getImageData() {
		return imageData;
	}

	public void setImageData(Blob imageData) {
		this.imageData = imageData;
	}

	public String getImageDescription() {
		return imageDescription;
	}

	public void setImageDescription(String imageDescription) {
		this.imageDescription = imageDescription;
	}

	public FarmerEntity getFarmerInfoTbl() {
		return farmerInfoTbl;
	}

	public void setFarmerInfoTbl(FarmerEntity farmerInfoTbl) {
		this.farmerInfoTbl = farmerInfoTbl;
	}

	public RenterEntity getRenterInfoTbl() {
		return renterInfoTbl;
	}

	public void setRenterInfoTbl(RenterEntity renterInfoTbl) {
		this.renterInfoTbl = renterInfoTbl;
	}

	public EquipmentInfoTable getEquipmentInfoTbl() {
		return equipmentInfoTbl;
	}

	public void setEquipmentInfoTbl(EquipmentInfoTable equipmentInfoTbl) {
		this.equipmentInfoTbl = equipmentInfoTbl;
	}

	public ImageInfoTable() {
		super();
	}

	public ImageInfoTable(Blob imageData, String imageDescription, FarmerEntity farmerInfoTbl,
			RenterEntity renterInfoTbl, EquipmentInfoTable equipmentInfoTbl) {
		super();
		this.imageData = imageData;
		this.imageDescription = imageDescription;
		this.farmerInfoTbl = farmerInfoTbl;
		this.renterInfoTbl = renterInfoTbl;
		this.equipmentInfoTbl = equipmentInfoTbl;
	}
	
	public ImageInfoTable(Blob imageData,  FarmerEntity farmerInfoTbl,String imageDescription) {
		super();
		this.imageData = imageData;
		this.farmerInfoTbl = farmerInfoTbl;
		this.imageDescription = imageDescription;
	}
	
	public ImageInfoTable(Blob imageData,  RenterEntity renterInfoTbl,String imageDescription) {
		super();
		this.imageData = imageData;
		this.renterInfoTbl = renterInfoTbl;
		this.imageDescription = imageDescription;
				
	}
	
	public ImageInfoTable(Blob imageData, String imageDescription,  EquipmentInfoTable equipmentInfoTbl) {
		super();
		this.imageData = imageData;
		this.imageDescription = imageDescription;
		this.equipmentInfoTbl = equipmentInfoTbl;
		this.imageDescription = imageDescription;
	}
	
	

	public ImageInfoTable(Blob imageData2, EquipmentInfoTable equipmentEntity2, String imageDescription2) {
		this.imageData = imageData2;
		this.imageDescription = imageDescription2;
		this.equipmentInfoTbl = equipmentEntity2;
		this.imageDescription = imageDescription2;
	}

	@Override
	public String toString() {
		return "ImageInfoTable [imageId=" + imageId + ", imageData=" + imageData + ", imageDescription="
				+ imageDescription + ", farmerInfoTbl=" + farmerInfoTbl + ", renterInfoTbl=" + renterInfoTbl
				+ ", equipmentInfoTbl=" + equipmentInfoTbl + "]";
	}
	
	
}
