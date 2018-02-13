package com.blogforum.notebook.interfaces.sso.impl;



import com.blogforum.notebook.interfaces.sso.UserClient;
import com.blogforum.sso.facade.user.UserServerFacade;

public class UserClientImpl implements UserClient {
	
	private UserServerFacade userServerFacade;
	

	
	public void setUserServerFacade(UserServerFacade userServerFacade) {
		this.userServerFacade = userServerFacade;
	}
}
