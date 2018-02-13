package com.blogforum.sso.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blogforum.common.tools.blogforumResult;
import com.blogforum.sso.pojo.entity.User;
import com.blogforum.sso.service.loginregistration.LoginRegisterContext;
import com.blogforum.sso.service.loginregistration.LoginRegisterFactory;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private LoginRegisterFactory loginRegisterFactory;

	@PostMapping("/loginregister")
	public blogforumResult loginregister(String cmCode, User user, String verificationCode,
						HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
		//设置上下文
		LoginRegisterContext context = new LoginRegisterContext();
		context.setUser(user);
		context.setVerificationCode(verificationCode);
		context.setHttpServletRequest(httpServletRequest);
		context.setHttpServletResponse(httpServletResponse);
		return loginRegisterFactory.getManager(cmCode).execute(context);
	}

}
