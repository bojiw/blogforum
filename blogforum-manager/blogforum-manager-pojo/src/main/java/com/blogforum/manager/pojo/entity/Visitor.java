/***********************************************************************
 * Module:  Visitor.java
 * Author:  Administrator
 * Purpose: Defines the Class Visitor
 ***********************************************************************/
package com.blogforum.manager.pojo.entity;

import java.util.Date;

/** 网站访问记录 */
public class Visitor {
	/**
	 * 编号
	 */
	private String id;
	/**
	 * 用户
	 */
	private User user;
	/**
	 * 访问开始时间
	 */
	private Date visitDate;
	/**
	 * 访问结束时间
	 */
	private Date leftDate;
	/**
	 * 访问ip地址
	 */
	private String ip;
	/**
	 * 访问客户端设备
	 */
	private String client;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Date getVisitDate() {
		return visitDate;
	}

	public void setVisitDate(Date visitDate) {
		this.visitDate = visitDate;
	}

	public Date getLeftDate() {
		return leftDate;
	}

	public void setLeftDate(Date leftDate) {
		this.leftDate = leftDate;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getClient() {
		return client;
	}

	public void setClient(String client) {
		this.client = client;
	}

	@Override
	public String toString() {
		return "Visitor [id=" + id + ", user=" + user + ", visitDate=" + visitDate + ", leftDate=" + leftDate + ", ip="
				+ ip + ", client=" + client + "]";
	}

}