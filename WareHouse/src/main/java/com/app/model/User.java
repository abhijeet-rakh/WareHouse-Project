package com.app.model;

import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table
@Data
public class User {
	
	@Id
	@GeneratedValue
	@Column(name="uid")
	private Integer userid;
	
	@Column(name="name")
    private String userName;
    
    @Column(name="email")
	private String mail;

    @Column(name="pwd")
    private String password;
    
    @Column(name="mobile")
    private String mobile;
    
    @ElementCollection(fetch=FetchType.EAGER)
    @CollectionTable(name="uer_roles",joinColumns=@JoinColumn(name="uid"))
    @Column(name="roles")
    private Set<String> roles;
        
}
