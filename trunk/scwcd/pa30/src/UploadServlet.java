import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		String retorno = "ok"; // Convencao em caso de sucesso

		try {
			ServletContext sc = getServletContext();
			String fileName = sc.getRealPath("/WEB-INF/saida.txt");
			FileOutputStream fos = new FileOutputStream(fileName);

			InputStream is = req.getInputStream();
			if (!copy(is, fos)) {
				res.sendError(500);
				retorno = "xx";
			} else {
				res.setStatus(HttpServletResponse.SC_OK);
			}
			is.close();
		} catch (Exception e) {
			res.sendError(500);
			retorno = "xx";
		}

		PrintWriter pw = res.getWriter();
		pw.println(retorno);
	}

	public static boolean copy(InputStream origem, OutputStream destino) {
		boolean copia = true;
		int bytes = -1;
		byte[] buffer = new byte[4096];
		try {
			while (copia) {
				bytes = origem.read(buffer, 0, 4096);
				if (bytes == -1)
					break;
				destino.write(buffer, 0, bytes);
			}
			destino.flush();
		} catch (Exception e) {
			return false;
		}
		return true;
	}
}
