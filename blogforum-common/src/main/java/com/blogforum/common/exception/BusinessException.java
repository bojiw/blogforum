package com.blogforum.common.exception;


import com.blogforum.common.enums.BizErrorEnum;

/**
 * 自定义业务异常类
 * 
 * @author wwd
 *
 */
public class BusinessException extends RuntimeException {

	private static final long	serialVersionUID	= 1L;

	public String				code;

	/**
	 * 返回前端错误信息
	 * 
	 * @param message
	 */
	public BusinessException(String message) {
		super(message);
	}

	public BusinessException(String code, String message) {
		super(message);
		this.code = code;
	}

	public BusinessException(String message, Throwable cause) {
		super(message, cause);
	}

	public BusinessException(BizErrorEnum bizError,Exception e){
		super(bizError.getMsg(),e);
		this.code = bizError.getCode();
	}
	public BusinessException(BizErrorEnum bizError){
		super(bizError.getMsg());
		this.code = bizError.getCode();
	}
	
	public String getCode() {
		return code;
	}

}
