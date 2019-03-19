package com.app.dao.impl;

import java.util.List;
import java.util.Map;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.dao.IUomDao;
import com.app.model.Uom;
import com.app.utility.IUomUtility;

@Repository
public class UomDaoImpl implements IUomDao {

	@Autowired
	public HibernateTemplate ht;

	@Override
	public void deleteUom(Integer id) {
		Uom u = new Uom();
		u.setUomId(id);
		ht.delete(u);
	}

	@Override
	public List<Uom> getAllUom() {
		return ht.loadAll(Uom.class);
	}

	@Override
	public Uom getUombyId(Integer id) {
		return ht.get(Uom.class, id);
	}

	
	@Override
	public Integer saveUom(Uom u) {
		return (Integer) ht.save(u);
	}

	@Override
	public void updateUom(Uom u) {
		ht.update(u);
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean isUomModelExists(String UomModel) {
		long count = 0;
		/*
		 * String
		 * hql=" select count(uomModel) from "+Uom.class.getName()+" where uomModel=?";
		 */

		DetachedCriteria hql = DetachedCriteria.forClass(Uom.class)
				.setProjection(Projections.projectionList()
				.add(Projections.count("uomModel")))
				.add(Restrictions.eq("uomModel", UomModel));

		List<Long> list = (List<Long>) ht.findByCriteria(hql);

		if (list != null && !list.isEmpty()) {
			count = list.get(0);
			System.out.println("count=" + count);
		}
		System.out.println("count boolean=" + (count > 0 ? true : false));
		return count > 0 ? true : false;
	}

	
	@SuppressWarnings("unchecked")
	@Override
	public Map<Integer, String> getUomIdandModel() {
		/*
		String hql = " select uomId,uomModel from " + Uom.class.getName();
		*/
		
		System.out.println("getUomIdandModel");
		DetachedCriteria hql=DetachedCriteria.forClass(Uom.class)
		         .setProjection(Projections.projectionList()
		         .add(Projections.property("uomId"))
		         .add(Projections.property("uomModel")));
		         
		List<Object[]> list = (List<Object[]>) ht.findByCriteria(hql);
	
		return IUomUtility.ConvertListtoMap(list);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Object[]> getUomTypeCount() {
	    DetachedCriteria hql=DetachedCriteria.forClass(Uom.class)
        .setProjection(Projections.projectionList()
        .add(Projections.groupProperty("uomType"))
        .add(Projections.count("uomType")));
	    
		return (List<Object[]>) ht.findByCriteria(hql);
	}
	
}