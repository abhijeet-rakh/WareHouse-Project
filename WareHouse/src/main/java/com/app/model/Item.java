package com.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="item_tab")
@Data
public class Item {
	
	 @Id
	 @GeneratedValue
	 @Column(name="item_id")
     private Integer itemId;
	 
	 @Column(name="item_code")
     private String itemCode;
	 
	 @Column(name="item_length")
     private Double itemLength;
	 
	 @Column(name="item_width")
     private Double itemWidth;
	 
	 @Column(name="item_height")
     private Double itemHeight;
	 
	 @Column(name="item_cost")
     private Double baseCost;
  
	 @Column(name="item_currency")
	 private String baseCurrency;

	 @Column(name="item_desc")
	 private String itemDesc;
	 	 
	 @ManyToOne
	 @JoinColumn(name="uom_id")
	 private Uom uom;
	 
	 @ManyToOne
	 @JoinColumn(name="ord_id")
	 private OrderMethod om;
		
}
