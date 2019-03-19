package com.app.dao;

import java.util.List;
import java.util.Map;

import com.app.model.Uom;

public interface IUomDao {
	
	public void deleteUom(Integer id);
	public List<Uom>getAllUom();
	public Uom getUombyId(Integer id);
	public Integer saveUom(Uom u);
	public void updateUom(Uom u);
    public boolean isUomModelExists(String UomModel);
    public Map<Integer,String> getUomIdandModel();
    public List<Object[]> getUomTypeCount();
    
    
}
