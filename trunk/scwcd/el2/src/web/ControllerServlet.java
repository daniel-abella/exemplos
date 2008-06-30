package web;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dominio.Pessoa;

public class ControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws IOException, ServletException {

		String nome = req.getParameter("nome");
		if (nome == null || nome.length() == 0) {
			nome = "Nome não fornecido";
		}
		
		Pessoa pessoa = new Pessoa();
		pessoa.setNome(nome);
		
		req.setAttribute("pessoa", pessoa);
		RequestDispatcher rd = req.getRequestDispatcher("visao.jsp");
		rd.forward(req, res);
	}
}
