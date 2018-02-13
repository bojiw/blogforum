package com.blogforum.notebook.interfaces.sso.impl;

import com.blogforum.common.model.Result;
import com.blogforum.notebook.interfaces.sso.SessionClient;
import com.blogforum.notebook.interfaces.utils.BaseInvocation;
import com.blogforum.notebook.interfaces.utils.ServiceTemplate;
import com.blogforum.sso.facade.model.UserVO;
import com.blogforum.sso.facade.session.SessionServerFacade;


public class SessionClientImpl implements SessionClient {

	private SessionServerFacade sessionServerFacade;
	
	@Override
	public Boolean isLogin(final String token) {
		return ServiceTemplate.invoke(new BaseInvocation<Boolean>() {
			@Override
			public Result<Boolean> execute() {
				return sessionServerFacade.isLogin(token);
			}
		});
	}

	@Override
	public UserVO getUserByToken(final String token) {
		return ServiceTemplate.invoke(new BaseInvocation<UserVO>() {

			@Override
			public Result<UserVO> execute() {
				return sessionServerFacade.getUserByToken(token);
			}
		});
	}
	@Override
	public Boolean userLoginOut(final String token) {
		return ServiceTemplate.invoke(new BaseInvocation<Boolean>() {

			@Override
			public Result<Boolean> execute() {
				return sessionServerFacade.loginOut(token);
			}
			
		});
		
	}

	public void setSessionServerFacade(SessionServerFacade sessionServerFacade) {
		this.sessionServerFacade = sessionServerFacade;
	}

	

}
