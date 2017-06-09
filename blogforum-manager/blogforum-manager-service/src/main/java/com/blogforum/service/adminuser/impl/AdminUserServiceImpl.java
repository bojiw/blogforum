package com.blogforum.service.adminuser.impl;

import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blogforum.common.enums.BizError;
import com.blogforum.common.exception.BusinessException;
import com.blogforum.common.tools.blogforumResult;
import com.blogforum.common.utils.MD5SaltUtils;
import com.blogforum.dao.mapper.AdminUserMapper;
import com.blogforum.manager.pojo.entity.AdminUser;
import com.blogforum.service.adminuser.AdminUserService;

@Service
public class AdminUserServiceImpl implements AdminUserService {

	private static Logger	logger	= Logger.getLogger(AdminUserServiceImpl.class);
	@Autowired
	private AdminUserMapper	adminUserMapper;

	@Override
	public blogforumResult insert(AdminUser adminUser) {
		// 给用户的密码进行加密
		String salt = MD5SaltUtils.randomCreateSalt();
		String encodePWD = MD5SaltUtils.encode(adminUser.getPassword(), salt);
		if (null == encodePWD) {
			return blogforumResult.build(BizError.SYS_EXCEPTION, "false");
		}
		adminUser.setPassword(encodePWD);
		adminUser.setSalt(salt);
		adminUser.setCreateDate(new Date());
		try {
			adminUserMapper.insert(adminUser);
		} catch (Exception e) {
			logger.error("插入数据库失败:" + adminUser.toString(), e);
			return blogforumResult.build(BizError.DATABASE_INSERT, "false");
		}

		return blogforumResult.ok();
	}

	@Override
	public AdminUser getByUserPwd(AdminUser adminUser) {
		AdminUser newAdminUser = null;
		try {
			newAdminUser = adminUserMapper.getByUserPwd(adminUser);
		} catch (Exception e) {
			logger.error(BizError.DATABASE_EXCEPTION.getMsg(), e);
			return newAdminUser;
		}

		return newAdminUser;
	}

	@Override
	public AdminUser getByID(String adminUser_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AdminUser getByUserName(String username) {
		AdminUser newAdminUser = null;
		try {
			newAdminUser = adminUserMapper.getByUserName(username);
		} catch (Exception e) {
			logger.error(BizError.DATABASE_EXCEPTION.getMsg(), e);
			throw new BusinessException(BizError.DATABASE_EXCEPTION);
		}

		return newAdminUser;
	}

}
