import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class CascaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest r, HttpServletResponse s)
			throws ServletException, IOException {
		PrintWriter pw = s.getWriter();
		pw.println("<html><body>");
		pw.println("<h3>Cabecalho</h3>");

		RequestDispatcher rd = r.getRequestDispatcher("/miolo");
		rd.include(r, s);

		pw.println("<h3>Rodapé</h3>");
		pw.println("</body></html>");
	}
}
