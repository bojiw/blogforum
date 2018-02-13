package com.blogforum.notebook.pojo.vo;

import com.blogforum.notebook.pojo.entity.DataEntity;

public class NoteTitleVO extends DataEntity<NoteTitleVO> {

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
	/**
	 * 删除标记 N为不删除 Y为删除
	 */
	private String				delFlag;

	/**
	 * 扩展参数
	 */
	private String				extjson;

	/**
	 * 博客笔记iD
	 */
	private String				blogId;

	/**
	 * 加密的访问笔记
	 */
	private String				pwdShareId;


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


}
