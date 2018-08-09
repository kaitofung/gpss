package com.lyyzoo.gpss.api.service;

import java.util.List;

import com.lyyzoo.gpss.api.vo.Storage;

public interface IStorageService {
	List<Storage> getStorages(int pageSize , Long currentPage);
	
	List<Storage> getStoragesByName(String name, int pageSize , Long currentPage);
	
	long getStoragesCount(String name);
	
	long deleteStorages(List<String> sids);
	
	int createStorage(Storage storage);
	
	int editStorage(Storage storage);

}
