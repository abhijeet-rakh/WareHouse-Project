package com.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "sale_ord_tab")
@Setter
@Getter
public class SaleOrder {

	@Id
	@GeneratedValue
	@Column(name = "ord_id")
	private Integer orderId;

	@Column(name = "ord_code")
	private String orderCode;

	@ManyToOne
	@JoinColumn(name="ship_id")
	private ShipmentType shiptype;

	@ManyToOne
	@JoinColumn(name="Customer_id")
	private WhUserType whusertype;

	@Column(name = "Ref_Number")
	private Integer refNumber;

	@Column(name = "stock_mode")
	private String stockMode;

	@Column(name = "stock_source")
	private String stockSource;

	@Column(name = "default_status")
	private String defaultStatus;

	@Column(name = "sale_ord_desc")
	private String saleOrdDesc;
	
}
