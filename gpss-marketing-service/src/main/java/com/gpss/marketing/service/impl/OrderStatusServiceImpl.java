package com.gpss.marketing.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.gpss.marketing.service.dao.IOrderStatusDao;
import com.lyyzoo.gpss.api.service.IOrderStatusService;
import com.lyyzoo.gpss.api.vo.OrderStatus;
@Service
public class OrderStatusServiceImpl implements IOrderStatusService {

	@Resource
	private IOrderStatusDao orderStatusDao;
	
	@Override
	public List<OrderStatus> getOrderStatus() {
		return orderStatusDao.doGetBeans(null);
	}

}
