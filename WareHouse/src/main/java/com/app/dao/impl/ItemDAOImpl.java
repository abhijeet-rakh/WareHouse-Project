package com.app.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.dao.IItemDAO;
import com.app.model.Item;
import com.app.model.Uom;

@Repository
public class ItemDAOImpl implements IItemDAO{

	@Autowired
	private HibernateTemplate ht;
	
	@Override
	public Integer saveItem(Item item) {
		return (Integer) ht.save(item);
	}

	@Override
	public List<Item> getAllItem() {
		return ht.loadAll(Item.class);
	}

	@Override
	public void deleteItem(Integer id) {
		Item item=new Item();
		item.setItemId(id);
		ht.delete(item);
	}

	@Override
	public Item getItemById(Integer id) {
		return ht.get(Item.class, id);
	}

	@Override
	public void updateItem(Item item) {
		
		System.out.println(item.getItemId()+" "+item.getItemCode()+" "+item.getItemHeight()+" "+item.getItemWidth()+" "+item.getItemLength()+" "+item.getBaseCost()+" "+item.getBaseCurrency());
		
		ht.update(item);
	}
	

	@SuppressWarnings("unchecked")
	@Override
	public List<Object[]> getItemByCount() {
	
		/*
		String hql = "select uomModel,count(uomModel) from " + Uom.class.getName() + " group by uomModel ";
	*/	
		DetachedCriteria hql=DetachedCriteria.forClass(Uom.class)
				.setProjection(Projections.projectionList()
				.add(Projections.groupProperty("uomModel"))
				.add(Projections.count("uomModel"))
				);
	
		return (List<Object[]>) ht.findByCriteria(hql);
	}
	
	
}
