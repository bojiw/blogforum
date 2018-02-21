package com.blogforum.common.tools;

import java.text.MessageFormat;

import org.slf4j.Logger;

public class LoggerUtil {

	/**
	 * 打印信息日志
	 * @param logger
	 * @param msg
	 * @param arguments
	 * @author: wwd
	 * @time: 2018年1月13日
	 */
	public static void info(Logger logger, String msg,Object... arguments){
		if (logger.isInfoEnabled()) {
			logger.info(MessageFormat.format(msg, arguments));
		}
	}
	
	/**
	 * 打印警告日志
	 * @param logger
	 * @param msg
	 * @param arguments
	 * @author: wwd
	 * @time: 2018年1月13日
	 */
	public static void warn(Logger logger, String msg,Object... arguments){
		if (logger.isWarnEnabled()) {
			logger.warn(MessageFormat.format(msg, arguments));
		}
	}
	
	/**
	 * 打印错误日志
	 * @param logger
	 * @param msg
	 * @param arguments
	 * @author: wwd
	 * @time: 2018年1月13日
	 */
	public static void error(Logger logger, String msg,Object... arguments){
		error(logger, null, msg, arguments);
	}
	
	/**
	 * 打印错误堆栈日志
	 * @param logger
	 * @param e
	 * @param msg
	 * @param arguments
	 * @author: wwd
	 * @time: 2018年1月13日
	 */
	public static void error(Logger logger, Exception e, String msg,Object... arguments){
		if (logger.isErrorEnabled()) {
			logger.error(MessageFormat.format(msg, arguments),e);
		}
	}
	
}
