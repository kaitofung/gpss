package com.gpss.goods.service;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.lyyzoo.gpss.api.service.IStorageService;


@ContextConfiguration(locations = { "classpath*:spring/spring-*.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class StorageServiceImplTest  {

	@Resource 
	private IStorageService storageService;
	
//	@Test
//	public void testGetSuppliers() {
//		System.out.println(supplierService.getSuppliers(2, 2L));
//	}
//	@Test
//	public void testGetStoragesCount() {
//		System.out.println(storageService.getStoragesCount("海"));
//	}
	
	@Test
	public void testGetStorageRecordsCount() {
		Map<String, Object> params = new HashMap<String, Object>();
		System.out.println(storageService.getStorageRecordsCount(params));
	}
	
//	@Test
//	public void testDeleteSuppliers() {
//		List<String> list = new ArrayList<>();
//		list.add("1");
//		System.out.println(storageService.deleteStorages(list));
//	}
	
//	@Test
//	public void testGetStorages() {
//		System.out.println(storageService.getStoragesByName("仓", 8, 1L));
//	}
	@Test
	public void testGetStorageRecords() {
//		System.out.println(storageService.getStorageRecords(333, 1L));
	}
//	@Test
//	public void testCreateSuppliers() {
//		Supplier supplier = new Supplier();
//		supplier.setAddress("Tokyo");
//		supplier.setContacts_name("曹操");
//		supplier.setDescription("神秘组织");
//		supplier.setMobile("1547996523");
//		supplier.setName("日本鱼肝油");
//		supplier.setUpdatetime(new Date());
//		System.out.println(supplierService.createSupplier(supplier));
//	}
	
//	@Test
//	public void testEditStorage() {
//		Storage storage = storageService.getStorages(1, 1L).get(0);
//		storage.setName("55");
//		storage.setAddress("zz");
//		storage.setDescription("zz");
//		System.out.println(storageService.editStorage(storage));
//	}
	
//	@Test
//	public void testCreateStorage() {
//		Storage storage = new Storage();
//		storage.setName("55");
//		storage.setAddress("zz");
//		storage.setDescription("zz");
//		storage.setMobile("13545699875");
//		storage.setEname("xx");
//		System.out.println(storageService.createStorage(storage));
//	}
}
