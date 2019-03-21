package com.lyyzoo.gpss.api.service;

import java.util.List;
import java.util.Map;

import com.lyyzoo.gpss.api.vo.Menu;

public interface IMenuService {
	List<Menu> getMenus();
	
	List<Menu> getMenus(Map<String, Object> param);
	
	boolean modifyMenu(Menu menu);
	
	boolean createMenu(Menu menu);
	
	boolean removeMenu(Menu menu);
	
	boolean removeMenus(List<String> mids);
}
