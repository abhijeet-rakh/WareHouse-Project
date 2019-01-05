package com.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="WH_USER_TYPE")
@Setter
@Getter
public class WhUserType {
	
	@Id
	@GeneratedValue
	@Column(name="id")
	private Integer whid;
	
	@Column(name="user_type")
	private String userType;
	
	@Column(name="user_code")
    private String userCode;
	
	@Column(name="user_for")
	private String userFor;
	
	@Column(name="user_mail")
	private String userEmail;
	
	@Column(name="user_contact")
	private String userContact;
	
	@Column(name="user_id_type")
	private String userIdType;
	
	@Column(name="id_number")
	private String idnumber;
	
}
