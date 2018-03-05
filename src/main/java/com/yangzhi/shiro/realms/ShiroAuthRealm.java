package com.yangzhi.shiro.realms;

import java.util.HashSet;
import java.util.Set;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

public class ShiroAuthRealm extends AuthorizingRealm {

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		// TODO Auto-generated method stub
		
		//1. 把 AuthenticationToken转换为 UsernamePasswordToken
		UsernamePasswordToken utoken = (UsernamePasswordToken) token;
		
		//2. 从UsernamePasswordToken获取用户名
		String username = utoken.getUsername();
		
		//3. 调用数据的方法，从数据中查询username对应的用户记录
		System.out.println("从数据库中获取" + username + " 所对应的用户信息");
		
		//4. 若用户不存在，则可以抛出UnknownAccountException
		if("unknown".equals(username)) {
			throw new UnknownAccountException("用户不存在！");
		}
		
		//5. 根据用户信息的情况，决定是够抛出其他的AuthenticationException异常
		if("monster".equals(username)) {
			throw new LockedAccountException("该用户已被锁定！");
		}
		
		//6. 根据用户信息的情况，来构建AuthenticationInfo对象并返回，通常使用的实现类为： SimpleAuthenticationInfo
		// 以下信息是用数据中获取的、
		//1) pricipal: 认证的实体信息， 可以是usename, 也可以是数据表对应的用户的实体类对象
		Object principal = username;
		//2) credentials : 密码
		Object credentials = null;
		if("admin".equals(username)) {
			credentials = "a50190df8f732769b9639c4eb9733270";
		}else {
			credentials = "28cc5b84ef7877c89d67c03a27effafa";
		}
	
		//3) realmName: 当前realm对象的name， 调用父类的getName()方法即可
		String realmName = getName();
		
		//SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(principal, credentials, realmName);
		ByteSource credentialsSalt = ByteSource.Util.bytes(username);
		SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(principal, credentials, credentialsSalt , realmName);
		System.out.println("===============> doGetAuthenticationInfo()  invoke " + token);
		return info;
	}
	
	
	
	
	public static void main(String[] args) {
		String algorithmName = "MD5";
		
		ByteSource salt = ByteSource.Util.bytes("user");
		int iterations = 99;
		Object source = "123456";
		Object result = new SimpleHash(algorithmName, source, salt, iterations);
		System.out.println(result);
	}




	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection arg0) {

		//1. 从PrincipalCollection中获取登录用户的信息
		Object principal = arg0.getPrimaryPrincipal();
		//2. 利用登录的用户信息来获取当前用户的角色或者权限
		Set<String> roles = new HashSet<>();
		roles.add("user");
		if("admin".equals(principal)) {
			roles.add("admin");
		}
		//3. 创建SimpleAuthorizationInfo, 并设置roles的属性
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		info.setRoles(roles);
		//4. 放回SimpleAuthorizationInfo 对象
		return info;
	}
}
