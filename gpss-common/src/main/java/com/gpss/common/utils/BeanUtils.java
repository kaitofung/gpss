package com.gpss.common.utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.cglib.beans.BeanMap;

/**
 * 验证码图片生成工具
 *  使用JAVA生成的图片验证码，调用getRandcode方法获取图片验证码，以流的方式传输到前端页面。
 *  
 * 
 */
public class BeanUtils {
	/**
	 * 将一个普通Java对象转化成Map对象
	 * @param bean 要转化的普通Java对象
	 * @param <T> bean的类型
	 * @return 返回转化后的Map对象
	 */
	public static <T> Map<String, Object> beanToMap(T bean) {  
	    Map<String, Object> map =  new HashMap<String, Object>();  
	    if (bean != null) {  
	        BeanMap beanMap = BeanMap.create(bean);  
	        for (Object key : beanMap.keySet()) {  
	            map.put(key+"", beanMap.get(key));  
	        }             
	    }  
	    return map;  
	}
	
	/** 
	 * 将List&lt;T&gt;转换为List&lt;Map&lt;String, Object&gt;&gt; 
	 * @param objList 待转换的bean集合List
	 * @param <T> bean的类型
	 * @return 转换后的map集合List
	 */  
	public static <T> List<Map<String, Object>> objectsToMaps(List<T> objList) {  
	    List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();  
	    if (objList != null && objList.size() > 0) {  
	        Map<String, Object> map = null;  
	        T bean = null;  
	        for (int i = 0,size = objList.size(); i < size; i++) {  
	            bean = objList.get(i);  
	            map = beanToMap(bean);  
	            list.add(map);  
	        }  
	    }  
	    return list;  
	}  
	  
	/** 
	 * 将List&lt;Map&lt;String,Object&gt;&gt;转换为List&lt;T&gt; 
	 * @param maps 参数的集合
	 * @param clazz 转换的bean的类
	 * @param <T> 转换的bean的类型
	 * @return 转换后的bean集合
	 * @throws InstantiationException 可能抛出的异常 
	 * @throws IllegalAccessException 可能抛出的异常 
	 */  
	public static <T> List<T> mapsToObjects(List<Map<String, Object>> maps,Class<T> clazz) throws InstantiationException, IllegalAccessException {  
	    List<T> list = new ArrayList<T>();  
	    if (maps != null && maps.size() > 0) {  
	        Map<String, Object> map = null;  
	        T bean = null;  
	        for (int i = 0,size = maps.size(); i < size; i++) {  
	            map = maps.get(i);  
	            bean = clazz.newInstance();  
	            mapToBean(map, bean);  
	            list.add(bean);  
	        }  
	    }  
	    return list;  
	}
	
	/** 
	 * 将map装换为javabean对象 
	 * @param map 待转换的map集合
	 * @param bean 转换成的bean
	 * @param <T> 转换成的bean类型
	 * @return  返回转换后的bean
	 */  
	public static <T>T mapToBean(Map<String, Object> map,T bean) {  
	    BeanMap beanMap = BeanMap.create(bean);  
	    beanMap.putAll(map);  
	    return bean;  
	}
	
/**
 * 	将map装换为javabean对象 
 * @param map  待转换的map
 * @param clazz 要转换的bean的类
 * @param <T> 要转换的bean的类型
 * @return  返回转换后的bean
 */
	public static <T> T mapToBean(Map<String, Object> map,Class<T> clazz) {  
		T bean = null;
		try {
			bean = clazz.newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
			return null;
		} catch (IllegalAccessException e) {
			e.printStackTrace();
			return null;
		}
		BeanMap beanMap = BeanMap.create(bean);  
		beanMap.putAll(map);  
		return bean;  
	}

}
