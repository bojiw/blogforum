package com.blogforum.sso.common.utils;

import org.apache.commons.lang3.StringUtils;

import com.blogforum.common.enums.BizError;
import com.blogforum.sso.common.enums.SSOBizError;
import com.blogforum.sso.common.exception.SSOBusinessException;
/**
 * 包装谷歌的Preconditions类返回自定义异常
 * @author Administrator
 *
 */
public class Preconditions {
	
	/**
	 * 检查是否为空 为空则抛异常
	 * @param obj
	 * @param msg
	 */
	public static void checkNotNull(Object obj,BizError bizError){
		
		try {
			if (obj instanceof String) {
				if (StringUtils.isBlank(obj.toString())) {
					throw new Exception();
				}
			}
			com.google.common.base.Preconditions.checkNotNull(obj);
		} catch (Exception e) {
			throw new SSOBusinessException(bizError);
		}
	}
	/**
	 * 检查是否为空 为空则抛异常
	 * @param obj
	 * @param msg
	 */
	public static void checkNotNull(Object obj,SSOBizError bizError){
		try {
			if (obj instanceof String) {
				if (StringUtils.isBlank(obj.toString())) {
					throw new Exception();
				}
			}
			com.google.common.base.Preconditions.checkNotNull(obj);
		} catch (Exception e) {
			throw new SSOBusinessException(bizError);
		}
	}
	
	

	/**
	 * 检查是否为空 不为空则抛异常
	 * @param obj
	 * @param msg
	 */
	public static void checkNull(Object obj,BizError bizError){
		if (obj != null) {
			throw new SSOBusinessException(bizError);
		}
	}

	/**
	 * 检查是否为空 不为空则抛异常
	 * @param obj
	 * @param msg
	 */
	public static void checkNull(Object obj,SSOBizError bizError){
		if (obj != null) {
			throw new SSOBusinessException(bizError);
		}
	}
	
}
