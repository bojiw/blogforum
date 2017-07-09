package com.blogforum.common.tools;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * json互相转换工具类
 * 
 * @author wwd
 *
 */
public class JsonUtils {

	// 定义jackson对象
	private static final ObjectMapper objectMapper = new ObjectMapper();

    /** 
     * javaBean,list,array convert to json string 
     */  
    public static String objTojson(Object obj) throws Exception {  
        return objectMapper.writeValueAsString(obj);  
    }  
  
    /** 
     * json string convert to javaBean 
     */  
    public static <T> T jsonTopojo(String jsonStr, Class<T> clazz)  
            throws Exception {  
        return objectMapper.readValue(jsonStr, clazz);  
    }  
  
    /** 
     * json string convert to map 
     */  
    public static <T> Map<String, Object> jsonTomap(String jsonStr)  
            throws Exception {  
        return objectMapper.readValue(jsonStr, Map.class);  
    }  
  
    /** 
     * json string convert to map with javaBean 
     */  
    public static <T> Map<String, T> jsonTomap(String jsonStr, Class<T> clazz)  
            throws Exception {  
        Map<String, Map<String, Object>> map = objectMapper.readValue(jsonStr,  
                new TypeReference<Map<String, T>>() {  
                });  
        Map<String, T> result = new HashMap<String, T>();  
        for (Entry<String, Map<String, Object>> entry : map.entrySet()) {  
            result.put(entry.getKey(), map2pojo(entry.getValue(), clazz));  
        }  
        return result;  
    }  
  
    /** 
     * json array string convert to list with javaBean 
     */  
    public static <T> List<T> jsonTolist(String jsonArrayStr, Class<T> clazz)  
            throws Exception {  
        List<Map<String, Object>> list = objectMapper.readValue(jsonArrayStr,  
                new TypeReference<List<T>>() {  
                });  
        List<T> result = new ArrayList<T>();  
        for (Map<String, Object> map : list) {  
            result.add(map2pojo(map, clazz));  
        }  
        return result;  
    }  
    
    public static String listTojson(List list) throws JsonProcessingException{
    		return objectMapper.writeValueAsString(list);
    		
    }
    
  
    /** 
     * map convert to javaBean 
     */  
    public static <T> T map2pojo(Map map, Class<T> clazz) {  
        return objectMapper.convertValue(map, clazz);  
    }  

}
