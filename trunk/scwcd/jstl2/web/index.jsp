<%-- 
    Document   : index
    Created on : Jul 13, 2008, 3:39:57 PM
    Author     : Fábio Nogueira de Lucena
--%>

<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>JSP Page</title>
    </head>
    <body>
        <h2>Ilustrando valores default</h2>
        Ao fazer uma requisição para este exemplo, forneça o parâmetro "teste". 
        
        <p>Chamada simples: <c:out value="${param.teste}" escapeXml="true"/>
        <p>Chamada com default: 
        
        <c:out value="${param.teste}">
            Não foi fornecido o argumento "teste"
        </c:out>
    </body>
</html>
