package com.blogforum.docking.common.exception;

import com.blogforum.common.enums.BizErrorEnum;
import com.blogforum.docking.common.enums.DockingErrorEnum;

/**
 * 自定义业务异常类
 * 
 * @author wwd
 *
 */
public class DockingBusinessException extends RuntimeException {

	private static final long	serialVersionUID	= 1L;

	public String				code;

	public String				msg;

	/**
	 * 返回前端错误信息
	 * 
	 * @param message
	 */
	public DockingBusinessException(String message) {
		super(message);
		this.code = "602";
		this.msg = message;
	}

	public DockingBusinessException(String code, String message) {
		super(message);
		this.code = code;
		this.msg = message;
	}

	public DockingBusinessException(String message, Throwable cause) {
		super(message, cause);
		this.code = "602";
		this.msg = message;
	}

	public DockingBusinessException(BizErrorEnum bizError, Exception e) {
		super(bizError.getMsg(), e);
		this.code = bizError.getCode();
		this.msg = bizError.getMsg();
	}

	public DockingBusinessException(BizErrorEnum bizError, String message) {
		super(bizError.getMsg());
		this.code = bizError.getCode();
		this.msg = message;
	}

	public DockingBusinessException(BizErrorEnum bizError) {
		super(bizError.getMsg());
		this.code = bizError.getCode();
		this.msg = bizError.getMsg();

	}

	public DockingBusinessException(DockingErrorEnum dockingError, Exception e) {
		super(dockingError.getMsg(), e);
		this.code = dockingError.getCode();
		this.msg = dockingError.getMsg();
	}

	public DockingBusinessException(DockingErrorEnum dockingError) {
		super(dockingError.getMsg());
		this.code = dockingError.getCode();
		this.msg = dockingError.getMsg();
	}

	public String getCode() {
		return code;
	}

	public String getMsg() {
		return msg;
	}

}
