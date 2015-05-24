<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>LOGIN</title>
</head>
<body>
<%
	String transmessage = (String)request.getAttribute("transmessage");
%>
<div align="center">
	<%
		if(transmessage != null){
			out.print(transmessage + "<br />");
			request.setAttribute("transmessage", null); 
		}
	%>
	<form action="/mySystem/login-judge" method="post">
		schoolID: <input type="text" name="schoolID" value="" /><br/>
		UserName: <input type="text" name="username" value="" /><br/>
		Password: <input type="password" name="password" value="" /><br/>
		<input type="submit" value="提交" /><br/>
	</form>
</div>
</body>
</html>