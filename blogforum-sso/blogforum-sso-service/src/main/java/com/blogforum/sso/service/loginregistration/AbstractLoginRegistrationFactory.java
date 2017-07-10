package com.blogforum.sso.service.loginregistration;

public interface AbstractLoginRegistrationFactory {
	
	/**
	 * 获取工厂中cmCode对应的bean
	 * @param cmscode
	 * @return
	 */
	public  LoginRegistration manager(String cmCode);

}
