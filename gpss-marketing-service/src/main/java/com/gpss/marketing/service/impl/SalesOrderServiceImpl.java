package com.gpss.marketing.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.gpss.marketing.service.dao.ISalesOrderDao;
import com.lyyzoo.gpss.api.service.AbstractService;
import com.lyyzoo.gpss.api.service.ISalesOrderService;
import com.lyyzoo.gpss.api.vo.SalesOrder;

@Service
public class SalesOrderServiceImpl extends AbstractService implements ISalesOrderService{

	@Resource
	private ISalesOrderDao salesOrderDao;
	
	@Override
	public List<SalesOrder> getSalesOrders(Map<String, Object> params, int pageSize, Long currentPage) {
		return salesOrderDao.doGetBeans(queryData(params, pageSize, currentPage));
	}
	
	@Override
	public List<SalesOrder> getSalesOrders(Map<String, Object> params) {
		return salesOrderDao.doGetBeans(params);
	}

	@Override
	public Long getSalesOrdersCount(Map<String, Object> params) {
		return salesOrderDao.doGetBeansCount(params);
	}

	@Override
	public boolean createSalesOrders(SalesOrder salesOrder) {
		return salesOrderDao.doCreateBean(salesOrder) > 0;
	}

	@Override
	public boolean modifySalesOrder(SalesOrder salesOrder) {
		return salesOrderDao.doUpdateBean(salesOrder) > 0;
	}
}
