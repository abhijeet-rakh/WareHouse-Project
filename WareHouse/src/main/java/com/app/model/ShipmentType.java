package com.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="shipment_type_tab")
public class ShipmentType {
	
    @Id
    @GeneratedValue
    @Column(name="sid")
	private Integer id;
    
    @Column(name="shipmode")
	private String shipmentMode;
    
    @Column(name="shipcode")
	private String shipmentCode;

    @Column(name="enableship")
    private String enableShipment;
    
    @Column(name="shipgrade")
	private String shipmentGrade;
    
    @Column(name="shipdesc")
	private String ShipmentDesc;

    
    public ShipmentType() {
	      System.out.println("ShipmentType:0-param Constructor");
	}    
    
    
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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

}
