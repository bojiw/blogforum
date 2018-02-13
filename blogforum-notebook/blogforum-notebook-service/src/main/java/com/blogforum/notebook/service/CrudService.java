package com.blogforum.notebook.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.blogforum.notebook.common.page.Page;
import com.blogforum.notebook.dao.mapper.CrudMapper;
import com.blogforum.notebook.pojo.entity.DataEntity;

/**
 * Service层增删改查基类
 * 
 * @author Edward
 * 
 * @param <T>
 * @param <ID>
 */
public abstract class CrudService<T extends DataEntity<T>> implements BaseService<T> {

	@Autowired
	protected CrudMapper<T> mapper;

	/**
	 * 查询单笔记录
	 * 
	 * @param id
	 * @return
	 */
	public T getById(T t) {
		return mapper.getById(t);
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
	 * @param t
	 * @return
	 */
	public List<T> queryList(T t) {
		return mapper.queryList(t);
	}

	/**
	 * 查询全部记录(分页)
	 * 
	 * @param page
	 * @param t
	 * @return
	 */
	public Page<T> queryList(Page<T> page, T t) {
		t.setPage(page);
		page = page.setList(mapper.queryList(t));
		return page;
	}

	/**
	 * 保存货更新(不推荐该方法，这个把业务分开个更为明确)
	 * 
	 * @param t
	 */
	// public void saveOrUpdate(T t) {
	// if (t.isNew()) {
	// this.save(t);
	// } else {
	// this.update(t);
	// }
	// }

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
	public void delete(T t) {
		t.setUpdateDate(new Date());
		mapper.delete(t);
	}

}
