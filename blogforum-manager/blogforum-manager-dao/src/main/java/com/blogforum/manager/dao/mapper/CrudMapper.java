package com.blogforum.manager.dao.mapper;

import java.util.List;


public interface CrudMapper<T extends DataEntity<T>> extends BaseMapper {
	public void save(T t);

	public void delete(String id);

	public void delete(List<String> ids);

	public void update(T t);

	public T get(String id);

	public T get(T t);

	public List<T> queryList();

	public List<T> queryList(T t);
}
