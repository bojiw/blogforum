package com.blogforum.service.user.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blogforum.common.enums.BizError;
import com.blogforum.dao.mapper.UserMapper;
import com.blogforum.service.adminuser.impl.AdminUserServiceImpl;
import com.blogforum.service.user.UserService;

@Service
public class UserServiceImpl implements UserService {
	private static Logger	logger	= Logger.getLogger(AdminUserServiceImpl.class);

	/* 查询user表 */
	@Autowired
	public UserMapper		userMapper;

	@Override
	public int getCount() {
		int count = 0;
		try {
			count = userMapper.getCount();
		} catch (Exception e) {
			logger.error(BizError.DATABASE_EXCEPTION.getMsg(), e);
		}

		return count;
	}

}
