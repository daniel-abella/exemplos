<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
O nome fornecido foi:<br/><b>
<%= request.getAttribute("nome") %>
</b>

<br/><br/>
O nome fornecido foi: (agora usando el)<br/>
<b>${requestScope.nome}</b>
</body>
</html>