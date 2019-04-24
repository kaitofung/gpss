package com.lyyzoo.gpss.filter;

import javax.annotation.Resource;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.AccessControlFilter;

import com.lyyzoo.gpss.api.service.IUserService;
import com.lyyzoo.gpss.api.vo.User;

public class UserSetting extends AccessControlFilter {

	@Resource
	private IUserService userService;

	@Override
    protected boolean preHandle(ServletRequest request, ServletResponse response) throws Exception {
       System.err.println("rememberMe-->preHandle");
		Subject subject = getSubject(request, response);
        if (subject == null) {
            return false;
        }
        HttpSession session = ((HttpServletRequest)request).getSession();
        User current_user = (User) session.getAttribute("user");
        //判断session是否失效，若失效刷新之
        if(current_user == null ){
        	String uid = (String) subject.getPrincipal();
        	User user = userService.getUserByUid(uid);	
        	session.setAttribute("user", user);
        }
        return true;
    }

	@Override
	protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue)
			throws Exception {
		System.err.println("rememberMe-->isAccessAllowed");
		return true;
	}

	@Override
	protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
		System.err.println("rememberMe-->onAccessDenied");
		return true;
	}
}