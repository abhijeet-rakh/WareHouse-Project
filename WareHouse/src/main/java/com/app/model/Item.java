package com.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="item_tab")
@Data
public class Item {
	
	 @Id
	 @GeneratedValue
	 @Column(name="id")
     private Integer itemId;
	 
	 @Column(name="icode")
     private String itemCode;
	 
	 @Column(name="ilength")
     private Double itemLength;
	 
	 @Column(name="iwidth")
     private Double itemWidth;
	 
	 @Column(name="iheight")
     private Double itemHeight;
	 
	 @Column(name="icost")
     private Double baseCost;
  
	 @Column(name="icurrency")
	 private String baseCurrency;

	 @Column(name="idesc")
	 private String itemDesc;
	 	 
	 @ManyToOne
	 @JoinColumn(name="uomid")
	 private UOM uom;
	 
	 @OneToOne
	 @JoinColumn(name="ordid")
	 private OrderMethod om;
	 
}
