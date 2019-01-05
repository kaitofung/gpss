package com.lyyzoo.gpss.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Semaphore;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gpss.common.utils.BeanUtils;
import com.gpss.common.utils.CaptchaUtil;
import com.gpss.common.utils.IMappingParameter;
import com.lyyzoo.gpss.api.service.IUserService;
import com.lyyzoo.gpss.api.vo.Employee;
import com.lyyzoo.gpss.api.vo.User;

@Controller
@RequestMapping("/user")
public class UserController extends AbstractController implements IMappingParameter {
	@Resource
	private IUserService userService;
	
	@ResponseBody
	@RequestMapping("/tests")
	public Object test() {
		return "It works!!";
	}
	
	@RequestMapping("/login")
	public Object login() {
		return "login";
	}
	
	@RequestMapping("/welcome")
	public Object welcome() {
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
	@RequestMapping("/user_data_items")
	public Object userDataItems(int pageSize , Long currentPage) {
		return userService.getUsersDataItem(pageSize, currentPage);
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
		System.err.println(uid);
		System.err.println(newPassword);
		boolean isSuccessful = userService.modifyUserProfile(paramToMap("uid", uid ,"newPassword", newPassword)) > 0;
		return paramToMap("isSuccessful",isSuccessful);
	}
	
	
	
	
}
