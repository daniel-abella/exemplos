import javax.servlet.http.*;
import java.io.*;
import javax.servlet.ServletException;

public class RosnarDoCao extends HttpServlet {
    public void service(HttpServletRequest r, HttpServletResponse s)
	throws ServletException, IOException {
	PrintWriter pw = s.getWriter();
	pw.println("<html><body>");
	pw.println("<h1>O cão rosna...</h1>");
	pw.println("</body></html>");
    }
}
