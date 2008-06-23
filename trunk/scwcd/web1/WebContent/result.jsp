<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ page import="java.util.List"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Sugestões oferecidas:</h1>
<%
	List<String> sugestoes = (List<String>) request
			.getAttribute("sugestoes");
	for (String sugestao : sugestoes) {
		out.print("<br>" + sugestao);
	}
%>
</body>
</html>