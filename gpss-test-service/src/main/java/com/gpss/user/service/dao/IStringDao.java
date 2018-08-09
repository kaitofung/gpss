package com.gpss.user.service.dao;


import java.util.List;
import java.util.Map;

import com.lyyzoo.gpss.api.vo.Role;
import com.lyyzoo.gpss.api.vo.Storage;
import com.lyyzoo.gpss.api.vo.Supplier;
import com.lyyzoo.gpss.api.vo.User;
import com.lyyzoo.gpss.api.vo.UsersDataItem;

/**
 * 
 * @author Administrator
 *
 */
public abstract interface IStringDao {
	
	public abstract List<String> doGetString();
	
}
