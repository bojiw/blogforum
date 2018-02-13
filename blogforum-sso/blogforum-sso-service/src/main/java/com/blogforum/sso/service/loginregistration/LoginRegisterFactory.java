package com.blogforum.sso.service.loginregistration;

public interface LoginRegisterFactory {
	
	/**
	 * 获取工厂中cmCode对应的bean
	 * @param cmscode
	 * @return
	 */
	public  LoginRegister getManager(String cmCode);

}
