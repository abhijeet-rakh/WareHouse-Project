package com.app.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.dao.IItemDAO;
import com.app.model.Item;

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
	
/*
	@Override
	public List<Object[]> getItemByCount() {
		String hql = "select ordermode,count(ordermode) from " + OrderMethod.class.getName() + " group by ordermode ";
		return 
	}
	
*/
	
	
}
