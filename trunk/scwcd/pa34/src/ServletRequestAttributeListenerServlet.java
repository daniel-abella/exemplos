import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletRequestAttributeListenerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws IOException, ServletException {

		req.setAttribute("atributo", "valor do atributo");
		req.setAttribute("atributo", "substituído");
		req.removeAttribute("atributo");
		
		RequestDispatcher view = req.getRequestDispatcher("s2");
		view.forward(req, res);
	}
}
