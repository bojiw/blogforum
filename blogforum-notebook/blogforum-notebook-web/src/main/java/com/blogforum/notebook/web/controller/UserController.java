package com.blogforum.notebook.web.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.blogforum.common.tools.CookieUtils;
import com.blogforum.common.tools.blogforumResult;
import com.blogforum.notebook.service.session.SessionServer;

@Controller
@RequestMapping("/user")
public class UserController {

	@Resource
	private SessionServer sessionServer;

	/**sso地址*/
	@Value("${sso.url}")
	private String	ssoUrl;
	
	@RequestMapping(value = "/loginout" , method = RequestMethod.POST)
	@ResponseBody
	public blogforumResult userLoginOut(HttpServletRequest request){
		String token = CookieUtils.getCookie(request, "COOKIE_TOKEN");
		sessionServer.userLoginOut(token);
		
		return blogforumResult.ok(ssoUrl);
	}
	
}
