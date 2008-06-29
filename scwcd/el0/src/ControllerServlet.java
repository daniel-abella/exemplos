import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws IOException, ServletException {

		String nome = req.getParameter("nome");
		if (nome == null || nome.length() == 0) {
			nome = "Nome não fornecido";
		}
		
		req.setAttribute("nome", nome);
		RequestDispatcher rd = req.getRequestDispatcher("visao.jsp");
		rd.forward(req, res);
	}
}
