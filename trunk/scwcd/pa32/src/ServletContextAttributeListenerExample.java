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

		Carro carro = new Carro(1);
		// Isto fará com que o ServletContextAttributeListener
		// seja avisado (attributeAdded)
		getServletContext().setAttribute("carro", carro);

		// ServletContextAttributeListener avisado via attributeRemoved
		getServletContext().removeAttribute("carro");

		// ServletContextAttributeListener avisado via attributeReplaced
		getServletContext().setAttribute("carro", "Uma simples string");

		String s1 = (String) getServletContext().getAttribute("attributeAdded");
		String s2 = (String) getServletContext().getAttribute(
				"attributeReplaced");
		String s3 = (String) getServletContext().getAttribute(
				"attributeRemoved");

		String msg = (String) getServletContext().getAttribute("carro");

		res.setContentType("text/html");
		PrintWriter pw = res.getWriter();
		pw.println("<html><body>" + s1 + "<br>" + s2 + "<br>" + s3 + "<br>"
				+ msg + "</body></html>");
	}

}
