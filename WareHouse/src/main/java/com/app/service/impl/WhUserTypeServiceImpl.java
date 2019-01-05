package com.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IWhuserTypeDAO;
import com.app.model.WhUserType;
import com.app.service.IWhuserTypeService;

@Service
public class WhUserTypeServiceImpl implements IWhuserTypeService{

	@Autowired
	private IWhuserTypeDAO dao;

	@Transactional
	public Integer saveWhusertype(WhUserType wut) {
		return dao.saveWhusertype(wut);
	}

	@Transactional
	public void deleteWhusertype(Integer id) {
		dao.deleteWhusertype(id);
	}

	@Transactional
	public void updateWhusertype(WhUserType wut) {
		dao.updateWhusertype(wut);
	}

	@Transactional(readOnly=true)
	public WhUserType getWhusertypeById(Integer id) {
		return dao.getWhusertypeById(id);
	}

	@Transactional(readOnly=true)
	public List<WhUserType> getAllWhuserType() {
		return dao.getAllWhuserType();
	}

	
}
