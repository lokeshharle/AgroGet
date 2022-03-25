package com.demo.pojo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "renter_info_tbl")
public class RenterEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "renter_id")
	private int renter_id;
	
	@Column(name = "renter_fname",nullable = false)
	private String renter_fname;
	
	@Column(name = "renter_mobile",unique = true,nullable = false)
	private String renter_mobile;
	
	@Column(name = "renter_email",nullable = false,unique = true)
	private String renter_email;
	
	@Column(name = "renter_username",nullable = false)
	private String renter_username;
	
	@Column(name = "renter_password",nullable = false)
	private String renter_password;
	
	@Column(name = "renter_address",nullable = false)
	private String renter_address;
	
	@Column(name = "renter_pincode",nullable = false)
	private int renter_pincode;
	
	@Column(name = "renter_shop_details",nullable = false)
	private String renter_shop_details;
	
	@Column(name = "renter_is_approved",columnDefinition = "TINYINT", nullable = false)
	private int renter_is_approved;
	
	@OneToMany(mappedBy = "renter", cascade = CascadeType.ALL)
	Set<EquipmentInfoTable> listOfEquipments=new HashSet<>();

	public RenterEntity() {
		super();
	}

	//constructor before adding equiments 
	public RenterEntity(int renter_id, String renter_fname, String renter_mobile, String renter_email,
			String renter_username, String renter_password, String renter_address, int renter_pincode,
			String renter_shop_details, int renter_is_approved) {
		super();
		this.renter_id = renter_id;
		this.renter_fname = renter_fname;
		this.renter_mobile = renter_mobile;
		this.renter_email = renter_email;
		this.renter_username = renter_username;
		this.renter_password = renter_password;
		this.renter_address = renter_address;
		this.renter_pincode = renter_pincode;
		this.renter_shop_details = renter_shop_details;
		this.renter_is_approved = renter_is_approved;
	}

	//constructor for after adding equipments 
	public RenterEntity(int renter_id, String renter_fname, String renter_mobile, String renter_email,
			String renter_username, String renter_password, String renter_address, int renter_pincode,
			String renter_shop_details, int renter_is_approved, Set<EquipmentInfoTable> listOfEquipments) {
		super();
		this.renter_id = renter_id;
		this.renter_fname = renter_fname;
		this.renter_mobile = renter_mobile;
		this.renter_email = renter_email;
		this.renter_username = renter_username;
		this.renter_password = renter_password;
		this.renter_address = renter_address;
		this.renter_pincode = renter_pincode;
		this.renter_shop_details = renter_shop_details;
		this.renter_is_approved = renter_is_approved;
		this.listOfEquipments = listOfEquipments;
	}
	
	

	public Set<EquipmentInfoTable> getListOfEquipments() {
		return listOfEquipments;
	}

	public void setListOfEquipments(Set<EquipmentInfoTable> listOfEquipments) {
		this.listOfEquipments = listOfEquipments;
	}

	public int getRenter_id() {
		return renter_id;
	}

	public void setRenter_id(int renter_id) {
		this.renter_id = renter_id;
	}

	public String getRenter_fname() {
		return renter_fname;
	}

	public void setRenter_fname(String renter_fname) {
		this.renter_fname = renter_fname;
	}

	public String getRenter_mobile() {
		return renter_mobile;
	}

	public void setRenter_mobile(String renter_mobile) {
		this.renter_mobile = renter_mobile;
	}

	public String getRenter_email() {
		return renter_email;
	}

	public void setRenter_email(String renter_email) {
		this.renter_email = renter_email;
	}

	public String getRenter_username() {
		return renter_username;
	}

	public void setRenter_username(String renter_username) {
		this.renter_username = renter_username;
	}

	public String getRenter_password() {
		return renter_password;
	}

	public void setRenter_password(String renter_password) {
		this.renter_password = renter_password;
	}

	public String getRenter_address() {
		return renter_address;
	}

	public void setRenter_address(String renter_address) {
		this.renter_address = renter_address;
	}

	public int getRenter_pincode() {
		return renter_pincode;
	}

	public void setRenter_pincode(int renter_pincode) {
		this.renter_pincode = renter_pincode;
	}

	public String getRenter_shop_details() {
		return renter_shop_details;
	}

	public void setRenter_shop_details(String renter_shop_details) {
		this.renter_shop_details = renter_shop_details;
	}

	public int getRenter_is_approved() {
		return renter_is_approved;
	}

	public void setRenter_is_approved(int renter_is_approved) {
		this.renter_is_approved = renter_is_approved;
	}

	@Override
	public String toString() {
		return "RenterEntity [renter_id=" + renter_id + ", renter_fname=" + renter_fname + ", renter_mobile="
				+ renter_mobile + ", renter_email=" + renter_email + ", renter_username=" + renter_username
				+ ", renter_password=" + renter_password + ", renter_address=" + renter_address + ", renter_pincode="
				+ renter_pincode + ", renter_shop_details=" + renter_shop_details + ", renter_is_approved="
				+ renter_is_approved + "]";
	}
	
	
	
}
