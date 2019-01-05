package com.lyyzoo.gpss.api.service;

import java.util.List;

import com.lyyzoo.gpss.api.vo.Client;

public interface IClientService {
	
	List<Client> getClients(int pageSize , Long currentPage, String name);
	
	long getClientsCount(String name);
	
	boolean deleteClients(List<String> cids);
	
	boolean createClient(Client client);

	boolean editClient(Client client);
}
