package com.blogforum.notebook.service.session.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.blogforum.notebook.interfaces.sso.SessionClient;
import com.blogforum.notebook.service.session.SessionServer;
import com.blogforum.sso.facade.model.UserVO;

public class SessionServerImpl implements SessionServer {

	@Autowired
	private SessionClient sessionClient;
	
	@Override
	public UserVO getUserByToken(String token) {
		return sessionClient.getUserByToken(token);
	}

	@Override
	public void userLoginOut(String token) {
		sessionClient.userLoginOut(token);
	}
	

}
