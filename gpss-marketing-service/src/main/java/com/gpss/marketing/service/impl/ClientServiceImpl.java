package com.gpss.marketing.service.impl;

import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.FutureTask;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.gpss.marketing.service.dao.IClientDao;
import com.lyyzoo.gpss.api.service.AbstractService;
import com.lyyzoo.gpss.api.service.IClientService;
import com.lyyzoo.gpss.api.vo.Client;

@Service
public class ClientServiceImpl extends AbstractService implements IClientService{
	
	@Resource
	private IClientDao clientDao;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Client> getClients(int pageSize, Long currentPage, String name) {
		return clientDao.doGetBeans(fuzzyQuery(name, "name", pageSize, currentPage));
	}

	@Override
	public long getClientsCount(String name) {
		return  clientDao.doGetBeansCount(paramToMap("name", name));
	}

	@Override
	public boolean deleteClients(List<String> cids) {
		if(cids == null)
			return false;
		return clientDao.doDeleteBeans(cids) == cids.size();
	}

	@Override
	public boolean createClient(Client client) {
		return clientDao.doCreateBean(client) > 0;
	}
	
	@Override
	public boolean editClient(Client client) {
		client.setUpdatedTime(new Date());
		return clientDao.doUpdateBean(client) > 0;
	}


}
