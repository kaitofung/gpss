package com.gpss.marketing.service;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.lyyzoo.gpss.api.service.IPurchcaseOrderService;


@ContextConfiguration(locations = { "classpath*:spring/spring-*.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class PurchaseOrderServiceImplTest  {

	@Resource 
	private IPurchcaseOrderService purchcaseOrderService;

//	@Test
//	public void testGetPurchaseOrders() {
//		System.out.println(purchcaseOrderService.getPurchaseOrders(null));
//	}
	
	@Test
	public void testGetPurchaseOrders() {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("gid", 2);
		System.out.println(purchcaseOrderService.getPurchaseOrdersCount(params));
	}
	
}
