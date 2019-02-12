package com.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.ISaleOrderDAO;
import com.app.model.SaleOrder;
import com.app.service.ISaleOrderService;

@Service
public class SaleOrderServiceImpl implements ISaleOrderService{

	@Autowired
	private ISaleOrderDAO dao;
	
	@Transactional
	public Integer saveSaleOrder(SaleOrder so) {
		return dao.saveSaleOrder(so);
	}

	@Transactional(readOnly=true)
	public List<SaleOrder> getAllSaleOrder() {
		return dao.getAllSaleOrder();
	}

	@Transactional
	public void deleteSaleOrder(Integer id) {
	       dao.deleteSaleOrder(id);
	}

	@Transactional(readOnly=true)
	public SaleOrder getSaleOrderById(Integer id) {
		return dao.getSaleOrderById(id);
	}

	@Transactional
	public void updateSaleOrder(SaleOrder so) {
		dao.updateSaleOrder(so);
	}

}
