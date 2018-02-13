/***********************************************************************
 * Module:  Note.java
 * Author:  Administrator
 * Purpose: Defines the Class Note
 ***********************************************************************/
package com.blogforum.notebook.pojo.entity;

/** 笔记表 */
public class Note extends DataEntity<Note> {
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
	 * 笔记内容
	 */
	private String				noteBody;

	/**
	 * md格式笔记内容
	 */
	private String				mdNoteBody;

	/**
	 * 用户Id
	 */
	private String				userId;
	/**
	 * 笔记本Id
	 */
	private String				noteBookId;

	/**
	 * 附件路径
	 */
	private String				enclosure;

	/**
	 * 笔记类型 普通笔记或者markdown笔记
	 */
	private String				type;
	/**
	 * 删除标记 N为不删除 Y为删除
	 */
	private String				delFlag;

	/**
	 * 扩展参数
	 */
	private String				extjson;

	/**
	 * 标签,用;隔开
	 */
	private String				label;

	/**
	 * 博客笔记iD
	 */
	private String				blogId;

	/**
	 * 加密的访问笔记
	 */
	private String				pwdShareId;

	/**
	 * 纯文本笔记内容
	 */
	private String				context;

	/**
	 * 内容类型 是原创还是转载还是翻译
	 */
	private String				textType;

	/**
	 * 笔记本名字
	 */
	private String				noteBookName;

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

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getEnclosure() {
		return enclosure;
	}

	public void setEnclosure(String enclosure) {
		this.enclosure = enclosure;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDelFlag() {
		return delFlag;
	}

	public void setDelFlag(String delFlag) {
		this.delFlag = delFlag;
	}

	public String getExtjson() {
		return extjson;
	}

	public void setExtjson(String extjson) {
		this.extjson = extjson;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getBlogId() {
		return blogId;
	}

	public void setBlogId(String blogId) {
		this.blogId = blogId;
	}

	public String getPwdShareId() {
		return pwdShareId;
	}

	public void setPwdShareId(String pwdShareId) {
		this.pwdShareId = pwdShareId;
	}

	public String getMdNoteBody() {
		return mdNoteBody;
	}

	public void setMdNoteBody(String mdNoteBody) {
		this.mdNoteBody = mdNoteBody;
	}

	public String getNoteBookId() {
		return noteBookId;
	}

	public void setNoteBookId(String noteBookId) {
		this.noteBookId = noteBookId;
	}

	public String getTextType() {
		return textType;
	}

	public void setTextType(String noteType) {
		this.textType = noteType;
	}

	public String getContext() {
		return context;
	}

	public void setContext(String context) {
		this.context = context;
	}

	public String getNoteBookName() {
		return noteBookName;
	}

	public void setNoteBookName(String noteBookName) {
		this.noteBookName = noteBookName;
	}

}