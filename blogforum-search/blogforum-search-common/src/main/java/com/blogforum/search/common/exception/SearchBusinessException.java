package com.blogforum.search.common.exception;

import com.blogforum.common.enums.BizErrorEnum;

public class SearchBusinessException extends RuntimeException {

	private static final long	serialVersionUID	= 1L;

	public String				code;

	public String				msg;

	/**
	 * 返回前端错误信息
	 * 
	 * @param message
	 */
	public SearchBusinessException(String message) {
		super(message);
		this.code = "602";
		this.msg = message;
	}

	public SearchBusinessException(String code, String message) {
		super(message);
		this.code = code;
		this.msg = message;
	}

	public SearchBusinessException(String message, Throwable cause) {
		super(message, cause);
		this.code = "602";
		this.msg = message;
	}

	public SearchBusinessException(BizErrorEnum bizError, Exception e) {
		super(bizError.getMsg(), e);
		this.code = bizError.getCode();
		this.msg = bizError.getMsg();
	}

	public SearchBusinessException(BizErrorEnum bizError, String message) {
		super(bizError.getMsg());
		this.code = bizError.getCode();
		this.msg = message;
	}

	public SearchBusinessException(BizErrorEnum bizError) {
		super(bizError.getMsg());
		this.code = bizError.getCode();
		this.msg = bizError.getMsg();

	}

	public String getCode() {
		return code;
	}

	public String getMsg() {
		return msg;
	}

}
