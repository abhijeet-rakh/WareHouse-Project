package com.app.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.dao.IUserDAO;
import com.app.model.User;

@Repository
public class UserDAOImpl implements IUserDAO {

	@Autowired
	private HibernateTemplate ht;
	
	@Override
	public Integer saveUser(User user) {
		return (Integer) ht.save(user); 
	}

	@Override
	public void updateUser(User user) {
		ht.update(user);
	}

	@Override
	public void deleteUser(Integer id) {
	     User user=new User();
	     user.setUserid(id);
	     ht.delete(user);
	}

	@Override
	public List<User> getAllUser() {
		return ht.loadAll(User.class);
	}

	@Override
	public User getUserById(Integer id) {
		return ht.get(User.class, id);
	}

	@Override
	public boolean isEmailExist(String type, String userEmail) {

		long count=0;
		
		DetachedCriteria hql=DetachedCriteria.forClass(User.class)
				.setProjection(Projections.projectionList()
				.add(Projections.count("type")))
				.add(Restrictions.eq("type",userEmail));
		
		List<Long>  list=(List<Long>) ht.findByCriteria(hql);
		        
		if(list!=null && !list.isEmpty()) {
			count=list.get(0);
			System.out.println("count="+count);
		}
		
		return count>0?true:false;
	}

	@Override
	public boolean isMobileExist(String type, String userMobile) {
		long count=0;
		
		DetachedCriteria hql=DetachedCriteria.forClass(User.class)
				.setProjection(Projections.projectionList()
				.add(Projections.count("type")))
				.add(Restrictions.eq("type",userMobile));
		
		List<Long>  list=(List<Long>) ht.findByCriteria(hql);
		        
		if(list!=null && !list.isEmpty()) {
			count=list.get(0);
			System.out.println("count="+count);
		}
		
		return count>0?true:false;
	}

	@Override
	public User findByUserEmail(String username) {
		User user=null; 
		
		DetachedCriteria hql=DetachedCriteria.forClass(User.class)
				.add(Restrictions.eq("mail",username));
		
		List<User> list=(List<User>) ht.findByCriteria(hql);
		
		if(list!=null && list.isEmpty()) {
			user=list.get(0);
		}
		return user;
	}

}