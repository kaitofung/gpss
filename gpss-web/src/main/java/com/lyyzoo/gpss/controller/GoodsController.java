package com.lyyzoo.gpss.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import com.lyyzoo.gpss.controller.AbstractController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.gpss.common.utils.IMappingParameter;
import com.lyyzoo.gpss.api.service.IGoodsService;
import com.lyyzoo.gpss.api.vo.Goods;

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
	
	@ResponseBody
	@RequestMapping("/delete")
	public Object deleteGoodses(@RequestParam("gids[]") List<String> gids) {
		return paramToMap("isSucceed" , goodsService.deleteGoodses(gids));
	}
	
	@ResponseBody
	@RequestMapping("/goods_types")
	public Object getGoodsTypes() {
		return goodsService.getGoodsType();
	}
	
	@ResponseBody
	@RequestMapping("/goods_specifications")
	public Object getGoodsSpecifications() {
		return goodsService.getGoodsSpecifications();
	}
	
	
	@ResponseBody
	@RequestMapping("/create")
	public Object createGoods(Goods goods, MultipartFile photox) throws IllegalStateException, IOException {
		System.err.println(goods);
		if(photox !=null && !photox.isEmpty()) {
			String suffix = photox.getOriginalFilename().substring(photox.getOriginalFilename().lastIndexOf("."));
			String path = getRequest().getServletContext().getRealPath("/upload/") + UUID.randomUUID() + suffix;
			System.err.println(path);
			photox.transferTo(new File(path));
			goods.setPhoto(path);
		} else {
			goods.setPhoto("");
		}
		return paramToMap("isSucceed" , goodsService.createGoods(goods));
	}
	
	@ResponseBody
	@RequestMapping("/edit")
	public Object editGoods(Goods goods, MultipartFile photox) throws IllegalStateException, IOException {
		System.err.println(goods);
		if(photox !=null && !photox.isEmpty()) {
			String suffix = photox.getOriginalFilename().substring(photox.getOriginalFilename().lastIndexOf("."));
			String path = getRequest().getServletContext().getRealPath("/upload/") + UUID.randomUUID() + suffix;
			System.err.println(path);
			photox.transferTo(new File(path));
			goods.setPhoto(path);
		} 
		return paramToMap("isSucceed" , goodsService.modifyGoods(goods));
	}

	
}
