<%@taglib uri="http://java.sun.com/jsf/html" prefix="h"%><%@taglib
	uri="http://java.sun.com/jsf/core" prefix="f"%><%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>Forneça dados da sua conta</h2>
<f:view>
	
	<h:form><h:panelGrid border="1" columns="2">
		<h:outputText value="Nome:"></h:outputText>
		
		<h:inputText value="#{login.nome}"></h:inputText><h:outputText value="Senha:"></h:outputText>
		<h:inputSecret value="#{login.senha}"></h:inputSecret>
	</h:panelGrid><br><h:commandButton value="Login" action="login"></h:commandButton></h:form>
	
	
</f:view></body>
</html>