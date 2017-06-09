/***********************************************************************
 * Module:  Permision.java
 * Author:  Administrator
 * Purpose: Defines the Class Permision
 ***********************************************************************/
package com.blogforum.manager.pojo.entity;

import java.util.List;

/** 权限表 */
public class Permision {
	/**
	 * 编号
	 */
	public int id;
	/**
	 * 权限名称
	 */
	public String name;
	/**
	 * 访问路径
	 */
	public String controller;

	/**
	 * 拥有这个权限的角色
	 */
	public List<Role> roles;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getController() {
		return controller;
	}

	public void setController(String controller) {
		this.controller = controller;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	@Override
	public String toString() {
		return "Permision [id=" + id + ", name=" + name + ", controller=" + controller + ", roles=" + roles + "]";
	}

}