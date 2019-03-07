package com.gpss.storage.service.impl;


import java.util.List;
import java.util.Map;
import java.util.Objects;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.gpss.common.utils.IMappingParameter;
import com.gpss.storage.service.dao.IStorageDao;
import com.gpss.storage.service.dao.IStorageRecordDao;
import com.gpss.user.service.dao.IUserDao;
import com.lyyzoo.gpss.api.service.AbstractService;
import com.lyyzoo.gpss.api.service.IStorageService;
import com.lyyzoo.gpss.api.service.ISupplierService;
import com.lyyzoo.gpss.api.vo.Employee;
import com.lyyzoo.gpss.api.vo.Storage;
import com.lyyzoo.gpss.api.vo.StorageRecord;

@Service
public class StorageServiceImpl extends AbstractService implements IStorageService,IMappingParameter {

	@Resource
	private IStorageDao storageDao;
	@Resource
	private IUserDao userDao;
	@Resource
	private IStorageRecordDao storageRecordDao;


	@Override
	public List<Storage> getStorages(int pageSize, Long currentPage) {
		return this.getStoragesByName("", pageSize, currentPage);
	}

	@Override
	public List<Storage> getStoragesByName(String name, int pageSize, Long currentPage) {
		return storageDao.doGetBeans(fuzzyQuery(name, "name", pageSize, currentPage));
	}

	@Override
	public long getStoragesCount(String name) {
		if(Objects.nonNull(name) && !"".equals(name)) {
			return storageDao.doGetBeansCount(paramToMap("name", "%" + name + "%"));
		}
		return storageDao.doGetBeansCount();
	}

	@Override
	public long deleteStorages(List<String> sids) {
		return storageDao.doDeleteBeans(sids);
	}
	
	@Override
	public int editStorage(Storage storage) {
		return (int) storageDao.doUpdateBean(storage);
	}


	@Override
	public int createStorage(Storage storage) {
		Employee employee = userDao.doGetEmployee(paramToMap("name", storage.getEname()));
		if(employee == null ) {
			return 0;
		}
		storage.setEid(employee.getEid());
		return (int) storageDao.doCreateBean(storage);
	}


	@Override
	public List<StorageRecord> getStorageRecords(Map<String, Object> params) {
		return storageRecordDao.doGetBeans(params);
	}

	@Override
	public long getStorageRecordsCount(Map<String, Object> params) {
		return storageRecordDao.doGetBeansCount(params);
	}

	@Override
	public List<StorageRecord> getStorageRecords(Map<String, Object> params, Long currentPage, Integer pageSize) {
		params.putAll(offsetNPageSize(pageSize, currentPage));
		return getStorageRecords(params);
	}

	

}
