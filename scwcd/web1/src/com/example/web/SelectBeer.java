package com.example.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.model.BeerExpert;

public class SelectBeer extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);

	}

	protected void doGet(HttpServletRequest r, HttpServletResponse s)
			throws ServletException, IOException {
		s.setContentType("text/html");
		PrintWriter pw = s.getWriter();
		pw.println("<b>Beer selection advice</b>");
		String color = r.getParameter("color");
		pw.println("<p>Got beer color: " + color);
		pw.println("<br>Sugestões:");
		List<String> sugestoes = new BeerExpert().getBrands(color);
		r.setAttribute("sugestoes", sugestoes);
		
		RequestDispatcher rd = r.getRequestDispatcher("result.jsp");
		rd.forward(r, s);
	}

}
