import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Redireciona extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req,
			 HttpServletResponse res)
	throws ServletException, IOException {

	String selecao = req.getParameter("portal");
	String destino = null;
	if ("CNN".equals(selecao)) {
	    destino = "http://www.cnn.com";
	} else if ("GOOGLE".equals(selecao)) {
	    destino = "http://www.google.com";
	} else if ("MercadoLivre".equals(selecao)) {
	    destino = "http://www.mercadolivre.com.br";
	} else {
	    throw new RuntimeException("Algo estranho aconteceu");
	}
	res.sendRedirect(destino);
    }
}
