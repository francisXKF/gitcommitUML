<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Index</title>
</head>
<body>
<%
	String nowuser = (String)session.getAttribute("nowuser");
	if(nowuser == null){
		out.print("<a href='/mySystem/JSP/login.jsp'>login</a>");
	}
	else{
		out.print("<a href='/mySystem/JSP/logout.jsp'>logout</a>");
	}
%>
<a href="/mySystem/JSP/register.jsp">Register</a>
</body>
</html>