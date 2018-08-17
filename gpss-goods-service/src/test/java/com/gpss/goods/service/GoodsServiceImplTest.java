package com.gpss.goods.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.lyyzoo.gpss.api.service.IGoodsService;
import com.lyyzoo.gpss.api.vo.GoodsSpecification;


@ContextConfiguration(locations = { "classpath*:spring/spring-*.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class GoodsServiceImplTest  {

	@Resource 
	private IGoodsService goodsService;
	
//	@Test
//	public void testGetGoodses() {
//		System.out.println(goodsService.getGoodses(2, 1L));
//	}
	
//	@Test
//	public void testGetGoodses() {
//		System.out.println(goodsService.getGoodses(2, 1L, "可乐"));
//	}
	
//	@Test
//	public void testGetGoodsesCount() {
//		System.out.println(goodsService.getGoodsesCount());
//	}
	
//	@Test
//	public void testGetGoodsesCountByName() {
//		System.out.println("xxx"+goodsService.getGoodsesCount("可乐"));
//	}
//	@Test
//	public void testGetGoodsSpecifications() {
//		System.out.println(goodsService.getGoodsSpecifications("瓶"));
//	}
//	@Test
//	public void testGetGoodsSpecificationCount() {
//		System.out.println(goodsService.getGoodsSpecificationsCount("瓶"));
//	}
//	@Test
//	public void testGetGoodsSpecificationTypes() {
//		System.out.println(goodsService.getGoodsSpecificationTypes());
//	}
	
//	@Test
//	public void testDeleteGoodsSpecifications() {
//		List<String> list = new ArrayList<>();
//		list.add("1");
//		System.out.println(goodsService.deleteGoodsSpecifications(list));
//	}
//	@Test
//	public void testDeleteGoodses() {
//		List<String> list = new ArrayList<>();
//		list.add("1");
//		System.out.println(goodsService.deleteGoodses(list));
//	}
	
	
	
//	@Test
//	public void testGetGoodsTypes() {
//		System.out.println(goodsService.getGoodsType());
//	}
//	@Test
//	public void testGetGoodsSpecifications() {
//		System.err.println(goodsService.getGoodsSpecifications(2, 1L, "瓶")+ "!!!");
//	}
	
//	@Test
//	public void testGetStorages() {
//		System.out.println(storageService.getStoragesByName("仓", 8, 1L));
//	}
//	@Test
//	public void testCreateGoods() {
//		Goods goods =new Goods();
//		goods.setDescription("good");
//		goods.setGspecification_id("2");
//		goods.setGtype_id("2");
//		goods.setName("xxxxx");
//		goods.setPhoto("D:\\mldn_workspace\\ssm2\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp1\\wtpwebapps\\gpss-web\\upload\\764cf34b-c021-41bd-aa45-6ec3ee7104b1.txt");
//		goods.setPrice(5);
//		goods.setProducer("太极");
//		System.out.println(goodsService.createGoods(goods));
//	}
//	@Test
//	public void testCreateGoodsSpecification() {
//		GoodsSpecification gs = new GoodsSpecification();
//		gs.setDescription("xxxxx");
//		gs.setGspecificationType("xxxxxxxxx");
//		gs.setName("xxxxxxxxxxxxxxxxxxxx");
//		System.out.println(goodsService.createGoodsSpecification(gs));
//	}
	
	@Test
	public void testEditStorage() {
		GoodsSpecification gs = new GoodsSpecification();
		gs.setGspecificationId("8");
		gs.setDescription("xxxxxxx");
		gs.setGspecificationType("xx");
		gs.setName("111");
		System.out.println(goodsService.modifyGoodsSpecification(gs));
	}
//	@Test
//	public void testEditStorage() {
//		Goods goods = new Goods();
//		goods.setName("xxxx");
//		goods.setDescription("xxxxxx");
//		goods.setGid("12");
//		goods.setGspecification_id("1");
//		goods.setGtype_id("1");
//		goods.setPhoto("xxxx");
//		goods.setPrice(0.424f);
//		goods.setProducer("xxxxf");
//		System.out.println(goodsService.modifyGoods(goods));
//	}
	
//	@Test
//	public void testCreateStorage() {
//		Storage storage = new Storage();
//		storage.setName("55");
//		storage.setAddress("zz");
//		storage.setDescription("zz");
//		storage.setMobile("13545699875");
//		storage.setEname("xx");
//		System.out.println(storageService.createStorage(storage));
//	}
}
