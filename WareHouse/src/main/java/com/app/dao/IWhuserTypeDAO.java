package com.app.dao;

import java.util.List;

import com.app.model.WhUserType;

public interface IWhuserTypeDAO {
	
	public Integer saveWhusertype(WhUserType wut);
	public void deleteWhusertype(Integer id);
	public void updateWhusertype(WhUserType wut);
	public WhUserType getWhusertypeById(Integer id);
    public List<WhUserType> getAllWhuserType();
    public List<Object[]> getWhUserTypeCount();
    
    
}
