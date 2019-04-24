package com.gpss.storage.service.dao;



import java.util.List;
import java.util.Map;

import com.gpss.common.base.IBaseDao;
import com.lyyzoo.gpss.api.vo.StorageRecord;

/**
 * 
 * @author Administrator
 *
 */
public abstract interface IStorageRecordDao extends IBaseDao<StorageRecord> {

	
//	public abstract List<Storage> doGetStorages(Map<String,Object> queryData);
//
//	public abstract int doGetStoragesCount();
//	
//	public abstract long doDeleteStorages(List<String> sids);
//	
//	public abstract int doGetStoragesCount(Map<String,Object> param);
//	
//	public abstract int doCreateStorage(Storage storage);
//	
//	public abstract int doUpdateStorage(Storage storage);
	
	
	public abstract List<StorageRecord> doGetSimpleBean(Map<String, Object> params);
	
	public abstract Long doUpdateStorageCount(Map<String, Object> params);
	
}
