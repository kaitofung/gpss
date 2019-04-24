package com.gpss.user.service.dao;


import java.util.List;
import java.util.Map;

import com.gpss.common.base.IBaseDao;
import com.lyyzoo.gpss.api.vo.Employee;
import com.lyyzoo.gpss.api.vo.Role;
import com.lyyzoo.gpss.api.vo.User;
import com.lyyzoo.gpss.api.vo.UsersDataItem;

/**
 * 
 * @author Administrator
 *
 */
public interface IUserDao extends IBaseDao<User>{
	public abstract boolean doCreateUser(User user);
	
	public abstract boolean doCreateEmployee(Employee employee);
	
	public abstract User doGetUser(Map<String,Object> map);

	public abstract List<Role> doGetRoles(String uid);
	
	public abstract List<Employee> doGetEmployees(Map<String,Object> param);
	
	public abstract List<UsersDataItem> doGetUsersDataItems(Map<String,Object> queryData);
	
	public abstract List<Map<String,Object>> doGetEmployeeTypes();
	
	public abstract long doGetUsersDataItemCount(Map<String, Object> params);
	
	public abstract long doGetEmployeesCount(Map<String,Object> param);
	
	public abstract long doLock(Map<String,Object> param);
	
	public abstract long doUpdateEmployee(Map<String,Object> param);
	
	public abstract long doUpdateProfile(Map<String,Object> param);
	
	public abstract Employee doGetEmployee(Map<String,Object> param);
	
	public abstract Long doRemoveEmployees(List<String> eids);
	
	public abstract Long doAddRole(UsersDataItem usersDataItem);
	
	public abstract Long doEditRole(UsersDataItem usersDataItem);
	
	
}
