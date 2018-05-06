package com.blogforum.common.exception;

import com.blogforum.common.enums.BizErrorEnum;

/**
 * 消息可丢弃异常
 * @author wwd
 *
 */
public class MsgDiscardException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String				code;

	public String				msg;


	public MsgDiscardException(String message) {
		super(message);
		this.code = "500";
		this.msg = message;
	}

	public MsgDiscardException(String code, String message) {
		super(message);
		this.code = code;
		this.msg = message;
	}

	public MsgDiscardException(String message, Throwable cause) {
		super(message, cause);
		this.code = "602";
		this.msg = message;
	}

	public MsgDiscardException(BizErrorEnum bizError, Exception e) {
		super(bizError.getMsg(), e);
		this.code = bizError.getCode();
		this.msg = bizError.getMsg();
	}

	public MsgDiscardException(BizErrorEnum bizError, String message) {
		super(bizError.getMsg());
		this.code = bizError.getCode();
		this.msg = message;
	}

	public MsgDiscardException(BizErrorEnum bizError) {
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
