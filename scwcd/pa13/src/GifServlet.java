import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class GifServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest r, HttpServletResponse s)
			throws ServletException, IOException {
		PrintWriter pw = s.getWriter();
		pw.println("<html><h3>");
		pw.println(getServletConfig().getServletName());
		pw.println("</h3></html>");
	}
}
