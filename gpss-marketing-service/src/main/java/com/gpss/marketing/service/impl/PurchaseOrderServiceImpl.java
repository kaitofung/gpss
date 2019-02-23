package com.gpss.marketing.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.gpss.marketing.service.dao.IPurchaseOrderDao;
import com.lyyzoo.gpss.api.service.AbstractService;
import com.lyyzoo.gpss.api.service.IPurchaseOrderService;
import com.lyyzoo.gpss.api.vo.PurchaseOrder;

@Service
public class PurchaseOrderServiceImpl extends AbstractService implements IPurchaseOrderService{

	@Resource
	private IPurchaseOrderDao purchaseOrderDao;
	
	@Override
	public List<PurchaseOrder> getPurchaseOrders(Map<String, Object> params, int pageSize, Long currentPage) {
		return purchaseOrderDao.doGetBeans(queryData(params, pageSize, currentPage));
	}
	
	@Override
	public List<PurchaseOrder> getPurchaseOrders(Map<String, Object> params) {
		return purchaseOrderDao.doGetBeans(params);
	}

	@Override
	public Long getPurchaseOrdersCount(Map<String, Object> params) {
		return purchaseOrderDao.doGetBeansCount(params);
	}

	@Override
	public boolean createPurchaseOrders(PurchaseOrder purchaseOrder) {
		return purchaseOrderDao.doCreateBean(purchaseOrder) > 0;
	}

	@Override
	public boolean modifyPurchaseOrder(PurchaseOrder purchaseOrder) {
		return purchaseOrderDao.doUpdateBean(purchaseOrder) > 0;
	}
}
