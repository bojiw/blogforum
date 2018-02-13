package com.blogforum.notebook.common.exception;

import com.blogforum.common.enums.BizErrorEnum;
import com.blogforum.common.model.ErrorContext;

public class ThirdPartyException extends RuntimeException {

	/**
	 * 
	 */
	private static final long	serialVersionUID	= -2560491460117979104L;

	public String				code;

	public ThirdPartyException() {
	}

	public ThirdPartyException(BizErrorEnum bizErrorEnum) {
		super(bizErrorEnum.getMsg());
		this.code = bizErrorEnum.getCode();
	}
	
	public ThirdPartyException(BizErrorEnum bizErrorEnum, Exception e) {
		super(bizErrorEnum.getMsg(), e);
		this.code = bizErrorEnum.getCode();
	}

	public ThirdPartyException(BizErrorEnum bizErrorEnum, ErrorContext errorContext) {
		super(bizErrorEnum.getMsg(), errorContext.getException());
		this.code = errorContext.getErrorCode();
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

}
