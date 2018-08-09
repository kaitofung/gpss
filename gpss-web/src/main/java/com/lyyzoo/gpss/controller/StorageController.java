package com.lyyzoo.gpss.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gpss.common.utils.IMappingParameter;
import com.lyyzoo.gpss.api.service.IStorageService;
import com.lyyzoo.gpss.api.vo.Storage;

@Controller
@RequestMapping("/storage")
public class StorageController extends AbstractController implements IMappingParameter {
	@Resource
	private IStorageService storageService;
	
	@ResponseBody
	@RequestMapping("/storages")
	public Object getStorages(int pageSize, Long currentPage, String name) {
		long storagesCount = storageService.getStoragesCount(name);	
		getRequest().setAttribute("storagesCount", storagesCount);
		return storageService.getStoragesByName(name, pageSize, currentPage);
	}
	
	@ResponseBody
	@RequestMapping("/storages/count")
	public Object getStoragesCount(String name) {
		return storageService.getStoragesCount(name);
	}
	
	@RequestMapping("/storage_manage")
	public Object storageManage() {
		long storagesCount = storageService.getStoragesCount("");
		getRequest().setAttribute("storagesCount", storagesCount);
		return "storage_manage";
	}
	
	@ResponseBody
	@RequestMapping("/delete")
	public Object deleteStorages(@RequestParam("sids[]") List<String> sids) {
		return paramToMap("isSucceed" , storageService.deleteStorages(sids) > 0);
	}
	
	@ResponseBody
	@RequestMapping("/create")
	public Object createSupplier(Storage storage) {
		return paramToMap("isSucceed" , storageService.createStorage(storage) > 0);
	}
	
	@ResponseBody
	@RequestMapping("/edit")
	public Object editStorage(Storage storage) {
		return paramToMap("isSucceed" , storageService.editStorage(storage) >0);
	}

	
}
