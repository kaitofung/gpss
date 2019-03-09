package com.gpss.marketing.service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.lyyzoo.gpss.api.service.ISalesOrderService;
import com.lyyzoo.gpss.api.vo.SalesOrder;


@ContextConfiguration(locations = { "classpath*:spring/spring-*.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class SalesOrderServiceImplTest  {

	@Resource 
	private ISalesOrderService purchcaseOrderService;

//	@Test
//	public void testGetSalesOrders() {
//		System.out.println(purchcaseOrderService.getSalesOrders(null));
//	}
	
//	@Test
//	public void testGetSalesOrdersCount() {
//		Map<String, Object> params = new HashMap<String, Object>();
//		params.put("gid", 212);
//		System.out.println(purchcaseOrderService.getSalesOrdersCount(params));
//	}
	
	@Test
	public void testModifySalesOrders() {
		SalesOrder salesOrder = new SalesOrder();
		salesOrder.setSoid("1");
		salesOrder.setAppendix("qqqqqqqqqqq");
		salesOrder.setAuditStatus("2");
		salesOrder.setCreatedtime(new Date());
		salesOrder.setCreaterId("2");
		salesOrder.setName("haoah");
		salesOrder.setPrice(222222f);
		salesOrder.setNum(2222);
		salesOrder.setSupplierId("3");
		salesOrder.setStorageId("3");
		salesOrder.setSalesOrderGid("3");
		salesOrder.setSalesOrderGspecificationId("3");
		salesOrder.setSalesOrderStoreId("3");
		salesOrder.setAuditedTime(new Date());
		salesOrder.setAuditedId("1");
		salesOrder.setCid("3");
		salesOrder.setAuditedContent("aaaaaaaaaaa");
		System.out.println(purchcaseOrderService.modifySalesOrder(salesOrder));
	}
	
//	@Test
//	public void testCreateSalesOrders() {
//		SalesOrder salesOrder = new SalesOrder();
//		salesOrder.setAppendix("备注内容");
//		salesOrder.setAuditStatus("1");
//		salesOrder.setCreatedtime(new Date());
//		salesOrder.setCreaterId("1");
//		salesOrder.setName("");
//		salesOrder.setPrice(11f);
//		salesOrder.setNum(3131);
//		salesOrder.setSupplierId("2");
//		salesOrder.setStorageId("2");
//		salesOrder.setAuditedId(null);
//		salesOrder.setCid("9");
//		salesOrder.setSalesOrderGid("2");
//		salesOrder.setSalesOrderGspecificationId("2");
//		salesOrder.setSalesOrderStoreId("2");
//		System.out.println(purchcaseOrderService.createSalesOrders(salesOrder));
//	}
	
}
