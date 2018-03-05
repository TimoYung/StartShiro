<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
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
	<h1>UnauthorizedUrl！</h1>
</body>
</html>