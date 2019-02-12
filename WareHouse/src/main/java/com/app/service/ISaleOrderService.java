package com.app.service;

import java.util.List;

import com.app.model.SaleOrder;

public interface ISaleOrderService {

	public Integer saveSaleOrder(SaleOrder so);
	public List<SaleOrder> getAllSaleOrder();
	public void deleteSaleOrder(Integer id);
	public SaleOrder getSaleOrderById(Integer id);
	public void updateSaleOrder(SaleOrder so);
//	public List<Object[]> getSaleOrderByCount();


}
