package com.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IUomTypeDAO;
import com.app.model.UOM;
import com.app.service.IUOMTypeService;

@Service
public class UOMTypeServiceImpl implements IUOMTypeService {

	@Autowired
	private IUomTypeDAO dao;
	
	@Transactional
	public Integer saveUOMtype(UOM uom) {
          return dao.saveUOMtype(uom);
	}

	@Transactional(readOnly=true)
	public List<UOM> getAllUOMtype() {
		return dao.getAllUOMtype();
	}

	@Transactional
	public void deleteUOMById(Integer id) {
	      dao.deleteUOMById(id);
	}

	@Transactional(readOnly=true)
	public UOM getUOMtypeById(Integer id) {
		return dao.getUOMtypeById(id);
	}

	@Transactional
 	public void updateUOMtype(UOM uom) {
		dao.updateUOMtype(uom);
	}
	
}
