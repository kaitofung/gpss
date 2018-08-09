package com.gpss.supplier.service.dao;


import java.util.List;
import java.util.Map;

import com.lyyzoo.gpss.api.vo.Role;
import com.lyyzoo.gpss.api.vo.Supplier;
import com.lyyzoo.gpss.api.vo.User;
import com.lyyzoo.gpss.api.vo.UsersDataItem;

/**
 * 
 * @author Administrator
 *
 */
public abstract interface ISupplierDao {
	public abstract List<Supplier> doGetSuppliers(Map<String,Object> queryData);
	
	public abstract int doGetSuppliersCount();
}
