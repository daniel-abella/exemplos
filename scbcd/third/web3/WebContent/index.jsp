<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="javax.naming.*,java.util.*,utils.*"%>

<%!String formato = "SHORT";
	String pais = "Brasil";

	private FormataDataBeanRemote servico;

	public void jspInit() {
		try {
			InitialContext ctx = new InitialContext();
			String nameCtx = FormataDataBeanRemote.class.getName();
			servico = (FormataDataBeanRemote) ctx.lookup(nameCtx);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>web3</title>
</head>
<body>
<h1>Exibe data corrente conforme formato</h1>
Selecione a opção de país e formato da data. Posteriormente, peça para
atualizar a data para o formato especificado.
<br>
<p>
<form>País: <select name="pais">
	<option value="br">Brasil</option>
	<option value="us">US</option>
</select> Formato: <select name="formato">
	<option value="SHORT">Curto</option>
	<option value="FULL">Extenso</option>
</select> <input type="submit" value="Atualize"></form>

<p>Data corrente (padrão): <%=new Date().toString()%> <%
 	if (request != null && servico != null) {
 		if (request.getParameter("pais").equals("br")) {
 			servico.formatoBr();
 			pais = "Brasil";
 		} else {
 			servico.formatoUs();
 			pais = "EUA";
 		}
 		if (request.getParameter("formato").equals("SHORT")) {
 			servico.formatoSimples();
 			formato = "SHORT";
 		} else {
 			servico.formatoExtenso();
 			formato = "EXTENSO";
 		}
 	}
 %>

<p>Formato:<b><%= pais %></b>, <b><%= formato %></b><br>
<p>Data (formato acima): <%= servico.data() %>
</body>
</html>