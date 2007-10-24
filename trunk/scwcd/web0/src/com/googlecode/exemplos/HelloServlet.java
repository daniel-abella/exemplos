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
		String userName = request.getParameter("usuario");
		if (userName == null || userName.length() == 0) {
			url = "/index.jsp";
			request.setAttribute("erro", "Usuário não pode ser nulo!");
		} else {
			Usuario usuario = ur.getFromUserId(userName);
			String fullName = usuario == null ? null : usuario.getFullName();
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