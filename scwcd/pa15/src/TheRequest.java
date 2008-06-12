import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class TheRequest extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest r, HttpServletResponse s)
			throws ServletException, IOException {
		PrintWriter pw = s.getWriter();
		pw.println("<html><b>Nome do Servlet: </b>");
		pw.println(getServletConfig().getServletName());
		pw.println("<br><b>URL: </b>");
		pw.println(r.getRequestURL());
		pw.println("<br><b>URI: </b>");
		pw.println(r.getRequestURI());
		pw.println("<br><b>Context Path: </b>");
		pw.println(r.getContextPath());
		pw.println("<br><b>Servlet Path: </b>");
		pw.println(r.getServletPath());
		pw.println("<br><b>Path Info: </b>");
		pw.println(r.getPathInfo());
		pw.println("</html>");
	}
}
