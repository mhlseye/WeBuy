package com.wyd.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.wyd.dao.ProductMembershipDao;
import com.wyd.domain.ProductMembership;

@Repository("productMembershipDao")
@Transactional 
public class ProductMembershipDaoImpl implements ProductMembershipDao{

	@Resource
	private SessionFactory sessionFactory;
	private Session getCurrentSession(){
		return this.sessionFactory.getCurrentSession();
	}
	
	public ProductMembership load(int id) {
		return this.getCurrentSession().load(ProductMembership.class, id);
	}
	
	public ProductMembership get(int id) {
		return this.getCurrentSession().get(ProductMembership.class, id);
	}
	
	@SuppressWarnings("unchecked")
	public List<ProductMembership> findAll() {
		return this.getCurrentSession().createQuery("from ProductMembership").setCacheable(true).list();
	}
	
	public void persist(ProductMembership entity) {
		this.getCurrentSession().persist(entity);
	}
	
	public Integer save(ProductMembership entity) {
		return (Integer) this.getCurrentSession().save(entity);
	}
	
	public void saveOrUpdate(ProductMembership entity) {
		this.getCurrentSession().saveOrUpdate(entity);
	}
	
	public void delete(int id) {
		this.getCurrentSession().delete(this.load(id));
	}
	
	public void flush() {
		this.getCurrentSession().flush();
	}
}
