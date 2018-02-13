package com.blogforum.manager.web.controller;

import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.blogforum.common.enums.BizErrorEnum;
import com.blogforum.common.exception.BusinessException;
import com.blogforum.common.tools.blogforumResult;
import com.blogforum.manager.pojo.entity.AdminUser;
import com.blogforum.manager.pojo.entity.Role;
import com.blogforum.manager.service.adminuser.AdminUserService;
import com.blogforum.manager.service.adminuser.impl.AdminUserServiceImpl;

/**
 * 对管理员的操作Controller
 * 
 * @author wwd
 *
 */
@Controller
@RequestMapping("/adminuser")
public class AdminUserController {
	private static Logger		logger	= Logger.getLogger(AdminUserServiceImpl.class);

	@Autowired
	private AdminUserService	adminUserService;

	@RequestMapping(value = "/insert.actioin", method = { RequestMethod.POST })
	@ResponseBody
	public blogforumResult insert(String username, String password, Integer roleId, HttpSession session)
						throws BusinessException {

		AdminUser admin = (AdminUser) session.getAttribute("adminuser");
		if (admin == null) {
			logger.error(BizErrorEnum.NO_LOGIN.getMsg());
			throw new BusinessException(BizErrorEnum.NO_LOGIN);
		}

		AdminUser adminUser = checkInsert(username, password, roleId);
		if (adminUser == null) {
			logger.error("添加管理员用户所传参数非法,adminID:" + admin.getId());
			throw new BusinessException(BizErrorEnum.NULL_PARAMETER);
		}
		blogforumResult result = adminUserService.insert(adminUser);
		return result;
	}


	/**
	 * 验证添加的管理员参数是否正确
	 * 
	 * @param username
	 * @param password
	 * @param roleId
	 * @return
	 * @author wwd
	 * @date 2017年3月4日下午11:35:23
	 * @version V1.0
	 */
	private AdminUser checkInsert(String username, String password, Integer roleId) {
		if (StringUtils.isBlank(username) && StringUtils.isBlank(password) && roleId == null) {
			return null;
		}

		if (roleId <= 0 && roleId >= 30) {
			return null;
		}

		AdminUser adminUser = new AdminUser();
		adminUser.setUsername(username);
		adminUser.setPassword(password);
		Role role = new Role();
		role.setId(roleId);
		adminUser.setRole(role);
		return adminUser;
	}



}
