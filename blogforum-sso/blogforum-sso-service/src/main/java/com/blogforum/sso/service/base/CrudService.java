package com.blogforum.sso.service.base;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.blogforum.sso.dao.mapper.CrudMapper;
import com.blogforum.sso.pojo.entity.DataEntity;

/**
 * Service层增删改查基类
 * 
 * @author Edward
 * 
 * @param <T>
 * @param <ID>
 */
public abstract class CrudService<T extends DataEntity<T>> extends BaseService {

	@Autowired
	protected CrudMapper<T> mapper;

	/**
	 * 查询单笔记录
	 * 
	 * @param id
	 * @return
	 */
	public T getById(String id) {
		return mapper.getById(id);
	}

	/**
	 * 查询单笔记录
	 * 
	 * @param t
	 * @return
	 */
	public T get(T t) {
		return mapper.get(t);
	}

	/**
	 * 查询全部记录
	 * 
	 * @return
	 */
	public List<T> queryList() {
		return mapper.queryList();
	}

	/**
	 * 查询全部记录
	 * 
	 * @param t
	 * @return
	 */
	public List<T> queryList(T t) {
		return mapper.queryList(t);
	}

	/**
	 * 保存
	 * 
	 * @param t
	 */
	public void save(T t) {
		t.setCreateDate(new Date());
		t.setUpdateDate(new Date());
		mapper.save(t);
	}

	/**
	 * 更新
	 * 
	 * @param t
	 */
	public void update(T t) {
		t.setUpdateDate(new Date());
		mapper.update(t);
	}

	/**
	 * 删除单笔
	 * 
	 * @param id
	 */
	public void delete(String id) {
		mapper.delete(id);
	}

	/**
	 * 删除多笔记录
	 * 
	 * @param ids
	 */
	public void delete(List<String> ids) {
		mapper.delete(ids);
	}

}
