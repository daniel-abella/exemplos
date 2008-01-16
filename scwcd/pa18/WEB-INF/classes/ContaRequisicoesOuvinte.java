import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class ContaRequisicoesOuvinte implements ServletRequestListener {

    // Nada interessante a ser feito
    public void requestDestroyed(ServletRequestEvent sre) {}

    // Acumula o total de requisições
    public void requestInitialized(ServletRequestEvent sre) {
	ServletContext sc = sre.getServletContext();
	Integer total = (Integer) sc.getAttribute("total");
	if (total == null) {
	    total = new Integer(0);
	    sc.setAttribute("total", total);
	}
	sc.setAttribute("total", ++total);
    }
}
