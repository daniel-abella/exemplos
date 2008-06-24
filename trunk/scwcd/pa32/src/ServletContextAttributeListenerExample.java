import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletContextAttributeListenerExample extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws IOException, ServletException {
		
		// Apenas para guardar as mensagens do listener
		// ServletContextAttributeListener (via attributeAdded)
		getServletContext().setAttribute("msg", new StringBuilder());

		// ServletContextAttributeListener (via attributeAdded)
		getServletContext().setAttribute("x", "");
		
		// ServletContextAttributeListener avisado via attributeReplaced
		getServletContext().setAttribute("x", "Uma simples string");

		// ServletContextAttributeListener avisado via attributeRemoved
		getServletContext().removeAttribute("x");
		
		StringBuilder msg = (StringBuilder) getServletContext().getAttribute("msg");
		PrintWriter pw = res.getWriter();
		pw.println("<html><body>" + msg + "</body></html>");
	}

}
