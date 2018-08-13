package com.lyyzoo.gpss.api.service;

import java.util.List;

import com.lyyzoo.gpss.api.vo.Goods;
import com.lyyzoo.gpss.api.vo.GoodsSpecification;
import com.lyyzoo.gpss.api.vo.GoodsType;

public interface IGoodsService {
	List<Goods> getGoodses(int pageSize , Long currentPage);
	
	List<Goods> getGoodses(int pageSize , Long currentPage, String name);
	
	boolean deleteGoodses(List<String> gids);
	
	boolean createGoods(Goods goods);
	
	Long getGoodsesCount(String name);
	
	Long getGoodsesCount();
	
	List<GoodsType> getGoodsType();
	
	List<GoodsSpecification> getGoodsSpecifications();
	
	boolean modifyGoods(Goods goods);
	

}
