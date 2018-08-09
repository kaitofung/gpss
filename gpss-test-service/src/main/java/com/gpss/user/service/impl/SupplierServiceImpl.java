package com.gpss.user.service.impl;


import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.gpss.common.utils.IMappingParameter;
import com.gpss.user.service.dao.ISupplierDao;
import com.lyyzoo.gpss.api.service.AbstractService;
import com.lyyzoo.gpss.api.service.ISupplierService;
import com.lyyzoo.gpss.api.vo.Supplier;

@Service
public class SupplierServiceImpl extends AbstractService implements ISupplierService,IMappingParameter {

	@Resource
	private ISupplierDao supplierDao;

	@Override
	public List<Supplier> getSuppliers(int pageSize, Long currentPage) {
		return supplierDao.doGetSuppliers(offsetNPageSize(pageSize, currentPage));
	}

	@Override
	public int getSuppliersCount(String name) {
		if(Objects.nonNull(name) && !"".equals(name)) {
			return supplierDao.doGetSuppliersCount(paramToMap("name", "%" + name + "%"));
		}
		return supplierDao.doGetSuppliersCount();
	}

	@Override
	public List<Supplier> getSuppliersByName(int pageSize, Long currentPage, String name) {
		Map<String,Object> map = offsetNPageSize(pageSize, currentPage);
		if(Objects.nonNull(name) && !"".equals(name))
		map.put("name", "%" + name + "%");
		return supplierDao.doGetSuppliers(map);
	}

	@Override
	public long deleteSuppliers(List<String> sids) {
		return supplierDao.doDeleteSuppliers(sids);
	}

	@Override
	public int createSupplier(Supplier supplier) {
		supplier.setUpdatetime(new Date());
		return supplierDao.doCreateSupplier(supplier);
	}

	@Override
	public int editSupplier(Supplier supplier) {
		supplier.setUpdatetime(new Date());
		return supplierDao.doUpdateSupplier(supplier);
	}

	@Override
	public int getSuppliersCount() {
		// TODO Auto-generated method stub
		return 0;
	}
	

}
