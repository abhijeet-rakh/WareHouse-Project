package com.app.dao;

import java.util.List;

import com.app.model.Item;

public interface IItemDAO {

	public Integer saveItem(Item item);
	public List<Item> getAllItem();
	public void deleteItem(Integer id);
	public Item getItemById(Integer id);
	public void updateItem(Item item);
	public List<Object[]> getItemByCount();

}
