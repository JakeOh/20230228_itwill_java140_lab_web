package com.itwill.post.controller.post;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class PostCreateController
 */
@WebServlet(name = "postCreateController", urlPatterns = { "/post/create" })
public class PostCreateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
	        throws ServletException, IOException {
		System.out.println("postCreateController.doGet()");
		
		request.getRequestDispatcher("/WEB-INF/post/create.jsp")
		        .forward(request, response);
	}

}
