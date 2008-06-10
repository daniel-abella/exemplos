import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

public class ExibeParametros extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unchecked")
	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {

		PrintWriter pw = res.getWriter();
		pw.println("<html><body>");
		pw.println("<h1>ExibeParametros</h1>");
		Enumeration<String> pars = req.getParameterNames();
		if (pars.hasMoreElements()) {
			String parametro;
			while (pars.hasMoreElements()) {
				parametro = (String) pars.nextElement();
				pw.println("<br>" + parametro + ": ");
				pw.println(req.getParameter(parametro));
			}
		} else {
			pw.println("Nenhum parâmetro fornecido.");
		}
	}

}
