import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;

public class LoginServlet extends HttpServlet {
    Map<String,String> senhas = new HashMap<String,String>();

    public void init() {
	senhas.put("user","password");
	senhas.put("usuario", "senha");
	senhas.put("demo", "123");
    }

    private boolean verifica(String usuario, String senha) {
	boolean ok = true;
	ok = senhas.get(usuario) != null;
	ok = ok && (senhas.get(usuario).equals(senha));
	return ok;
    }

    protected void doPost(HttpServletRequest req,
			 HttpServletResponse res)
	throws ServletException, IOException {
	
	String usuario = req.getParameter("user");
	String senha = req.getParameter("password");
	RequestDispatcher rd = null;
	if (verifica(usuario,senha)) {
	    req.setAttribute("usuario", usuario);
	    ServletContext sc = getServletContext();
	    rd = sc.getRequestDispatcher("/saldo");
	} else {
	    rd = req.getRequestDispatcher("index.html");	    
	}	
	rd.forward(req,res);
    }
   
    protected void doGet(HttpServletRequest r, HttpServletResponse s)
	throws ServletException, IOException {
	doPost(r,s);
    }
}
