package com.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="purchase_order")
@Data
public class PurchaseOrder {
	
	@Id
	@Column(name="o_id")
	@GeneratedValue
	private Integer orderId;
	
	@Column(name="o_code")
	private String orderCode;
	
	@Column(name="ship_mode")
	private String shipmentMode;
	
	@Column(name="vendor")
	private String vendor;
	
	@Column(name="refNum")
	private String refNum;
	
	@Column(name="quali_check")
	private String qualityCheck;
	
	@Column(name="ord_status")
	private String ordStatus;
	
	@Column(name="ord_desc")
    private String ordDesc;
    
    
}
