import javax.servlet.http.*;
import java.io.*;
import javax.servlet.ServletException;

public class ObtemArgumento extends HttpServlet {
    // O método service é sobrescrito abaixo. Isto significa que
    // tal servlet irá tratar todo e qualquer método (POST, GET, ...)
    public void service(HttpServletRequest r, HttpServletResponse s)
	throws ServletException, IOException {

	PrintWriter pw = s.getWriter();
	String parametro = r.getParameter("a");
	pw.println("<html><body>");
	pw.println("<h1>ParÃ¢metro</h1>");
	pw.println("Argumento: a<br>Valor:  " + parametro);
	pw.println("</body></html>");
    }
}
