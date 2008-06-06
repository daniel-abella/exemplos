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
	linha("<h1>Requisição</h1>");
	linha("getAttribute(\"fabio\"): " + req.getAttribute("fabio"));
	nomesAtributos(req);
	linha("getCharacterEncoding: " + req.getCharacterEncoding());
	linha("getContentLength(): " + req.getContentLength());
	linha("getContentType(): " + req.getContentType());

	linha("Mostra getInputStream() ou getReader() por sorteio");
	linha("(não podem ser chamados para uma mesma requisição)");
	if (new Date().getTime() % 2 == 0)
	    linha("getInputStream(): " + req.getInputStream());
	else {
	    linha("getReader(): " + req.getReader().readLine());
	}

	linha("getLocalAddr(): " + req.getLocalAddr());
	linha("getLocale(): " + req.getLocale());
	linha("getLocales():");
	Enumeration locales = req.getLocales();
	while (locales.hasMoreElements())
	    linha(locales.nextElement().toString());

	linha("getLocalName(): " + req.getLocalName());
	linha("getLocalPort(): " + req.getLocalPort());
	linha("getParameter(\"fabio\"): " + req.getParameter("fabio"));

	linha("getParameterMap():");
	Map<String,String> mapa = req.getParameterMap();
	

	linha("");
	linha("Nova consulta? Clique <a href=\"consulta.html\">aqui</a>");
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
