package com.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IOrderMethodDAO;
import com.app.model.OrderMethod;
import com.app.service.IOrderMethodService;

@Service
public class OrderMethodServiceImpl implements IOrderMethodService {

	@Autowired
	private IOrderMethodDAO dao;
	
	@Transactional
	public Integer saveOrderMethod(OrderMethod om) {
		return dao.saveOrderMethod(om);
	}

	@Override
	public List<OrderMethod> getAllOrderMethod() {
		return dao.getAllOrderMethod();
	}

	@Transactional
	public void deleteOrderMethod(Integer id) {
	    dao.deleteOrderMethod(id);
	}

	@Override
	public OrderMethod getOrderMethodById(Integer id) {
		return dao.getOrderMethodById(id);
	}

}
