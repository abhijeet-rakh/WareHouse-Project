package com.app.dao;

import java.util.List;

import com.app.model.ShipmentType;

public interface IShipmentTypeDAO {

	public Integer saveShipmentType(ShipmentType st);
	public List<ShipmentType> getAllShipmentType();
	public void deleteShipmentType(Integer id);

}

