<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Welcome page</title>
</head>
<style>
	body{
		background-image: url(../welcome.jpg);
        background-color: #393;
	}
</style>
<body>
<%
	String transmessage = (String)request.getAttribute("transmessage");
%>
<h1>
	<%
		if(transmessage != null){
			out.print(transmessage + "<br />");
			request.setAttribute("transmessage", null); 
		}
		out.print("5秒之后跳转到主界面");
		response.setHeader("refresh", "5; url=/mySystem/");
	%>
</h1>
</body>
</html>