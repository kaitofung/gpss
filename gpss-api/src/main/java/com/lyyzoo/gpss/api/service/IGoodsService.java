package com.lyyzoo.gpss.api.service;

import java.util.List;

import com.lyyzoo.gpss.api.vo.Goods;
import com.lyyzoo.gpss.api.vo.GoodsSpecification;
import com.lyyzoo.gpss.api.vo.GoodsType;

public interface IGoodsService {
	List<Goods> getGoodses(int pageSize , Long currentPage);
	
	List<Goods> getGoodses(int pageSize , Long currentPage, String name);
	
	boolean deleteGoodses(List<String> gids);
	
	boolean deleteGoodsSpecifications(List<String> gspecificationIds);
	
	boolean createGoods(Goods goods);
	
	boolean createGoodsSpecification(GoodsSpecification goodsSpecification);
	
	Long getGoodsesCount(String name);
	
	Long getGoodsSpecificationsCount(String gspecificationType);
	
	Long getGoodsSpecificationsCount();
	
	Long getGoodsesCount();
	
	List<GoodsType> getGoodsType();
	
	List<GoodsSpecification> getGoodsSpecifications(int pageSize, Long currentPage, String gspecificationType);
	
	List<GoodsSpecification> getGoodsSpecifications();
	
	List<String> getGoodsSpecificationTypes();
	
	boolean modifyGoods(Goods goods);
	
	boolean modifyGoodsSpecification(GoodsSpecification goodSpecification);
	
}
