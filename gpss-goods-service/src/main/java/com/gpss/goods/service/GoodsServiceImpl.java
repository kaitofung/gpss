package com.gpss.goods.service;


import java.util.List;
import java.util.Map;
import java.util.Objects;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.gpss.common.utils.IMappingParameter;
import com.gpss.goods.service.dao.IGoodsDao;
import com.lyyzoo.gpss.api.service.AbstractService;
import com.lyyzoo.gpss.api.service.IGoodsService;
import com.lyyzoo.gpss.api.vo.Goods;
import com.lyyzoo.gpss.api.vo.GoodsSpecification;
import com.lyyzoo.gpss.api.vo.GoodsType;
@Service
public class GoodsServiceImpl extends AbstractService implements IGoodsService,IMappingParameter {

	@Resource
	IGoodsDao goodsDao;

	@Override
	public List<Goods> getGoodses(int pageSize, Long currentPage) {
		return goodsDao.doGetBeans(offsetNPageSize(pageSize, currentPage));
	}

	@Override
	public Long getGoodsesCount(String name) {
		return goodsDao.doGetBeansCount(paramToMap("name", "%" + name + "%"));
	}

	@Override
	public Long getGoodsesCount() {
		return goodsDao.doGetBeansCount();
	}


	@Override
	public List<Goods> getGoodses(int pageSize, Long currentPage, String name) {
		return goodsDao.doGetBeans(fuzzyQuery(name, "name", pageSize, currentPage));
	}

	@Override
	public boolean deleteGoodses(List<String> gids) {
		return goodsDao.doDeleteBeans(gids) > 0;
	}

	@Override
	public List<GoodsType> getGoodsType() {
		return goodsDao.doGetGoodsTypes();
	}

	@Override
	public List<GoodsSpecification> getGoodsSpecifications() {
		return goodsDao.doGetGoodsSpecifications(paramToMap("gspecificationType", ""));
	}

	@Override
	public boolean createGoods(Goods goods) {
		return goodsDao.doCreateBean(goods) > 0;
	}

	@Override
	public boolean modifyGoods(Goods goods) {
		return goodsDao.doUpdateBean(goods) > 0;
	}

	@Override
	public List<GoodsSpecification> getGoodsSpecifications(int pageSize, Long currentPage,String gspecificationType) {
		return goodsDao.doGetGoodsSpecifications(fuzzyQuery(gspecificationType, "gspecificationType", pageSize, currentPage));
	}

	@Override
	public List<String> getGoodsSpecificationTypes() {
		return goodsDao.doGetGoodsSpecificationTypes();
	}

	@Override
	public Long getGoodsSpecificationsCount(String gspecificationType) {
		if(Objects.isNull(gspecificationType) || "".equals(gspecificationType))
		return  getGoodsSpecificationsCount();
		return goodsDao.doGetGoodsSpecificationsCount(paramToMap("gspecificationType", "%" + gspecificationType + "%"));
	}

	@Override
	public boolean deleteGoodsSpecifications(List<String> gspecificationIds) {
		return goodsDao.doDeleteGoodsSepcifications(gspecificationIds) > 0;
	}

	@Override
	public Long getGoodsSpecificationsCount() {
		return goodsDao.doGetGoodsSpecificationsCount(paramToMap("gspecificationType", ""));
	}

	@Override
	public boolean createGoodsSpecification(GoodsSpecification goodsSpecification) {
		return goodsDao.doCreateGoodsSpecification(goodsSpecification) > 0;
	}

	@Override
	public boolean modifyGoodsSpecification(GoodsSpecification goodSpecification) {
		return goodsDao.doUpdateGoodsSpecification(goodSpecification) >0;
	}

}
