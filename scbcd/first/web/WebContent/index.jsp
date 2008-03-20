<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Tutorial EJB3</title>
</head>
<body>
<h2>Meu primeiro <i>session bean</i>, minha janela para o universo!</h2>
Forneça abaixo uma seqüência de caracteres e pressione o botão EXECUTE.
Um <i>session bean</i> receberá a requisição
<i>String maiusculas(String entrada)</i>, que converte a seqüência de 
entrada em outra contendo apenas letras maiúsculas.

<form action="maiuscula" method="get">
Entrada: <input name="entrada" maxlength="30"><br><br>
<input type="submit" value="EXECUTE">
</form>
</body>
</html>