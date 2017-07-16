package com.blogforum.sso.service.loginregistration;

import java.util.Map;

import com.blogforum.common.enums.BizError;
import com.blogforum.sso.common.exception.SSOBusinessException;

public class LoginRegisterFactoryImpl implements LoginRegisterFactory {
	
	private Map<String, LoginRegister> manager;
	
	public LoginRegister manager(String cmCode){
		LoginRegister loginRegistration = manager.get(cmCode);
		if (loginRegistration == null) {
			throw new SSOBusinessException(BizError.ILLEGAL_PARAMETER);
		}
		return loginRegistration;
	}

	public void setManager(Map<String, LoginRegister> manager) {
		this.manager = manager;
	}
	
	

}
