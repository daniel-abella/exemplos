import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class DestroySessionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unchecked")
	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws IOException, ServletException {
		
		ServletContext sc = getServletContext();
		List<HttpSession> sessions = (List) sc.getAttribute("sessoes");

		int tamanho = 0;
		if (sessions != null && sessions.size() > 0) {
			sessions.remove(0);
			tamanho = sessions.size();
		}
		res.setContentType("text/html");
		PrintWriter pw = res.getWriter();
		pw.println("<html><body>Total de sessoes: " + tamanho);
		pw.println("<br>Requisicoes: " + sc.getAttribute("contador") + "</body></html>");
	}
}
