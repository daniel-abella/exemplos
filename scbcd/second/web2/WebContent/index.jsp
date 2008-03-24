<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Stateful bean</title>
</head>
<body>
<h2>Stateful bean</h2>
Ao requisitar serviço, se nenhuma entrada é fornecida na caixa de texto,
então entrada anterior não nula será empregada, caso esta exista.

<form action="servico" method="get">
Entrada: <input name="entrada" maxlength="30"><br>
<input type="submit" value="EXECUTE">
</form>

</body>
</html>