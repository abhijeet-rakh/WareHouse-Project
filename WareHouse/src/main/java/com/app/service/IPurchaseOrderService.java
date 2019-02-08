package com.app.service;

import java.util.List;

import com.app.model.PurchaseOrder;

public interface IPurchaseOrderService {

	public Integer savePurchaseOrder(PurchaseOrder po);
	public List<PurchaseOrder> getAllPurchaseOrder();
	public void deletePurchaseOrder(Integer id);
	public PurchaseOrder getPurchaseOrderById(Integer id);
	public void updatePurchaseOrder(PurchaseOrder po);
}
