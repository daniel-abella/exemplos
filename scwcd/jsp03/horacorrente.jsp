<html>
<body>
<%@ page language="java" %>
<%@ page import="java.io.*" %>
<%@ page import="java.text.*" %>
<%@ page import="java.util.*" %>
<%! String data; %>
<%
	Locale l = new Locale("pt", "BR");
	DateFormat df = DateFormat.getTimeInstance(DateFormat.FULL, l);
	data = df.format(new Date());
%>
Hora corrente no servidor: <%= data %>.
</body>
</html>