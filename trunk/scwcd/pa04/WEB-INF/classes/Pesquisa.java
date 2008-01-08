import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Pesquisa extends HttpServlet {
    public void doPost(HttpServletRequest req, HttpServletResponse res)
	throws ServletException, IOException {

	PrintWriter pw = res.getWriter();
	pw.println("<html><body>");
	pw.println("<h1>Pesquisa de Opinião</h1>");
	pw.println("Sua cidade preferida: <b>" + req.getParameter("cidade"));
	pw.println("</b><br>");
	pw.println("Estado: <b>" + req.getParameter("estado"));
	pw.println("</b><br><br>");
	pw.println("Obrigado!");
    }
}
