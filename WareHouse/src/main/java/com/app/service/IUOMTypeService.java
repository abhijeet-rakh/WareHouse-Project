package com.app.service;

import java.util.List;

import com.app.model.UOM;

public interface IUOMTypeService {

	public Integer saveUOMtype(UOM uom);
	public List<UOM> getAllUOMtype();
	public void deleteUOMById(Integer id);
	public UOM getUOMtypeById(Integer id);
	public void updateUOMtype(UOM uom);
}
