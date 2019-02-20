package com.app.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IUomDao;
import com.app.model.Uom;
import com.app.service.IUomService;

@Service
public class UomServiceImpl implements IUomService {

	@Autowired
	public IUomDao dao;

	@Transactional
	public void deleteUom(Integer id) {
		dao.deleteUom(id);
	}

	@Transactional(readOnly=true)
	public List<Uom> getAllUom() {
		return dao.getAllUom();
	}

	@Transactional(readOnly=true)
	public Uom getUombyId(Integer id) {
		return dao.getUombyId(id);
	}

	@Transactional
	public Integer saveUom(Uom u) {
		return dao.saveUom(u);
	}

	@Transactional
	public void updateUom(Uom u) {
		dao.updateUom(u);
	}

	@Transactional(readOnly=true)
	public boolean isUomModelExist(String uomModel) {
		System.out.println("isUomModelExist serviceImpl");
		return dao.isUomModelExists(uomModel);
	}

	@Override
	public Map<Integer, String> getUomIdandModel() {
		return dao.getUomIdandModel();
	}
	
}
