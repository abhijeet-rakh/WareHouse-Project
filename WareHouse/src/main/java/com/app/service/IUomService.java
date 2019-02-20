package com.app.service;

import java.util.List;
import java.util.Map;

import com.app.model.Uom;

public interface IUomService {
	
	public void deleteUom(Integer id);
	public List<Uom> getAllUom();
	public Uom getUombyId(Integer id);
	public Integer saveUom(Uom u);
	public void updateUom(Uom u);
	public boolean isUomModelExist(String uomModel);
	public Map<Integer,String> getUomIdandModel();

}
