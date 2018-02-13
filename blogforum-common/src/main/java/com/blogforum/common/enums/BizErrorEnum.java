package com.blogforum.common.enums;

public enum BizErrorEnum {
	
	//数据库异常
	/**调用数据库失败 */
	DATABASE_EXCEPTION("301","调用数据库失败"),
	/**插入数据库失败 */
	DATABASE_INSERT("302","插入数据库失败"),

	
	//常规异常
	/**加密失败*/
	FAIL_ENCODE("601","加密失败"),
	/**常规错误*/
	ROUTINE_ERROR("602","常规错误"),
	

	
	//返回信息
	/**用户不存在*/
	NO_USER("700","用户不存在"),
	/**参数不能为空*/
	NULL_PARAMETER("701", "参数不能为空"), 
	/**用户未登录*/
	NO_LOGIN("702", "用户未登录"),
	/**用户已登录*/
	USER_LOGIN("703","用户已登录"),
	/**用户名密码不能为空!*/
	NULL_USERPWD("704", "用户名密码不能为空!"),
	/**系统异常*/
	SYS_EXCEPTION("705", "系统异常"), 
	/**非法参数*/
	ILLEGAL_PARAMETER("706","非法参数"),
	/**用户名密码错误*/
	FAIL_USERPWD("707","用户名密码错误"),
	
	
	//第三方错误
	/**第三方接口调用异常*/
	THIRD_PARTY_INTERFACE_EXCEPTION("900","第三方接口调用异常");

	private String	code;
	private String	msg;

	private BizErrorEnum(String code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	public BizErrorEnum getBizByCode(String code){
		for (BizErrorEnum bizError : values()) {
			if (bizError.code.equals(code)) {
				return bizError;
			}
		}
		return null;
	}
	public BizErrorEnum getBizByMsg(String msg){
		for (BizErrorEnum bizError : values()) {
			if (bizError.msg.equals(msg)) {
				return bizError;
			}
		}
		return null;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	
}
