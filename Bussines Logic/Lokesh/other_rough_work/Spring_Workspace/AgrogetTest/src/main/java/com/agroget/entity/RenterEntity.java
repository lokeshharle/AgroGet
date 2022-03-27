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
}
