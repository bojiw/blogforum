package com.blogforum.common.enums;

public enum BizError {
	
	//数据库异常
	DATABASE_EXCEPTION("301","调用数据库失败"),
	DATABASE_INSERT("302","插入数据库失败"),

	
	//常规异常
	FAIL_ENCODE("601","加密失败"),
	

	
	//返回信息
	NO_USER("700","用户不存在"),
	NULL_PARAMETER("701", "参数不能为空"), 
	NO_LOGIN("702", "用户未登录"),
	USER_LOGIN("703","用户已登录"),
	NULL_USERPWD("704", "用户名密码不能为空!"),
	SYS_EXCEPTION("705", "系统异常"), 
	ILLEGAL_PARAMETER("706","非法参数"),
	FAIL_USERPWD("707","用户名密码错误");

	private String	status;
	private String	msg;

	private BizError(String status, String msg) {
		this.status = status;
		this.msg = msg;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

}
