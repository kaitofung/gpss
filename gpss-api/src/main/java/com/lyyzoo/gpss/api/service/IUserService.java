package com.lyyzoo.gpss.api.service;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import com.lyyzoo.gpss.api.vo.Employee;
import com.lyyzoo.gpss.api.vo.User;
import com.lyyzoo.gpss.api.vo.UsersDataItem;

public interface IUserService {
	boolean addUser(User user);
	
	boolean addUserRole(UsersDataItem userDataItem);
	
	boolean modifyUserRole(UsersDataItem userDataItem);
	
	boolean addEmployee(Employee employee);
	
	boolean lockUser(User user);
	
	boolean unlockUser(User user);
	
	boolean lockUser(String userId);
	
	boolean unlockUser(String userId);
	
	User getUserByUid(String uid);
	
	Collection<String> getRolesByUser(User user);
	
	Collection<String> getRolesByUserId(String uid);
	
	Integer getUsersDataItemCount(Map<String, Object> params);

	List<UsersDataItem> getUsersDataItem(int pageSize , Long currentPage);
	
	List<UsersDataItem> getUsersDataItem(Map<String, Object> params);
	
	List<UsersDataItem> getUsersDataItem(Map<String, Object> params, int pageSize , Long currentPage);
	
	List<UsersDataItem> getUsersDataItem(int pageSize , int currentPage);
	
	List<Employee> getEmployees(int pageSize , Long currentPage, String name, String etypeid);
	
	long getAllUserDataItemCount();
	
	List<Map<String, Object>> getEmployeeTypes();
	
	long getEmployeesCount(Map<String,Object> params);
	
	long modifyEmployData(Map<String,Object> params);
	
	long modifyUserProfile(Map<String,Object> params);
	
	Employee getEmployee(String name);
	
	boolean removeEmployees(List<String> eids);
	
	boolean modifyUser(User user);
	
}
