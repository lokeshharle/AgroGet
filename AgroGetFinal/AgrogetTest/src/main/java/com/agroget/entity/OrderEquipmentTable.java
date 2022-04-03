package com.agroget.entity;


import java.sql.Time;
import java.util.Date;

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

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="order_equipment_tbl")
public class OrderEquipmentTable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="order_equipment_id")
	private int orderEquipmetId;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	@Column(name="from_date")
	private Date fromDate;

	@Temporal(TemporalType.DATE)
	@Column(name="to_date")
	private Date toDate;
	
	@Column(name="from_time")
	private int fromTime;
	
	@Column(name="to_time")
	private int toTime;
	
	@Column(name="order_equipment_status")
	private int orderEquipmentStatus;

	@Column(name="service_address",length = 100)
	private String serviceAddress;
	
	@ManyToOne
	@JoinColumn(name="equipment_id")
	private EquipmentInfoTable equipmentInfoTbl;

	@ManyToOne
	@JoinColumn(name="order_id")
	private OrderInfoTable orderInfoTbl;

	

	public int getOrderEquipmetId() {
		return orderEquipmetId;
	}

	public void setOrderEquipmetId(int orderEquipmetId) {
		this.orderEquipmetId = orderEquipmetId;
	}

	public Date getFromDate() {
		return fromDate;
	}

	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}

	public Date getToDate() {
		return toDate;
	}

	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}

	public int getFromTime() {
		return fromTime;
	}

	public void setFromTime(int fromTime) {
		this.fromTime = fromTime;
	}

	public int getToTime() {
		return toTime;
	}

	public void setToTime(int toTime) {
		this.toTime = toTime;
	}

	public int getOrderEquipmentStatus() {
		return orderEquipmentStatus;
	}

	public void setOrderEquipmentStatus(byte orderEquipmentStatus) {
		this.orderEquipmentStatus = orderEquipmentStatus;
	}

	public String getServiceAddress() {
		return serviceAddress;
	}

	public void setServiceAddress(String serviceAddress) {
		this.serviceAddress = serviceAddress;
	}

	public EquipmentInfoTable getEquipmentInfoTbl() {
		return equipmentInfoTbl;
	}

	public void setEquipmentInfoTbl(EquipmentInfoTable equipmentInfoTbl) {
		this.equipmentInfoTbl = equipmentInfoTbl;
	}

	public OrderInfoTable getOrderInfoTbl() {
		return orderInfoTbl;
	}

	public void setOrderInfoTbl(OrderInfoTable orderInfoTbl) {
		this.orderInfoTbl = orderInfoTbl;
	}

	public OrderEquipmentTable() {
		super();
	}
	
	public OrderEquipmentTable(Date fromDate, Date toDate, int fromTime, int toTime, int orderEquipmentStatus,
			String serviceAddress, EquipmentInfoTable equipmentInfoTbl, OrderInfoTable orderInfoTbl) {
		super();
		this.fromDate = fromDate;
		this.toDate = toDate;
		this.fromTime = fromTime;
		this.toTime = toTime;
		this.orderEquipmentStatus = orderEquipmentStatus;
		this.serviceAddress = serviceAddress;
		this.equipmentInfoTbl = equipmentInfoTbl;
		this.orderInfoTbl = orderInfoTbl;
	}
	
	public OrderEquipmentTable(Date fromDate, Date toDate, int fromTime, int toTime,
			String serviceAddress, EquipmentInfoTable equipmentInfoTbl, OrderInfoTable orderInfoTbl) {
		super();
		this.fromDate = fromDate;
		this.toDate = toDate;
		this.fromTime = fromTime;
		this.toTime = toTime;
		this.orderEquipmentStatus = 1;
		this.serviceAddress = serviceAddress;
		this.equipmentInfoTbl = equipmentInfoTbl;
		this.orderInfoTbl = orderInfoTbl;
	}

	@Override
	public String toString() {
		return "OrderEquipmentTable [orderEquipmetId=" + orderEquipmetId + ", fromDate=" + fromDate + ", toDate="
				+ toDate + ", fromTime=" + fromTime + ", toTime=" + toTime + ", orderEquipmentStatus="
				+ orderEquipmentStatus + ", serviceAddress=" + serviceAddress + ", equipmentInfoTbl=" + equipmentInfoTbl
				+ ", orderInfoTbl=" + orderInfoTbl + "]";
	}
	
	
	
}
