package com.itwill.post.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class HomeController
 */
@WebServlet(name = "homeController", urlPatterns = { "" })
// "http://localhost:8081/post/" 요청주소(context root)를 처리하는 서블릿.
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
	        throws ServletException, IOException {
		System.out.println("homeController.doGet() 호출");
		
		// View로 요청을 포워드:
		request.getRequestDispatcher("/WEB-INF/main.jsp")
		        .forward(request, response);
	}

}
