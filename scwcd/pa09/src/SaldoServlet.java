import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SaldoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

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
	pw.println(" é " + (int) (Math.random() * 1000));
	pw.println("</html>");
    }
}
