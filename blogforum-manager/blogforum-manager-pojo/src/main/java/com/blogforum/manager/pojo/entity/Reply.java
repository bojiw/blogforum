/***********************************************************************
 * Module:  Reply.java
 * Author:  Administrator
 * Purpose: Defines the Class Reply
 ***********************************************************************/
package com.blogforum.manager.pojo.entity;

import java.util.Date;

/** 楼层回复表 */
public class Reply {
	/**
	 * 编号
	 */
	private String id;
	/**
	 * 用户编号
	 */
	private User user;
	/**
	 * 博客笔记编号
	 */
	private BlogNote blognode;
	/**
	 * 评论内容
	 */
	private String content;
	/**
	 * 创建时间
	 */
	private Date createDate;
	/**
	 * 是否发布 N为不发布 Y为发布
	 */
	private String releaseFlat;

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

	public BlogNote getBlognode() {
		return blognode;
	}

	public void setBlognode(BlogNote blognode) {
		this.blognode = blognode;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getReleaseFlat() {
		return releaseFlat;
	}

	public void setReleaseFlat(String releaseFlat) {
		this.releaseFlat = releaseFlat;
	}

	@Override
	public String toString() {
		return "Reply [id=" + id + ", user=" + user + ", blognode=" + blognode + ", content=" + content
				+ ", createDate=" + createDate + ", releaseFlat=" + releaseFlat + "]";
	}

}