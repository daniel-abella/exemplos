<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%-- 
    Document   : index
    Created on : Jul 13, 2008, 4:13:08 PM
    Author     : Fábio Nogueira de Lucena
--%>

<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>JSP Page</title>
    </head>
    <body>
        <h2>Exibe o conteúdo de uma lista de arrays</h2>
        
        <table>
            <tr><td>Lista</td><td>Elemento</td><td>Conteúdo</td>
            <c:forEach var="array" items="${listaDeArrays}" varStatus="v1">
                <c:forEach var="item" items="${array}" varStatus="v2">
                    <tr><td>${v1.count}</td><td>${v2.count}</td><td>${item}</td>
                </c:forEach>
            </c:forEach>
        </table>
    </body>
</html>
