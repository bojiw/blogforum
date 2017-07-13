package com.blogforum.sso.common.utils;

/**
 * 数学计算工具类
 * @author Administrator
 *
 */
public class MathCalculationUtil {
	
	/**
	 * 获取4位随机数
	 * @return
	 */
	public static int getFourRandom(){
		return (int) (Math.random() * (9000) + 1000);
	}

}
