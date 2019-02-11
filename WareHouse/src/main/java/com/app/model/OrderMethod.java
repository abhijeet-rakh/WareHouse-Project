package com.app.model;

import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OrderColumn;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="order_tab")
@Getter
@Setter
@ToString
public class OrderMethod {
	
	@Id
	@GeneratedValue
	@Column(name="o_id")
	private Integer oid;
	
    @Column(name="order_mode")	
	private String ordermode;
    
    @Column(name="order_code")
	private String ordercode;
    
    @Column(name="execute_type")
	private String executetype;
    
    @Column(name="description")
    private String orderdesc;
    
   @ElementCollection(fetch=FetchType.EAGER)
    @CollectionTable(name="order_accept",
      joinColumns=@JoinColumn(name="oid"))
    @OrderColumn(name="pos")
    @Column(name="data")
	private List<String> orderaccept;
    
}
