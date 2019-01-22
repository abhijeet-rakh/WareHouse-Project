package com.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="Doc_tab")
@Setter
@Getter
public class Document {
	@Id
	@GeneratedValue
	@Column(name="fid")
	private Integer fileId;

	
	@Column(name="fname")
	private String fileName;

	@Column(name="fdata")
	@Lob    // Byte[] + LOB = BLOB if we didn't give this Lob then application gives org.hibernate.exception.DataException: could not execute query 
	private byte[] fileData;
	
}
