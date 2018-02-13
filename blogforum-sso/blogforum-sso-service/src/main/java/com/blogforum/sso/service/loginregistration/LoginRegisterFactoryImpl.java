package com.blogforum.sso.service.loginregistration;

import java.util.Map;

import com.blogforum.common.enums.BizErrorEnum;
import com.blogforum.sso.common.exception.SSOBusinessException;

public class LoginRegisterFactoryImpl implements LoginRegisterFactory {
	
	private Map<String, LoginRegister> manager;
	
	public LoginRegister getManager(String cmCode){
		LoginRegister loginRegistration = manager.get(cmCode);
		if (loginRegistration == null) {
			throw new SSOBusinessException(BizErrorEnum.ILLEGAL_PARAMETER);
		}
		return loginRegistration;
	}

	public void setManager(Map<String, LoginRegister> manager) {
		this.manager = manager;
	}
	
	

}
