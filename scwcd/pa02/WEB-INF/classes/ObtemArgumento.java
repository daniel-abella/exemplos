import javax.servlet.http.*;
import java.io.*;
import javax.servlet.ServletException;

public class ObtemArgumento extends HttpServlet {
    public void service(HttpServletRequest r, HttpServletResponse s)
	throws ServletException, IOException {

	PrintWriter pw = s.getWriter();
	String parametro = r.getParameter("a");
	pw.println("<html><body>");
	pw.println("<h1>Parâmetro</h1>");
	pw.println("Argumento: a<br>Valor:  " + parametro);
	pw.println("</body></html>");
    }
}
