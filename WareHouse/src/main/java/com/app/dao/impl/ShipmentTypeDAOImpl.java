package com.app.dao.impl;

import java.util.List;

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

		System.out.println("desc=" + st.getDesc());
		id = (Integer) ht.save(st);

		return id;
	}

	@Override
	public List<ShipmentType> getAllShipmentType() {
		List<ShipmentType> list = ht.loadAll(ShipmentType.class);
		return list;
	}

	@Override
	public void deleteShipmentType(Integer id) {
		ShipmentType st = null;
		st = new ShipmentType();
		st.setId(id);
		ht.delete(st);
	}

	@Override
	public ShipmentType getShipmentTypeById(Integer id) {
		return ht.get(ShipmentType.class, id);
	}

	@Override
	public void updateShipmentType(ShipmentType st) {
		ht.update(st);
	}

	@Override
	public List<Object[]> getShipmentTypeCount() {
		String hql = " select shipmentMode,count(shipmentMode) from " + ShipmentType.class.getName()
				+ " group by shipmentMode ";
		return (List<Object[]>) ht.find(hql);
	}

}
