import java.io.IOException;
import java.io.PrintWriter;

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
		ServletContext sc = getServletContext();
		return (String) sc.getAttribute("atributo");
	}
}
