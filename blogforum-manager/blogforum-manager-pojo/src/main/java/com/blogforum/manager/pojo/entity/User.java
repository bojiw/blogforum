/***********************************************************************
 * Module:  User.java
 * Author:  Administrator
 * Purpose: Defines the Class User
 ***********************************************************************/
package com.blogforum.manager.pojo.entity;

import java.util.Date;
import java.util.List;

/** 用户表 */
public class User {
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
	 * 创建时间
	 */
	private Date createDate;
	/**
	 * 更新时间
	 */
	private Date updateDate;
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
	 * 更新人
	 */
	private String updateBy;
	/**
	 * 备注信息
	 */
	private String remarks;
	/**
	 * 所在省份
	 */
	private Area provinceLocation;
	/**
	 * 所在城市
	 */
	private Area cityLocation;
	/**
	 * 出生省份
	 */
	private Area birthProvince;
	/**
	 * 出生城市
	 */
	private Area birthCity;

	/**
	 * 博客访问历史记录
	 */
	private List<UserBlogHistory> userBlogHistorys;

	/**
	 * 笔记本
	 */
	private List<NoteBook> noteGroups;

	/**
	 * 笔记
	 */
	private List<Note> notes;

	/**
	 * 创建的公共笔记
	 */
	private List<PublicNote> publicNotes;

	/**
	 * 加密的访问笔记
	 */
	private List<PwdShareNode> pwdShareNodes;

	/**
	 * 发表的评论
	 */
	private List<Reply> replies;

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

	public String getUpdateBy() {
		return updateBy;
	}

	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public Area getProvinceLocation() {
		return provinceLocation;
	}

	public void setProvinceLocation(Area provinceLocation) {
		this.provinceLocation = provinceLocation;
	}

	public Area getCityLocation() {
		return cityLocation;
	}

	public void setCityLocation(Area cityLocation) {
		this.cityLocation = cityLocation;
	}

	public Area getBirthProvince() {
		return birthProvince;
	}

	public void setBirthProvince(Area birthProvince) {
		this.birthProvince = birthProvince;
	}

	public Area getBirthCity() {
		return birthCity;
	}

	public void setBirthCity(Area birthCity) {
		this.birthCity = birthCity;
	}

	public List<UserBlogHistory> getUserBlogHistorys() {
		return userBlogHistorys;
	}

	public void setUserBlogHistorys(List<UserBlogHistory> userBlogHistorys) {
		this.userBlogHistorys = userBlogHistorys;
	}

	public List<NoteBook> getNoteGroups() {
		return noteGroups;
	}

	public void setNoteGroups(List<NoteBook> noteGroups) {
		this.noteGroups = noteGroups;
	}

	public List<Note> getNotes() {
		return notes;
	}

	public void setNotes(List<Note> notes) {
		this.notes = notes;
	}

	public List<PublicNote> getPublicNotes() {
		return publicNotes;
	}

	public void setPublicNotes(List<PublicNote> publicNotes) {
		this.publicNotes = publicNotes;
	}

	public List<PwdShareNode> getPwdShareNodes() {
		return pwdShareNodes;
	}

	public void setPwdShareNodes(List<PwdShareNode> pwdShareNodes) {
		this.pwdShareNodes = pwdShareNodes;
	}

	public List<Reply> getReplies() {
		return replies;
	}

	public void setReplies(List<Reply> replies) {
		this.replies = replies;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", salt=" + salt + ", role="
				+ role + ", email=" + email + ", iphone=" + iphone + ", createDate=" + createDate + ", updateDate="
				+ updateDate + ", loginDate=" + loginDate + ", loginIp=" + loginIp + ", status=" + status + ", image="
				+ image + ", updateBy=" + updateBy + ", remarks=" + remarks + ", provinceLocation=" + provinceLocation
				+ ", cityLocation=" + cityLocation + ", birthProvince=" + birthProvince + ", birthCity=" + birthCity
				+ ", userBlogHistorys=" + userBlogHistorys + ", noteGroups=" + noteGroups + ", notes=" + notes
				+ ", publicNotes=" + publicNotes + ", pwdShareNodes=" + pwdShareNodes + ", replies=" + replies + "]";
	}

}