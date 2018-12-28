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

@Entity
@Table(name = "shipment_type_tab")
public class ShipmentType {

	@Id
	@GenericGenerator(name = "custom_id", strategy = "com.app.generator.WareHouseIdGenerator")
	@GeneratedValue(generator = "custom_id")
	@Column(name = "sid")
	private String id;

	@Column(name = "shipmode")
	private String shipmentMode;

	@Column(name = "shipcode")
	private String shipmentCode;

	@Column(name = "enableship")
	private String enableShipment;

	@Column(name = "shipgrade")
	private String shipmentGrade;

	@Column(name = "shipdesc")
	private String ShipmentDesc;

	@Version
	@Column(name = "updatecount")
	private int shipcount;

	@CreationTimestamp
	@Column(name = "createdOn")
	private OffsetDateTime time;

	@UpdateTimestamp
	@Column(name = "updatedOn")
	private OffsetDateTime updttime;

	public ShipmentType() {
		System.out.println("ShipmentType:0-param Constructor");
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getShipmentMode() {
		return shipmentMode;
	}

	public void setShipmentMode(String shipmentMode) {
		this.shipmentMode = shipmentMode;
	}

	public String getShipmentCode() {
		return shipmentCode;
	}

	public void setShipmentCode(String shipmentCode) {
		this.shipmentCode = shipmentCode;
	}

	public String getEnableShipment() {
		return enableShipment;
	}

	public void setEnableShipment(String enableShipment) {
		this.enableShipment = enableShipment;
	}

	public String getShipmentGrade() {
		return shipmentGrade;
	}

	public void setShipmentGrade(String shipmentGrade) {
		this.shipmentGrade = shipmentGrade;
	}

	public String getShipmentDesc() {
		return ShipmentDesc;
	}

	public void setShipmentDesc(String shipmentDesc) {
		ShipmentDesc = shipmentDesc;
	}

	public int getShipcount() {
		return shipcount;
	}

	public void setShipcount(int shipcount) {
		this.shipcount = shipcount;
	}

	public OffsetDateTime getTime() {
		return time;
	}

	public void setTime(OffsetDateTime time) {
		this.time = time;
	}

	public OffsetDateTime getUpdttime() {
		return updttime;
	}

	public void setUpdttime(OffsetDateTime updttime) {
		this.updttime = updttime;
	}

}
