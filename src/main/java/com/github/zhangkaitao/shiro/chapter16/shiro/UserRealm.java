package com.github.zhangkaitao.shiro.chapter16.shiro;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import com.github.zhangkaitao.shiro.chapter16.entity.User;
import com.github.zhangkaitao.shiro.chapter16.service.UserService;

public class UserRealm extends AuthorizingRealm {
	@Autowired private UserService userService;
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		String username = (String)principals.getPrimaryPrincipal();
		SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
		authorizationInfo.setRoles(userService.findRoles(username));
		authorizationInfo.setStringPermissions(userService.findPermissions(username));
		System.out.println(userService.findPermissions(username));
		return authorizationInfo;
	}
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws
	AuthenticationException {
		String username = (String)token.getPrincipal();
		User user = userService.findByUsername(username);
		if(user == null) {
			throw new UnknownAccountException();//没找到帐号
		}
		if(Boolean.TRUE.equals(user.getLocked())) {
			throw new LockedAccountException(); //帐号锁定
		}
		return new SimpleAuthenticationInfo(
				user.getUsername(), //用户名
				user.getPassword(), //密码
				ByteSource.Util.bytes(user.getSalt()),//salt=username+salt
				getName() //realm name
				);
	}
}