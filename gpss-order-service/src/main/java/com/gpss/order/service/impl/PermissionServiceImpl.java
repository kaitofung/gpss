package com.gpss.order.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.gpss.order.service.dao.IPermissionDao;
import com.lyyzoo.gpss.api.service.IPermissionService;
import com.lyyzoo.gpss.api.vo.Permission;

@Service
public class PermissionServiceImpl implements IPermissionService{

	@Resource
	IPermissionDao permissionDao;
	
	@Override
	public List<Permission> getPermissions() {
		return permissionDao.doGetPermissions();
	}

}
