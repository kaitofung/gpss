package com.gpss.marketing.service;

import java.util.Date;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.lyyzoo.gpss.api.service.IClientService;
import com.lyyzoo.gpss.api.vo.Client;


@ContextConfiguration(locations = { "classpath*:spring/spring-*.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class ClientServiceImplTest  {

	@Resource 
	private IClientService clientService;
	
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
//	public void testGetClientsCount() {
//		System.out.println(clientService.getClientsCount(""));
//	}
//	@Test
//	public void testGetClients() {
//		System.out.println(clientService.getClients(2, 1L, "啊啊"));
//	}
	
//	@Test
//	public void testDeleteClients() {
//		List<String> list = new ArrayList<>();
//		list.add("1");
//		list.add("6");
//		System.out.println(clientService.deleteClients(list));
//	}
	
	
	
	
	
	@Test
	public void testEditClient() {
			Client client = new Client();
			client.setCid("3");
			client.setAddress("北京市xxx");
			client.setContacts("Tomxxx");
			client.setDescription("重要客户xx");
			client.setName("大客户呀xxxxxxxxxx " );
			client.setPhoneNum("13555666999");
			client.setUpdatedTime(new Date());
			System.out.println(clientService.editClient(client));
	}
//	@Test
//	public void testCreateClient() {
//		int i = 0;
//		while(true) {
//			Client client = new Client();
//			client.setAddress("北京市");
//			client.setContacts("Tom");
//			client.setDescription("重要客户");
//			client.setName("大客户呀 " + i);
//			client.setPhoneNum("13546998562");
//			client.setUpdatedTime(new Date());
//			System.out.println(clientService.createClient(client));
//			i ++;
//			if(i == 10) {
//				break;
//			}
//		}
//	}
//	@Test
//	public void testCreateGoodsSpecification() {
//		GoodsSpecification gs = new GoodsSpecification();
//		gs.setDescription("xxxxx");
//		gs.setGspecificationType("xxxxxxxxx");
//		gs.setName("xxxxxxxxxxxxxxxxxxxx");
//		System.out.println(goodsService.createGoodsSpecification(gs));
//	}
	
//	@Test
//	public void testEditStorage() {
//		GoodsSpecification gs = new GoodsSpecification();
//		gs.setGspecificationId("8");
//		gs.setDescription("xxxxxxx");
//		gs.setGspecificationType("xx");
//		gs.setName("111");
//		System.out.println(goodsService.modifyGoodsSpecification(gs));
//	}
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
