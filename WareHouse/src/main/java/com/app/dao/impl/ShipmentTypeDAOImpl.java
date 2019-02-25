package com.app.dao.impl;

import java.util.List;
import java.util.Map;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.dao.IShipmentTypeDAO;
import com.app.model.ShipmentType;
import com.app.utility.IShipmentTypeUtility;

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

	@SuppressWarnings("unchecked")
	@Override
	public List<Object[]> getShipmentTypeCount() {
		/*
		String hql = " select shipmentMode,count(shipmentMode) from " + ShipmentType.class.getName()
				+ " group by shipmentMode ";
		*/
		
		DetachedCriteria hql=DetachedCriteria.forClass(ShipmentType.class)
				.setProjection(Projections.projectionList()
				.add(Projections.groupProperty("shipmentMode") )
				.add(Projections.count("shipmentMode"))
				);
		
		return (List<Object[]>) ht.findByCriteria(hql);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Map<Integer, String> getEnableShipments() {
	   /* 
		String hql="select id,shipmentCode from "+ShipmentType.class.getName()+" where enableShipment=?";
       */
	    DetachedCriteria hql=DetachedCriteria.forClass(ShipmentType.class)
	    		.setProjection(Projections.projectionList()
	    		.add(Projections.property("id"))
	    		.add(Projections.property("shipmentCode")))
	    		.add(Restrictions.eq("enableShipment","YES"));
	    List<Object[]> list= (List<Object[]>) ht.findByCriteria(hql);
	    
        Map<Integer,String> map=IShipmentTypeUtility.ConvertListtoMap(list);
	    return map;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Map<Integer,String> getEnableShipmentMode(){
		DetachedCriteria hql=DetachedCriteria.forClass(ShipmentType.class)
				.setProjection(Projections.projectionList()
				.add(Projections.property("id"))
				.add(Projections.property("shipmentMode"))
				);
        List<Object[]> list=(List<Object[]>) ht.findByCriteria(hql);
		Map<Integer,String> map=IShipmentTypeUtility.ConvertListtoMap(list);
		return map;
	}

}
