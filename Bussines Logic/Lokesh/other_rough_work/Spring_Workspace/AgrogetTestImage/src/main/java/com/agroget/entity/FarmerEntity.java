package com.agroget.entity;

import java.sql.Blob;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name = "farmer_info_tbl")
public class FarmerEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "farmer_id")
	private int farmerId;
	
	@Column(name = "farmer_fname",length = 20)
	private String farmerFname;
	
	@Column(name = "farmer_lname",length = 20)
	private String farmerLname;
	
	@Column(name = "farmer_mobile",unique = true,length = 11)
	private String farmerMobile;
	
	@Column(name = "farmer_email",unique = true,length = 50)
	private String farmerEmail;
	
	@Column(name = "farmer_username",length = 50)
	private String farmerUsername;
	
	@Column(name = "farmer_password",length = 20)
	private String farmerPassword;
	
	@Column(name = "farmer_address",length = 100)
	private String farmerAddress;
	
	@Column(name = "farmer_pincode",length = 6)
	private String farmerPincode;
	
	@Lob
	@Column(name="vendor_image ",columnDefinition = "MEDIUMBLOB")
	private Blob farmerImage ;

	
	
	public FarmerEntity(String farmerFname, String farmerLname, String farmerMobile, String farmerEmail,
			String farmerUsername, String farmerPassword, String farmerAddress, String farmerPincode,
			Blob farmerImage) {
		super();
		this.farmerFname = farmerFname;
		this.farmerLname = farmerLname;
		this.farmerMobile = farmerMobile;
		this.farmerEmail = farmerEmail;
		this.farmerUsername = farmerUsername;
		this.farmerPassword = farmerPassword;
		this.farmerAddress = farmerAddress;
		this.farmerPincode = farmerPincode;
		this.farmerImage = farmerImage;
	}

	public FarmerEntity() {
		super();
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
	
	

	public Blob getFarmerImage() {
		return farmerImage;
	}

	public void setFarmerImage(Blob farmerImage) {
		this.farmerImage = farmerImage;
	}

	@Override
	public String toString() {
		return "FarmerEntity [farmerId=" + farmerId + ", farmerFname=" + farmerFname + ", farmerLname=" + farmerLname
				+ ", farmerMobile=" + farmerMobile + ", farmerEmail=" + farmerEmail + ", farmerUsername="
				+ farmerUsername + ", farmerPassword=" + farmerPassword + ", farmerAddress=" + farmerAddress
				+ ", farmerPincode=" + farmerPincode + "]";
	}

}
