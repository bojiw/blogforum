package com.blogforum.manager.web.controller;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.blogforum.common.enums.BizErrorEnum;
import com.blogforum.common.exception.BusinessException;
import com.blogforum.common.tools.blogforumResult;
import com.blogforum.common.utils.MD5SaltUtils;
import com.blogforum.manager.pojo.entity.AdminUser;
import com.blogforum.manager.service.adminuser.AdminUserService;
import com.blogforum.manager.service.adminuser.impl.AdminUserServiceImpl;
import com.blogforum.manager.web.constant.ReturnViewPage;

@Controller
@RequestMapping("/")
public class IndexController {
	private static Logger		logger	= Logger.getLogger(AdminUserServiceImpl.class);

	
	@Autowired
	private AdminUserService	adminUserService;

	/**
	 * 首页请求
	 * @param session
	 * @param modelMap
	 * @return
	 * @author wwd
	 * @date 2017年3月19日上午12:07:27
	 * @version V1.0
	 */
	@RequestMapping("/index.action")
	public String index(HttpSession session, ModelMap modelMap) {
		
		AdminUser adminUser = (AdminUser) session.getAttribute("adminuser");
		modelMap.addAttribute("adminUserName", adminUser.getUsername());
		return ReturnViewPage.index;
	}

	
	
	@RequestMapping(value = "/login.action", method = { RequestMethod.POST })
	@ResponseBody
	public blogforumResult login(String username, String password, HttpSession session)
						throws BusinessException {

		AdminUser admin = (AdminUser) session.getAttribute("adminuser");

		if (admin != null) {
			logger.warn(BizErrorEnum.USER_LOGIN.getMsg());
			throw new BusinessException(BizErrorEnum.USER_LOGIN);
		}
		admin = checkLogin(username, password);
		AdminUser adminresult = adminUserService.getByUserPwd(admin);
		if (adminresult == null) {
			return blogforumResult.build(BizErrorEnum.FAIL_USERPWD, "false");
		}
		session.setAttribute("adminuser", adminresult);
		return blogforumResult.ok();
	}
	
	
	/**
	 * 退出请求
	 * @param session
	 * @return
	 * @author wwd
	 * @date 2017年3月19日上午12:07:40
	 * @version V1.0
	 */
	@RequestMapping("/loginout.action")
	public String Index(HttpSession session) {
		session.removeAttribute("adminuser");
		return ReturnViewPage.login;
	}
	
	
	
	
	/**
	 * 验证用户名是否存在 参数是否不为空
	 * 
	 * @param username
	 * @param password
	 * @return
	 * @throws BusinessException
	 * @author wwd
	 * @date 2017年3月12日上午11:38:28
	 * @version V1.0
	 */
	private AdminUser checkLogin(String username, String password) throws BusinessException {
		if (username == null || password == null) {
			throw new BusinessException(BizErrorEnum.NULL_USERPWD);
		}
		AdminUser admin = adminUserService.getByUserName(username);
		if (admin == null) {
			throw new BusinessException(BizErrorEnum.NO_USER);
		}
		String salt = admin.getSalt();
		String encodePWD = MD5SaltUtils.encode(password, salt);
		admin.setUsername(username);
		admin.setPassword(encodePWD);
		return admin;

	}

}
