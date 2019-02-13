package com.wyd.dao;

import java.util.List;

public interface GenericDao<T> {
	
    T load(int id);
	
	T get(int id);
	
	List<T> findAll();
	
	void persist(T entity);
	
	Integer save(T entity);
	
	void saveOrUpdate(T entity);
	
	void delete(int id);
	
	void flush();
}
