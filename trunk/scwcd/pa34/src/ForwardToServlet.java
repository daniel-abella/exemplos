import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ForwardToServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws IOException, ServletException {
		
		PrintWriter pw = res.getWriter();
		pw.println("<html><body>" + saida() + "</body></html>");
	}
	
	@SuppressWarnings("unchecked")
	public String saida() {
		String retorno = "";
		ServletContext sc = getServletContext();
		Enumeration nomes = sc.getAttributeNames();
		while (nomes.hasMoreElements()) {
			System.out.println(nomes.nextElement()); 
		}
		return retorno;
	}
}
