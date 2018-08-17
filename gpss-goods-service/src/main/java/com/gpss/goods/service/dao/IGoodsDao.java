package com.gpss.goods.service.dao;

import java.util.List;
import java.util.Map;

import com.gpss.common.base.IBaseDao;
import com.lyyzoo.gpss.api.vo.Goods;
import com.lyyzoo.gpss.api.vo.GoodsSpecification;
import com.lyyzoo.gpss.api.vo.GoodsType;
import com.lyyzoo.gpss.api.vo.Role;

public interface IGoodsDao extends IBaseDao<Goods>{
	
	List<GoodsType> doGetGoodsTypes();
	
	List<GoodsSpecification> doGetGoodsSpecifications(Map<String,Object> param);
	
	List<String> doGetGoodsSpecificationTypes();
	
	Long doGetGoodsSpecificationsCount(Map<String,Object> param);
	
	Long doDeleteGoodsSepcifications(List<String> gspecificationIds);
	
	Long doCreateGoodsSpecification(GoodsSpecification goodsSpecificationn);
	
	Long doUpdateGoodsSpecification(GoodsSpecification goodspecification);
}
