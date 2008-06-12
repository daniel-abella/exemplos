import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GetClassName extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {

		PrintWriter pw = res.getWriter();
		pw.write("<html><body>");
		String fmt = "<br>Interface %s implementada por ";
		pw.write(String.format(fmt, HttpServletRequest.class.getName()));
		pw.write(req.getClass().getName());
		pw.write(String.format(fmt, HttpServletResponse.class.getName()));
		pw.write(res.getClass().getName());
		pw.write("</body></html>");
	}
}
