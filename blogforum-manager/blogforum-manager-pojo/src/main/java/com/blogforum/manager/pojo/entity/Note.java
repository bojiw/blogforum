/***********************************************************************
 * Module:  Note.java
 * Author:  Administrator
 * Purpose: Defines the Class Note
 ***********************************************************************/
package com.blogforum.manager.pojo.entity;

import java.util.Date;

/** 笔记表 */
public class Note {
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
	 * 用户
	 */
	public User user;
	/**
	 * 笔记本
	 */
	public NoteBook noteBook;

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
	 * 缩略图图片路径
	 */
	public String smallImage;

	/**
	 * 标签,用;隔开
	 */
	public String label;

	/**
	 * 博客笔记
	 */
	public BlogNote blogNote;

	/**
	 * 加密的访问笔记
	 */
	public PwdShareNode pwdShareNode;

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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public NoteBook getNoteBook() {
		return noteBook;
	}

	public void setNoteBook(NoteBook noteBook) {
		this.noteBook = noteBook;
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

	public BlogNote getBlogNote() {
		return blogNote;
	}

	public void setBlogNote(BlogNote blogNote) {
		this.blogNote = blogNote;
	}

	public PwdShareNode getPwdShareNode() {
		return pwdShareNode;
	}

	public void setPwdShareNode(PwdShareNode pwdShareNode) {
		this.pwdShareNode = pwdShareNode;
	}

	@Override
	public String toString() {
		return "Note [id=" + id + ", noteTitle=" + noteTitle + ", noteBody=" + noteBody + ", createDate=" + createDate
				+ ", updateDate=" + updateDate + ", user=" + user + ", noteBook=" + noteBook + ", enclosure="
				+ enclosure + ", image=" + image + ", imagetext=" + imagetext + ", delFlag=" + delFlag + ", smallImage="
				+ smallImage + ", label=" + label + ", blogNote=" + blogNote + ", pwdShareNode=" + pwdShareNode + "]";
	}

}