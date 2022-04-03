package com.agroget.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="feedback_info_tbl")
public class FeedBackInfoTable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="feedback_id")
	private int feedbackId;

	@Column(name="feedback_comments",length = 100)
	private String feedbackComments;

	@Column(name="feedback_rating")
	private int feedbackRating;

	@ManyToOne
	@JoinColumn(name="equipment_id",nullable = false)
	private EquipmentInfoTable equipmentInfoTbl;

	@ManyToOne
	@JoinColumn(name="farmer_id",nullable = false)
	private FarmerEntity farmerInfoTbl;

	public FeedBackInfoTable() {
		super();
	}
	
	
}
