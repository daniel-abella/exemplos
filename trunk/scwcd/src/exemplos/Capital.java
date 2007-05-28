package exemplos;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class for Servlet: Capital
 * 
 */
public class Capital extends javax.servlet.http.HttpServlet implements
		javax.servlet.Servlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/*
	 * (non-Java-doc)
	 * 
	 * @see javax.servlet.http.HttpServlet#HttpServlet()
	 */
	public Capital() {
		super();
	}

	/*
	 * (non-Java-doc)
	 * 
	 * @see javax.servlet.http.HttpServlet#doGet(HttpServletRequest request,
	 *      HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		processa(request,response);
	}

	protected void processa(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String estado = request.getParameter("estado");
		String capital = capitais.get(estado);
		request.setAttribute("capital", capital);
		request.getRequestDispatcher("/WEB-INF/jsp/capital.jsp").forward(request, response);
	}
	
	/*
	 * (non-Java-doc)
	 * 
	 * @see javax.servlet.http.HttpServlet#doPost(HttpServletRequest request,
	 *      HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		processa(request,response);
	}

	private static Map<String,String> capitais = null;
	
	public void init() throws ServletException {
		if (capitais==null) {
			capitais = new HashMap<String,String>();
			capitais.put("go", "Goiânia");
			capitais.put("ba", "Bahia");
		}
	}	
}