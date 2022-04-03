package com.agroget.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "farmer_info_tbl")
public class FarmerEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "farmer_id")
	private int farmerId;
	
	@Column(name = "farmer_fname",nullable = false,length = 20)
	private String farmerFname;
	
	@Column(name = "farmer_lname",nullable = false,length = 20)
	private String farmerLname;
	
	@Column(name = "farmer_mobile",unique = true,nullable = false,length = 10)
	private String farmerMobile;
	
	@Column(name = "farmer_email",nullable = false,unique = true,length = 50)
	private String farmerEmail;
	
	@Column(name = "farmer_username",nullable = false,length = 50)
	private String farmerUsername;
	
	@Column(name = "farmer_password",nullable = false,length = 20)
	private String farmerPassword;
	
	@Column(name = "farmer_address",nullable = false,length = 100)
	private String farmerAddress;
	
	@Column(name = "farmer_pincode",nullable = false,length = 6)
	private String farmerPincode;
	
	@OneToMany(mappedBy="farmerInfoTbl")
	private List<OrderInfoTable> orderInfoTbls;
	
	@OneToMany(mappedBy="farmerInfoTbl")
	private List<FeedBackInfoTable> feedbackInfoTbls;

	@OneToMany(mappedBy="farmerInfoTbl")
	private List<ImageInfoTable> imageInfoTbls;
	
	public FarmerEntity() {
	}

	public FarmerEntity(String farmerFname, String farmerLname, String farmerMobile, String farmerEmail,
			String farmerUsername, String farmerPassword, String farmerAddress, String farmerPincode) {
		super();
		this.farmerFname = farmerFname;
		this.farmerLname = farmerLname;
		this.farmerMobile = farmerMobile;
		this.farmerEmail = farmerEmail;
		this.farmerUsername = farmerUsername;
		this.farmerPassword = farmerPassword;
		this.farmerAddress = farmerAddress;
		this.farmerPincode = farmerPincode;
	}

	public FarmerEntity(String farmerEmail, String farmerUsername, String farmerPassword) {
		super();
		this.farmerUsername = farmerUsername;
		this.farmerPassword = farmerPassword;
	}

	public FarmerEntity(String farmerEmail, String farmerPassword) {
		super();
		this.farmerEmail = farmerEmail;
		this.farmerPassword = farmerPassword;
	}

	public int getFarmerId() {
		return farmerId;
	}

	public void setFarmerId(int farmerId) {
		this.farmerId = farmerId;
	}

	public String getFarmerFname() {
		return farmerFname;
	}

	public void setFarmerFname(String farmerFname) {
		this.farmerFname = farmerFname;
	}

	public String getFarmerLname() {
		return farmerLname;
	}

	public void setFarmerLname(String farmerLname) {
		this.farmerLname = farmerLname;
	}

	public String getFarmerMobile() {
		return farmerMobile;
	}

	public void setFarmerMobile(String farmerMobile) {
		this.farmerMobile = farmerMobile;
	}

	public String getFarmerEmail() {
		return farmerEmail;
	}

	public void setFarmerEmail(String farmerEmail) {
		this.farmerEmail = farmerEmail;
	}

	public String getFarmerUsername() {
		return farmerUsername;
	}

	public void setFarmerUsername(String farmerUsername) {
		this.farmerUsername = farmerUsername;
	}

	public String getFarmerPassword() {
		return farmerPassword;
	}

	public void setFarmerPassword(String farmerPassword) {
		this.farmerPassword = farmerPassword;
	}

	public String getFarmerAddress() {
		return farmerAddress;
	}

	public void setFarmerAddress(String farmerAddress) {
		this.farmerAddress = farmerAddress;
	}

	public String getFarmerPincode() {
		return farmerPincode;
	}

	public void setFarmerPincode(String farmerPincode) {
		this.farmerPincode = farmerPincode;
	}

	@Override
	public String toString() {
		return "FarmerEntity [farmerId=" + farmerId + ", farmerFname=" + farmerFname + ", farmerLname=" + farmerLname
				+ ", farmerMobile=" + farmerMobile + ", farmerEmail=" + farmerEmail + ", farmerUsername="
				+ farmerUsername + ", farmerPassword=" + farmerPassword + ", farmerAddress=" + farmerAddress
				+ ", farmerPincode=" + farmerPincode + ", orderInfoTbls=" + orderInfoTbls + ", feedbackInfoTbls="
				+ feedbackInfoTbls + ", imageInfoTbls=" + imageInfoTbls + "]";
	}
	
	
	
	
}
