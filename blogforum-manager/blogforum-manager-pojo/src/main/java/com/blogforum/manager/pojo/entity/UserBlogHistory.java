/***********************************************************************
 * Module:  BlogHistory.java
 * Author:  Administrator
 * Purpose: Defines the Class BlogHistory
 ***********************************************************************/
package com.blogforum.manager.pojo.entity;

import java.util.Date;

/** 博客访问历史记录 */
public class UserBlogHistory {
	/**
	 * 编号
	 */
	public String id;
	/**
	 * 用户
	 */
	public User user;
	/**
	 * 博客笔记
	 */
	public BlogNote blogNote;
	/**
	 * 访问时间
	 */
	public Date createDate;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public BlogNote getBlogNote() {
		return blogNote;
	}

	public void setBlogNote(BlogNote blogNote) {
		this.blogNote = blogNote;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	@Override
	public String toString() {
		return "UserBlogHistory [id=" + id + ", user=" + user + ", blogNote=" + blogNote + ", createDate=" + createDate
				+ "]";
	}

}