package com.lyyzoo.gpss.controller;


import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gpss.common.utils.IMappingParameter;
import com.lyyzoo.gpss.api.service.IMenuService;

@Controller
@RequestMapping("/system_manage")
public class SystemController extends AbstractController implements IMappingParameter {
	@Resource
	private IMenuService menuService;
	
	@RequestMapping("/menu_manage")
	public Object menuManage() {
		return "menu_manage";
	}
	
	@ResponseBody
	@RequestMapping("/menus")
	public Object getenus() {
		return menuService.getMenus();
	}
	
	

	
}
