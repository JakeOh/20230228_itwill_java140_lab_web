package com.itwill.jsp1;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FirstServlet
 */
public class FirstServlet extends HttpServlet {
    // src/main/webapp/WEB-INF/web.xml에서 요청 주소 매핑이 되어 있음.
    // http://localhost:8081/jsp1/ex1 요청에 매핑된 서블릿 클래스.
    
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FirstServlet() {
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
	        throws ServletException, IOException {
	    // 클라이언트에서 GET 방식의 요청이 왔을 때, 
	    // WAS(Web Application Server, Tomcat)가 호출하는 메서드.
	    // 파라미터 request: 클라이언트가 보낸 요청에 대한 정보를 가지고 있는 객체.
	    // 파라미터 response: WAS가 클라이언트로 보낼 응답을 작성하기 위해 필요한 기능들을 가지고 있는 객체.
		
	    LocalDateTime curTime = LocalDateTime.now(); // 서버의 현재 시간.
	    
	    PrintWriter writer = response.getWriter();
	    writer.append("<!doctype html>")
	        .append("<html>")
	        .append("  <head>")
	        .append("    <meta charset='UTF-8' />")
	        .append("    <title>Servlet 1</title>")
	        .append("  </head>")
	        .append("  <body>")
	        .append("    <h1>첫번째 Servlet</h1>")
	        .append("    <h2>")
	        .append(curTime.toString())
	        .append("    </h2>")
	        .append("  </body>")
	        .append("</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
	        throws ServletException, IOException {
	    // 클라이언트에서 POST 방식의 요청이 왔을 때, 
        // WAS(Web Application Server, Tomcat)가 호출하는 메서드.
		doGet(request, response);
	}

}
