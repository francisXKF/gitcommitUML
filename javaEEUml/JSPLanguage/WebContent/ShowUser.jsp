<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
//http://www.wzsky.net/html/Program/jsp/19281.html
	ArrayList user = (ArrayList)request.getAttribute("user");
	out.println(user);
	
	int i;
	for(i = 0; i < 3; i++){
		out.println(user.get(i) + "<br />");
	}
	
%>
</body>
</html>