<html>
<body>
<hr>
<b>application</b> : <%= application %>
<br><b>getServletContext()</b> : <%= getServletContext() %>
<hr>
<b>session</b> : <%= session %>
<br><b>request.getSession()</b> : <%= request.getSession() %>
<hr>
<b>request</b> : <%= request %>
<br><b>request.getServletPath()</b> : <%= request.getServletPath() %>
<hr>
<b>page</b> : <%= page %>
<br><b>((HttpServlet) page).getServletName()</b> : 
<%= ((HttpServlet) page).getServletName() %>
<hr>
</body>
</html>