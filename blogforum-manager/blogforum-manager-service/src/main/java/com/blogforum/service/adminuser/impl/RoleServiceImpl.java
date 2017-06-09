package com.blogforum.service.adminuser.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.blogforum.common.enums.BizError;
import com.blogforum.dao.mapper.RoleMapper;
import com.blogforum.manager.pojo.entity.Role;
import com.blogforum.service.adminuser.RoleService;

@Service
public class RoleServiceImpl implements RoleService {
	
	private static Logger	logger	= Logger.getLogger(RoleServiceImpl.class);
	
	@Autowired
	private RoleMapper roleMapper;

	@Override
	public int insert(RoleService role) {
		// TODO Auto-generated method stub
		return 0;
	}

	//设置ehcache缓存 根据roleid
	@Override
	@Cacheable(value="baseCache",key="'Role'+#role_id")
	public Role getByID(int role_id) {
		Role role = null;
		try {
			role = roleMapper.getByID(role_id);
		} catch (Exception e) {
			logger.error(BizError.DATABASE_EXCEPTION.getMsg(),e);
			return role;
		}
		return role;
	}

	//删除ehcache缓存 根据roleid
	@Override
	@CacheEvict(value="baseCache",key="'Role'+#role.getId()")
	public int updateRole(Role role) {
		return 0;
	}

}
