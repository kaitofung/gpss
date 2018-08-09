package com.gpss.user.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.lyyzoo.gpss.api.service.ISupplierService;
import com.lyyzoo.gpss.api.vo.Supplier;


@ContextConfiguration(locations = { "classpath:spring/spring-*.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class SupplierServiceImplTest  {

	@Resource 
	private ISupplierService supplierService;
	
//	@Test
//	public void testGetSuppliers() {
//		System.out.println(supplierService.getSuppliers(2, 2L));
//	}
	
//	@Test
//	public void testDeleteSuppliers() {
//		List<String> list = new ArrayList<>();
//		list.add("66");
//		list.add("3");
//		list.add("4");
//		System.out.println(supplierService.deleteSuppliers(list));
//	}
	
//	@Test
//	public void testGetSuppliers() {
//		System.out.println(supplierService.getSuppliersByName(33, 1L, ""));
//	}
	@Test
	public void testCreateSuppliers() {
		Supplier supplier = new Supplier();
		supplier.setAddress("Tokyo");
		supplier.setContacts_name("曹操");
		supplier.setDescription("神秘组织");
		supplier.setMobile("1547996523");
		supplier.setName("日本鱼肝油");
		supplier.setUpdatetime(new Date());
		System.out.println(supplierService.createSupplier(supplier));
	}
	
//	@Test
//	public void testEditSuppliers() {
//		Supplier supplier = new Supplier();
//		supplier.setSid("5281");
//		supplier.setAddress("xxxxxxxxxxxxx");
//		supplier.setContacts_name("xxxxxxxxx");
//		supplier.setDescription("xxxxx");
//		supplier.setMobile("xxxxxxxxxxx");
//		supplier.setName("日本鱼肝油");
//		System.out.println(supplierService.editSupplier(supplier));
//	}
}
