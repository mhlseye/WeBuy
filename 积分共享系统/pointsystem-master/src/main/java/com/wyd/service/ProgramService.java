package com.wyd.service;

import java.util.List;

import javax.jws.WebService;

import com.wyd.domain.Program;

@WebService
public interface ProgramService{
	Program load(int id);
	
	Program get(int id);
	
	List<Program> findAll();
	
	void persist(Program program);
	
	Integer save(Program program);
	
	void saveOrUpdate(Program program);
	
	void delete(int id);
	
	void flush();
}
