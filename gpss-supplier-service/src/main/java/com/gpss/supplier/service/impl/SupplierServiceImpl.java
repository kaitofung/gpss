package com.gpss.supplier.service.impl;


import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.gpss.common.utils.IMappingParameter;
import com.gpss.supplier.service.dao.ISupplierDao;
import com.lyyzoo.gpss.api.service.AbstractService;
import com.lyyzoo.gpss.api.service.ISupplierService;
import com.lyyzoo.gpss.api.vo.Supplier;

@Service
public class SupplierServiceImpl extends AbstractService implements ISupplierService,IMappingParameter {

	@Resource
	private ISupplierDao supplierDao;

	@Override
	public List<Supplier> getSuppliers(int pageSize, Long currentPage) {
		int offset = (int) (pageSize * (currentPage - 1)) ;
		return supplierDao.doGetSuppliers(paramToMap("offset", offset,"pagesize", pageSize));
	}

	@Override
	public int getSuppliersCount() {
		return supplierDao.doGetSuppliersCount();
	}
	

	@Override
	public List<Supplier> getSuppliersByName(int pageSize, Long currentPage, String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getSuppliersCount(String name) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long deleteSuppliers(List<String> sids) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int createSupplier(Supplier supplier) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int editSupplier(Supplier supplier) {
		// TODO Auto-generated method stub
		return 0;
	}
	

}
