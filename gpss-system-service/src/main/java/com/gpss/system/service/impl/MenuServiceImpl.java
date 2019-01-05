package com.gpss.system.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.gpss.system.service.dao.IMenuDao;
import com.lyyzoo.gpss.api.service.IMenuService;
import com.lyyzoo.gpss.api.vo.Menu;

@Service
public class MenuServiceImpl implements IMenuService{

	@Resource
	private IMenuDao menuDao;
	
	@Override
	public List<Menu> getMenus() {
		return menuDao.doGetBeans(null);
	}
	
	
}
