<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Resultado</title>
</head>
<body>
<h2>Resultado obtido</h2>
Entrada: <b><%= request.getParameter("entrada") %></b><br>
Sa�da: <b><%= request.getAttribute("resultado") %></b>
<hr>
<form action="/web/index.jsp" method="get">
<input type="submit" value="Experimente novamente...">
</form>
</body>
</html>