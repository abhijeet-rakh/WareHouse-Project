package com.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IUnitOfMeasurementTypeDAO;
import com.app.model.UnitOfMeasurement;
import com.app.service.IUnitOfMeasurementTypeService;

@Service
public class UnitOfMeasurementTypeServiceImpl implements IUnitOfMeasurementTypeService {

	@Autowired
	private IUnitOfMeasurementTypeDAO dao;
	
	@Transactional
	public Integer saveUnitOfMeasurementtype(UnitOfMeasurement UnitOfMeasurement) {
          return dao.saveUnitOfMeasurementtype(UnitOfMeasurement);
	}

	@Transactional(readOnly=true)
	public List<UnitOfMeasurement> getAllUnitOfMeasurementtype() {
		return dao.getAllUnitOfMeasurementtype();
	}

	@Transactional
	public void deleteUnitOfMeasurementById(Integer id) {
	      dao.deleteUnitOfMeasurementById(id);
	}

	@Transactional(readOnly=true)
	public UnitOfMeasurement getUnitOfMeasurementtypeById(Integer id) {
		return dao.getUnitOfMeasurementtypeById(id);
	}

	@Transactional
 	public void updateUnitOfMeasurementtype(UnitOfMeasurement UnitOfMeasurement) {
		dao.updateUnitOfMeasurementtype(UnitOfMeasurement);
	}

	@Transactional(readOnly=true)
	public List<Object[]> getUnitOfMeasurementtypeCount() {
		return dao.getUnitOfMeasurementtypeCount();
	}
	
}
