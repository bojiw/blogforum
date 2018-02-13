/***********************************************************************
 * Module:  User.java
 * Author:  Administrator
 * Purpose: Defines the Class User
 ***********************************************************************/
package com.blogforum.sso.pojo.entity;

import java.util.Date;

/** 用户表 */
public class User extends DataEntity<User> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 编号
	 */
	private String id;
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
	private int role;
	/**
	 * Email邮件
	 */
	private String email;
	/**
	 * 手机号
	 */
	private String iphone;

	/**
	 * 最后登录时间
	 */
	private Date loginDate;
	/**
	 * 最后登录ip
	 */
	private String loginIp;
	/**
	 * 状态 0为正常 1为无法登录 2为删除状态
	 */
	private int status = 0;
	/**
	 * 头像路径
	 */
	private String image;
	/**
	 * 备注信息
	 */
	private String remarks;
	/**
	 * 所在省份
	 */
	private String provinceLocation;
	/**
	 * 所在城市
	 */
	private String cityLocation;
	/**
	 * 出生省份
	 */
	private String birthProvince;
	/**
	 * 出生城市
	 */
	private String birthCity;


	public String getId() {
		return id;
	}

	public void setId(String id) {
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

	public int getRole() {
		return role;
	}

	public void setRole(int role) {
		this.role = role;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getIphone() {
		return iphone;
	}

	public void setIphone(String iphone) {
		this.iphone = iphone;
	}


	public Date getLoginDate() {
		return loginDate;
	}

	public void setLoginDate(Date loginDate) {
		this.loginDate = loginDate;
	}

	public String getLoginIp() {
		return loginIp;
	}

	public void setLoginIp(String loginIp) {
		this.loginIp = loginIp;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getProvinceLocation() {
		return provinceLocation;
	}

	public void setProvinceLocation(String provinceLocation) {
		this.provinceLocation = provinceLocation;
	}

	public String getCityLocation() {
		return cityLocation;
	}

	public void setCityLocation(String cityLocation) {
		this.cityLocation = cityLocation;
	}

	public String getBirthProvince() {
		return birthProvince;
	}

	public void setBirthProvince(String birthProvince) {
		this.birthProvince = birthProvince;
	}

	public String getBirthCity() {
		return birthCity;
	}

	public void setBirthCity(String birthCity) {
		this.birthCity = birthCity;
	}


}