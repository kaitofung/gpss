package com.lyyzoo.gpss.api.service;

import java.util.List;
import java.util.Map;

import com.lyyzoo.gpss.api.vo.Role;

public interface IRoleService {
	List<Role> getRoles(Map<String,Object> param);
}
