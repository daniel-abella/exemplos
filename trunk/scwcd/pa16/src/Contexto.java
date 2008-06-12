import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Contexto extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest r, HttpServletResponse s)
			throws ServletException, IOException {
		PrintWriter pw = s.getWriter();
		pw.println("<html>");

		ServletContext sc = getServletContext();
		if (sc != getServletConfig().getServletContext())
			pw.println("Impossível!!");
		else
			pw.println("Contexto obtido sem problemas");

		int major = sc.getMajorVersion();
		int minor = sc.getMinorVersion();
		pw.println("<br>Versão: " + major + "." + minor);
		pw.println("</html>");
	}
}
