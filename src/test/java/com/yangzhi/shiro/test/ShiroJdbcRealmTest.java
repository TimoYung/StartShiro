package com.yangzhi.shiro.test;

import static org.junit.Assert.fail;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.apache.shiro.util.ThreadContext;
import org.junit.After;
import junit.framework.Assert;
import org.junit.Test;

/**
 * @Author: TimoYung
 * @Date  : 2017年10月3日 下午11:46:06
 */
public class ShiroJdbcRealmTest {

	@Test
	public void test() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testJdbcRealm() {
		//1、获取SecurityManager工厂，此处使用Ini配置文件初始化SecurityManager
		Factory<SecurityManager> factory = 
				new IniSecurityManagerFactory("classpath:shiro-jdbc-realm.ini");
		
		//2、得到SecurityManager实例，并绑定给SecurityUtils
		SecurityManager securityManager = factory.getInstance();
		SecurityUtils.setSecurityManager(securityManager);
		
		//3、得到Subject及床架用户名与密码身份验证Token
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken("zhang","123");
		
		try {
			subject.login(token);
		} catch (AuthenticationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Assert.assertEquals(true, subject.isAuthenticated());
		
		//6、退出
        subject.logout();
	}
	
	 @After
	    public void tearDown() throws Exception {
	        ThreadContext.unbindSubject();//退出时请解除绑定Subject到线程 否则对下次测试造成影响
	    }

}
