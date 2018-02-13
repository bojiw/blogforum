package com.blogforum.notebook.common.exception;

import com.blogforum.common.enums.BizErrorEnum;
import com.blogforum.notebook.common.enums.NoteErrorEnum;

public class NoteBusinessException extends RuntimeException {

	private static final long	serialVersionUID	= 1L;

	public String				code;

	public String				msg;

	/**
	 * 返回前端错误信息
	 * 
	 * @param message
	 */
	public NoteBusinessException(String message) {
		super(message);
		this.code = "602";
		this.msg = message;
	}

	public NoteBusinessException(String code, String message) {
		super(message);
		this.code = code;
		this.msg = message;
	}

	public NoteBusinessException(String message, Throwable cause) {
		super(message, cause);
		this.code = "602";
		this.msg = message;
	}

	public NoteBusinessException(BizErrorEnum bizError, Exception e) {
		super(bizError.getMsg(), e);
		this.code = bizError.getCode();
		this.msg = bizError.getMsg();
	}

	public NoteBusinessException(BizErrorEnum bizError, String message) {
		super(bizError.getMsg());
		this.code = bizError.getCode();
		this.msg = message;
	}

	public NoteBusinessException(BizErrorEnum bizError) {
		super(bizError.getMsg());
		this.code = bizError.getCode();
		this.msg = bizError.getMsg();

	}

	public NoteBusinessException(NoteErrorEnum noteBizError, Exception e) {
		super(noteBizError.getMsg(), e);
		this.code = noteBizError.getCode();
		this.msg = noteBizError.getMsg();
	}

	public NoteBusinessException(NoteErrorEnum noteBizError) {
		super(noteBizError.getMsg());
		this.code = noteBizError.getCode();
		this.msg = noteBizError.getMsg();
	}

	public String getCode() {
		return code;
	}

	public String getMsg() {
		return msg;
	}

}
