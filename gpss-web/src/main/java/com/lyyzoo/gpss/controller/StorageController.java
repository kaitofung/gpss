package com.lyyzoo.gpss.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gpss.common.utils.BeanUtils;
import com.gpss.common.utils.IMappingParameter;
import com.lyyzoo.gpss.api.service.IStorageService;
import com.lyyzoo.gpss.api.vo.Storage;
import com.lyyzoo.gpss.api.vo.StorageRecord;

@Controller
@RequestMapping("/storage")
public class StorageController extends AbstractController implements IMappingParameter {
	@Resource
	private IStorageService storageService;
	
	@RequestMapping("/summary")
	public Object summary() {
		return "storage_summary";
	}
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
	
	@ResponseBody
	@RequestMapping("/edit_storage_record")
	public Object editStorage(StorageRecord storageRecord) {
		return paramToMap("isSucceed" , storageService.editStorageRecord(storageRecord));
	}
	
	@ResponseBody
	@RequestMapping("/storage_records")
	public Object editStorage(StorageRecord storageRecord, int pageSize, Long currentPage) {
		Map<String,Object> map = new HashMap<String,Object>();
		Map<String,Object> params = BeanUtils.beanToMap(storageRecord);
		map.put("total", storageService.getStorageRecordsCount(params));
		List<StorageRecord> list = storageService.getStorageRecords(params, currentPage, pageSize);
		map.put("rows", list);
		return map;
	}
	
	@ResponseBody
	@RequestMapping("/storage_record_count")
	public Object storageRecordCount(StorageRecord storageRecord) {
		return BeanUtils.beanToMap(storageRecord);
	}

	
}
