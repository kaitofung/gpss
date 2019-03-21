package com.gpss.system.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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

	@Override
	public boolean modifyMenu(Menu menu) {
		return menuDao.doUpdateBean(menu) > 0;
	}

	@Override
	public boolean createMenu(Menu menu) {
		return menuDao.doCreateBean(menu) > 0;
	}

	@Override
	public boolean removeMenu(Menu menu) {
		List<String> mids = new ArrayList<String>();
		mids.add(menu.getMid());
		return removeMenus(mids);
	}

	@Override
	public boolean removeMenus(List<String> mids) {
		return menuDao.doDeleteBeans(mids) == mids.size();
	}

	@Override
	public List<Menu> getMenus(Map<String, Object> param) {
		return menuDao.doGetBeans(param);
	}
	
	
}
