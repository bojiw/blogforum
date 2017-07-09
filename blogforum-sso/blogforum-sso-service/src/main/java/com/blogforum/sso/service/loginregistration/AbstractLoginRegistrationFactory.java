package com.blogforum.sso.service.loginregistration;

import java.util.HashMap;
import java.util.Map;

import com.blogforum.common.enums.BizError;
import com.blogforum.sso.common.exception.SSOBusinessException;

public class AbstractLoginRegistrationFactory {
	
	private static Map<String, LoginRegistration> manager = new HashMap<String, LoginRegistration>();
	static {
		manager.put("mailRegistration", new SendMailRegistration());
	}
	
	public LoginRegistration manager(String cmscode){
		LoginRegistration loginRegistration = manager.get(cmscode);
		if (loginRegistration == null) {
			throw new SSOBusinessException(BizError.ILLEGAL_PARAMETER);
		}
		return loginRegistration;
	}

}
