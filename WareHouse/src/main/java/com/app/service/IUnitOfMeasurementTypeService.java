package com.app.service;

import java.util.List;

import com.app.model.UnitOfMeasurement;

public interface IUnitOfMeasurementTypeService {

	public Integer saveUnitOfMeasurementtype(UnitOfMeasurement UnitOfMeasurement);
	public List<UnitOfMeasurement> getAllUnitOfMeasurementtype();
	public void deleteUnitOfMeasurementById(Integer id);
	public UnitOfMeasurement getUnitOfMeasurementtypeById(Integer id);
	public void updateUnitOfMeasurementtype(UnitOfMeasurement UnitOfMeasurement);
	public List<Object[]> getUnitOfMeasurementtypeCount();
	
}
