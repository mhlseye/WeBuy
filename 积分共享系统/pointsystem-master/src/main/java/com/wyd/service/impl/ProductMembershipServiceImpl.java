package com.wyd.service.impl;

import java.util.List;

import javax.annotation.Resource;
import javax.jws.WebParam;
import javax.jws.WebService;

import org.springframework.stereotype.Service;

import com.wyd.dao.ProductMembershipDao;
import com.wyd.domain.ProductMembership;
import com.wyd.service.ProductMembershipService;

@Service("productMembershipService")
@WebService(endpointInterface = "com.wyd.service.ProductMembershipService") 
public class ProductMembershipServiceImpl implements ProductMembershipService{
	@Resource
	private ProductMembershipDao productMembershipDao;

	@Override
	public ProductMembership load(@WebParam(name = "id")int id) {
		return productMembershipDao.load(id);
	}

	@Override
	public ProductMembership get(@WebParam(name = "id")int id) {
		return productMembershipDao.get(id);
	}

	@Override
	public List<ProductMembership> findAll() {
		return productMembershipDao.findAll();
	}

	@Override
	public void persist(ProductMembership productMembership) {
		productMembershipDao.persist(productMembership);
	}

	@Override
	public Integer save(ProductMembership productMembership) {
		return productMembershipDao.save(productMembership);
	}

	@Override
	public void saveOrUpdate(ProductMembership productMembership) {
		productMembershipDao.saveOrUpdate(productMembership);
	}

	@Override
	public void delete(@WebParam(name = "id")int id) {
		productMembershipDao.delete(id);
	}

	@Override
	public void flush() {
		productMembershipDao.flush();
	}

}
