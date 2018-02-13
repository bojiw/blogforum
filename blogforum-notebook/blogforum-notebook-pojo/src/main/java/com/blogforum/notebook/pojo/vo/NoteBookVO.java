/***********************************************************************
 * Module:  NoteBookVO.java
 * Author:  wwd
 * Purpose: Defines the Class Note
 ***********************************************************************/
package com.blogforum.notebook.pojo.vo;

import com.blogforum.notebook.pojo.entity.DataEntity;

/**
 * 笔记本显示VO
 * 
 * @author wwd
 *
 */
public class NoteBookVO extends DataEntity<NoteBookVO> {

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
	 * 对应笔记总数
	 */
	private int				noteCount;

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

	public int getNoteCount() {
		return noteCount;
	}

	public void setNoteCount(int noteCount) {
		this.noteCount = noteCount;
	}

}
