package com.gpss.user.service.impl;


import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.gpss.common.utils.IMappingParameter;
import com.gpss.user.service.dao.IUserDao;
import com.lyyzoo.gpss.api.service.AbstractService;
import com.lyyzoo.gpss.api.service.IUserService;
import com.lyyzoo.gpss.api.vo.Employee;
import com.lyyzoo.gpss.api.vo.Role;
import com.lyyzoo.gpss.api.vo.User;
import com.lyyzoo.gpss.api.vo.UsersDataItem;

@Service
public class UserServiceImpl extends AbstractService implements IUserService,IMappingParameter {

	@Resource
	private IUserDao userDao;
	
	@Override
	public boolean addUser(User user) {
		return userDao.doCreateUser(user);
	}

	@Override
	public boolean lockUser(User user) {
		if(Objects.isNull(user))return false;
		return lockUser(user.getUid());
	}

	@Override
	public boolean unlockUser(User user) {
		return unlockUser(user.getUid());
	}

	@Override
	public User getUserByUid(String uid) {
		return userDao.doGetUser(paramToMap("uid", uid));
	}

	@Override
	public Collection<String> getRolesByUser(User user) {
		return (user == null || user.getUid() == null) ? 
				null : this.getRolesByUserId(user.getUid());
	}

	@Override
	public Collection<String> getRolesByUserId(String uid) {
		List<Role> roles = userDao.doGetRoles(uid);
		if(roles == null ) return new ArrayList<String>();
		List<String> roleCodes = new ArrayList<String>();
		for (int i = 0; i < roles.size(); i++) {
			roleCodes.add(roles.get(i).getRoleCode());
		}
		return roleCodes;
	}

	@Override
	public List<UsersDataItem> getUsersDataItem(int pageSize, Long currentPage) {
		return this.getUsersDataItem(pageSize, currentPage.intValue());
	}

	@Override
	public List<UsersDataItem> getUsersDataItem(int pageSize, int currentPage) {
		int offset = pageSize * (currentPage - 1) ;
		return userDao.doGetUsersDataItems(paramToMap("offset", offset,"pagesize", pageSize));
	}
	
	@Override
	public long getAllUserDataItemCount() {
		return userDao.doGetUsersDataItemCount(null);
	}

	@Override
	public boolean lockUser(String userId) {
		if(Objects.isNull(userId))return false;
		return userDao.doLock(paramToMap("uid", userId,"locked", 1)) > 0;
	}

	@Override
	public boolean unlockUser(String userId) {
		if(Objects.isNull(userId))return false;
		return userDao.doLock(paramToMap("uid", userId,"locked", 0)) > 0;
	}

	@Override
	public long modifyEmployData(Map<String, Object> params) {
		return userDao.doUpdateEmployee(params);
	}
	
	@Override
	public long modifyUserProfile(Map<String, Object> params) {
		return userDao.doUpdateProfile(params);
	}

	@Override
	public Employee getEmployee(String name) {
		return userDao.doGetEmployee(paramToMap("name", name));
	}

	@Override
	public List<Employee> getEmployees(int pageSize , Long currentPage, String name, String etypeid) {
		int offset = (int) (pageSize * (currentPage - 1)) ;
		return userDao.doGetEmployees(paramToMap("offset", offset,"pagesize", pageSize,"name", name, "etypeid", etypeid));
	}

	@Override
	public long getEmployeesCount(Map<String, Object> params) {
		return userDao.doGetEmployeesCount(params);
	}

	@Override
	public List<Map<String, Object>> getEmployeeTypes() {
		return userDao.doGetEmployeeTypes();
	}

	@Override
	public boolean addEmployee(Employee employee) {
		return userDao.doCreateEmployee(employee);
	}

	@Override
	public boolean removeEmployees(List<String> eids) {
		return userDao.doRemoveEmployees(eids) == eids.size();
	}

	@Override
	public List<UsersDataItem> getUsersDataItem(Map<String, Object> params) {
		return userDao.doGetUsersDataItems(params);
	}

	@Override
	public List<UsersDataItem> getUsersDataItem(Map<String, Object> params, int pageSize, Long currentPage) {
		return getUsersDataItem(queryData(params, pageSize, currentPage));
	}

	@Override
	public Integer getUsersDataItemCount(Map<String, Object> params) {
		return (int) userDao.doGetUsersDataItemCount(params);
	}

	@Override
	public boolean modifyUser(User user) {
		return userDao.doUpdateBean(user) > 0;
	}

	@Override
	public boolean addUserRole(UsersDataItem userDataItem) {
		return userDao.doAddRole(userDataItem) > 0;
	}

	@Override
	public boolean modifyUserRole(UsersDataItem userDataItem) {
		return userDao.doEditRole(userDataItem) > 0;
	}

}
