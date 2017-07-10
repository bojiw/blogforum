package com.blogforum.sso.dao.redis;

import java.text.MessageFormat;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.RedisSystemException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.blogforum.common.enums.BizError;
import com.blogforum.sso.common.exception.SSOBusinessException;

@Component
@Transactional
public class RedisClientImpl implements RedisClick {
    @Autowired  
    private RedisTemplate<String, ?> redisTemplate;  
    
    @Autowired 
    private RedisTemplate<String,?> stringRedisTemplate;
      
    @Override  
    public boolean set(final String key, final String value) {  
    	boolean result = false;
    	try {
            result = stringRedisTemplate.execute(new RedisCallback<Boolean>() {  
                @Override  
                public Boolean doInRedis(RedisConnection connection) throws DataAccessException {  
                    RedisSerializer<String> serializer = stringRedisTemplate.getStringSerializer();  
                    connection.set(serializer.serialize(key), serializer.serialize(value));  
                    return true;  
                }  
            });  
		} catch (Exception e) {
			throw new RedisSystemException(MessageFormat.format("redis插入数据失败,key:{0},value:{1}", key,value),e);
		}

        if (!result) {
			throw new RedisSystemException(MessageFormat.format("redis插入数据失败,key:{0},value:{1}", key,value),new SSOBusinessException(BizError.SYS_EXCEPTION));
		}
        return result;  
    }  
  
    public String get(final String key){  
        String result = redisTemplate.execute(new RedisCallback<String>() {  
            @Override  
            public String doInRedis(RedisConnection connection) throws DataAccessException {  
                RedisSerializer<String> serializer = redisTemplate.getStringSerializer();  
                byte[] value =  connection.get(serializer.serialize(key));  
                return serializer.deserialize(value);  
            }  
        });  
        return result;  
    }  
  
    @Override  
    public boolean expire(final String key, long expire) {  
    	boolean result = false;
    	try {
    		result = redisTemplate.expire(key, expire, TimeUnit.SECONDS);  
		} catch (Exception e) {
			throw new RedisSystemException(MessageFormat.format("redis插入数据失败,key:{0},value:{1}", key,expire),e);
		}
    	
    	
        return result;  
    }  
  
    @Override  
    public <T> boolean setList(String key, List<T> list){  
        String value = JSON.toJSONString(list);  
        return set(key,value);  
    }  
  
    @Override  
    public <T> List<T> getList(String key,Class<T> clz){  
        String json = get(key);  
        if(json!=null){  
            List<T> list = JSON.parseArray(key,clz);
            return list;  
        }  
        return null;  
    }  
  
    @Override  
    public long lpush(final String key, Object obj){  
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
    public long rpush(final String key, Object obj){  
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
                byte[] res =  connection.lPop(serializer.serialize(key));  
                return serializer.deserialize(res);  
            }  
        });  
        return result;  
    }

	@Override
	public boolean setObject(String key, Object obj){
		String json = JSON.toJSONString(obj);
		return set(key, json);
	}  
  
}
