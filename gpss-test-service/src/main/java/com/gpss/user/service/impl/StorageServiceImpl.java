package com.gpss.user.service.impl;


import java.util.List;
import java.util.Map;
import java.util.Objects;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.gpss.common.utils.IMappingParameter;
import com.gpss.user.service.dao.IStorageDao;
import com.gpss.user.service.dao.IStringDao;
import com.lyyzoo.gpss.api.service.AbstractService;
import com.lyyzoo.gpss.api.service.IStorageService;
import com.lyyzoo.gpss.api.vo.Storage;

@Service
public class StorageServiceImpl extends AbstractService implements IStorageService,IMappingParameter {

	@Resource
	private IStorageDao storageDao;
	
	@Resource
	private IStringDao stringDao;

	@Override
	public List<String> getStrings() {
		System.err.println("---getStrings()----");
		return stringDao.doGetString();
	}
	
	@Override
	public List<Storage> getStorages(int pageSize, Long currentPage) {
		return this.getStoragesByName("", pageSize, currentPage);
	}

	@Override
	public List<Storage> getStoragesByName(String name, int pageSize, Long currentPage) {
		Map<String,Object> map = offsetNPageSize(pageSize, currentPage);
		if(Objects.nonNull(name) && !"".equals(name))
		map.put("name", "%" + name + "%");
		return storageDao.doGetStorages(map);
	}

	@Override
	public long getStoragesCount(String name) {
		if(Objects.nonNull(name) && !"".equals(name)) {
			return storageDao.doGetStoragesCount(paramToMap("name", "%" + name + "%"));
		}
		return storageDao.doGetStoragesCount();
	}

	@Override
	public long deleteStorages(List<String> sids) {
		return storageDao.doDeleteStorages(sids);
	}

	@Override
	public int createStorage(Storage storage) {
		return 0;
	}

	@Override
	public int editStorage(Storage storage) {
		return storageDao.doUpdateStorage(storage);
	}
	

}
