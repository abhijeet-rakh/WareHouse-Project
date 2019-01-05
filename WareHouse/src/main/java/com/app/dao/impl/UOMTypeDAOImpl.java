package com.app.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.dao.IUomTypeDAO;
import com.app.model.UOM;


@Repository
public class UOMTypeDAOImpl implements IUomTypeDAO{

	@Autowired
	private HibernateTemplate ht;
	
	@Override
	public Integer saveUOMtype(UOM uom) {
		return (Integer) ht.save(uom);
	}

	@Override
	public List<UOM> getAllUOMtype() {
		return ht.loadAll(UOM.class);
	}

	@Override
	public void deleteUOMById(Integer id) {
            UOM u=new UOM();
            u.setUomid(id);
            ht.delete(u);
	}

	@Override
	public UOM getUOMtypeById(Integer id) {
		return ht.get(UOM.class,id);
	}

	@Override
	public void updateUOMtype(UOM uom) {
         ht.update(uom);		
	}
	
}
