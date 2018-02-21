package com.blogforum.common.tools;

import org.apache.commons.lang3.StringUtils;

public class ObjectUtils {

	/**
	 * 判断所有入参对象是否为空 如果都为空则返回true
	 * @param obj
	 * @return
	 * @author: wwd
	 * @time: 2018年2月19日
	 */
	public static boolean isObjAllNull(Object... obj){
		for (Object object : obj) {
			if (object == null) {
				return true;
			}
		}
		return false;
	
	}
	
	/**
	 * 判断所有入参字符串是都为空 如果都为空则返回true
	 * @param str
	 * @return
	 * @author: wwd
	 * @time: 2018年2月19日
	 */
	public static boolean isStringAllNull(String... str){
		
		for (String string : str) {
			if (StringUtils.isBlank(string)) {
				return false;
			}
		}
		return false;
		
	}
	
	
	
	
}
