package com.blogforum.sso.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.blogforum.common.tools.blogforumResult;
import com.blogforum.sso.common.exception.SSOBusinessException;
import com.blogforum.sso.pojo.entity.User;
import com.blogforum.sso.service.loginregistration.LoginRegistrationFactory;
import com.blogforum.sso.service.userservice.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private LoginRegistrationFactory abstractLoginRegistrationFactory;
	
	@RequestMapping("/adduser")
	public void addUser(){
		userService.addUser();
		throw new SSOBusinessException("错误");
	}
	
	@RequestMapping("/loginregistration")
	public blogforumResult loginregistration(String cmCode,User user){
		return abstractLoginRegistrationFactory.manager(cmCode).execute(user);
	}
	
	

}
