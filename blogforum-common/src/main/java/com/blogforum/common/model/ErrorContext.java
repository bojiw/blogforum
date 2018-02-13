package com.blogforum.common.model;

import com.blogforum.common.enums.BizErrorEnum;

/**
 * rpc返回类错误上下文
 * 
 * @author wwd
 *
 */
public class ErrorContext extends BaseVO {

	/**
	 * 
	 */
	private static final long	serialVersionUID	= 2139263857134895731L;

	/**
	 * 错误码
	 */
	private String				errorCode;

	/**
	 * 错误名
	 */
	private String				errorName;

	/**
	 * 错误信息
	 */
	private String				errorMessage;

	/**
	 * 异常类
	 */
	private Throwable			exception;

	public ErrorContext() {
	}

	public ErrorContext(BizErrorEnum errorEnum,String errorMessage){
		this(errorEnum.getCode(), errorEnum.getMsg() , errorMessage, null);
	}
	
	public ErrorContext(String errorCode, String errorName, String errorMessage) {
		this(errorCode, errorName, errorMessage, null);
	}

	public ErrorContext(String errorCode, String errorName, String errorMessage, Throwable exception) {
		this.errorCode = errorCode;
		this.errorName = errorName;
		this.errorMessage = errorMessage;
		this.exception = exception;
	}

	public Throwable getException() {
		return exception;
	}

	public void setException(Throwable exception) {
		this.exception = exception;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorName() {
		return errorName;
	}

	public void setErrorName(String errorName) {
		this.errorName = errorName;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

}
