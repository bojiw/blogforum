package com.blogforum.sso.dao.redis;

import java.util.List;

public interface RedisClick {
    public boolean set(String key, String value);  
    
    public boolean setObject(String key, Object obj) throws Exception;
    
    public String get(String key);  
      
    public boolean expire(String key,long expire);  
      
    public <T> boolean setList(String key ,List<T> list) throws Exception ;  
      
    public <T> List<T> getList(String key,Class<T> clz) throws Exception ;  
      
    public long lpush(String key,Object obj)  throws Exception ;  
      
    public long rpush(String key,Object obj)  throws Exception ;  
      
    public String lpop(String key);  
}
