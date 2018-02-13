package com.blogforum.notebook.interfaces.utils;

import com.blogforum.common.model.Result;

public interface InvocationSupport<T, F> {

	/**
	 * 结果类转换
	 * 
	 * @param input
	 * @return
	 * @author: wwd
	 * @time: 2017年11月7日
	 */
	Result<T> convertResult(F input);

	/**
	 * 执行调用rpc接口
	 * 
	 * @return
	 * @author: wwd
	 * @time: 2017年11月7日
	 */
	F execute();

}
