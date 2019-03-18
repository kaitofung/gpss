package com.gpss.system.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.lyyzoo.gpss.api.service.IMenuService;
import com.lyyzoo.gpss.api.service.IRoleService;
import com.lyyzoo.gpss.api.vo.Menu;


@ContextConfiguration(locations = { "classpath*:spring/spring-*.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class SystemServiceImplTest  {

	@Resource 
	private IMenuService menuService;
	@Resource 
	private IRoleService roleService;
	
	
//	@Test
//	public void testGetRoles() {
//		Map<String, Object> param = new HashMap<String, Object>();
//		param.put("roleCode", "purchaser");
//		System.out.println(roleService.getRoles(null));
//	}
	
//	@Test
//	public void testModifyRole() {
//		Role role = new Role();
//		role.setRid(2);
//		role.setName("aaaa");
//		role.setDescription("Test");
//		System.out.println(roleService.modifyRole(role));
//	}
//	@Test
//	public void testModifyMenu() {
//		Menu menu = new Menu();
//		menu.setName("aaa");
//		menu.setMid("1");
//		menu.setUrl("sss");
//		System.out.println(menuService.modifyMenu(menu));
//	}
	@Test
	public void testDeleteMenus() {
		List<Menu> list = new ArrayList<Menu>();
		Menu menu = new Menu();
		menu.setMid("29");
		list.add(menu);
		System.out.println(menuService.removeMenu(menu));
	}
	
//	@Test
//	public void testCreateMenu() {
//		Menu menu = new Menu();
//		menu.setName("aaa");
//		menu.setUrl("sss");
//		menu.setParentId("1");
//		System.out.println(menuService.createMenu(menu));
//	}
	
//	@Test
//	public void testGetMenus() {
//		System.out.println(menuService.getMenus());
//	}
}
