package com.agroget.entity;


import java.sql.Time;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="order_equipment_tbl")
public class OrderEquipmentTable {
	
	@Id
	@Column(name="order_equipment_id")
	private int orderEquipmetId;
	
	@Temporal(TemporalType.DATE)
	@Column(name="from_date")
	private Date fromDate;

	@Temporal(TemporalType.DATE)
	@Column(name="to_date")
	private Date toDate;
	
	@Column(name="from_time")
	private Time fromTime;
	
	@Column(name="to_time")
	private Time toTime;
	
	@Column(name="order_equipment_status",columnDefinition = "TINYINT",nullable = false)
	private byte orderEquipmentStatus;

	@Column(name="service_address",length = 100,nullable = false)
	private String serviceAddress;
	
	@ManyToOne
	@JoinColumn(name="equipment_id",nullable = false)
	private EquipmentInfoTable equipmentInfoTbl;

	@ManyToOne
	@JoinColumn(name="order_id",nullable = false)
	private OrderInfoTable orderInfoTbl;

	public OrderEquipmentTable() {
		super();
	}

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

	public Time getFromTime() {
		return fromTime;
	}

	public void setFromTime(Time fromTime) {
		this.fromTime = fromTime;
	}

	public Time getToTime() {
		return toTime;
	}

	public void setToTime(Time toTime) {
		this.toTime = toTime;
	}

	public byte getOrderEquipmentStatus() {
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

	public OrderEquipmentTable(int orderEquipmetId, Date fromDate, Date toDate, Time fromTime, Time toTime,
			byte orderEquipmentStatus, String serviceAddress, EquipmentInfoTable equipmentInfoTbl,
			OrderInfoTable orderInfoTbl) {
		super();
		this.orderEquipmetId = orderEquipmetId;
		this.fromDate = fromDate;
		this.toDate = toDate;
		this.fromTime = fromTime;
		this.toTime = toTime;
		this.orderEquipmentStatus = orderEquipmentStatus;
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
