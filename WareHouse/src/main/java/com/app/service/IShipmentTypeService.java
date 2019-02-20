package com.app.service;

import java.util.List;
import java.util.Map;

import com.app.model.ShipmentType;

public interface IShipmentTypeService {

	public Integer saveShipmentType(ShipmentType st);
	public List<ShipmentType> getAllShipmentType();
	public void deleteShipmentType(Integer id);
	public ShipmentType getShipmentTypeById(Integer id);
	public void updateShipmentType(ShipmentType st);
	public List<Object[]> getShipmentTypeCount();
	public Map<Integer,String> getEnableShipments();
	public Map<Integer,String> getEnableShipmentMode();
	
	
}
