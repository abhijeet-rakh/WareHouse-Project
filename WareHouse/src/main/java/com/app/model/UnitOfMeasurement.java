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
public class UnitOfMeasurement {

	@Id
	@GeneratedValue
	@Column(name="u_id")
	private Integer uomId;
	
	@Column(name="uom_type")
	private String uomType;
	
	@Column(name="uom_model")
	private String uomModel;
	
	@Column(name="uom_desc")
	private String uomDesc;
		
}
