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
@Table(name="uom_type_tab")
@Setter
@Getter
public class UOM {

	@Id
	@GeneratedValue
	@Column(name="uid")
	private Integer uomid;
	
	@Column(name="uom_type")
	private String uomtype;
	
	@Column(name="uom_model")
	private String uommodel;
	
	@Column(name="uom_desc")
	private String uomdesc;
	
		
}
