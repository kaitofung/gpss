package com.lyyzoo.gpss.shiro;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;

import com.lyyzoo.gpss.api.service.IUserService;
import com.lyyzoo.gpss.api.vo.User;

public class BaseAuthenticationFilter extends FormAuthenticationFilter {

	@Resource
	IUserService userService;

	@Override
	protected boolean onLoginSuccess(AuthenticationToken token, Subject subject, ServletRequest request,
			ServletResponse response) throws Exception {
		HttpServletRequest req = (HttpServletRequest) request;
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("accountNum", (String) (subject.getPrincipal()));
		User user = userService.getUserByUid(token.getPrincipal().toString());
		SecurityUtils.getSubject().getSession().setAttribute("user", user);
		System.err.println("登录成功！！！！！");
		return super.onLoginSuccess(token, subject, request, response);
	}

	private String randname = "rand";
	private String randparam = "code";

	
	
	public String getRandname() {
		return randname;
	}



	public void setRandname(String randname) {
		this.randname = randname;
	}



	public String getRandparam() {
		return randparam;
	}



	public void setRandparam(String randparam) {
		this.randparam = randparam;
	}


	@Override
	protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
		HttpSession session = ((HttpServletRequest) request).getSession();
		String rand = (String) session.getAttribute(this.randname);
		String code = request.getParameter(this.randparam);
		if((rand == null && code == null)) {
			return true;
		}
		if ((rand == null || "".equals(rand) || code == null || "".equals(code))) {
			System.err.println("验证码不允许为空 " + " code = "+ code);
			request.setAttribute("error", "验证码输入有误");
			return true;
		} else {
			if (!rand.equalsIgnoreCase(code)) {
				request.setAttribute("error", "验证码输入有误");
				return true;
			}
		}
		setFirstLoginTag(session);
		System.err.println("访问拒绝？！");
		System.err.println(getFailureKeyAttribute());
		return super.onAccessDenied(request, response);
	}
	
	@Override
	protected boolean onLoginFailure(AuthenticationToken token, AuthenticationException e, ServletRequest request,
			ServletResponse response) {
		System.err.println("登录失败");
//		if(e instanceof UnknownAccountException) {
//			request.setAttribute("error", "此用户不存在");
//		} else if (e instanceof IncorrectCredentialsException) {
//			request.setAttribute("error", "错误的用户名或密码");
//		} else if(e instanceof LockedAccountException) {
//			request.setAttribute("error", "用户已被锁定");
//		} else {
//			request.setAttribute("error", "系统出现未知错误");
//		}
		return super.onLoginFailure(token, e, request, response);
	}



	private void setFirstLoginTag(HttpSession session) {
		session.setAttribute("firstLogin", System.currentTimeMillis());
	}
	

}
