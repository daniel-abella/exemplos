import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.net.URL;
import java.util.Date;

public class GetClassName extends HttpServlet {
    protected void doGet(HttpServletRequest req,
			 HttpServletResponse res)
	throws ServletException, IOException {

	PrintWriter pw = res.getWriter();
	pw.write("<html><body>");
	String fmt = "<br>Interface %s implementada por ";
	pw.write(String.format(fmt, HttpServletRequest.class.getName()));
	pw.write(req.getClass().getName());
	pw.write(String.format(fmt, HttpServletResponse.class.getName()));
	pw.write(res.getClass().getName());
	pw.write("</body></html>");
    }
}
