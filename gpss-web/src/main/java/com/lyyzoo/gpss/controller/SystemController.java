package com.lyyzoo.gpss.controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gpss.common.utils.BeanUtils;
import com.gpss.common.utils.IMappingParameter;
import com.lyyzoo.gpss.api.service.IMenuService;
import com.lyyzoo.gpss.api.service.IRoleService;
import com.lyyzoo.gpss.api.vo.Client;
import com.lyyzoo.gpss.api.vo.Menu;
import com.lyyzoo.gpss.api.vo.PurchaseOrder;
import com.lyyzoo.gpss.api.vo.Role;

@Controller
@RequestMapping("/system_manage")
public class SystemController extends AbstractController implements IMappingParameter {
	@Resource
	private IMenuService menuService;
	@Resource
	private IRoleService roleService;
	
	@RequestMapping("/menu_manage")
	public Object menuManage() {
		return "menu_manage";
	}
	
	@RequestMapping("/role_manage")
	public Object roleManage() {
		return "role_manage";
	}
	
	@ResponseBody
	@RequestMapping("/menus")
	public Object getenus() {
		return menuService.getMenus();
	}
	
	@ResponseBody
	@RequestMapping("/roles")
	public Object roles(int pageSize , Long currentPage, Role role) {
		Map<String,Object> map = new HashMap<String,Object>();
		Map<String,Object> params = BeanUtils.beanToMap(role);
		map.put("total", roleService.getRolesCount(params));
		List<Role> list = roleService.getRoles(params, pageSize, currentPage);
		map.put("rows", list);
		return map;
	}
	
	@ResponseBody
	@RequestMapping("/modify_role")
	public Object modifyRole(Role role) {
		return paramToMap("isSucceed",roleService.modifyRole(role));
	}
	
	@ResponseBody
	@RequestMapping("/create_menu")
	public Object createMenu(Menu menu) {
		return paramToMap("isSucceed",menuService.createMenu(menu));
	}
	
	@ResponseBody
	@RequestMapping("/modify_menu")
	public Object modifyMenu(Menu menu) {
		return paramToMap("isSucceed",menuService.modifyMenu(menu));
	}
	
	@ResponseBody
	@RequestMapping("/remove_menu")
	public Object removeMenu(Menu menu) {
		return paramToMap("isSucceed",menuService.removeMenu(menu));
	}
	
	@ResponseBody
	@RequestMapping("/top_menus")
	public Object getTopMenus() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("menuLevel", 1);
		List<Menu> menus = menuService.getMenus(map);
		return menus;
	}
	
	

	
}
