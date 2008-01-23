<html>
<body>

<%-- DIRETIVAS --%>
<%@ page language="java" %>
<%@ page import="java.text.*" %>
<%@ page import="java.util.*" %>

<%-- DECLARACOES --%>
<%! DateFormat df = null; %>
<%! public void jspInit() {
	Locale l = new Locale("pt", "BR");
	df = DateFormat.getTimeInstance(DateFormat.FULL, l);    
    } %>

<%-- EXPRESSAO --%>
Hora corrente no servidor: <%= df.format(new Date()) %>.
</body>
</html>