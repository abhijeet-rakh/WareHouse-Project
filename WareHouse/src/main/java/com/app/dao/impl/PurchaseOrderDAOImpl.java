package com.app.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.dao.IPurchaseOrderDAO;
import com.app.model.PurchaseOrder;

@Repository
public class PurchaseOrderDAOImpl implements IPurchaseOrderDAO {

	@Autowired
	private HibernateTemplate ht;
	
	
	@Override
	public Integer savePurchaseOrder(PurchaseOrder po) {
		return (Integer) ht.save(po); 
	}

	@Override
	public List<PurchaseOrder> getAllPurchaseOrder() {
		return ht.loadAll(PurchaseOrder.class);
	}

	@Override
	public void deletePurchaseOrder(Integer id) {
		PurchaseOrder po=new PurchaseOrder();
		po.setOrderId(id);
        ht.delete(po);
	}

	@Override
	public PurchaseOrder getPurchaseOrderById(Integer id) {
		return ht.get(PurchaseOrder.class, id);
	}

	@Override
	public void updatePurchaseOrder(PurchaseOrder po) {
        ht.update(po);
	}

}
