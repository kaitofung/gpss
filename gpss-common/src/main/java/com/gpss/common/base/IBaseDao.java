package com.gpss.common.base;

import java.util.List;
import java.util.Map;


public interface IBaseDao<T> {
	
	public abstract List<T> doGetBeans(Map<String,Object> parameters);
	
	public abstract long doGetBeansCount();

	public abstract long doGetBeansCount(Map<String,Object> parameters);
	
	public abstract long doDeleteBeans(List<String> ids);
	
	public abstract long doCreateBean(T bean);
	
	public abstract long doUpdateBean(T bean);
}
