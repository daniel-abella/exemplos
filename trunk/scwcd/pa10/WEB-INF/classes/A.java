import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;

public class A extends HttpServlet {
    public void init() {
	ServletContext sc = getServletContext();
	if (sc.getAttribute("total") == null)
	    sc.setAttribute("total", new Integer(0));
    }
    
    public void atualizaContador() {
	ServletContext sc = getServletContext();
	synchronized(Object.class) { 
	    Integer contador = (Integer) sc.getAttribute("total") + 1;
	    sc.setAttribute("total", contador); 
	}
    }

    protected void doGet(HttpServletRequest req,
			 HttpServletResponse res)
	throws ServletException, IOException {

	atualizaContador();

	PrintWriter pw = res.getWriter();
	ServletContext sc = getServletContext();
	pw.println("<html><body>Total de requisições: ");
	pw.println(sc.getAttribute("total") + "</body></html>");
    }

    protected void doPost(HttpServletRequest r, HttpServletResponse s)
	throws ServletException, IOException {
	doGet(r,s);
    }
}
