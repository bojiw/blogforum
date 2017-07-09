package com.blogforum.sso.service.userservice.impl;

import org.springframework.stereotype.Service;

import com.blogforum.sso.pojo.entity.User;
import com.blogforum.sso.service.base.CrudService;
import com.blogforum.sso.service.userservice.UserService;

@Service
public class UserServiceImpl extends CrudService<User> implements UserService {

	@Override
	public void addUser() {
		System.out.println("aa");

	}

}
