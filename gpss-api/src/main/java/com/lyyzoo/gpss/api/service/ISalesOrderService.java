package com.lyyzoo.gpss.api.service;

import java.util.List;
import java.util.Map;

import com.lyyzoo.gpss.api.vo.SalesOrder;

public interface ISalesOrderService {
	
	List<SalesOrder> getSalesOrders(Map<String, Object> params);
	
	Long getSalesOrdersCount(Map<String, Object> params);

	List<SalesOrder> getSalesOrders(Map<String, Object> params, int pageSize, Long currentPage);
	
	boolean createSalesOrders(SalesOrder SalesOrder);
	
	boolean modifySalesOrder(SalesOrder SalesOrder);
	
	boolean modifySalesOrder(List<String> sids);
}
