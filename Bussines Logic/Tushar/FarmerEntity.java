package com.demo.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "farmer_info_tbl")
public class FarmerEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "farmer_id")
	private int farmer_id;
	
	@Column(name = "farmer_fname",nullable = false)
	private String farmer_fname;
	
	@Column(name = "farmer_mobile",unique = true,nullable = false)
	private String farmer_mobile;
	
	@Column(name = "farmer_email",nullable = false,unique = true)
	private String farmer_email;
	
	@Column(name = "farmer_username",nullable = false)
	private String farmer_username;
	
	@Column(name = "farmer_password",nullable = false)
	private String farmer_password;
	
	@Column(name = "farmer_address",nullable = false)
	private String farmer_address;
	
	@Column(name = "farmer_pincode",nullable = false)
	private int farmer_pincode;
	
	public FarmerEntity() {
	}

	public FarmerEntity(int farmer_id, String farmer_fname, String farmer_mobile, String farmer_email, String farmer_username,
			String farmer_password, String farmer_address, int farmer_pincode) {
		super();
		this.farmer_id = farmer_id;
		this.farmer_fname = farmer_fname;
		this.farmer_mobile = farmer_mobile;
		this.farmer_email = farmer_email;
		this.farmer_username = farmer_username;
		this.farmer_password = farmer_password;
		this.farmer_address = farmer_address;
		this.farmer_pincode = farmer_pincode;
	}

	public int getFarmer_id() {
		return farmer_id;
	}

	public void setFarmer_id(int farmer_id) {
		this.farmer_id = farmer_id;
	}

	public String getFarmer_fname() {
		return farmer_fname;
	}

	public void setFarmer_fname(String farmer_fname) {
		this.farmer_fname = farmer_fname;
	}

	public String getFarmer_mobile() {
		return farmer_mobile;
	}

	public void setFarmer_mobile(String farmer_mobile) {
		this.farmer_mobile = farmer_mobile;
	}

	public String getFarmer_email() {
		return farmer_email;
	}

	public void setFarmer_email(String farmer_email) {
		this.farmer_email = farmer_email;
	}

	public String getFarmer_username() {
		return farmer_username;
	}

	public void setFarmer_username(String farmer_username) {
		this.farmer_username = farmer_username;
	}

	public String getFarmer_password() {
		return farmer_password;
	}

	public void setFarmer_password(String farmer_password) {
		this.farmer_password = farmer_password;
	}

	public String getFarmer_address() {
		return farmer_address;
	}

	public void setFarmer_address(String farmer_address) {
		this.farmer_address = farmer_address;
	}

	public int getFarmer_pincode() {
		return farmer_pincode;
	}

	public void setFarmer_pincode(int farmer_pincode) {
		this.farmer_pincode = farmer_pincode;
	}

	@Override
	public String toString() {
		return "FarmerEntity [farmer_id=" + farmer_id + ", farmer_fname=" + farmer_fname + ", farmer_mobile="
				+ farmer_mobile + ", farmer_email=" + farmer_email + ", farmer_username=" + farmer_username
				+ ", farmer_password=" + farmer_password + ", farmer_address=" + farmer_address + ", farmer_pincode="
				+ farmer_pincode + "]";
	}
}
