/***********************************************************************
 * Module:  PublicNodeUser.java
 * Author:  Administrator
 * Purpose: Defines the Class PublicNodeUser
 ***********************************************************************/
package com.blogforum.manager.pojo.entity;

/** 公共多人协作笔记和用户对应表 */
public class PublicNodeUser {
	/**
	 * 编号
	 */
	public String id;
	/**
	 * 用户id
	 */
	public String userId;
	/**
	 * 公共笔记id
	 */
	public String publicnoteId;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPublicnoteId() {
		return publicnoteId;
	}

	public void setPublicnoteId(String publicnoteId) {
		this.publicnoteId = publicnoteId;
	}

	@Override
	public String toString() {
		return "PublicNodeUser [id=" + id + ", userId=" + userId + ", publicnoteId=" + publicnoteId + "]";
	}

}