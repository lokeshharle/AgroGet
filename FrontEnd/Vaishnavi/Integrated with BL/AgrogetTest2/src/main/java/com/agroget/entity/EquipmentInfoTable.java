package com.agroget.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="equipment_info_tbl")
public class EquipmentInfoTable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="equipment_id")
	private int equipment_id;
	
	@Column(name="equipment_name",nullable = false,length = 20)
	private String equipment_name;
	
	@Column(name="equipment_type",nullable = false,length = 20)
	private String equipment_type;
	
	@Column(name="equipment_rate_type",nullable = false,length = 15)
	private String equipment_rate_type;
	
	@Column(name="equipment_rate", columnDefinition = "DOUBLE",nullable = false)
	private double equipment_rate;
	
	@Column(name="equipment_description")
	private String equipment_description;
	
	@Column(name="equipment_status",columnDefinition = "TINYINT",nullable = false)
	private int equipment_status;
	
	@ManyToOne
	@JoinColumn(name="renter_id",nullable = false)
	private RenterEntity renter;
	
	@OneToMany(mappedBy="equipmentInfoTbl")
	private List<OrderEquipmentTable> orderEquipmentTbls;
	
	@OneToMany(mappedBy="equipmentInfoTbl")
	private List<FeedBackInfoTable> feedbackInfoTbls;
	
	@OneToMany(mappedBy="equipmentInfoTbl")
	private List<ImageInfoTable> imageInfoTbls;

	//Constructor --> not required renterId (RenterEntity renter)
	public EquipmentInfoTable(int equipment_id, String equipment_name, String equipment_type,
			String equipment_rate_type, double equipment_rate, String equipment_description, int equipment_status) {
		super();
		this.equipment_id = equipment_id;
		this.equipment_name = equipment_name;
		this.equipment_type = equipment_type;
		this.equipment_rate_type = equipment_rate_type;
		this.equipment_rate = equipment_rate;
		this.equipment_description = equipment_description;
		this.equipment_status = equipment_status;
	}

	public int getEquipment_id() {
		return equipment_id;
	}

	public void setEquipment_id(int equipment_id) {
		this.equipment_id = equipment_id;
	}

	public String getEquipment_name() {
		return equipment_name;
	}

	public void setEquipment_name(String equipment_name) {
		this.equipment_name = equipment_name;
	}

	public String getEquipment_type() {
		return equipment_type;
	}

	public void setEquipment_type(String equipment_type) {
		this.equipment_type = equipment_type;
	}

	public String getEquipment_rate_type() {
		return equipment_rate_type;
	}

	public void setEquipment_rate_type(String equipment_rate_type) {
		this.equipment_rate_type = equipment_rate_type;
	}

	public double getEquipment_rate() {
		return equipment_rate;
	}

	public void setEquipment_rate(double equipment_rate) {
		this.equipment_rate = equipment_rate;
	}

	public String getEquipment_description() {
		return equipment_description;
	}

	public void setEquipment_description(String equipment_description) {
		this.equipment_description = equipment_description;
	}

	public int getEquipment_status() {
		return equipment_status;
	}

	public void setEquipment_status(int equipment_status) {
		this.equipment_status = equipment_status;
	}

	public RenterEntity getRenter() {
		return renter;
	}

	public void setRenter(RenterEntity renter) {
		this.renter = renter;
	}
	
	public EquipmentInfoTable()
	{
		
	}

	@Override
	public String toString() {
		return "EquipmentInfoTable [equipment_id=" + equipment_id + ", equipment_name=" + equipment_name
				+ ", equipment_type=" + equipment_type + ", equipment_rate_type=" + equipment_rate_type
				+ ", equipment_rate=" + equipment_rate + ", equipment_description=" + equipment_description
				+ ", equipment_status=" + equipment_status + "]";
	}
	
	
}
