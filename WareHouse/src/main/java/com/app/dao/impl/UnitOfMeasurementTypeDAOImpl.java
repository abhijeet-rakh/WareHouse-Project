package com.app.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.dao.IUnitOfMeasurementTypeDAO;
import com.app.model.UnitOfMeasurement;


@Repository
public class UnitOfMeasurementTypeDAOImpl implements IUnitOfMeasurementTypeDAO{

	@Autowired
	private HibernateTemplate ht;
	
	@Override
	public Integer saveUnitOfMeasurementtype(UnitOfMeasurement UnitOfMeasurement) {
		return (Integer) ht.save(UnitOfMeasurement);
	}

	@Override
	public List<UnitOfMeasurement> getAllUnitOfMeasurementtype() {
		return ht.loadAll(UnitOfMeasurement.class);
	}

	@Override
	public void deleteUnitOfMeasurementById(Integer id) {
            UnitOfMeasurement u=new UnitOfMeasurement();
            u.setUomId(id);
            ht.delete(u);
	}

	@Override
	public UnitOfMeasurement getUnitOfMeasurementtypeById(Integer id) {
		return ht.get(UnitOfMeasurement.class,id);
	}

	@Override
	public void updateUnitOfMeasurementtype(UnitOfMeasurement UnitOfMeasurement) {
         ht.update(UnitOfMeasurement);		
	}

	@Override
	public List<Object[]> getUnitOfMeasurementtypeCount() {
	  String hql="select UnitOfMeasurementtype,count(UnitOfMeasurementtype) from "+UnitOfMeasurement.class.getName()+" group by UnitOfMeasurementtype ";
	  return (List<Object[]>) ht.find(hql);
	}
	
}
