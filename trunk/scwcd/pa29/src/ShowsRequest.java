import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

public class ShowsRequest extends HttpServlet {

    private PrintWriter pw = null;

    public void doPost(HttpServletRequest req, HttpServletResponse res)
	throws ServletException, IOException {
	doGet(req,res);
    }

    public void doGet(HttpServletRequest req, HttpServletResponse res)
	throws ServletException, IOException {

	pw = res.getWriter();
	linha("<html><body>");
	linha("<h1>Request</h1>");
	linha("getAttribute(\"fabio\"): " + req.getAttribute("fabio"));
	nomesAtributos(req);
	linha("getCharacterEncoding: " + req.getCharacterEncoding());
	linha("getContentLength(): " + req.getContentLength());
    }

    public void linha(String linha) {
	pw.println(linha);
	pw.println("<br/>");
    }

    public void nomesAtributos(javax.servlet.ServletRequest req) {
	Enumeration e = req.getAttributeNames();
	if (e.hasMoreElements()) {
	    while (e.hasMoreElements()) {
		linha((String) e.nextElement());
	    }
	} else {
	    linha("Não há atributos na requisição.");
	}
    }
}
