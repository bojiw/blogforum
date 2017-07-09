/***********************************************************************
 * Module:  RolePermision.java
 * Author:  Administrator
 * Purpose: Defines the Class RolePermision
 ***********************************************************************/
package com.blogforum.manager.pojo.entity;

/** 角色权限对应表 */
public class RolePermision {
	/**
	 * 编号
	 */
	private long id;

	private int roleId;
	private int permisionId;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public int getPermisionId() {
		return permisionId;
	}

	public void setPermisionId(int permisionId) {
		this.permisionId = permisionId;
	}

	@Override
	public String toString() {
		return "RolePermision [id=" + id + ", roleId=" + roleId + ", permisionId=" + permisionId + "]";
	}

}