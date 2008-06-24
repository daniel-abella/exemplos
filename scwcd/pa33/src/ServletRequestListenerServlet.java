import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletRequestListenerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws IOException, ServletException {

		res.setContentType("text/html");
		PrintWriter pw = res.getWriter();
		int contador = (Integer) getServletContext().getAttribute("contador");
		pw.println("<html><body>" + contador + "</body></html>");
	}
}
