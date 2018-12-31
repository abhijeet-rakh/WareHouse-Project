package com.app.service;

import java.util.List;

import com.app.model.ShipmentType;

public interface IShipmentTypeService {

	public Integer saveShipmentType(ShipmentType st);
	public List<ShipmentType> getAllShipmentType();
	public void deleteShipmentType(Integer id);
	
}
