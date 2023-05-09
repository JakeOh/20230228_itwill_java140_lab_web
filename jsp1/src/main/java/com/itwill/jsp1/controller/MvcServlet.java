package com.itwill.jsp1.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Timestamp;
import java.time.LocalDateTime;

/**
 * Servlet implementation class MvcServlet
 */
@WebServlet(name = "mvcServlet", urlPatterns = { "/mvc" })
public class MvcServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LocalDateTime now = LocalDateTime.now();
		Timestamp ts = Timestamp.valueOf(now);
	    
		request.setAttribute("now", ts);
		
	    request.getRequestDispatcher("/WEB-INF/view.jsp")
		    .forward(request, response);
	}

}
