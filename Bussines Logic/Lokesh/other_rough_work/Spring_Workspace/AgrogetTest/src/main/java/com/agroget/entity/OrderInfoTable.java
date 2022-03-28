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

	

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public byte getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(byte orderStatus) {
		this.orderStatus = orderStatus;
	}

	public double getOrderTotalCost() {
		return orderTotalCost;
	}

	public void setOrderTotalCost(double orderTotalCost) {
		this.orderTotalCost = orderTotalCost;
	}

	public FarmerEntity getFarmerInfoTbl() {
		return farmerInfoTbl;
	}

	public void setFarmerInfoTbl(FarmerEntity farmerInfoTbl) {
		this.farmerInfoTbl = farmerInfoTbl;
	}

	public List<OrderEquipmentTable> getOrderEquipmentTbls() {
		return orderEquipmentTbls;
	}

	public void setOrderEquipmentTbls(List<OrderEquipmentTable> orderEquipmentTbls) {
		this.orderEquipmentTbls = orderEquipmentTbls;
	}

	public OrderInfoTable(int orderId, Date orderDate, byte orderStatus, double orderTotalCost,
			FarmerEntity farmerInfoTbl, List<OrderEquipmentTable> orderEquipmentTbls) {
		super();
		this.orderId = orderId;
		this.orderDate = orderDate;
		this.orderStatus = orderStatus;
		this.orderTotalCost = orderTotalCost;
		this.farmerInfoTbl = farmerInfoTbl;
		this.orderEquipmentTbls = orderEquipmentTbls;
	}



	@Override
	public String toString() {
		return "OrderInfoTable [orderId=" + orderId + ", orderDate=" + orderDate + ", orderStatus=" + orderStatus
				+ ", orderTotalCost=" + orderTotalCost + ", farmerInfoTbl=" + farmerInfoTbl + ", orderEquipmentTbls="
				+ orderEquipmentTbls + "]";
	}

	
	
	
}
