package com.lyyzoo.gpss.controller;

import java.sql.PreparedStatement;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.FutureTask;

import javax.annotation.Resource;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gpss.common.utils.IMappingParameter;
import com.lyyzoo.gpss.api.service.IClientService;
import com.lyyzoo.gpss.api.vo.Client;
import com.lyyzoo.gpss.api.vo.Employee;

@Controller
@RequestMapping("/marketing_manage")
public class MarketingController extends AbstractController {
	@Resource
	private IClientService clientService;
	
	@RequestMapping("/client_manage")
	public Object clientManage() {
		return "client_manage";
	}
	
	@ResponseBody
	@RequestMapping("/clients")
	public Object clients(int pageSize , Long currentPage, String name) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("total", clientService.getClientsCount(name));
		List<Client> list = clientService.getClients(pageSize, currentPage, name);
		map.put("rows", list);
		return map;
	}
	
	@ResponseBody
	@RequestMapping("/delete/client_delete")
	public Object deleteClients(@RequestParam("cids[]") List<String> cids) {
		return paramToMap("isSucceed", clientService.deleteClients(cids));
	}
	
	@ResponseBody
	@RequestMapping("/create/client_create")
	public Object createClient(Client client) {
		client.setUpdatedTime(new Date());
		return paramToMap("isSucceed", clientService.createClient(client));
	}
	
	@ResponseBody
	@RequestMapping("/edit/client_edit")
	public Object editClient(Client client) {
		client.setUpdatedTime(new Date());
		return paramToMap("isSucceed", clientService.editClient(client));
	}
	
}
