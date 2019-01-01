package com.app.dao;

import java.util.List;

import com.app.model.UOM;

public interface IUomTypeDAO {

	public Integer saveUOMtype(UOM uom);

	public List<UOM> getAllUOMtype();

	public void deleteUOMById(Integer id);

	/*
	 * public void updateUOMtype(UOM uom); 
	 * public UOM getUOMtypeById(Integer id);
	 */

}
