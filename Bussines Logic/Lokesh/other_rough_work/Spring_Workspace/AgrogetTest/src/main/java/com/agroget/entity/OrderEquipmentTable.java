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
	
	
}
