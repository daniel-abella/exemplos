import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class RedirecionaTrivial extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest r, HttpServletResponse s)
			throws ServletException, IOException {
		s.sendRedirect("http://www.cnn.com");
	}
}
