package com.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


import lombok.Data;

//unit of measurement(uom)
@Entity
@Table(name = "uom_tab")
@Data
public class Uom {

	@Id
	@Column(name = "Uom_ID")
	@GeneratedValue
	private Integer uomId;

	@Column(name = "Uom_Type")
	private String uomType;
	
	@Column(name = "Uom_Model")
	private String uomModel;
	
	@Column(name = "Uom_Dsc")
	private String uomDsc;

}
