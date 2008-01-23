<!-- Comentário em HTML -->
<%-- Comentário em JSP --%>
<!-- Comentário em HTML é enviado para o browser -->
<%-- Comentário em JSP é removido pelo servidor (browser não os recebe) --%>

<html>
<body>

<!-- Abaixo segue uma diretiva -->
<%-- Os delimitadores de uma diretiva são <%@ %> --%>
<%@ page language="java" %>

<!-- Abaixo segue uma declaração -->
<%! int contador = 0; %>

<!-- Abaixo segue um scriptlet -->
<% contador++; %>

<!-- A sentença abaixo inclui uma expressão -->
<%-- ok --%>
Esta é a requisição de número <%= contador %> que está sendo atendida.
</body>
</html>