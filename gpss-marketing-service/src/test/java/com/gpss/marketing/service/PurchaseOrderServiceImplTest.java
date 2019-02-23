package com.gpss.marketing.service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.lyyzoo.gpss.api.service.IPurchaseOrderService;
import com.lyyzoo.gpss.api.vo.PurchaseOrder;


@ContextConfiguration(locations = { "classpath*:spring/spring-*.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class PurchaseOrderServiceImplTest  {

	@Resource 
	private IPurchaseOrderService purchcaseOrderService;

//	@Test
//	public void testGetPurchaseOrders() {
//		System.out.println(purchcaseOrderService.getPurchaseOrders(null));
//	}
	
//	@Test
//	public void testGetPurchaseOrders() {
//		Map<String, Object> params = new HashMap<String, Object>();
//		params.put("gid", 2);
//		System.out.println(purchcaseOrderService.getPurchaseOrdersCount(params));
//	}
	
	@Test
	public void testModifyPurchaseOrders() {
		PurchaseOrder purchaseOrder = new PurchaseOrder();
		purchaseOrder.setPoid("6");
		purchaseOrder.setAppendix("备注内容x");
		purchaseOrder.setAuditStatus("2");
		purchaseOrder.setCreatedtime(new Date());
		purchaseOrder.setCreaterId("2");
		purchaseOrder.setName("xxxxxxxx");
		purchaseOrder.setPrice(222222f);
		purchaseOrder.setNum(2222);
		purchaseOrder.setSupplierId("3");
		purchaseOrder.setStorageId("3");
		purchaseOrder.setPurchaseOrderGid("3");
		purchaseOrder.setPurchaseOrderGspecificationId("3");
		purchaseOrder.setPurchaseOrderStoreId("3");
		purchaseOrder.setAuditedTime(new Date());
		purchaseOrder.setAuditedId("1");
		System.out.println(purchcaseOrderService.modifyPurchaseOrder(purchaseOrder));
	}
//	@Test
//	public void testGetPurchaseOrders() {
//		PurchaseOrder purchaseOrder = new PurchaseOrder();
//		purchaseOrder.setAppendix("备注内容");
//		purchaseOrder.setAuditStatus("1");
//		purchaseOrder.setCreatedtime(new Date());
//		purchaseOrder.setCreaterId("1");
//		purchaseOrder.setName("");
//		purchaseOrder.setPrice(11f);
//		purchaseOrder.setNum(3131);
//		purchaseOrder.setSupplierId("2");
//		purchaseOrder.setStorageId("2");
//		purchaseOrder.setAuditedId(null);
//		purchaseOrder.setPurchaseOrderGid("2");
//		purchaseOrder.setPurchaseOrderGspecificationId("2");
//		purchaseOrder.setPurchaseOrderStoreId("2");
//		System.out.println(purchcaseOrderService.createPurchaseOrders(purchaseOrder));
//	}
	
}
