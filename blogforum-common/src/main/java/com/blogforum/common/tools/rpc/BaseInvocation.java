package com.blogforum.common.tools.rpc;

import com.blogforum.common.model.Result;

public abstract class BaseInvocation<T> implements InvocationSupport<T, Result<T>> {

	@Override
	public Result<T> convertResult(Result<T> input) {
		return input;
	}


}
