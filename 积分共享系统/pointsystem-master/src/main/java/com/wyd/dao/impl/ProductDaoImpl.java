package com.wyd.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.wyd.dao.ProductDao;
import com.wyd.domain.Product;

@Repository("productDao")
@Transactional 
public class ProductDaoImpl implements ProductDao{

	@Resource
	private SessionFactory sessionFactory;
	private Session getCurrentSession(){
		return this.sessionFactory.getCurrentSession();
	}
	
	public Product load(int id) {
		return this.getCurrentSession().load(Product.class, id);
	}
	
	public Product get(int id) {
		return this.getCurrentSession().get(Product.class, id);
	}
	
	@SuppressWarnings("unchecked")
	public List<Product> findAll() {
		return this.getCurrentSession().createQuery("from Product").setCacheable(true).list();
	}
	
	public void persist(Product entity) {
		this.getCurrentSession().persist(entity);
	}
	
	public Integer save(Product entity) {
		return (Integer) this.getCurrentSession().save(entity);
	}
	
	public void saveOrUpdate(Product entity) {
		this.getCurrentSession().saveOrUpdate(entity);
	}
	
	public void delete(int id) {
		this.getCurrentSession().delete(this.load(id));
	}
	
	public void flush() {
		this.getCurrentSession().flush();
	}

}
