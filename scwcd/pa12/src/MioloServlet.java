import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class MioloServlet extends HttpServlet {

    public void doGet(HttpServletRequest r,
		      HttpServletResponse s)
	throws ServletException, IOException {
	PrintWriter pw = s.getWriter();
	pw.println("Mensagem: todo pão tem miolo.");
    }
}
