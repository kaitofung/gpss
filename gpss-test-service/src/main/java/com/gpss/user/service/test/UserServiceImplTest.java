package com.gpss.user.service.test;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.lyyzoo.gpss.api.service.IUserService;

@ContextConfiguration(locations= {"classpath:spring/spring-*.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class UserServiceImplTest {
	@Resource 
	private IUserService userService;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
	}

	@Test
	public void testAddUser() {
//		User user = new User();
//		user.setLock(0);
//		user.setPassword("r3tt4t");
//		user.setUid("t34t43t");
//		user.setUname("testffew");
//		System.out.println(userService.addUser(user));
	}

//	@Test
//	public void testGetUserByName() {
//		System.out.println(userService.getUserByUid("xx"));
//	}
	
//	@Test
//	public void testModifyUserProfile() {
//		Map<String,Object> map = new HashMap<String,Object>();
//		map.put("newpassword", 123456);
//		map.put("uid", "admin001");
//		System.out.println(userService.modifyUserProfile(map));
//	}
	
//	@Test
//	public void testModifyEmployData() {
//		Map<String,Object> map = new HashMap<String,Object>();
//		map.put("eid", 2);
//		map.put("mobile", "111156165156");
//		map.put("birthday", new Date());
//		map.put("eid", 2);
//		map.put("etypeid", 2);
//		map.put("updatedtime", new Date());
//		map.put("name", "欧阳先生QQ");
//		map.put("updater", "admin001");
//		System.out.println(userService.modifyEmployData(map));
//	}
	
	@Test
	public void testgetUsersDataItemCount() {
		System.out.println(userService.getAllUserDataItemCount());
	}
	
	
//	@Test
//	public void testGetUserRoles() {
//		User user = new User();
//		user.setUid("admin001");
//		System.out.println(userService.getRolesByUser(user));
//	}
	
//	@Test
//	public void testLockUser() {
//		System.out.println(userService.lockUser("admin001"));
//	}

//	@Test
//	public void testUnlockUser() {
//		System.out.println(userService.unlockUser("admin001"));
//	}

}
