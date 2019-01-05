package com.app.model;

import java.time.OffsetDateTime;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;

@Entity
@Table(name = "shipment_type_tab")
@Data
public class ShipmentType {

	@Id
//	@GenericGenerator(name = "custom_id", strategy = "com.app.generator.WareHouseIdGenerator")
//	@GeneratedValue(generator = "custom_id")
	@GeneratedValue
	@Column(name = "sid")
	private Integer id;

	@Column(name = "shipmode")
	private String shipmentMode;

	@Column(name = "shipcode")
	private String shipmentCode;

	@Column(name = "enableship")
	private String enableShipment;

	@Column(name = "shipgrade")
	private String shipmentGrade;

	@Column(name = "shipdesc")
	private String desc;
	
	/*
	@Version
	@Column(name = "updatecount")
	private int shipcount;

	@CreationTimestamp
	@Column(name = "createdOn")
	private OffsetDateTime createtime;

	@UpdateTimestamp
	@Column(name = "updatedOn")
	private OffsetDateTime updttime;
*/

	
}