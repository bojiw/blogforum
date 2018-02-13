package com.blogforum.notebook.dao.mapper;

import java.util.List;

import com.blogforum.notebook.pojo.entity.DataEntity;



public interface CrudMapper<T extends DataEntity<T>> extends BaseMapper {
	void save(T t);

	void delete(T t);

	void update(T t);

	T getById(T t);

	T get(T t);

	List<T> queryList(T t);
}
