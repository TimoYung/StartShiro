package com.yangzhi.shiro.handlers;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/shiro")
public class ShiroHandler {

	@RequestMapping("/login")
	public String login(@RequestParam("username")String username, @RequestParam("password")String password) {
		
		Subject subject =  SecurityUtils.getSubject();
		
		if(!subject.isAuthenticated()) {
			UsernamePasswordToken token = new UsernamePasswordToken(username, password);
			token.setRememberMe(true);
			try {
				subject.login(token);
			}catch(AuthenticationException e) {
				System.out.println("登录失败 \n" + e.getMessage());
			}
		}
		return "redirect:/shiro/list.do";
	}
	
	@RequestMapping("/user.do")
	public String user() {
		
		return "user";
	}
	
	@RequestMapping("/admin.do")
	public String admin() {
		
		return "admin";
	}
	
	@RequestMapping("/list.do")
	public String list() {
		
		return "list";
	}
}
