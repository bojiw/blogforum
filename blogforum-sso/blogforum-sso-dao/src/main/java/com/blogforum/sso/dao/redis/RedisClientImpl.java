package com.blogforum.sso.dao.redis;

import java.text.MessageFormat;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.annotation.Resource;

import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.RedisSystemException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;

/**
 * 普通redis客户端
 * 
 * @author Administrator
 *
 */
@Service("redisClient")
public class RedisClientImpl implements RedisClient {
	
	@Resource
	private RedisTemplate<String, ?> redisTemplate;

	@Override
	public Boolean set(final String key, final String value) {
		Boolean result = redisTemplate.execute(new RedisCallback<Boolean>() {
			@Override
			public Boolean doInRedis(RedisConnection connection) throws DataAccessException {
				RedisSerializer<String> serializer = redisTemplate.getStringSerializer();
				connection.set(serializer.serialize(key), serializer.serialize(value));
				return true;
			}
		});
		return result;
	}

	public String get(final String key) {
		String result = redisTemplate.execute(new RedisCallback<String>() {
			@Override
			public String doInRedis(RedisConnection connection) throws DataAccessException {
				RedisSerializer<String> serializer = redisTemplate.getStringSerializer();
				byte[] value = connection.get(serializer.serialize(key));
				return serializer.deserialize(value);
			}
		});
		return result;
	}

	@Override
	public Boolean expire(final String key, long expire) {
		Boolean result = false;
		try {
			result = redisTemplate.expire(key, expire, TimeUnit.SECONDS);
		} catch (Exception e) {
			throw new RedisSystemException(MessageFormat.format("redis插入数据失败,key:{0},value:{1}", key, expire), e);
		}

		return result;
	}

	@Override
	public <T> Boolean setList(String key, List<T> list) {
		String value = JSON.toJSONString(list);
		return set(key, value);
	}

	@Override
	public <T> List<T> getList(String key, Class<T> clz) {
		String json = get(key);
		if (json != null) {
			List<T> list = JSON.parseArray(key, clz);
			return list;
		}
		return null;
	}

	@Override
	public long lpush(final String key, Object obj) {
		final String value = JSON.toJSONString(obj);
		long result = redisTemplate.execute(new RedisCallback<Long>() {
			@Override
			public Long doInRedis(RedisConnection connection) throws DataAccessException {
				RedisSerializer<String> serializer = redisTemplate.getStringSerializer();
				long count = connection.lPush(serializer.serialize(key), serializer.serialize(value));
				return count;
			}
		});
		return result;
	}

	@Override
	public long rpush(final String key, Object obj) {
		final String value = JSON.toJSONString(obj);
		long result = redisTemplate.execute(new RedisCallback<Long>() {
			@Override
			public Long doInRedis(RedisConnection connection) throws DataAccessException {
				RedisSerializer<String> serializer = redisTemplate.getStringSerializer();
				long count = connection.rPush(serializer.serialize(key), serializer.serialize(value));
				return count;
			}
		});
		return result;
	}

	@Override
	public String lpop(final String key) {
		String result = redisTemplate.execute(new RedisCallback<String>() {
			@Override
			public String doInRedis(RedisConnection connection) throws DataAccessException {
				RedisSerializer<String> serializer = redisTemplate.getStringSerializer();
				byte[] res = connection.lPop(serializer.serialize(key));
				return serializer.deserialize(res);
			}
		});
		return result;
	}

	@Override
	public Boolean setObject(String key, Object obj) {
		String json = JSON.toJSONString(obj);
		return set(key, json);
	}

	@Override
	public Boolean setExpire(final String key, Object obj, final long expire) {
		final String value = JSON.toJSONString(obj);
		Boolean Result = redisTemplate.execute(new RedisCallback<Boolean>() {

			@Override
			public Boolean doInRedis(RedisConnection connection) throws DataAccessException {
				connection.setEx(key.getBytes(), expire, value.getBytes());
				return true;
			}
		});
		return Result;
	}

	@Override
	public void del(final String key) {
		redisTemplate.execute(new RedisCallback<Long>() {

			@Override
			public Long doInRedis(RedisConnection connection) throws DataAccessException {
				Long del = connection.del(redisTemplate.getStringSerializer().serialize(key));
				return del;
			}
			
		});
	}

}
