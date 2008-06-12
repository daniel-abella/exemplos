import java.util.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class ContextoParametro extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unchecked")
	public void doGet(HttpServletRequest r, HttpServletResponse s)
			throws ServletException, IOException {
		PrintWriter pw = s.getWriter();
		pw.println("<html>");

		ServletContext sc = getServletContext();
		Enumeration<String> pars = sc.getInitParameterNames();
		String name = null;
		while (pars.hasMoreElements()) {
			name = (String) pars.nextElement();
			pw.println("<br>" + name + ": " + sc.getInitParameter(name));
		}
		String nomeArquivo = "qualquer-nome.jpg";
		pw.println("<br>Mime type para " + nomeArquivo + " : "
				+ sc.getMimeType(nomeArquivo));
		pw.println("</html>");
	}
}
