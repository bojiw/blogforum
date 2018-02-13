package com.blogforum.sso.dao.redis;

import java.util.List;

public interface RedisClient {
	public Boolean set(String key, String value);

	public Boolean setObject(String key, Object obj);

	public String get(String key);

	public Boolean expire(String key, long expire);

	public <T> Boolean setList(String key, List<T> list);

	public <T> List<T> getList(String key, Class<T> clz);

	public long lpush(String key, Object obj);

	public long rpush(String key, Object obj);

	public String lpop(String key);

	/**
	 * 增加key并且设置过期时间
	 * 
	 * @param key
	 * @param value
	 * @param expire
	 * @return
	 */
	public Boolean setExpire(String key, Object value, long expire);

	/**
	 * 通过key删除对应的值
	 * @param key
	 * @author: wwd
	 * @time: 2018年2月7日
	 */
	public void del(String key);
}
