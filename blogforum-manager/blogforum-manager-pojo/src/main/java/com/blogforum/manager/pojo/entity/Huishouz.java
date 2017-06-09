/***********************************************************************
 * Module:  Huishouz.java
 * Author:  Administrator
 * Purpose: Defines the Class Huishouz
 ***********************************************************************/
package com.blogforum.manager.pojo.entity;

import java.util.Date;

/** 回收笔记表 */
public class Huishouz {
	/**
	 * 编号
	 */
	public String id;
	/**
	 * 笔记标题
	 */
	public String noteTitle;
	/**
	 * 笔记内容
	 */
	public String noteBody;
	/**
	 * 创建时间
	 */
	public Date createDate;
	/**
	 * 更新时间
	 */
	public Date updateDate;
	/**
	 * 用户id
	 */
	public String userId;
	/**
	 * 笔记本id
	 */
	public String notebookId;
	/**
	 * 博客笔记id
	 */
	public String blogId;
	/**
	 * 附件路径
	 */
	public String enclosure;
	/**
	 * 存放图片路径
	 */
	public String image;
	/**
	 * 图片文字
	 */
	public String imagetext;
	/**
	 * 删除标记 N为不删除 Y为删除
	 */
	public String delFlag;
	/**
	 * 加密共享笔记id
	 */
	public String pwdShareId;

	/**
	 * 缩略图图片路径
	 */
	public String smallImage;

	/**
	 * 标签,用;隔开
	 */
	public String label;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNoteTitle() {
		return noteTitle;
	}

	public void setNoteTitle(String noteTitle) {
		this.noteTitle = noteTitle;
	}

	public String getNoteBody() {
		return noteBody;
	}

	public void setNoteBody(String noteBody) {
		this.noteBody = noteBody;
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

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getNotebookId() {
		return notebookId;
	}

	public void setNotebookId(String notebookId) {
		this.notebookId = notebookId;
	}

	public String getBlogId() {
		return blogId;
	}

	public void setBlogId(String blogId) {
		this.blogId = blogId;
	}

	public String getEnclosure() {
		return enclosure;
	}

	public void setEnclosure(String enclosure) {
		this.enclosure = enclosure;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getImagetext() {
		return imagetext;
	}

	public void setImagetext(String imagetext) {
		this.imagetext = imagetext;
	}

	public String getDelFlag() {
		return delFlag;
	}

	public void setDelFlag(String delFlag) {
		this.delFlag = delFlag;
	}

	public String getPwdShareId() {
		return pwdShareId;
	}

	public void setPwdShareId(String pwdShareId) {
		this.pwdShareId = pwdShareId;
	}

	public String getSmallImage() {
		return smallImage;
	}

	public void setSmallImage(String smallImage) {
		this.smallImage = smallImage;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	@Override
	public String toString() {
		return "Huishouz [id=" + id + ", noteTitle=" + noteTitle + ", noteBody=" + noteBody + ", createDate="
				+ createDate + ", updateDate=" + updateDate + ", userId=" + userId + ", notebookId=" + notebookId
				+ ", blogId=" + blogId + ", enclosure=" + enclosure + ", image=" + image + ", imagetext=" + imagetext
				+ ", delFlag=" + delFlag + ", pwdShareId=" + pwdShareId + ", smallImage=" + smallImage + ", label="
				+ label + "]";
	}

}