import java.util.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class ContextoParametro extends HttpServlet {

    public void doGet(HttpServletRequest r,
		      HttpServletResponse s)
	throws ServletException, IOException {
	PrintWriter pw = s.getWriter();
	pw.println("<html>");

	ServletContext sc = getServletContext();
	Enumeration pars = sc.getInitParameterNames();
	String name = null;
	while (pars.hasMoreElements()) {
	    name = (String) pars.nextElement();
	    pw.println("<br>" + name + ": " + sc.getInitParameter(name));
	}
	pw.println("<br>Mime type para index.html: " 
		   + sc.getMimeType("index.html"));
	pw.println("</html>");
    }
}
