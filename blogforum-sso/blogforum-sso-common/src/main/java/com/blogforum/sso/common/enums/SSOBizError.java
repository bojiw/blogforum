package com.blogforum.sso.common.enums;

public enum SSOBizError {

	/**短信发送失败*/
	SMS_ERROR("801","短信发送失败，请重试！！！"),
	
	/**邮箱不能为空*/
	EMAIL_NOTNULL("802","邮箱不能为空!"),
	
	/**邮箱已经注册*/
	EMAIL_ISREGISTER("803","该邮箱已经注册！"),
	
	/**手机号不能为空*/
	IPHONE_NOTNULL("804","手机号不能为空！"),
	
	/**该手机号已经注册*/
	IPHONE_ISREGISTER("805","该手机号已经注册!"),
	
	/**验证码不能为空*/
	VECODE_NOTNULL("806","验证码不能为空!"),
	
	/**验证码不正确*/
	VECODE_ERROR("807","验证码不正确,请重新获取!"),
	
	/**用户已经注册*/
	USER_ISREGERSTER("808","用户已经注册!");
	
	private String	code;
	private String	msg;

	private SSOBizError(String code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	public SSOBizError getBizByCode(String code){
		for (SSOBizError ssoBizError : values()) {
			if (ssoBizError.code.equals(code)) {
				return ssoBizError;
			}
		}
		return null;
	}
	public SSOBizError getBizByMsg(String msg){
		for (SSOBizError ssoBizError : values()) {
			if (ssoBizError.msg.equals(msg)) {
				return ssoBizError;
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
