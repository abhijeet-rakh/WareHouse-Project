package com.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IItemDAO;
import com.app.model.Item;
import com.app.service.IItemService;

@Service
public class ItemServiceImpl implements IItemService {

	@Autowired
	private IItemDAO dao;
	
	@Transactional
	public Integer saveItem(Item item) {
		return dao.saveItem(item);
	}

	@Transactional(readOnly=true)
	public List<Item> getAllItem() {
		return dao.getAllItem();
	}

	@Transactional
	public void deleteItem(Integer id) {
	        dao.deleteItem(id);
	}

	@Transactional(readOnly=true)
	public Item getItemById(Integer id) {
		return dao.getItemById(id);
	}

	@Transactional
	public void updateItem(Item item) {
	       dao.updateItem(item);
	}

	@Override
	public List<Object[]> getItemByCount() {
		return dao.getItemByCount();
	}

}
