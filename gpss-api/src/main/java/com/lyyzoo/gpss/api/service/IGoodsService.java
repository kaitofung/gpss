package com.lyyzoo.gpss.api.service;

import java.util.List;

import com.lyyzoo.gpss.api.vo.Goods;

public interface IGoodsService {
	List<Goods> getGoodses(int pageSize , Long currentPage);
	
	List<Goods> getGoodses(int pageSize , Long currentPage, String name);
	
	Long getGoodsesCount(String name);
	
	Long getGoodsesCount();

}
