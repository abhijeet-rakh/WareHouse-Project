package com.app.service;

import java.util.List;

import com.app.model.OrderMethod;

public interface IOrderMethodService {
	
	public Integer saveOrderMethod(OrderMethod om);
	public List<OrderMethod> getAllOrderMethod();
	public void deleteOrderMethod(Integer id);
	public OrderMethod getOrderMethodById(Integer id);
	public void updateOrderMethod(OrderMethod om);
	public List<Object[]> getOrderModeByCount();
	
}
