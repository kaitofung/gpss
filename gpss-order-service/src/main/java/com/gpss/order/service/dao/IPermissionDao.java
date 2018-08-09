package com.gpss.order.service.dao;

import java.util.List;

import com.lyyzoo.gpss.api.vo.Permission;

public interface IPermissionDao {
	List<Permission> doGetPermissions();
}
