<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html>
<head>
<%-- 可解决超链接使用相对路径时路劲错误问题 --%>
<base href="<%=basePath%>">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="this is my page">
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Do Login Page</h1>
	<form action="shiro/login" method="post">
		<dl>
			<dd>
				<label for="username">用户名：</label> <input id="username"
					name="username" placeholder="请输入用户名" />
			</dd>
		</dl>
		<dl>
			<dd>
				<label for="passsword">密&nbsp;&nbsp;&nbsp;码：</label> <input
					type="password" id="password" name="password" placeholder="请输入密码" />
			</dd>
		</dl>
		<dl>
			<dd>
				<input type="submit" value="登录" />
		</dl>
	</form>
</body>
</html>