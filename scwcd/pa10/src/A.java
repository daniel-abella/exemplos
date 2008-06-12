import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class A extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void init() {
		ServletContext sc = getServletContext();
		if (sc.getAttribute("total") == null)
			sc.setAttribute("total", new Integer(0));
	}

	public void atualizaContador() {
		ServletContext sc = getServletContext();
		synchronized (Object.class) {
			Integer contador = (Integer) sc.getAttribute("total") + 1;
			sc.setAttribute("total", contador);
		}
	}

	protected void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {

		atualizaContador();

		PrintWriter pw = res.getWriter();
		ServletContext sc = getServletContext();
		pw.println("<html><body>Total de requisições: ");
		pw.println(sc.getAttribute("total") + "</body></html>");
	}

	protected void doPost(HttpServletRequest r, HttpServletResponse s)
			throws ServletException, IOException {
		doGet(r, s);
	}
}
