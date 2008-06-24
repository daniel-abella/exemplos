import java.io.IOException;

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
		
		// ServletContextAttributeListener avisado via attributeReplaced
		getServletContext().setAttribute("carro", "Uma simples string");

		// ServletContextAttributeListener avisado via attributeRemoved
		getServletContext().removeAttribute("carro");
	}

}
