import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;

public class SaldoServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req,
			 HttpServletResponse res)
	throws ServletException, IOException {
	doPost(req,res);
    }

    protected void doPost(HttpServletRequest req,
			 HttpServletResponse res)
	throws ServletException, IOException {
	
	String usuario = (String) req.getAttribute("usuario");
	if (usuario == null) {
	    RequestDispatcher rd = req.getRequestDispatcher("index.html");
	    rd.forward(req,res);
	    return;
	}

	// 'usuario' foi autenticado
	PrintWriter pw = res.getWriter();
	pw.println("<html>");
	pw.println("O saldo do usuário " + usuario);
	pw.println("é " + (int) (Math.random() * 1000));
	pw.println("</html>");
    }
}
