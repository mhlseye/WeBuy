package com.wyd.service.impl;

import java.util.List;

import javax.annotation.Resource;
import javax.jws.WebParam;
import javax.jws.WebService;

import org.springframework.stereotype.Service;

import com.wyd.dao.ProductDao;
import com.wyd.domain.Product;
import com.wyd.service.ProductService;

@Service("productService")
@WebService(endpointInterface = "com.wyd.service.ProductService") 
public class ProductServiceImpl implements ProductService{
	@Resource
	private ProductDao productDao;

	@Override
	public Product load(@WebParam(name = "id")int id) {
		return productDao.load(id);
	}

	@Override
	public Product get(@WebParam(name = "id")int id) {
		return productDao.get(id);
	}

	@Override
	public List<Product> findAll() {
		return productDao.findAll();
	}

	@Override
	public void persist(Product product) {
		productDao.persist(product);
	}

	@Override
	public Integer save(Product product) {
		return productDao.save(product);
	}

	@Override
	public void saveOrUpdate(Product product) {
		productDao.saveOrUpdate(product);
	}

	@Override
	public void delete(@WebParam(name = "id")int id) {
		productDao.delete(id);
	}

	@Override
	public void flush() {
		productDao.flush();
	}
}
