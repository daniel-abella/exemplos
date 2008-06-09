import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;

public class Headers extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse res)
	throws ServletException, IOException {

	PrintWriter pw = res.getWriter();
	pw.println("<html>");
	pw.println("<body>");
	pw.println("<h2>Elementos de header de requisição http</h2>");

	Enumeration headers = req.getHeaderNames();
	String header;
	int elementos = 0;
	while (headers.hasMoreElements()) {
	    elementos++;
	    header = (String) headers.nextElement();
	    pw.println("<br><b>" + header + "</b>: ");
	    pw.println(req.getHeader(header));
	}

	pw.println("<br><hr><br>Total de elementos: " + elementos);

	pw.println("</body>");
	pw.println("</html>");
    }    
}
