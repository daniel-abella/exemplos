import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class ExibeTotal extends HttpServlet {

    public void doGet(HttpServletRequest r,
		      HttpServletResponse s)
	throws ServletException, IOException {
	PrintWriter pw = s.getWriter();
	pw.println("<html>");
	pw.println("Total: " + getServletContext().getAttribute("total"));
	pw.println("</html>");
    }
}