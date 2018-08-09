package com.lyyzoo.gpss.controller;

import java.util.Enumeration;
import java.util.List;
import java.util.Objects;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gpss.common.utils.IMappingParameter;
import com.lyyzoo.gpss.api.service.ISupplierService;
import com.lyyzoo.gpss.api.vo.Supplier;
import com.lyyzoo.gpss.api.vo.User;

@Controller
@RequestMapping("/supplier")
public class SupplierController extends AbstractController implements IMappingParameter {
	@Resource
	private ISupplierService supplierService;
	
	@ResponseBody
	@RequestMapping("/suppliers")
	public Object getSuppliers(int pageSize, Long currentPage, String name) {
		int suppliersCount = supplierService.getSuppliersCount(name);
		getRequest().setAttribute("suppliersCount", suppliersCount);
		return supplierService.getSuppliersByName(pageSize, currentPage, name);
	}
	
	@ResponseBody
	@RequestMapping("/suppliers/name")
	public Object getSuppliersByName(int pageSize, Long currentPage, String name) {
		return supplierService.getSuppliersByName(pageSize, currentPage, name);
	}
	
	@ResponseBody
	@RequestMapping("/suppliers/count")
	public Object getSuppliersCount(String name) {
		return supplierService.getSuppliersCount(name);
	}
	
	
	@RequestMapping("/supplier_manage")
	public Object supplierManage() {
		int suppliersCount = supplierService.getSuppliersCount(null);
		getRequest().setAttribute("suppliersCount", suppliersCount);
		return "supplier_manage";
	}
	
	@ResponseBody
	@RequestMapping("/delete")
	public Object deleteSuppliers(@RequestParam("sids[]") List<String> sids) {
		return paramToMap("isSucceed" , supplierService.deleteSuppliers(sids) > 0);
	}
	
	@ResponseBody
	@RequestMapping("/create")
	public Object createSupplier(Supplier supplier) {
		return paramToMap("isSucceed" , supplierService.createSupplier(supplier) >0);
	}
	
	@ResponseBody
	@RequestMapping("/edit")
	public Object editSupplier(Supplier supplier) {
		return paramToMap("isSucceed" , supplierService.editSupplier(supplier) >0);
	}

	
}
