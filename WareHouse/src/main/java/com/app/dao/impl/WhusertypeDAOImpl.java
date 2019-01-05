package com.app.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.dao.IWhuserTypeDAO;
import com.app.model.WhUserType;

@Repository
public class WhusertypeDAOImpl implements IWhuserTypeDAO {

	@Autowired
    private HibernateTemplate ht;
    
	
	@Override
	public Integer saveWhusertype(WhUserType wut) {
		return (Integer) ht.save(wut); 
	}

	@Override
	public void deleteWhusertype(Integer id) {
		WhUserType wut=new WhUserType();
		wut.setWhid(id);
        ht.delete(wut);
	}

	@Override
	public void updateWhusertype(WhUserType wut) {
           ht.update(wut);
	}

	@Override
	public WhUserType getWhusertypeById(Integer id) {
		return ht.get(WhUserType.class, id);
	}

	@Override
	public List<WhUserType> getAllWhuserType() {
		return ht.loadAll(WhUserType.class);
	}

}
