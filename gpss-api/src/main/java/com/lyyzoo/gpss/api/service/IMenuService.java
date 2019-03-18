package com.lyyzoo.gpss.api.service;

import java.util.List;

import com.lyyzoo.gpss.api.vo.Menu;

public interface IMenuService {
	List<Menu> getMenus();
	
	boolean modifyMenu(Menu menu);
	
	boolean createMenu(Menu menu);
	
	boolean removeMenu(Menu menu);
	
	boolean removeMenus(List<String> mids);
}
