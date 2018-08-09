package com.gpss.user.service.dao;


import java.util.List;
import java.util.Map;

import com.gpss.user.service.mybaits.UserSqlSessionDaoSupport;
import com.lyyzoo.gpss.api.vo.Employee;
import com.lyyzoo.gpss.api.vo.Role;
import com.lyyzoo.gpss.api.vo.User;
import com.lyyzoo.gpss.api.vo.UsersDataItem;

/**
 * 
 * @author Administrator
 *
 */
public interface IUserDao {
	public abstract boolean doCreateUser(User user);
	
	public abstract User doGetUser(Map<String,Object> map);
	
	public abstract List<Role> doGetRoles(String uid);
	
	public abstract List<UsersDataItem> doGetUsersDataItems(Map<String,Object> queryData);
	
	public abstract long doGetUsersDataItemCount();
	
	public abstract long doLock(Map<String,Object> param);
	
	public abstract long doUpdateEmployee(Map<String,Object> param);
	
	public abstract long doUpdateProfile(Map<String,Object> param);
	
	public abstract Employee doGetEmployee(Map<String,Object> param);
	
	
}
