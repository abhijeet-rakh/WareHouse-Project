package com.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table (name="whtype")
@Data
public class WhUserType {
	
	@Id
	@GeneratedValue
	@Column(name="uid")
	private Integer whId;
	
	@Column(name="utype")
	private String whType;
	
	@Column(name="ucode")
	private String whCode;
	
	@Column(name="ufor")
	private String whFor;
	
	@Column(name="uemail")
	private String whEmail;
	
	@Column(name="ucontact")
	private String whContact;
	
	@Column(name="uidtype")
	private String whIdType;
	
	@Column(name="uidother")
	private String whIdOther;
	
	@Column(name="uidnumber")
	private String whIdNumber;
	
	
}
