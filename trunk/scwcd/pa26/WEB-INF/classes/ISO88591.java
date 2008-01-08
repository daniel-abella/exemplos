import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.net.URL;
import java.util.Date;

public class ISO88591 extends HttpServlet {
    protected void doGet(HttpServletRequest req,
			 HttpServletResponse res)
	throws ServletException, IOException {
	res.setContentType("text/html;charset=ISO-8859-1");
	PrintWriter pw = res.getWriter();
	pw.write("<html><body>açaí</body></html>");
    }
}
