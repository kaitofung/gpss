package com.lyyzoo.gpss.api.service;

import java.util.List;

import com.lyyzoo.gpss.api.vo.Supplier;

public interface ISupplierService {
	List<Supplier> getSuppliers(int pageSize , Long currentPage);
	
	List<Supplier> getSuppliersByName(int pageSize , Long currentPage , String name);
	
	int getSuppliersCount(String name);
	
	long deleteSuppliers(List<String> sids);
	
	int createSupplier(Supplier supplier);
	
	int editSupplier(Supplier supplier);

	int getSuppliersCount();
}
