package com.lyyzoo.gpss.realm;

import javax.annotation.Resource;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import com.lyyzoo.gpss.api.service.IUserService;
import com.lyyzoo.gpss.api.vo.User;

public class UserRealm extends AuthorizingRealm{
	@Resource
	private IUserService userService;
	
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		String principal = (String) principals.getPrimaryPrincipal();
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		info.addRoles(userService.getRolesByUserId(principal));
		return info;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		String uid = (String) token.getPrincipal();
		String password = new String((char[]) token.getCredentials());
		User user = userService.getUserByUid(uid);
		System.err.println(user);
		if(user == null ) {
			throw new UnknownAccountException("账户" + uid + "不存在");
		}
		if(!user.getPassword().equals(password)) {
			throw new IncorrectCredentialsException("错误的用户名或密码！") ;
		}
		if(user.getLocked() == 1) {
			throw new LockedAccountException(uid + "账户信息已经被锁定，无法登录！") ;
		}
		return new SimpleAuthenticationInfo(uid, password, this.getClass().getName());
	}
}
