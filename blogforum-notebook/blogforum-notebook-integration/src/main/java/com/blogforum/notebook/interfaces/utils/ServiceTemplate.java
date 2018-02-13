package com.blogforum.notebook.interfaces.utils;

import com.blogforum.common.enums.BizErrorEnum;
import com.blogforum.common.model.Result;
import com.blogforum.notebook.common.exception.ThirdPartyException;

/**
 * rpc调用统一模板类
 * 
 * @author wwd
 *
 */
public class ServiceTemplate {

	public static <T,F>	T invoke(InvocationSupport<T, F> invocationSupport){
		F result = null;
		try {
			result = invocationSupport.execute();
		} catch (Exception e) {
			throw new ThirdPartyException(BizErrorEnum.THIRD_PARTY_INTERFACE_EXCEPTION,e);
		}
		Result<T> newResult = invocationSupport.convertResult(result);
		if (newResult == null) {
			throw new ThirdPartyException(BizErrorEnum.NULL_PARAMETER);
		}
		if (!newResult.isSuccess()) {
			throw new ThirdPartyException(BizErrorEnum.THIRD_PARTY_INTERFACE_EXCEPTION,newResult.getErrorContext());
		}
		return newResult.getResultObj();
	}
}
