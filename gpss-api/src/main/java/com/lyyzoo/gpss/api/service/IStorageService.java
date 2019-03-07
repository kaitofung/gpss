package com.lyyzoo.gpss.api.service;

import java.util.List;
import java.util.Map;

import com.lyyzoo.gpss.api.vo.Storage;
import com.lyyzoo.gpss.api.vo.StorageRecord;

public interface IStorageService {
	List<Storage> getStorages(int pageSize , Long currentPage);
	
	List<StorageRecord> getStorageRecords(Map<String, Object> params);
	
	List<StorageRecord> getStorageRecords(Map<String, Object> params,Long currentPage,Integer pageSize);
	
	List<Storage> getStoragesByName(String name, int pageSize , Long currentPage);
	
	long getStoragesCount(String name);
	
	long getStorageRecordsCount(Map<String, Object> params);
	
	long deleteStorages(List<String> sids);
	
	int createStorage(Storage storage);
	
	int editStorage(Storage storage);

}
