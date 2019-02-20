package com.app.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IWhUserTypeDao;
import com.app.model.WhUserType;
import com.app.service.IWhUserTypeService;

@Service
public class WhUserTypeServiceImpl implements IWhUserTypeService{

	@Autowired
	private IWhUserTypeDao dao;

	@Transactional
	public Integer saveWhUserType(WhUserType w) {
		return dao.saveWhUserType(w);
	}

	@Transactional
	public void updateWhUserType(WhUserType w) {
		dao.updateWhUserType(w);
	}

	@Transactional
	public void deleteWhUserType(Integer id) {
		dao.deleteWhUserType(id);
	}

	@Transactional(readOnly=true)
	public WhUserType getWhUserTypeById(Integer id) {
		return dao.getWhUserTypeById(id);
	}

	@Transactional(readOnly=true)
	public List<WhUserType> getAllWhUserTypes() {
		return dao.getAllWhUserTypes();
	}

	@Transactional(readOnly=true)
	public Map<Integer, String> getVendors() {
		return dao.getVendors();
	}

	@Transactional(readOnly=true)
	public boolean isWhUserCodeExist(String usercode) {
		return dao.isWhUserCodeExist(usercode);
	}

	@Transactional(readOnly=true)
	public boolean isEmailOrMobileExists(String userEmailOrMobile) {
		return dao.isEmailOrMobileExists(userEmailOrMobile);
	}
	
}
