package com.agroget.entity;



import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="order_id")
	private int orderId;
	
//	@Temporal(TemporalType.DATE)
//	@Column(name="order_date")
//	private Date orderDate;

	@Column(name="order_status")
	private int orderStatus;

	@Column(name="order_total_cost")
	private double orderTotalCost;

	@ManyToOne
	@JoinColumn(name="farmer_id")
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

//	public Date getOrderDate() {
//		return orderDate;
//	}
//
//	public void setOrderDate(Date orderDate) {
//		this.orderDate = orderDate;
//	}

	public int getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(int orderStatus) {
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


//	public OrderInfoTable(Date orderDate, byte orderStatus, double orderTotalCost,FarmerEntity farmerEntity) {
//		this.orderDate = orderDate;
//		this.orderStatus = orderStatus;
//		this.orderTotalCost = orderTotalCost;
//		this.farmerInfoTbl = farmerEntity;
//		
//	}
	
//	public OrderInfoTable(Date orderDate, byte orderStatus, double orderTotalCost,FarmerEntity farmerEntity) {
//		
//		this.orderStatus = orderStatus;
//		this.orderTotalCost = orderTotalCost;
//		this.farmerInfoTbl = farmerEntity;
//		
//	}
	
	public OrderInfoTable(FarmerEntity farmerInfoTbl) {
		super();
		this.farmerInfoTbl = farmerInfoTbl;
	}

//	@Override
//	public String toString() {
//		return "OrderInfoTable [orderId=" + orderId + ", orderDate=" + orderDate + ", orderStatus=" + orderStatus
//				+ ", orderTotalCost=" + orderTotalCost + ", farmerInfoTbl=" + farmerInfoTbl + ", orderEquipmentTbls="
//				+ orderEquipmentTbls + "]";
//	}
	
	@Override
	public String toString() {
		return "OrderInfoTable [orderId=" + orderId + ", orderDate="  + ", orderStatus=" + orderStatus
				+ ", orderTotalCost=" + orderTotalCost + ", farmerInfoTbl=" + farmerInfoTbl + ", orderEquipmentTbls="
				+ orderEquipmentTbls + "]";
	}
	
}
