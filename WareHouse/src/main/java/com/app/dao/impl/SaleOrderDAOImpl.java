package com.app.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.dao.ISaleOrderDAO;
import com.app.model.SaleOrder;

@Repository
public class SaleOrderDAOImpl implements ISaleOrderDAO{

	@Autowired
	private HibernateTemplate ht;

	@Override
	public Integer saveSaleOrder(SaleOrder so) {
		return (Integer) ht.save(so);
	}

	@Override
	public List<SaleOrder> getAllSaleOrder() {
		System.out.println("all data in saleorder...");
		return ht.loadAll(SaleOrder.class);
	}

	@Override
	public void deleteSaleOrder(Integer id) {
		SaleOrder so=new SaleOrder();
		so.setOrderId(id);
		ht.delete(so);
	}

	@Override
	public SaleOrder getSaleOrderById(Integer id) {
		return ht.get(SaleOrder.class, id);
	}

	@Override
	public void updateSaleOrder(SaleOrder so) {
		ht.update(so);
	}
	
}
