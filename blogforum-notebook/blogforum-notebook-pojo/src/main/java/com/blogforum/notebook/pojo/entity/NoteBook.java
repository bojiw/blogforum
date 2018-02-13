/***********************************************************************
 * Module:  NodeGroup.java
 * Author:  Administrator
 * Purpose: Defines the Class NodeGroup
 ***********************************************************************/
package com.blogforum.notebook.pojo.entity;

/** 笔记本 存放笔记 */
public class NoteBook extends DataEntity<NoteBook> {
	/**
	 * 
	 */
	private static final long	serialVersionUID	= 1L;
	/**
	 * 笔记本编号
	 */
	private String				id;
	/**
	 * 父类目ID=0时，代表的是一级的类目
	 */
	private String				parentId;
	/**
	 * 笔记本名称
	 */
	private String				name;
	/**
	 * 创建笔记本的用户id
	 */
	private String				userId;

	/**
	 * 判断是否有子节点
	 */
	private boolean				haveNode;

	/**
	 * 删除标记 N为不删除 Y为删除
	 */
	private String				delFlag;

	public NoteBook() {
	}

	public NoteBook(String id) {
		init(null, id, null);
	}

	public NoteBook(String userId, String parentId) {
		init(userId, null, parentId);
	}

	public NoteBook(String userId, String id, String parentId) {
		init(userId, id, parentId);
	}

	private void init(String userId, String id, String parentId) {
		this.userId = userId;
		this.id = id;
		this.parentId = parentId;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public boolean getHaveNode() {
		return haveNode;
	}

	public void setHaveNode(boolean haveNode) {
		this.haveNode = haveNode;
	}

	public String getDelFlag() {
		return delFlag;
	}

	public void setDelFlag(String delFlag) {
		this.delFlag = delFlag;
	}

}