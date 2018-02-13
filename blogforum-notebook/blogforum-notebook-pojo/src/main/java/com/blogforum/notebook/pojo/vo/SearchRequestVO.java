package com.blogforum.notebook.pojo.vo;

public class SearchRequestVO {
	/**
	 * 搜索关键词
	 */
	private String	keyword;
	/**
	 * 请求页数
	 */
	private Integer	pageNo;
	/**
	 * 请求页数大小
	 */
	private Integer	pageSize	= 20;

	/**
	 * 用户id
	 */
	private String	userId;

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public Integer getPageNo() {
		return pageNo;
	}

	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

}
