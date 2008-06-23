import javax.servlet.http.*;
import java.io.*;
import javax.servlet.ServletException;

public class RosnarDoCao extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest r, HttpServletResponse s)
	throws ServletException, IOException {
	PrintWriter pw = s.getWriter();
	pw.println("<html><body>");
	pw.println("<h1>O c�o rosna...</h1>");
	pw.println("</body></html>");
    }
}
