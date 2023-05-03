package com.itwill.jsp1;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class ForwardServlet
 */
@WebServlet(name = "forwardServlet", urlPatterns = { "/ex3" })
public class ForwardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
	        throws ServletException, IOException {
		System.out.println("ForwardServlet#doGet() 호출");
	    
		// 클라이언트에서 서버로 온 요청을 새로운 페이지로 "forward" 방식으로 이동:
		// 같은 WAS(Web Application Server)의 같은 웹 애플리케이션 안에서만 페이지 이동이 가능.
		// 요청 주소(URL)가 바뀌지 않음.
		// request 객체와 response 객체가 유지됨.
		// 다른 (외부) 서버 또는 다른 웹 애플리케이션의 페이지로 forward 이동을 할 수 없음. 
		
		// src/main/webapp 폴더 아래의 파일 경로와 파일 이름을 사용.
	    request.getRequestDispatcher("example.jsp")
		    .forward(request, response);
	}

}
