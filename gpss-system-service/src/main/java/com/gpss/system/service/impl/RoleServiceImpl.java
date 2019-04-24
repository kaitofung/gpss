package com.gpss.system.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.gpss.system.service.dao.IRoleDao;
import com.lyyzoo.gpss.api.service.AbstractService;
import com.lyyzoo.gpss.api.service.IRoleService;
import com.lyyzoo.gpss.api.vo.Role;

@Service
public class RoleServiceImpl extends AbstractService implements IRoleService{

	@Resource
	private IRoleDao roleDao;

	@Override
	public List<Role> getRoles(Map<String, Object> param) {
		return roleDao.doGetBeans(param);
	}

	@Override
	public Integer getRolesCount(Map<String, Object> param) {
		return (int) roleDao.doGetBeansCount(param);
	}

	@Override
	public List<Role> getRoles(Map<String, Object> param, Integer pageSize, Long currentPage) {
		return getRoles(offsetNPageSize(pageSize, currentPage));
	}

	@Override
	public boolean modifyRole(Role role) {
		return roleDao.doUpdateBean(role) > 0;
	}
	
	
	
}
