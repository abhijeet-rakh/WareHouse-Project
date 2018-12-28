package com.app.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.dao.IShipmentTypeDAO;
import com.app.model.ShipmentType;

@Repository
public class ShipmentTypeDAOImpl implements IShipmentTypeDAO {

	@Autowired
	private HibernateTemplate ht;

	@Override
	public Integer saveShipmentType(ShipmentType st) {
		Integer id = null;

		id = (Integer) ht.save(st);

		return id;
	}

}
