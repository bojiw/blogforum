package com.blogforum.sso.service.loginregistration;

import com.blogforum.sso.pojo.entity.User;

public interface LoginRegistration {
	public void execute(User user) throws Exception;

}
