package com.blogforum.sso.dao.redis;

import java.util.List;

public interface RedisClient {
    public boolean set(String key, String value);  
    
    public boolean setObject(String key, Object obj);
    
    public String get(String key);  
      
    public boolean expire(String key,long expire);  
      
    public <T> boolean setList(String key ,List<T> list);  
      
    public <T> List<T> getList(String key,Class<T> clz);  
      
    public long lpush(String key,Object obj);  
      
    public long rpush(String key,Object obj);  
      
    public String lpop(String key);  
    /**
     * 增加key并且设置过期时间
     * @param key
     * @param value
     * @param expire
     * @return
     */
    public boolean setExpire(String key, Object value,long expire);
}
