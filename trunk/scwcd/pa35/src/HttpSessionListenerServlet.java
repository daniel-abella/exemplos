import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HttpSessionListenerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unchecked")
	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws IOException, ServletException {

		req.getSession();
		
		res.setContentType("text/html");
		PrintWriter pw = res.getWriter();
		ServletContext sc = getServletContext();
		List lista = (List) sc.getAttribute("sessoes");
		int valor = lista == null ? 0 : lista.size();
		pw.println("<html><body>Total de sessões: " + valor + "</body></html>");
	}

}
