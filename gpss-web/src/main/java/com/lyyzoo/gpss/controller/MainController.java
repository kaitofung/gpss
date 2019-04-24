package com.lyyzoo.gpss.controller;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import javax.annotation.Resource;
import javax.servlet.ServletException;
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
@RequestMapping("/")
public class MainController extends AbstractController implements IMappingParameter {

	@Resource
	private IMenuService menuService;
	
	@RequestMapping("/")
	public void main(HttpServletResponse response) throws ServletException, IOException {
		if(getRequest().getSession().getAttribute("user") != null) {
			User user =  (User) getRequest().getSession().getAttribute("user");
			setRequestAttribute("role", user.getRoleCode());
			setRequestAttribute("role2", "");
			List<Menu> menus = menuService.getMenus(paramToMap("menuLevel", 1));
			List<Menu> menus2 = menuService.getMenus(paramToMap("menuLevel", 2));
			setRequestAttribute("menus", menus);
			setRequestAttribute("menus2", menus2);
			response.sendRedirect(getRequest().getContextPath()+"/user/adminsystem");
		} else {
			response.sendRedirect(getRequest().getContextPath()+"/user/login");
		}
	}
}
