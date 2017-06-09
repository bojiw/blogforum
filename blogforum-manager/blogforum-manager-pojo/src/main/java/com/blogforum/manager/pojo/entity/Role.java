/***********************************************************************
 * Module:  Role.java
 * Author:  Administrator
 * Purpose: Defines the Class Role
 ***********************************************************************/
package com.blogforum.manager.pojo.entity;

import java.util.Date;
import java.util.List;

/** 角色表 */
public class Role {
	/**
	 * 编号
	 */
	public int id;
	/**
	 * 角色名称
	 */
	public String name;
	/**
	 * 创建者
	 */
	public String createBy;
	/**
	 * 创建时间
	 */
	public Date createDate;
	/**
	 * 更新时间
	 */
	public Date updateDate;
	/**
	 * 备注
	 */
	public String remarks;
	/**
	 * 删除标记 N为不删除 Y为删除
	 */
	public String delFlag;

	/**
	 * 拥有的权限
	 */
	public List<Permision> permisions;

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

	public String getCreateBy() {
		return createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
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

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getDelFlag() {
		return delFlag;
	}

	public void setDelFlag(String delFlag) {
		this.delFlag = delFlag;
	}

	public List<Permision> getPermisions() {
		return permisions;
	}

	public void setPermisions(List<Permision> permisions) {
		this.permisions = permisions;
	}

	@Override
	public String toString() {
		return "Role [id=" + id + ", name=" + name + ", createBy=" + createBy + ", createDate=" + createDate
				+ ", updateDate=" + updateDate + ", remarks=" + remarks + ", delFlag=" + delFlag + ", permisions="
				+ permisions + "]";
	}

}