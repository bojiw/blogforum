package com.blogforum.sso.dao.mapper;



import com.blogforum.sso.pojo.entity.User;

public interface UserMapper extends CrudMapper<User> {
	
	public User getUserByPwdName(User user);
	public User getUserByEmailORIphone(User uesr);
	public User getUserByName(User user);
}
