package com.blogforum.sso.dao.mapper;

import com.blogforum.sso.pojo.entity.User;

public interface UserMapper extends CrudMapper<User> {
	
	public User getByUserPwdName(User uesr);

}
