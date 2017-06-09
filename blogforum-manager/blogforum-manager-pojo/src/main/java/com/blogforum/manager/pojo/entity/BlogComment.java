/***********************************************************************
 * Module:  BlogComment.java
 * Author:  Administrator
 * Purpose: Defines the Class BlogComment
 ***********************************************************************/
package com.blogforum.manager.pojo.entity;

import java.util.Date;
import java.util.List;

/** 博客评论表 */
public class BlogComment {
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
	 * 评论内容
	 */
	public String content;
	/**
	 * 创建时间
	 */
	public Date createDate;
	/**
	 * 是否有回复N代表没有 Y代表有
	 */
	public String storey;
	/**
	 * 是否发布 N代表不发布 Y代表发布
	 */
	public String releaseFlat;

	/**
	 * 回复的内容
	 */
	public List<Reply> replies;

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

	public String getStorey() {
		return storey;
	}

	public void setStorey(String storey) {
		this.storey = storey;
	}

	public String getReleaseFlat() {
		return releaseFlat;
	}

	public void setReleaseFlat(String releaseFlat) {
		this.releaseFlat = releaseFlat;
	}

	public List<Reply> getReplies() {
		return replies;
	}

	public void setReplies(List<Reply> replies) {
		this.replies = replies;
	}

	@Override
	public String toString() {
		return "BlogComment [id=" + id + ", user=" + user + ", blogNote=" + blogNote + ", content=" + content
				+ ", createDate=" + createDate + ", storey=" + storey + ", releaseFlat=" + releaseFlat + ", replies="
				+ replies + "]";
	}

}