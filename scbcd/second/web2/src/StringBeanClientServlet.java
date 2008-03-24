
import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import second.StringBeanLocal;

public class StringBeanClientServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	public StringBeanLocal meuBean;

	protected void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		String entrada = req.getParameter("entrada");
		String resultado = meuBean.maiuscula(entrada);
		req.setAttribute("resultado", resultado);

		RequestDispatcher rd = null;
		rd = req.getRequestDispatcher("/WEB-INF/jsp/saida.jsp");
		rd.forward(req, res);
	}
}
