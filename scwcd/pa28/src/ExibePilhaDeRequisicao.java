import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ExibePilhaDeRequisicao extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {

		PrintWriter pw = res.getWriter();
		pw.println("<html><body>");
		pw.println("<h1>Pilha de execução</h1>");
		pw.println(getPilha());
	}

	String getPilha() {
		StringBuilder sb = new StringBuilder();
		StackTraceElement[] pilha = Thread.currentThread().getStackTrace();
		for (StackTraceElement ste : pilha) {
			sb.append(ste.toString());
			sb.append("<br/>");
		}
		return sb.toString();
	}

}
