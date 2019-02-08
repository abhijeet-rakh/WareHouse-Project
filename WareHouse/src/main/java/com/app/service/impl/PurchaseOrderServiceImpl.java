package com.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IPurchaseOrderDAO;
import com.app.model.PurchaseOrder;
import com.app.service.IPurchaseOrderService;


@Service
public class PurchaseOrderServiceImpl implements IPurchaseOrderService {

	@Autowired
	private IPurchaseOrderDAO dao;
	
	
	@Transactional
	public Integer savePurchaseOrder(PurchaseOrder po) {
		return dao.savePurchaseOrder(po);
	}

	@Transactional
	public List<PurchaseOrder> getAllPurchaseOrder() {
		return dao.getAllPurchaseOrder();
	}

	@Transactional
	public void deletePurchaseOrder(Integer id) {
         dao.deletePurchaseOrder(id);
	}

	@Transactional
	public PurchaseOrder getPurchaseOrderById(Integer id) {
		return dao.getPurchaseOrderById(id);
	}

	@Transactional
	public void updatePurchaseOrder(PurchaseOrder po) {
         dao.updatePurchaseOrder(po);
	}

}
