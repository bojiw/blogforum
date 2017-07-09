package com.blogforum.manager.pojo.entity;

import java.util.Date;

/***********************************************************************
 * Module:  AdminUser.java
 * Author:  Administrator
 * Purpose: Defines the Class AdminUser
 ***********************************************************************/

/** 管理员用户表 */
public class AdminUser extends DataEntity {
	/**
	 * 编号
	 */
	private int id;
	/**
	 * 登录用户名
	 */
	private String username;
	/**
	 * 密码
	 */
	private String password;
	/**
	 * 加盐
	 */
	private String salt;
	/**
	 * 角色
	 */
	private Role role;

	/**
	 * 创建时间
	 */
	private Date createDate;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	@Override
	public String toString() {
		return "AdminUser [id=" + id + ", username=" + username + ", password=" + password + ", salt=" + salt
				+ ", role=" + role + ", createDate=" + createDate + "]";
	}

}