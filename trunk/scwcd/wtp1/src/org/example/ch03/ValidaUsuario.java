package org.example.ch03;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ValidaUsuario extends javax.servlet.http.HttpServlet implements
		javax.servlet.Servlet {
	static final long serialVersionUID = 1L;

	public ValidaUsuario() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String url = "/hello-world.jsp";
		String user = request.getParameter("user");
		if (user == null || user.trim().length() == 0) {
			url = "/login-user.jsp";
			request.setAttribute("error", "User name must not be empty");
		} else {
			try {
				String fullname = new Database().lookupFullname(user);
				if (fullname.length() == 0)
					fullname = user + " (fullname not found)";
				request.setAttribute("fullname", fullname);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		ServletContext sc = getServletContext();
		RequestDispatcher dispatcher = sc.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

	/*
	 * (non-Java-doc)
	 * 
	 * @see javax.servlet.http.HttpServlet#doPost(HttpServletRequest request,
	 *      HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
}