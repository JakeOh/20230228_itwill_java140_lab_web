package com.itwill.jsp1;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class RedirectServlet
 */
public class RedirectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
	        throws ServletException, IOException {
		System.out.println("RedirectServlet#doGet() 호출");
		
		// 클라이언트에서 서버로 온 요청을 "redirect" 방식으로 페이지를 이동:
		// 최초 요청 주소(URL)가 이동하는 페이지로 변경.
		// 최초 요청의 request 객체와 response 객체가 이동하는 페이지로 전달되지 않음.
		// 같은 웹 서버 만이 아니라, 외부 서버의 페이지로도 이동이 가능.
//		response.sendRedirect("https://www.daum.net/");
		
		response.sendRedirect("example.jsp");
	}

}
