package com.blogforum.common.model;

/**
 * 泛型result结果类
 * 
 * @author wwd
 *
 * @param <T>
 */
public class Result<T> extends BaseVO {

	/**
	 * 
	 */
	private static final long	serialVersionUID	= 5225706809866854784L;

	/** 是否成功 */
	private boolean				success;

	/** 是否可以重试 */
	private boolean				retry = false;

	/** 错误信息上下文 */
	private ErrorContext		errorContext;

	/** 对象实例 */
	private T					resultObj;

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public boolean isRetry() {
		return retry;
	}

	public void setRetry(boolean retry) {
		this.retry = retry;
	}

	public ErrorContext getErrorContext() {
		return errorContext;
	}

	public void setErrorContext(ErrorContext errorContext) {
		this.errorContext = errorContext;
	}

	public T getResultObj() {
		return resultObj;
	}

	public void setResultObj(T resultObj) {
		this.resultObj = resultObj;
	}

	public Result() {
	}

	
	/**
	 * 
	 * @param success
	 *            是否成功
	 * @param resultObj
	 *            对象实例
	 */
	public Result(boolean success, T resultObj) {
		this.success = success;
		this.resultObj = resultObj;
	}

	
	/**
	 * 
	 * @param success
	 *            是否成功
	 * @param errorContext
	 *            错误信息上下文
	 * @param resultObj
	 *            对象实例
	 */
	public Result(boolean success, ErrorContext errorContext, T resultObj) {
		this.success = success;
		this.errorContext = errorContext;
		this.resultObj = resultObj;
	}

	/**
	 * 是否允许重试
	 * @param success
	 * @param retry
	 * @param errorContext
	 * @param resultObj
	 */
	public Result(boolean success, Boolean retry, ErrorContext errorContext, T resultObj) {
		this.success = success;
		this.retry = retry;
		this.errorContext = errorContext;
		this.resultObj = resultObj;
	}

}
