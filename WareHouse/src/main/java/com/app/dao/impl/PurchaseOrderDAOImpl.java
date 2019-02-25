package com.app.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
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

	@SuppressWarnings("unchecked")
	@Override
	public List<Object[]> getPurchaseOrderByCount() {
	    DetachedCriteria hql=DetachedCriteria.forClass(PurchaseOrder.class)
	    		.setProjection(Projections.projectionList()
	    		.add(Projections.groupProperty("qualityCheck"))
	    		.add(Projections.count("qualityCheck")));
	    
		return (List<Object[]>) ht.findByCriteria(hql);
	}

}
