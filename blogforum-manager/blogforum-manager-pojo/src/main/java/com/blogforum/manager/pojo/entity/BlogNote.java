/***********************************************************************
 * Module:  BlogNote.java
 * Author:  Administrator
 * Purpose: Defines the Class BlogNote
 ***********************************************************************/
package com.blogforum.manager.pojo.entity;

import java.util.Date;
import java.util.List;

/** 博客笔记 存放发布到博客的笔记 */
public class BlogNote {
	/**
	 * 编号
	 */
	public String id;
	/**
	 * 笔记
	 */
	public Note note;
	/**
	 * 创建时间
	 */
	public Date createDate;
	/**
	 * 更新时间
	 */
	public Date updateDate;
	/**
	 * 评论数量
	 */
	public int commentNum;
	/**
	 * 最后回复时间
	 */
	public Date lasttime;
	/**
	 * 最后回复人
	 */
	public String lastUserid;
	/**
	 * 是否发布 N为不发布 Y为发布
	 */
	public String releaseFlat;
	/**
	 * 访问次数
	 */
	public int visit;

	/**
	 * 评论内容
	 */
	public List<BlogComment> blogComments;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Note getNote() {
		return note;
	}

	public void setNote(Note note) {
		this.note = note;
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

	public int getCommentNum() {
		return commentNum;
	}

	public void setCommentNum(int commentNum) {
		this.commentNum = commentNum;
	}

	public Date getLasttime() {
		return lasttime;
	}

	public void setLasttime(Date lasttime) {
		this.lasttime = lasttime;
	}

	public String getLastUserid() {
		return lastUserid;
	}

	public void setLastUserid(String lastUserid) {
		this.lastUserid = lastUserid;
	}

	public String getReleaseFlat() {
		return releaseFlat;
	}

	public void setReleaseFlat(String releaseFlat) {
		this.releaseFlat = releaseFlat;
	}

	public int getVisit() {
		return visit;
	}

	public void setVisit(int visit) {
		this.visit = visit;
	}

	public List<BlogComment> getBlogComments() {
		return blogComments;
	}

	public void setBlogComments(List<BlogComment> blogComments) {
		this.blogComments = blogComments;
	}

	@Override
	public String toString() {
		return "BlogNote [id=" + id + ", note=" + note + ", createDate=" + createDate + ", updateDate=" + updateDate
				+ ", commentNum=" + commentNum + ", lasttime=" + lasttime + ", lastUserid=" + lastUserid
				+ ", releaseFlat=" + releaseFlat + ", visit=" + visit + ", blogComments=" + blogComments + "]";
	}

}