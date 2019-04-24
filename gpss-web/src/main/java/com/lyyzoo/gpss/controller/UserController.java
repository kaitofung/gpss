package com.lyyzoo.gpss.controller;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gpss.common.utils.BeanUtils;
import com.gpss.common.utils.CaptchaUtil;
import com.gpss.common.utils.IMappingParameter;
import com.lyyzoo.gpss.api.service.IMenuService;
import com.lyyzoo.gpss.api.service.IRoleService;
import com.lyyzoo.gpss.api.service.IUserService;
import com.lyyzoo.gpss.api.vo.Employee;
import com.lyyzoo.gpss.api.vo.Menu;
import com.lyyzoo.gpss.api.vo.Role;
import com.lyyzoo.gpss.api.vo.User;
import com.lyyzoo.gpss.api.vo.UsersDataItem;

@Controller
@RequestMapping("/user")
public class UserController extends AbstractController implements IMappingParameter {
	@Resource
	private IUserService userService;
	@Resource
	private IMenuService menuService;
	@Resource
	private IRoleService roleService;
	
	@ResponseBody
	@RequestMapping("/admin")
	public Object testx() {
		return "admin";
	}
	
	@ResponseBody
	@RequestMapping("/roles")
	public Object roles() {
		List<Role> list = roleService.getRoles(null, Integer.MAX_VALUE, 1L);
		return list;
	}
	
	
	@RequestMapping("/login")
	public Object login(String loginTag) {
		getRequest().getSession().setAttribute("loginTag", this.hashCode());
		return "login";
	}
	
	@RequestMapping("/logining")
	public Object logining(String uid, String password, HttpServletResponse response) {
		System.err.println(uid+"   " + password);
		AuthenticationToken token = new UsernamePasswordToken(uid,password);
		try {
			SecurityUtils.getSubject().login(token);
			setRequestAttribute("role", "admin");
			setRequestAttribute("role2", "");
			List<Menu> menus = menuService.getMenus(paramToMap("menuLevel", 1));
			List<Menu> menus2 = menuService.getMenus(paramToMap("menuLevel", 2));
			setRequestAttribute("menus", menus);
			setRequestAttribute("menus2", menus2);
			return "/adminsystem";
		} catch (Exception e) {
			e.printStackTrace();
			getRequest().setAttribute("error", e);
			return "login";
		}
	}
	
	
	@RequestMapping("/welcome")
	public Object welcome() {
		System.err.println(getRequest().getSession().getAttribute("user"));
		return "welcome";
	}
	
	@RequestMapping("/logout")
	public Object logout() {
		return "login";
	}
	
	@ResponseBody
	@RequestMapping("/lock")
	public Object lockUser(User user) {
		if(Objects.isNull(user)) return paramToMap("isSucceed" , false);
		
		return user.getLocked() == 1 
				? paramToMap("isSucceed" , userService.lockUser(user))
				: paramToMap("isSucceed" , userService.unlockUser(user));
	}
	
	@RequestMapping("/captcha")
	public Object captch() {
		HttpServletResponse response = (HttpServletResponse) getResponse();
		response.setContentType("image/jpeg");// 设置相应类型,告诉浏览器输出的内容为图片
        response.setHeader("Pragma", "No-cache");// 设置响应头信息，告诉浏览器不要缓存此内容
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expire", 0);
        CaptchaUtil randomValidateCode = new CaptchaUtil();
        try {
            randomValidateCode.getRandcode(getRequest(), response);// 输出图片方法
        } catch (Exception e) {
            e.printStackTrace();
        }
		return "captcha";
	}
	
	@RequestMapping("/adminsystem")
	public Object adminSystem() {
		User user =  (User) getRequest().getSession().getAttribute("user");
		setRequestAttribute("role", user.getRoleCode());
		setRequestAttribute("role2", "");
		List<Menu> menus = menuService.getMenus(paramToMap("menuLevel", 1));
		List<Menu> menus2 = menuService.getMenus(paramToMap("menuLevel", 2));
		setRequestAttribute("menus", menus);
		setRequestAttribute("menus2", menus2);
		return "adminsystem";
	}
	
	@ResponseBody
	@RequestMapping("/delete/employee_delete")
	public Object deleteEmployee(@RequestParam("eids[]") List<String> eids) {
		boolean result = false;
		try {
			result = userService.removeEmployees(eids);
		} catch (Exception e) {
			// 可能因为外键不能删除
		}
		return paramToMap("isSucceed", result);
	}
	
	@RequestMapping("/user_manage")
	public Object userManage() {
		getRequest().setAttribute("userDataCount", userService.getAllUserDataItemCount());
		return "user_manage";
	}
	
	@RequestMapping("/employee_manage")
	public Object employeeManage() {
		return "employee_manage";
	}
	
	@ResponseBody
	@RequestMapping("/employee_types")
	public Object employeeTypes() {
		return userService.getEmployeeTypes();
	}
	
	@ResponseBody
	@RequestMapping("/employees")
	public Object employees(int pageSize , Long currentPage, String name, String etypeid) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("total", userService.getEmployeesCount(paramToMap("name", name, "etypeid", etypeid)));
		List<Employee> list = userService.getEmployees(pageSize, currentPage, name, etypeid);
		map.put("rows", list);
		return map;
	}
	
	@ResponseBody
	@RequestMapping("/create/employee_create")
	public Object createEmployee(Employee employee) {
		employee.setUpdatedtime(new Date());
		return paramToMap("isSucceed", userService.addEmployee(employee));
	}
	
	@ResponseBody
	@RequestMapping("/edit/employee_edit")
	public Object employeeModify(Employee employee) {
		employee.setUpdatedtime(new Date());
		Map<String,Object> params = BeanUtils.beanToMap(employee);
		return paramToMap("isSucceed", userService.modifyEmployData(params));
	}
	
	@ResponseBody
	@RequestMapping("/create/user_data_items")
	public Object createUserDataItem(UsersDataItem userDataItem) {
		List<Employee> employees = userService.getEmployees(1, 1L, userDataItem.getRealName(), null);
		Employee employee  =  (employees != null) && employees.size() > 0 ? employees.get(0) : null;
		Map<String, Object> responseData = paramToMap("isSucceed", false);
		if(employee == null) {
			responseData.put("resultMessage", "入职员工没有此员工");
			return responseData;
		}
		User user = new User();
		user.setEid(employee.getEid());
		user.setLocked(0);
		user.setUid(userDataItem.getUid());
		user.setName(userDataItem.getNickName());
		user.setPassword(userDataItem.getPassword());
		user.setName(userDataItem.getNickName());
		user.setUpdatedTime(new Date());
		boolean addUserFlag = userService.addUser(user);
		boolean addUserRoleFlag = false;
		if(addUserFlag) {
			addUserRoleFlag = userService.addUserRole(userDataItem);
			return paramToMap("isSucceed", addUserRoleFlag);
		}
		return paramToMap("isSucceed", addUserFlag);
	}
	
	@ResponseBody
	@RequestMapping("/edit/user_data_items")
	public Object editUserDataItem(UsersDataItem userDataItem) {
		User user = new User();
		user.setUid(userDataItem.getUid());
		user.setName(userDataItem.getNickName());
		user.setPassword(userDataItem.getPassword());
		user.setName(userDataItem.getNickName());
		user.setUpdatedTime(new Date());
		
		boolean editUserFlag = userService.modifyUser(user);
		boolean editUserRoleFlag = false;
		if(editUserFlag) {
			editUserRoleFlag = userService.modifyUserRole(userDataItem);
			return paramToMap("isSucceed", editUserRoleFlag);
		}
		return paramToMap("isSucceed", editUserFlag);
	}
	
	@ResponseBody
	@RequestMapping("/user_data_items")
	public Object userDataItems(int pageSize , Long currentPage, UsersDataItem userDataItem) {
		Map<String,Object> map = new HashMap<String,Object>();
		Map<String,Object> params = BeanUtils.beanToMap(userDataItem);
		map.put("total", userService.getUsersDataItemCount(params));
		List<UsersDataItem> list = userService.getUsersDataItem(BeanUtils.beanToMap(userDataItem), pageSize, currentPage);
		map.put("rows", list);
		return map;
	}
	
	@ResponseBody
	@RequestMapping("/modify_employee_data")
	public Object modifyEmployeeData(String eid,
			String updaterId,
			String realName,
			String etypeid,
			Date birthday,
			String mobile) {
		Map<String,Object> map = paramToMap("eid", eid,
				"updater" , updaterId,
				"name" , realName,
				"etypeid", etypeid,
				"birthday", birthday,
				"updatedtime", new Date(),
				"mobile", mobile);
		map.put("userManage", true);
		return paramToMap("isSuccessful" , userService.modifyEmployData(map) > 0);
	}
	
	@RequestMapping("/modify_user_profile")
	public Object modifyUserProfile() {
		return "modify_user_profile";
	}
	
	@ResponseBody
	@RequestMapping("/process_modify_user_profile")
	public Object processModifyUserProfile(String uid, String password, String newPassword ,String newPasswordAgain) {
		if(Objects.isNull(uid) || Objects.isNull(password) || Objects.isNull(newPassword) || Objects.isNull(newPasswordAgain)) {
			return paramToMap("isSuccessful",false);
		}
		boolean isSuccessful = userService.modifyUserProfile(paramToMap("uid", uid ,"newPassword", newPassword)) > 0;
		return paramToMap("isSuccessful",isSuccessful);
	}
	
	
	
	
}
