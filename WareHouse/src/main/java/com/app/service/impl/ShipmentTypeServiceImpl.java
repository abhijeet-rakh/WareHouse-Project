package com.app.service.impl;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IShipmentTypeDAO;
import com.app.model.ShipmentType;
import com.app.service.IShipmentTypeService;

@Service
public class ShipmentTypeServiceImpl implements IShipmentTypeService {

	@Autowired
	private IShipmentTypeDAO dao;

	@Transactional
	public Integer saveShipmentType(ShipmentType st) {
		return dao.saveShipmentType(st);
	}
		
	@Transactional(readOnly=true)
	public List<ShipmentType> getAllShipmentType() {
		List<ShipmentType> list = dao.getAllShipmentType();
		return list;
	}

	@Transactional
	public void deleteShipmentType(Integer id) {
		dao.deleteShipmentType(id);
	}

	@Transactional(readOnly=true)
	public ShipmentType getShipmentTypeById(Integer id) {
		return dao.getShipmentTypeById(id);
	}
	
}
