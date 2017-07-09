package com.blogforum.sso.common.exception;


import com.blogforum.common.enums.BizError;

/**
 * 自定义业务异常类
 * 
 * @author wwd
 *
 */
public class SSOBusinessException extends RuntimeException {

	private static final long	serialVersionUID	= 1L;

	public String				code;

	/**
	 * 返回前端错误信息
	 * 
	 * @param message
	 */
	public SSOBusinessException(String message) {
		super(message);
		this.code = "705";
	}

	public SSOBusinessException(String code, String message) {
		super(message);
		this.code = code;
	}

	public SSOBusinessException(String message, Throwable cause) {
		super(message, cause);
	}

	public SSOBusinessException(BizError bizError,Exception e){
		super(bizError.getMsg(),e);
		this.code = bizError.getStatus();
	}
	public SSOBusinessException(BizError bizError){
		super(bizError.getMsg());
		this.code = bizError.getStatus();
	}
	
	public String getCode() {
		return code;
	}

}
