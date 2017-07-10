package com.blogforum.sso.service.loginregistration;

import java.util.Map;

import com.blogforum.common.enums.BizError;
import com.blogforum.sso.common.exception.SSOBusinessException;

public class AbstractLoginRegistrationFactoryImpl implements AbstractLoginRegistrationFactory {
	
	private Map<String, LoginRegistration> manager;
	
	public LoginRegistration manager(String cmCode){
		LoginRegistration loginRegistration = manager.get(cmCode);
		if (loginRegistration == null) {
			throw new SSOBusinessException(BizError.ILLEGAL_PARAMETER);
		}
		return loginRegistration;
	}

	public void setManager(Map<String, LoginRegistration> manager) {
		this.manager = manager;
	}
	
	

}
