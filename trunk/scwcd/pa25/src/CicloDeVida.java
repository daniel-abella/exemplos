import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CicloDeVida extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String path = null;

	public void init() {
		ServletContext context = getServletContext();
		path = context.getRealPath("/log.txt");
		registra("==> init()");
	}

	public void destroy() {
		registra("==> destroy()");
	}

	protected void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		registra("==> doGet()");
		res.sendRedirect("/pa25/index.html");
	}

	public void registra(String msg) {
		try {
			FileWriter fw = new FileWriter(path, true);
			String data = new Date().toString();
			fw.write(data, 0, data.length());
			fw.write(' ');
			fw.write(msg, 0, msg.length());
			fw.write('\n');
			fw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
