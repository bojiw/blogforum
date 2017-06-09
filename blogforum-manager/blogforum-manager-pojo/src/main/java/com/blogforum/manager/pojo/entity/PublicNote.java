/***********************************************************************
 * Module:  PublicNote.java
 * Author:  Administrator
 * Purpose: Defines the Class PublicNote
 ***********************************************************************/
package com.blogforum.manager.pojo.entity;

import java.util.Date;

/** 公共的笔记 可以多人协作写同一个笔记 */
public class PublicNote {
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
	 * 笔记本
	 */
	public NoteBook noteBook;
	/**
	 * 附件路径
	 */
	public String enclosure;
	/**
	 * 图片文字
	 */
	public String imag;
	/**
	 * 删除标记 N为不删除 Y为删除
	 */
	public String delFlag;
	/**
	 * 创建笔记人
	 */
	public User user;

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

	public String getImag() {
		return imag;
	}

	public void setImag(String imag) {
		this.imag = imag;
	}

	public String getDelFlag() {
		return delFlag;
	}

	public void setDelFlag(String delFlag) {
		this.delFlag = delFlag;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "PublicNote [id=" + id + ", noteTitle=" + noteTitle + ", noteBody=" + noteBody + ", createDate="
				+ createDate + ", updateDate=" + updateDate + ", noteBook=" + noteBook + ", enclosure=" + enclosure
				+ ", imag=" + imag + ", delFlag=" + delFlag + ", user=" + user + "]";
	}

}