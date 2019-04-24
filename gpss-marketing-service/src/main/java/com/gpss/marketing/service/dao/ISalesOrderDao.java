package com.gpss.marketing.service.dao;
import java.util.List;

import com.gpss.common.base.IBaseDao;
import com.lyyzoo.gpss.api.vo.SalesOrder;

public interface ISalesOrderDao extends IBaseDao<SalesOrder>{
	
	long doReturnsSalesOrders(List<String> sids);
	
}
