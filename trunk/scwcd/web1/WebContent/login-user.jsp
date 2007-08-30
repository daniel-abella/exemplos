<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
	String error_message = "";
	Object error = request.getAttribute("error");
	if (error != null) error_message = error.toString();
	String data =  new java.util.Date().toString(); 
%>
<h3>Data: <%= data %></h3>
<form action="HelloServlet">
<table cellspacing="4">
	<tr>
		<td>Enter your user name:</td>
		<td><input name="user" type="text" size="20"></td>
		<td style="color: red"><%= error_message %></td>
	</tr>
	<tr>
		<td/>
		<td><input type="submit" value="Login"></td>
		<td></td>
	</tr>
</table>
</form>
</body>
</html>