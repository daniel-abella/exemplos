<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Uma aplica��o simples (web0)</title>
</head>
<body>
<h1>Seja bem-vinda(o)!</h1>
<%
	String user = request.getParameter("usuario");
	String person = user != null ? (String) request.getAttribute("fullName") : null;
	if (person == null) {
%>
Usu�rio '<%= user %>' n�o encontrado. Tente novamente.
<% 
	} else {
%>
Usu�rio: <%= user %><br>
Nome completo: <b><%= person %></b>
<%
	}
%>
<br>Deseja experimentar outro usu�rio? Clique <a href="index.jsp">aqui</a>.
</body>
</html>