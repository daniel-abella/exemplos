package com.googlecode.exemplos;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

 public class HelloServlet extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
   static final long serialVersionUID = 1L;
   private static UsuarioRepository ur = null; 	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "/resposta.jsp";
		String user = request.getParameter("user");
		if (user == null || user.length() == 0) {
			url = "/index.jsp";
			request.setAttribute("error", "User name must not be empty!");
		} else {
			Usuario usuario = ur.getFromUserId(user);
			String fullName = usuario == null ? "Não cadastrado" : usuario.getFullName();
			request.setAttribute("fullName", fullName);
		}
		
		ServletContext context = getServletContext();
		RequestDispatcher dispatcher = context.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}  	

	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		ServletContext servletContext = config.getServletContext();
		ApplicationContext resource = WebApplicationContextUtils.getWebApplicationContext(servletContext);
		ur = (UsuarioRepository) ((BeanFactory) resource).getBean("usuarioRepository");
	}  	
}