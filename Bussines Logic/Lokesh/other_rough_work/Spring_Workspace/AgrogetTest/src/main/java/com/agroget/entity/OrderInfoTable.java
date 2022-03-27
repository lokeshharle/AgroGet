package com.agroget.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.OneToMany;

@Entity
@Table(name="order_info_tbl")
public class OrderInfoTable {

	@Id
	@Column(name="order_id")
	private int orderId;
	
	@Temporal(TemporalType.DATE)
	@Column(name="order_date",nullable = false)
	private Date orderDate;

	@Column(name="order_status",columnDefinition = "TINYINT")
	private byte orderStatus;

	@Column(name="order_total_cost")
	private double orderTotalCost;

	@ManyToOne
	@JoinColumn(name="farmer_id",nullable = false)
	private FarmerEntity farmerInfoTbl;
	
	@OneToMany(mappedBy="orderInfoTbl")
	private List<OrderEquipmentTable> orderEquipmentTbls;

	public OrderInfoTable() {
		super();
	}
	
	
}
