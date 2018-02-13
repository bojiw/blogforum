/***********************************************************************
 * Module:  PublicNote.java
 * Author:  Administrator
 * Purpose: Defines the Class PublicNote
 ***********************************************************************/
package com.blogforum.notebook.pojo.entity;

import java.util.Date;

/** 公共的笔记 可以多人协作写同一个笔记 */
public class PublicNote extends DataEntity<PublicNote>{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 编号
	 */
	private String	id;
	/**
	 * 笔记标题
	 */
	private String	noteTitle;
	/**
	 * 笔记内容
	 */
	private String	noteBody;
	/**
	 * 创建时间
	 */
	private Date		createDate;
	/**
	 * 更新时间
	 */
	private Date		updateDate;
	/**
	 * 笔记本
	 */
	private NoteBook	noteBook;
	/**
	 * 附件路径
	 */
	private String	enclosure;
	/**
	 * 图片文字
	 */
	private String	imag;
	/**
	 * 删除标记 N为不删除 Y为删除
	 */
	private String	delFlag;
	/**
	 * 创建笔记人
	 */
	private String	userId;

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

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "PublicNote [id=" + id + ", noteTitle=" + noteTitle + ", noteBody=" + noteBody + ", createDate="
							+ createDate + ", updateDate=" + updateDate + ", noteBook=" + noteBook + ", enclosure="
							+ enclosure + ", imag=" + imag + ", delFlag=" + delFlag + ", userId=" + userId + "]";
	}



}