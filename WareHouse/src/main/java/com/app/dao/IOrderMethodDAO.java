package com.app.dao;

import java.util.List;

import com.app.model.OrderMethod;

public interface IOrderMethodDAO {

	public Integer saveOrderMethod(OrderMethod om);
	public List<OrderMethod> getAllOrderMethod();
	public void deleteOrderMethod(Integer id);
	public OrderMethod getOrderMethodById(Integer id);
	public void updateOrderMethod(OrderMethod om);
	public List<Object[]> getOrderModeByCount();
	
	
	
}
