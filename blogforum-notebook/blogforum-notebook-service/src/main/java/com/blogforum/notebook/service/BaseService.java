package com.blogforum.notebook.service;

import java.util.List;

import com.blogforum.notebook.common.page.Page;

/**
 * Service层基类
 * 
 * @author Edward
 * 
 * @param <T>
 * @param <ID>
 */
public interface BaseService<T> {
	void save(T t);

	T getById(T t);
	
	T get(T t);
	
	List<T> queryList(T t);
	
	Page<T> queryList(Page<T> page, T t);
	
	void update(T t);

	public void delete(T t);
	
}
