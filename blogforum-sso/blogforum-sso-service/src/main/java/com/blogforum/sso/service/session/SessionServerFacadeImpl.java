package com.blogforum.sso.service.session;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import com.alibaba.fastjson.JSON;
import com.blogforum.common.model.Result;
import com.blogforum.common.tools.BaseConverter;
import com.blogforum.sso.dao.redis.RedisClient;
import com.blogforum.sso.facade.model.UserVO;
import com.blogforum.sso.facade.session.SessionServerFacade;
import com.blogforum.sso.pojo.entity.User;

public class SessionServerFacadeImpl implements SessionServerFacade {

	/** redis客户端 */
	@Autowired
	protected RedisClient redisClient;

	/** session开头key */
	@Value("${myValue.session_key}")
	protected String			SESSION_KEY;
	
	/** session过期时间 */
	@Value("${myValue.session_time}")
	protected int			SESSION_TIME;
	
	
	@Override
	public Result<Boolean> isLogin(String token) {
		//获取redis中保存的session信息
		StringBuffer session = new StringBuffer(SESSION_KEY).append(":").append(token);
		String userString = redisClient.get(session.toString());
		if (StringUtils.isEmpty(userString)) {
			return new Result<Boolean>(true, false);
		}
		return new Result<Boolean>(true, true);
	}
	
	@Override
	public Result<UserVO> getUserByToken(String token) {
		UserVO userVO = getUserVOByToken(token);
		return new Result<UserVO>(true, userVO);
	}


	/**
	 * 通过token获取redis存的user信息
	 * @param token
	 * @return
	 * @author: wwd
	 * @time: 2017年11月6日
	 */
	private UserVO getUserVOByToken(String token){
		//获取redis中保存的session信息
		StringBuffer session = new StringBuffer(SESSION_KEY).append(":").append(token);
		String userString = redisClient.get(session.toString());
		if (StringUtils.isEmpty(userString)) {
			return null;
		}
		User user = JSON.parseObject(userString,User.class);
		BaseConverter<User, UserVO> userConverter = new BaseConverter<>();
		UserVO userVO = userConverter.convert(user, UserVO.class);
		redisClient.expire(session.toString(), SESSION_TIME);
		return userVO;
	}

	@Override
	public Result<Boolean> loginOut(String token) {
		//拼接session的key
		StringBuffer session = new StringBuffer(SESSION_KEY).append(":").append(token);
		//删除session
		redisClient.del(session.toString());
		return new Result<Boolean>(true, true);
	}

}
