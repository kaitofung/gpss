package com.gpss.goods.service;


import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.gpss.common.utils.IMappingParameter;
import com.gpss.goods.service.dao.IGoodsDao;
import com.lyyzoo.gpss.api.service.AbstractService;
import com.lyyzoo.gpss.api.service.IGoodsService;
import com.lyyzoo.gpss.api.service.IRoleService;
import com.lyyzoo.gpss.api.vo.Goods;
import com.lyyzoo.gpss.api.vo.GoodsSpecification;
import com.lyyzoo.gpss.api.vo.GoodsType;
import com.lyyzoo.gpss.api.vo.Role;

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
		return goodsDao.doGetGoodsSpecifications();
	}

	@Override
	public boolean createGoods(Goods goods) {
		return goodsDao.doCreateBean(goods) > 0;
	}


	

}
