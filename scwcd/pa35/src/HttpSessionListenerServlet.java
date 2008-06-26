import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class HttpSessionListenerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unchecked")
	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws IOException, ServletException {

		HttpSession session = req.getSession();
		
		res.setContentType("text/html");
		PrintWriter pw = res.getWriter();
		ServletContext sc = getServletContext();
		List lista = (List) sc.getAttribute("sessoes");
		int valor = lista == null ? 0 : lista.size();
		pw.println("<html><body>Total de sessões: " + valor);
		if (session.isNew()) {
			pw.println("<br>Nova sessão foi criada...: " + session.getId());
		} else {
			pw.println("<br>Sessao reutilizada: " + session.getId());
		}
		
		pw.println("<br>Requisicoes: " + sc.getAttribute("contador"));
		pw.println("</body></html>");
	}

}
