package com.blogforum.search.common.utils;

import java.text.MessageFormat;

import org.apache.commons.lang3.StringUtils;

import com.blogforum.common.enums.BizErrorEnum;
import com.blogforum.search.common.exception.SearchBusinessException;

public class Preconditions {
	
	/**
	 * 检查是否为空 为空则抛异常
	 * @param obj
	 * @param msg
	 */
	public static void checkNotNull(Object obj,BizErrorEnum bizError){
		
		try {
			if (obj instanceof String) {
				if (StringUtils.isBlank(obj.toString())) {
					throw new Exception();
				}
			}
			com.google.common.base.Preconditions.checkNotNull(obj);
		} catch (Exception e) {
			throw new SearchBusinessException(bizError);
		}
	}
	
	/**
	 * 检查是否为空 为空则抛异常
	 * @param obj
	 * @param msg
	 */
	public static void checkNotNull(Object obj,String msg,Object ... st){
		
		try {
			if (obj instanceof String) {
				if (StringUtils.isBlank(obj.toString())) {
					throw new Exception();
				}
			}
			com.google.common.base.Preconditions.checkNotNull(obj);
		} catch (Exception e) {
			throw new SearchBusinessException(MessageFormat.format(msg, st));
		}
	}

	/**
	 * 检查是否为空 不为空则抛异常
	 * @param obj
	 * @param msg
	 */
	public static void checkNull(Object obj,BizErrorEnum bizError){
		if (obj != null) {
			throw new SearchBusinessException(bizError);
		}
	}

	
}
