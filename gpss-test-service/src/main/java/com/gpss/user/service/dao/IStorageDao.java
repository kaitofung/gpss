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
public abstract interface IStorageDao {
	
	public abstract List<Storage> doGetStorages(Map<String,Object> queryData);

	public abstract int doGetStoragesCount();
	
	public abstract long doDeleteStorages(List<String> sids);
	
	public abstract int doGetStoragesCount(Map<String,Object> param);
	
	public abstract int doCreateStorage(Storage storage);
	
	public abstract int doUpdateStorage(Storage storage);
	
}
