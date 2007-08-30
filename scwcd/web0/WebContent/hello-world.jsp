<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Uma aplicação simples (web0)</title>
</head>
<body>
<h1>Hello, world.</h1>
<%
	String user = request.getParameter("user");
	String person = user != null ? (String) request.getAttribute("fullName") : "?";
%>
Welcome to WTP, <b><%= person %></b>!
</body>
</html>