package com.lyyzoo.gpss.api.service;

import java.util.Map;
import java.util.Objects;

import com.gpss.common.utils.IMappingParameter;

public class AbstractService implements IMappingParameter{
	
	protected int currentPageToOffset(int pageSize, Long currentPage) {
		int offset = (int) (pageSize * (currentPage - 1)) ;
		return offset;
	}
	
	protected Map<String,Object> offsetNPageSize(int pageSize, Long currentPage) {
		return paramToMap("offset", currentPageToOffset(pageSize, currentPage),"pagesize", pageSize);
	}
	
	protected Map<String,Object> fuzzyQuery(String param, String paramName, int pageSize, Long currentPage) {
		Map<String,Object> map = offsetNPageSize(pageSize, currentPage);
		if(Objects.nonNull(param) && !"".equals(param))
		map.put(paramName, "%" + param + "%");
		return map;
	}
	
	protected Map<String,Object> fuzzyQuery(String param, String paramName) {
		return fuzzyQuery(param, paramName, Integer.MAX_VALUE, 1L);
	}

}
