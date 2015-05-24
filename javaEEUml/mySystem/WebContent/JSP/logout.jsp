<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>LOGOUT page</title>
</head>
<body>
<%
	session.setAttribute("nowuser", null);
%>
<h1>再见！</h1>
<%
	out.print("5秒之后跳转到主界面");
	response.setHeader("refresh", "5; url=/mySystem/");
%>
</body>
</html>