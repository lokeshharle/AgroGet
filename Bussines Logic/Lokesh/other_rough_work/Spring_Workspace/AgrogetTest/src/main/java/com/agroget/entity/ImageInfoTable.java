package com.agroget.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="image_info_tbl")
public class ImageInfoTable {

	@Id
	@Column(name="image_id")
	private int imageId;

	@Lob
	@Column(name="image_data",nullable = false)
	private byte[] imageData;

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

	public ImageInfoTable() {
		super();
	}
	
	
}
