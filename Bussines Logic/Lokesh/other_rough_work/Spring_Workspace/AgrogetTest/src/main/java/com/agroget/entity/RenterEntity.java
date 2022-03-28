package com.agroget.entity;

import java.util.List;

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
	private int renterId;
	
	@Column(name = "renter_fname",nullable = false,length = 20)
	private String renterFname;
	
	@Column(name = "renter_lname",nullable = false,length = 20)
	private String renterLname;
	
	@Column(name = "renter_mobile",unique = true,nullable = false,length = 11)
	private String renterMobile;
	
	@Column(name = "renter_email",nullable = false,unique = true,length = 20)
	private String renterEmail;
	
	@Column(name = "renter_username",nullable = false,length = 50)
	private String renterUsername;
	
	@Column(name = "renter_password",nullable = false,length = 20)
	private String renterPassword;
	
	@Column(name = "renter_address",nullable = false,length = 100)
	private String renterAddress;
	
	@Column(name = "renter_pincode",nullable = false,length = 6)
	private int renterPincode;
	
	@Column(name = "renter_shop_details",nullable = false,length = 100)
	private String renterShopDetails;
	
	@Column(name = "renter_is_approved",columnDefinition = "TINYINT", nullable = false,length = 1)
	private int renterIsApproved;
	
	@OneToMany(mappedBy = "renter",cascade = CascadeType.ALL)
	List<EquipmentInfoTable> listOfEquipments;

	@OneToMany(mappedBy="renterInfoTbl",cascade = CascadeType.ALL)
	private List<ImageInfoTable> imageInfoTbls;
	
	public RenterEntity() {
	}
	
	

	public int getRenterId() {
		return renterId;
	}



	public void setRenterId(int renterId) {
		this.renterId = renterId;
	}



	public String getRenterFname() {
		return renterFname;
	}



	public void setRenterFname(String renterFname) {
		this.renterFname = renterFname;
	}



	public String getRenterLname() {
		return renterLname;
	}



	public void setRenterLname(String renterLname) {
		this.renterLname = renterLname;
	}



	public String getRenterMobile() {
		return renterMobile;
	}



	public void setRenterMobile(String renterMobile) {
		this.renterMobile = renterMobile;
	}



	public String getRenterEmail() {
		return renterEmail;
	}



	public void setRenterEmail(String renterEmail) {
		this.renterEmail = renterEmail;
	}



	public String getRenterUsername() {
		return renterUsername;
	}



	public void setRenterUsername(String renterUsername) {
		this.renterUsername = renterUsername;
	}



	public String getRenterPassword() {
		return renterPassword;
	}



	public void setRenterPassword(String renterPassword) {
		this.renterPassword = renterPassword;
	}



	public String getRenterAddress() {
		return renterAddress;
	}



	public void setRenterAddress(String renterAddress) {
		this.renterAddress = renterAddress;
	}



	public int getRenterPincode() {
		return renterPincode;
	}



	public void setRenterPincode(int renterPincode) {
		this.renterPincode = renterPincode;
	}



	public String getRenterShopDetails() {
		return renterShopDetails;
	}



	public void setRenterShopDetails(String renterShopDetails) {
		this.renterShopDetails = renterShopDetails;
	}



	public int getRenterIsApproved() {
		return renterIsApproved;
	}



	public void setRenterIsApproved(int renterIsApproved) {
		this.renterIsApproved = renterIsApproved;
	}



	public List<EquipmentInfoTable> getListOfEquipments() {
		return listOfEquipments;
	}



	public void setListOfEquipments(List<EquipmentInfoTable> listOfEquipments) {
		this.listOfEquipments = listOfEquipments;
	}



	public List<ImageInfoTable> getImageInfoTbls() {
		return imageInfoTbls;
	}



	public void setImageInfoTbls(List<ImageInfoTable> imageInfoTbls) {
		this.imageInfoTbls = imageInfoTbls;
	}



	public RenterEntity(int renterId, String renterFname, String renterLname, String renterMobile, String renterEmail,
			String renterUsername, String renterPassword, String renterAddress, int renterPincode,
			String renterShopDetails, int renterIsApproved) {
		super();
		this.renterId = renterId;
		this.renterFname = renterFname;
		this.renterLname = renterLname;
		this.renterMobile = renterMobile;
		this.renterEmail = renterEmail;
		this.renterUsername = renterUsername;
		this.renterPassword = renterPassword;
		this.renterAddress = renterAddress;
		this.renterPincode = renterPincode;
		this.renterShopDetails = renterShopDetails;
		this.renterIsApproved = renterIsApproved;
	}



	@Override
	public String toString() {
		return "RenterEntity [renterId=" + renterId + ", renterFname=" + renterFname + ", renterLname=" + renterLname
				+ ", renterMobile=" + renterMobile + ", renterEmail=" + renterEmail + ", renterUsername="
				+ renterUsername + ", renterPassword=" + renterPassword + ", renterAddress=" + renterAddress
				+ ", renterPincode=" + renterPincode + ", renterShopDetails=" + renterShopDetails
				+ ", renterIsApproved=" + renterIsApproved + ", listOfEquipments=" + listOfEquipments
				+ ", imageInfoTbls=" + imageInfoTbls + "]";
	}
	
	
}
