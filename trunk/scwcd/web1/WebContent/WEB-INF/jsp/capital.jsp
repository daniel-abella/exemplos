<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Simple forward with states</title>
</head>
<body>
<h1>Servlet forward to JSP</h1>

<form action="capital">
	<input type="text" name="estado" size="3" maxlength="2" value="${param.estado}">
	<input type="submit" value="OK">
	<c:if test="${empty param.estado}">
		<hr>
		Forne�a um estado!
	</c:if>
	<c:if test="${!empty param.estado}">
		<hr>
		A capital de ${param.estado} � ${capital}
	</c:if>
</form>

</body>
</html>