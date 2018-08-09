package com.lyyzoo.gpss.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gpss.common.utils.IMappingParameter;
import com.lyyzoo.gpss.api.service.IGoodsService;
import com.lyyzoo.gpss.api.service.IStorageService;
import com.lyyzoo.gpss.api.vo.Storage;

@Controller
@RequestMapping("/goods")
public class GoodsController extends AbstractController implements IMappingParameter {
	@Resource
	private IGoodsService goodsService;
	
	@ResponseBody
	@RequestMapping("/goodses")
	public Object getGoodses(int pageSize, Long currentPage, String name) {
		long goodsesCount = goodsService.getGoodsesCount(name);	
		getRequest().setAttribute("goodsesCount", goodsesCount);
		return goodsService.getGoodses(pageSize, currentPage,name);
	}
	
	@ResponseBody
	@RequestMapping("/goodses/count")
	public Object getGoodsesCount(String name) {
		return goodsService.getGoodsesCount(name);
	}
	
	@RequestMapping("/goods_manage")
	public Object goodsManage() {
		long goodsesCount = goodsService.getGoodsesCount("");
		getRequest().setAttribute("goodsesCount", goodsesCount);
		return "goods_manage";
	}
//	
//	@ResponseBody
//	@RequestMapping("/delete")
//	public Object deleteStorages(@RequestParam("sids[]") List<String> sids) {
//		return paramToMap("isSucceed" , storageService.deleteStorages(sids) > 0);
//	}
//	
//	@ResponseBody
//	@RequestMapping("/create")
//	public Object createSupplier(Storage storage) {
//		return paramToMap("isSucceed" , storageService.createStorage(storage) > 0);
//	}
//	
//	@ResponseBody
//	@RequestMapping("/edit")
//	public Object editStorage(Storage storage) {
//		return paramToMap("isSucceed" , storageService.editStorage(storage) >0);
//	}

	
}
