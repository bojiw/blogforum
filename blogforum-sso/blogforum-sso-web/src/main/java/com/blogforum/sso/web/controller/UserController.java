package com.blogforum.sso.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blogforum.sso.common.exception.SSOBusinessException;
import com.blogforum.sso.service.userservice.UserService;

@RestController
public class UserController {
	private final static Logger LOGGER = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/adduser")
	public void addUser(){
		userService.addUser();
		throw new SSOBusinessException("错误");
	}
	
	

}
