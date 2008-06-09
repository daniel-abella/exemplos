import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Init extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String msg = null;

	public void init() {
		ServletConfig sc = getServletConfig();
		msg = sc.getInitParameter("msg");
	}

	protected void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {

		PrintWriter pw = res.getWriter();
		pw.println("<html><h1>");
		pw.println(msg);
		pw.println("</h1></html>");
	}
}
