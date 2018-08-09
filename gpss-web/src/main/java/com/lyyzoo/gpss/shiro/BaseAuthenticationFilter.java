package com.lyyzoo.gpss.shiro;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.shiro.authc.AuthenticationToken;
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
		req.getSession().setAttribute("user", user);
		return super.onLoginSuccess(token, subject, request, response);
	}

	private String randname = "captcha";
	private String randparam = "code";

	@Override
	protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
//		HttpSession session = ((HttpServletRequest) request).getSession();
//		String rand = (String) session.getAttribute(this.randname);
//		String code = request.getParameter(this.randparam);
//		if (rand == null || "".equals(rand) || code == null || "".equals(code)) {
//			request.setAttribute("error", "验证码不允许为空");
//			return true;
//		} else {
//			if (!rand.equalsIgnoreCase(code)) {
//				request.setAttribute("error", "验证码输入有误");
//				return true;
//			}
//		}
		return super.onAccessDenied(request, response);
	}

}
