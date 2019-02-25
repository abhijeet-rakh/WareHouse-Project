package com.app.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.dao.IOrderMethodDAO;
import com.app.model.OrderMethod;

@Repository
public class OrderMethodDAOImpl implements IOrderMethodDAO {

	@Autowired
	private HibernateTemplate ht;

	@Override
	public Integer saveOrderMethod(OrderMethod om) {
		return (Integer) ht.save(om);
	}

	@Override
	public List<OrderMethod> getAllOrderMethod() {
		return ht.loadAll(OrderMethod.class);
	}

	@Override
	public void deleteOrderMethod(Integer id) {
		OrderMethod om = new OrderMethod();
		om.setOid(id);
		ht.delete(om);
	}

	@Override
	public OrderMethod getOrderMethodById(Integer id) {
		return ht.get(OrderMethod.class, id);
	}

	@Override
	public void updateOrderMethod(OrderMethod om) {
		ht.update(om);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Object[]> getOrderModeByCount() {
		/*
		 * String hql = "select ordermode,count(ordermode) from " +
		 * OrderMethod.class.getName() + " group by ordermode ";
		 */
		DetachedCriteria hql = DetachedCriteria.forClass(OrderMethod.class)
				.setProjection(Projections.projectionList()
				.add(Projections.groupProperty("ordermode"))
				.add(Projections.count("ordermode")));

		return (List<Object[]>) ht.findByCriteria(hql);
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean isCodeExist(String orderCode) {

		long count = 0;
		/*
		 * String hql=" select count(ordercode) from "+OrderMethod.class.getName()
		 * +" where ordercode=?";
		 */

		DetachedCriteria hql = DetachedCriteria.forClass(OrderMethod.class)
				.setProjection(Projections.projectionList()
				.add(Projections.count("ordercode")))
				.add(Restrictions.eq("ordercode", orderCode));

		List<Long> list = (List<Long>) ht.findByCriteria(hql);

		if (list != null && !list.isEmpty()) {
			count = list.get(0);
			System.out.println("count  ");
		}
		System.out.println("count boolean=" + (count > 0 ? true : false));
		return count > 0 ? true : false;
	}
}
