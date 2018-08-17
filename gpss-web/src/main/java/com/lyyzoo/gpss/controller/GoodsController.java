package com.lyyzoo.gpss.controller;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.gpss.common.utils.IMappingParameter;
import com.lyyzoo.gpss.api.service.IGoodsService;
import com.lyyzoo.gpss.api.vo.Goods;
import com.lyyzoo.gpss.api.vo.GoodsSpecification;

@Controller
@RequestMapping("/goods")
public class GoodsController extends AbstractController implements IMappingParameter {
	@Resource
	private IGoodsService goodsService;
	
	@ResponseBody
	@RequestMapping("/goodses")
	public Object getGoodses(int pageSize, Long currentPage, String name) {
		long goodsesCount = goodsService.getGoodsesCount(name);	
		setAttribute("goodsesCount", goodsesCount);
		return goodsService.getGoodses(pageSize, currentPage,name);
	}
	
	@ResponseBody
	@RequestMapping("/goodses/count")
	public Object getGoodsesCount(String name) {
		return goodsService.getGoodsesCount(name);
	}
	
	@ResponseBody
	@RequestMapping("/gspecification/count")
	public Object getGoodsSpecificationsCount(String gspecificationType) {
		return goodsService.getGoodsSpecificationsCount(gspecificationType);
	}
	
	@RequestMapping("/goods_manage")
	public Object goodsManage() {
		long goodsesCount = goodsService.getGoodsesCount("");
		setAttribute("goodsesCount", goodsesCount);
		return "goods_manage";
	}
	
	@RequestMapping("/goods_param_manage")
	public Object goodsParamManage() {
		long gspecificationCount = goodsService.getGoodsSpecificationsCount("");
		getRequest().setAttribute("gspecificationCount", gspecificationCount);
		return "goods_param_manage";
	}
	
	@ResponseBody
	@RequestMapping("/delete")
	public Object deleteGoodses(@RequestParam("gids[]") List<String> gids) {
		return paramToMap("isSucceed" , goodsService.deleteGoodses(gids));
	}
	
	@ResponseBody
	@RequestMapping("/delete/goods_specification")
	public Object deleteGoodsSpecificationns(@RequestParam("gspecificationIds[]") List<String> gspecificationIds) {
		System.err.println(gspecificationIds);
		boolean result = false;
		try {
			result = goodsService.deleteGoodsSpecifications(gspecificationIds);
		} catch (Exception e) {
			e.printStackTrace();//外键约束无法删除
		}
		return paramToMap("isSucceed" ,result );
	}
	
	@ResponseBody
	@RequestMapping("/goods_types")
	public Object getGoodsTypes() {
		return goodsService.getGoodsType();
	}
	
	@ResponseBody
	@RequestMapping("/goods_specification_type")
	public Object getGoodsSpecificationTypes() {
		return goodsService.getGoodsSpecificationTypes();
	}
	
	@ResponseBody
	@RequestMapping("/goods_specifications")
	public Object getGoodsSpecifications(int pageSize, Long currentPage, String gspecificationType) {
		long gspecificationCount = goodsService.getGoodsSpecificationsCount(gspecificationType);
		setAttribute("gspecificationCount", gspecificationCount);
		System.err.println("pageSize:" +pageSize + "currentPage:"+currentPage + "xxx:" + gspecificationType);
		return goodsService.getGoodsSpecifications(pageSize, currentPage, gspecificationType);
	}
	
	@ResponseBody
	@RequestMapping("/goods_specification_name")
	public Object getGoodsSpecificationNames() {
		return goodsService.getGoodsSpecifications();
	}
	
	
	@ResponseBody
	@RequestMapping("/create")
	public Object createGoods(Goods goods, MultipartFile photox) throws IllegalStateException, IOException {
		setPhoto(goods, photox, true);
		return paramToMap("isSucceed" , goodsService.createGoods(goods));
	}
	
	@ResponseBody
	@RequestMapping("/create/goods_specification")
	public Object createGoodsSpecification(GoodsSpecification goodsSpecification) {
		return paramToMap("isSucceed" , goodsService.createGoodsSpecification(goodsSpecification));
	}
	
	@ResponseBody
	@RequestMapping("/edit")
	public Object editGoods(Goods goods, MultipartFile photox) throws IllegalStateException, IOException {
		setPhoto(goods, photox, false);
		return paramToMap("isSucceed" , goodsService.modifyGoods(goods));
	}
	
	@ResponseBody
	@RequestMapping("/edit/goods_specification")
	public Object editGoodsSpecification(GoodsSpecification goodsSpecification) {
		boolean result = false;
		try {
			result = goodsService.modifyGoodsSpecification(goodsSpecification);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return paramToMap("isSucceed" , result);
	}

	
}
