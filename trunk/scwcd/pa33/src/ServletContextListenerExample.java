import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletContextListenerExample extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws IOException, ServletException {

		Carro carro = (Carro) getServletContext().getAttribute("carro");
		String autonomia = carro != null ? Integer.toString(carro
				.getAutonomia()) : "erro";
		
		res.setContentType("text/html");
		PrintWriter pw = res.getWriter();
		pw.println("<html><body>" + autonomia + "</body></html>");
	}

}
