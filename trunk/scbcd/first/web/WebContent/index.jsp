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
Forne�a abaixo uma seq��ncia de caracteres e pressione o bot�o EXECUTE.
Um <i>session bean</i> receber� a requisi��o
<i>String maiusculas(String entrada)</i>, que converte a seq��ncia de 
entrada em outra contendo apenas letras mai�sculas.

<form action="maiuscula" method="get">
Entrada: <input name="entrada" maxlength="30"><br><br>
<input type="submit" value="EXECUTE">
</form>
</body>
</html>