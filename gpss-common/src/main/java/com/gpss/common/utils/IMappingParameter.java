package com.gpss.common.utils;

import java.util.HashMap;
import java.util.Map;

public interface IMappingParameter {
    
	/**
	 * 把参数装配成Map的形式
	 * 
	 * @param params 需要装配的参数
	 * @return 参数装配成的Map
	 */
	public default Map<String,Object> paramToMap(Object... params) {
		if(params == null || params.length % 2 != 0)
			throw new RuntimeException("params 's count has something wrong!! ");
		Map<String,Object> map = new HashMap<String,Object>();
		int count = 0;
		while(true) {
			if(count % 2 == 0 && !(params[count] instanceof String)) {
				throw new RuntimeException("params 's type has something wrong!! ");
			}
			map.put((String) params[count], params[count+1]);
			count = count + 2;
			if(count >= params.length ) {
				break;
			}
		}
		return map;
	}
}
