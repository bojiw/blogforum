package com.blogforum.sso.common.exception;

import com.blogforum.common.enums.BizErrorEnum;
import com.blogforum.sso.common.enums.SSOBizError;

/**
 * 自定义业务异常类
 * 
 * @author wwd
 *
 */
public class SSOBusinessException extends RuntimeException {

	private static final long	serialVersionUID	= 1L;

	public String				code;

	public String				msg;

	/**
	 * 返回前端错误信息
	 * 
	 * @param message
	 */
	public SSOBusinessException(String message) {
		super(message);
		this.code = "602";
		this.msg = message;
	}

	public SSOBusinessException(String code, String message) {
		super(message);
		this.code = code;
		this.msg = message;
	}

	public SSOBusinessException(String message, Throwable cause) {
		super(message, cause);
		this.code = "602";
		this.msg = message;
	}

	public SSOBusinessException(BizErrorEnum bizError, Exception e) {
		super(bizError.getMsg(), e);
		this.code = bizError.getCode();
		this.msg = bizError.getMsg();
	}

	public SSOBusinessException(BizErrorEnum bizError, String message) {
		super(bizError.getMsg());
		this.code = bizError.getCode();
		this.msg = message;
	}

	public SSOBusinessException(BizErrorEnum bizError) {
		super(bizError.getMsg());
		this.code = bizError.getCode();
		this.msg = bizError.getMsg();

	}

	public SSOBusinessException(SSOBizError ssoBizError, Exception e) {
		super(ssoBizError.getMsg(), e);
		this.code = ssoBizError.getCode();
		this.msg = ssoBizError.getMsg();
	}

	public SSOBusinessException(SSOBizError ssoBizError) {
		super(ssoBizError.getMsg());
		this.code = ssoBizError.getCode();
		this.msg = ssoBizError.getMsg();
	}

	public String getCode() {
		return code;
	}

	public String getMsg() {
		return msg;
	}

}
