package com.lyyzoo.gpss.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.CountDownLatch;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.gpss.common.utils.IMappingParameter;
import com.lyyzoo.gpss.api.service.IGoodsService;
import com.lyyzoo.gpss.api.vo.Client;
import com.lyyzoo.gpss.api.vo.Goods;
import com.lyyzoo.gpss.api.vo.GoodsSpecification;

@Controller
@RequestMapping("/goods")
public class GoodsController extends AbstractController implements IMappingParameter {
	@Resource
	private IGoodsService goodsService;
	
	static class Test{
		private int id;
		private  String name;
		private double price;
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public double getPrice() {
			return price;
		}
		public void setPrice(double price) {
			this.price = price;
		}
	}
	private static List<Test> tests = new ArrayList<>();
	private static List<Map<String,Object>> testsxx = new ArrayList<>();
	static {
		for (int i = 0; i < 50000; i++) {
			Test test = new Test();
			test.id = i;
			test.name = "xx" +i;
			test.price = i +55;
			tests.add(test);
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("roleId", i);
			map.put("roleName", "测试" + i);
			map.put("remark", "管理员" + i);
			map.put("createTime", System.currentTimeMillis());
			map.put("modifyTime", System.currentTimeMillis());
			testsxx.add(map);
		}
	}
	@ResponseBody
	@RequestMapping("/data1")
	public Object goodsParamManagex(int limit, int offset) {
		int end = limit + offset;
		int count = 1;
		List<Test> testsx = new ArrayList<>();
		while(true) {
			testsx.add(tests.get(offset));
			offset ++;
			if(offset > end) {
				break;
			}
		}
		return testsx;
	}
	static class Role{
		private int roleId;
		private String roleName;
		private String remark;
		private long createTime;
		private long modifyTime;
	}
	
	@ResponseBody
	@RequestMapping("/roles")
	public Object getGoodsesxx(int pageSize, int pageNum, String roleName) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("total", testsxx.size());
		int offset = pageNum *pageSize - pageSize;
		int end = offset + pageSize -1;
		List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
		while(true) {
			list.add(testsxx.get(offset));
			offset ++;
			if(offset > end ) {
				break;
			}
		}
		map.put("rows", list);
		return map;
	}
	
	@ResponseBody
	@RequestMapping("/departments")
	public Object departments(String name) {
		List<Map<String,Object>> list = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			Map<String,Object> map = new HashMap<>();
			map.put("deptId", i);
			map.put("parentId",new Random().nextInt(5));
			map.put("deptName", "开发"+i+"部");
			map.put("orderNum", new Random().nextInt(5));
			map.put("createTime", System.currentTimeMillis());
			list.add(map);
		}
		return list;
	}
	@ResponseBody
	@RequestMapping("/TestMVC/GetData")
	public Object departmentsx(String name) {
		List<Map<String,Object>> list = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			Map<String,Object> map = new HashMap<>();
			map.put("Id", i);
			map.put("Name", "开发"+i+"部");
			map.put("Desc", new Random().nextInt(50));
			list.add(map);
		}
		for (int i = 5; i < 10; i++) {
			Map<String,Object> map = list.get(i);
			map.put("ParentId", new Random().nextInt(3));
		}
		return list;
	}
	
	@ResponseBody
	@RequestMapping("/goodses")
	public Object getGoodses(int pageSize, Long currentPage, String name) {
		long goodsesCount = goodsService.getGoodsesCount(name);	
		setRequestAttribute("goodsesCount", goodsesCount);
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("total", goodsesCount);
		List<Goods> list = goodsService.getGoodses(pageSize, currentPage, name);
		map.put("rows", list);
		return map;
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
		setRequestAttribute("goodsesCount", goodsesCount);
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
		setRequestAttribute("gspecificationCount", gspecificationCount);
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("total", gspecificationCount);
		List<GoodsSpecification> list = goodsService.getGoodsSpecifications(pageSize, currentPage, gspecificationType);
		map.put("rows", list);
		return map;
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
