package com.lyyzoo.gpss.api.service;

import java.util.List;
import java.util.Map;

import com.lyyzoo.gpss.api.vo.PurchaseOrder;

public interface IPurchaseOrderService {
	
	List<PurchaseOrder> getPurchaseOrders(Map<String, Object> params);
	
	Long getPurchaseOrdersCount(Map<String, Object> params);

	List<PurchaseOrder> getPurchaseOrders(Map<String, Object> params, int pageSize, Long currentPage);
	
	boolean createPurchaseOrders(PurchaseOrder purchaseOrder);
	
	boolean modifyPurchaseOrder(PurchaseOrder purchaseOrder);
}
