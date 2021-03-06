package com.app.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "shipment_type_tab")
@Data
public class ShipmentType {

	@Id
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