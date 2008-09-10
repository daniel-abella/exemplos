<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Meu primeiro exemplo JSTL!</title>
    </head>
    <body>
        <h2>Apenas exibe parâmetro de nome "valor" (/servico?valor=teste)</h2>
        valor (escapeXml="false"): <c:out value="${valor}" escapeXml="false"/>
        <br/>
        valor (escapeXml="true"): <c:out value="${valor}" escapeXml="true"/>
        <br/>
        valor (just c:out): <c:out value="${valor}"/>
    </body>
</html>
