/***********************************************************************
 * Module:  PwdShareNode.java
 * Author:  Administrator
 * Purpose: Defines the Class PwdShareNode
 ***********************************************************************/
package com.blogforum.notebook.pojo.entity;

import java.util.Date;

/** 加密访问笔记 用户分享以后会生成一个密码 其他人查看加密的笔记需要输入密码 */
public class PwdShareNode extends DataEntity<PwdShareNode> {
	/**
	 * 
	 */
	private static final long	serialVersionUID	= 1L;
	/**
	 * 编号
	 */
	private String				id;
	/**
	 * 用户id
	 */
	private String				userId;
	/**
	 * 笔记
	 */
	private Note					node;
	/**
	 * 加密密码
	 */
	private String				password;
	/**
	 * 创建时间
	 */
	private Date					createDate;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Note getNode() {
		return node;
	}

	public void setNode(Note node) {
		this.node = node;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "PwdShareNode [id=" + id + ", userId=" + userId + ", node=" + node + ", password=" + password
							+ ", createDate=" + createDate + "]";
	}

}