package com.blogforum.sso.dao.mapper;

import java.util.List;

import com.blogforum.sso.pojo.entity.DataEntity;


public interface CrudMapper<T extends DataEntity<T>> extends BaseMapper {
	public void save(T t);

	public void delete(String id);

	public void delete(List<String> ids);

	public void update(T t);

	public T getById(String id);

	public T get(T t);

	public List<T> queryList();

	public List<T> queryList(T t);
}
