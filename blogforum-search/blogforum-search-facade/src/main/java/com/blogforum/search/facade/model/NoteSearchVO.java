package com.blogforum.search.facade.model;

import java.util.Date;

public class NoteSearchVO extends SuperVO {

	/**
	 * 
	 */
	private static final long	serialVersionUID	= 1L;

	/**
	 * 编号
	 */
	private String				id;
	/**
	 * 笔记标题
	 */
	private String				noteTitle;

	/**
	 * 笔记纯文本内容
	 */
	private String				noteContext;

	/**
	 * 用户Id
	 */
	private String				userId;
	/**
	 * 笔记本Id
	 */
	private String				noteBookId;

	/**
	 * 笔记本名字
	 */
	private String				noteBookName;

	/**
	 * 笔记类型 普通笔记或者markdown笔记
	 */
	private String				type;

	private Date				updateDate;

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

	public String getNoteContext() {
		return noteContext;
	}

	public void setNoteContext(String noteContext) {
		this.noteContext = noteContext;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getNoteBookId() {
		return noteBookId;
	}

	public void setNoteBookId(String noteBookId) {
		this.noteBookId = noteBookId;
	}

	public String getNoteBookName() {
		return noteBookName;
	}

	public void setNoteBookName(String noteBookName) {
		this.noteBookName = noteBookName;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

}
