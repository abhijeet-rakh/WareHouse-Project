package com.app.dao;

import java.util.List;
import java.util.Map;

import com.app.model.WhUserType;

public interface IWhUserTypeDao {
	public Integer saveWhUserType(WhUserType w);
	public void updateWhUserType(WhUserType w);
	public void deleteWhUserType(Integer id);
	public WhUserType getWhUserTypeById(Integer id);
	public List<WhUserType> getAllWhUserTypes();	
	public Map<Integer,String> getVendors();
	public Map<Integer, String> getCustomers();
	public boolean isWhUserCodeExist(String usercode);
	public boolean isEmailOrMobileExists(String userEmailOrMobile);
	public List<Object[]> getWhTypeByCount();
	
	
}
