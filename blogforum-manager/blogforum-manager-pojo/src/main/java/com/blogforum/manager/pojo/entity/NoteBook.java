/***********************************************************************
 * Module:  NodeGroup.java
 * Author:  Administrator
 * Purpose: Defines the Class NodeGroup
 ***********************************************************************/
package com.blogforum.manager.pojo.entity;

import java.util.Date;
import java.util.List;

/** 笔记本 存放笔记 */
public class NoteBook {
	/**
	 * 笔记本编号
	 */
	public String id;
	/**
	 * 父类目ID=0时，代表的是一级的类目
	 */
	public String parentId;
	/**
	 * 笔记本名称
	 */
	public String name;
	/**
	 * 创建笔记本的用户id
	 */
	public User user;
	/**
	 * 创建时间
	 */
	public Date createDate;
	/**
	 * 更新时间
	 */
	public Date updateDate;

	/**
	 * 笔记
	 */
	public List<Note> notes;

	/**
	 * 公共笔记
	 */
	public List<PublicNote> publicNotes;

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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public List<Note> getNotes() {
		return notes;
	}

	public void setNotes(List<Note> notes) {
		this.notes = notes;
	}

	public List<PublicNote> getPublicNotes() {
		return publicNotes;
	}

	public void setPublicNotes(List<PublicNote> publicNotes) {
		this.publicNotes = publicNotes;
	}

	@Override
	public String toString() {
		return "NoteBook [id=" + id + ", parentId=" + parentId + ", name=" + name + ", user=" + user + ", createDate="
				+ createDate + ", updateDate=" + updateDate + ", notes=" + notes + ", publicNotes=" + publicNotes + "]";
	}

}