package com.app.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.dao.IDocumentDAO;
import com.app.model.Document;

@Repository
public class DocumentDAOiImpl implements IDocumentDAO {

	@Autowired
	private HibernateTemplate ht;
	
	@Override
	public Integer saveDocument(Document doc) {
		return (Integer) ht.save(doc);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Object[]> getObjectIdAndNames() {		
	    
		/*
		String hql="select fileId,fileName,fileData from com.app.model.Document";
	*/	
		
		DetachedCriteria hql=DetachedCriteria.forClass(Document.class)
				.setProjection(Projections.projectionList()
				.add(Projections.property("fileId"))
				.add(Projections.property("fileName"))
				.add(Projections.property("fileData")));
		
		return (List<Object[]>) ht.findByCriteria(hql);
	}

	@Override
	public Document getDocumentById(Integer id) {
        return ht.get(Document.class, id);
	}
	
}
