import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import java.text.*;

public class RecebeRequisicoes extends HttpServlet {

    public void doGet(HttpServletRequest r,
		      HttpServletResponse s)
	throws ServletException, IOException {

	PrintWriter pw = s.getWriter();
	pw.println("<html><body>");
	Integer total = (Integer) getServletContext().getAttribute("total");
	DateFormat df = DateFormat.getInstance();
	pw.println("Requisicao: " + total + " em " + df.format(new Date()));
	pw.println("</body></html>");
    }
}
