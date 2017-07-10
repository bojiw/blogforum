package com.blogforum.sso.service.loginregistration;

import com.blogforum.common.tools.blogforumResult;
import com.blogforum.sso.pojo.entity.User;

public interface LoginRegistration {
	public blogforumResult execute(User user) ;

}
