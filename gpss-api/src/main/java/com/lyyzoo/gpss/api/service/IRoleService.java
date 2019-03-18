package com.lyyzoo.gpss.api.service;

import java.util.List;
import java.util.Map;

import com.lyyzoo.gpss.api.vo.Role;

public interface IRoleService {
	List<Role> getRoles(Map<String,Object> param);
	
	List<Role> getRoles(Map<String,Object> param, Integer pageSize, Long currentPage);
	
	Integer getRolesCount(Map<String, Object> param);
	
	boolean modifyRole(Role role);
}
