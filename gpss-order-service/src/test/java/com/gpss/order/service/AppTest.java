package com.gpss.order.service;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.lyyzoo.gpss.api.service.IPermissionService;


@ContextConfiguration(locations = { "classpath:spring/spring-*.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class AppTest  {

	@Resource 
	private IPermissionService permissionService;
	
	@Test
	public void testGetSuppliers() {
		System.out.println(permissionService.getPermissions());
	}
}
