package com.app.dao.impl;

import java.util.List;
import java.util.Map;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.dao.IWhUserTypeDao;
import com.app.model.WhUserType;
import com.app.utility.IWhUserTypeUtility;

@Repository
public class WhUserTypeDaoImpl implements IWhUserTypeDao {

	@Autowired
	private HibernateTemplate ht;
	
	@Override
	public Integer saveWhUserType(WhUserType w) {
		return (Integer) ht.save(w);
	}

	
	@Override
	public void updateWhUserType(WhUserType w) {
		ht.update(w);
	}

	
	@Override
	public void deleteWhUserType(Integer id) {
		WhUserType wut = new WhUserType();
		wut.setWhId(id);
		ht.delete(wut);
	}

	
	@Override
	public WhUserType getWhUserTypeById(Integer id) {
		return ht.get(WhUserType.class, id);
	}

	
	@Override
	public List<WhUserType> getAllWhUserTypes() {
		return ht.loadAll(WhUserType.class);
	}

	
	@SuppressWarnings("unchecked")
	@Override
	public Map<Integer, String> getVendors() { 
	System.out.println("getVendors___");
	//	String hql=" select whId,whType from "+WhUserType.class.getName()+" where whType=? ";
	  DetachedCriteria hql=DetachedCriteria.forClass(WhUserType.class)
		.setProjection(Projections.projectionList()
				.add(Projections.property("whId"))
				.add(Projections.property("whCode"))
				).add(Restrictions.eq("whType","VENDOR"));
	
	  List<Object[]> list=(List<Object[]>) ht.findByCriteria(hql);
	  
	  Map<Integer,String> map=IWhUserTypeUtility.ConversionListToMap(list);
		return map;
	}


	@SuppressWarnings("unchecked")
	@Override
	public boolean isWhUserCodeExist(String usercode) {
		/*
		String hql="select count(whCode) from "+WhUserType.class.getName()+" where whCode=?";
        */
		
		long count=0;

		DetachedCriteria hql=
				DetachedCriteria.forClass(WhUserType.class)
				.setProjection(Projections.count("whCode"))
				.add(Restrictions.eq("whCode",usercode));

		List<Long> list=(List<Long>) ht.findByCriteria(hql);
		
		if(list!=null && !list.isEmpty()) {
			count=list.get(0);
		}

		System.out.println("isWhUserCodeExist");
		
		return count>0?true:false;

	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean isEmailOrMobileExists(String userEmailOrMobile) {
		
	   long count=0;
	   
	   DetachedCriteria hql=DetachedCriteria.forClass(WhUserType.class)
			   .setProjection(Projections.count("whEmail"))
			   .add(Restrictions.eq("whEmail",userEmailOrMobile));
	   
	       List<Long> list=(List<Long>) ht.findByCriteria(hql);
		
	       if(list!=null && !list.isEmpty()) {
	    	   count=list.get(0);
	       }
	       
	       System.out.println("isEmailOrMobileExists");
	       
		return count>0?true:false;
	}
	
}
