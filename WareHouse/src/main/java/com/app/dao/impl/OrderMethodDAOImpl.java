package com.app.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.dao.IOrderMethodDAO;
import com.app.model.OrderMethod;

@Repository
public class OrderMethodDAOImpl implements IOrderMethodDAO {

	@Autowired
	private HibernateTemplate ht;
	
	
	@Override
	public Integer saveOrderMethod(OrderMethod om) {	
		return (Integer) ht.save(om);
	}


	@Override
	public List<OrderMethod> getAllOrderMethod() {
		return ht.loadAll(OrderMethod.class);
	}


	@Override
	public void deleteOrderMethod(Integer id) {
	     OrderMethod om=new OrderMethod();
	     om.setOid(id);
	     ht.delete(om);
	}
	
}
