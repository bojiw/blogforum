package com.blogforum.search.facade.model;

import java.util.Date;

public class BookSearchVO extends SuperVO {

	/**
	 * 
	 */
	private static final long	serialVersionUID	= 1L;

	private String				id;
	/**
	 * 笔记本名
	 */
	private String				name;
	/**
	 * 父ID
	 */
	private String				parentId;
	/**
	 * 用户id
	 */
	private String				userId;
	/**
	 * 是否有子节点
	 */
	private boolean				haveNode;
	/**
	 * 更新时间
	 */
	private Date				updateDate;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public boolean isHaveNode() {
		return haveNode;
	}

	public void setHaveNode(boolean haveNode) {
		this.haveNode = haveNode;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

}
