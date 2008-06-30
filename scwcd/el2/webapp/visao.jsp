<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="dominio.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
Nome do atributo "pessoa":<br/><b>
<%=((Pessoa)request.getAttribute("pessoa")).getNome()%>
</b>

<br/><br/>
Nome do atributo "pessoa": (agora usando el)<br/>
<b>${requestScope.pessoa.nome}</b>

<br/><br/>
Nome do atributo "pessoa": (agora usando JavaBean standard actions)<br/>
<jsp:useBean id="pessoa" class="dominio.Pessoa" scope="request" />
<b><jsp:getProperty name="pessoa" property="nome"/></b>

<br/><br/>
Nome do atributo "outraPessoa": (agora usando JavaBean standard actions)<br/>
<jsp:useBean id="outraPessoa" class="dominio.Pessoa" scope="request">
	<jsp:setProperty name="outraPessoa" property="nome" value="nome padrão" />
</jsp:useBean>
<b><jsp:getProperty name="outraPessoa" property="nome"/></b>
</body>
</html>