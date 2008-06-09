import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.net.URL;

public class SendBinary extends HttpServlet {
    protected void doGet(HttpServletRequest req,
			 HttpServletResponse res)
	throws ServletException, IOException {

	// Informa ao browser que se trata de uma figura
	res.setContentType("image/jpeg");

	ServletContext context = getServletContext();
	URL url = context.getResource("/kyrios-logo.jpg");
	byte[] byteArray = new byte[1024];

	InputStream is = url.openStream();
	OutputStream os = res.getOutputStream();
	int bytesLidos = 0;
	while ((bytesLidos = is.read(byteArray)) != -1) {
	    os.write(byteArray,0,bytesLidos);
	}

	is.close();
	os.flush();
    }
}
