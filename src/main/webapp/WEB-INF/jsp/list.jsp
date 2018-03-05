<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://shiro.apache.org/tags" prefix="shiro"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>This is List page</h1>
	Welecome:
	<shiro:principal></shiro:principal>
	<shiro:hasRole name="admin">
		<a href="shiro/admin.do">Admin Page</a>
		<br>
		<br>
	</shiro:hasRole>
	<a href="shiro/user.do">User Page</a>
	<br>
	<br>
	<shiro:hasRole name="user"></shiro:hasRole>

	<a href="shiro/logout">Logout</a>
	<br>
	<br>

</body>
</html>