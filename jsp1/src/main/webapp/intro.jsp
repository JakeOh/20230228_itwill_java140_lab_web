<%@ page import="java.time.LocalDateTime" %> <%-- Java class의 import 문장. --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%-- page 지시문: JSP 페이지의 설정. 컨텐트 타입 설정, 인코딩 설정, import 문장, ... --%>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8" />
        <title>JSP</title>
    </head>
    <body>
        <h1>JSP 소개</h1>
        <h2>Java Server Page</h2>
        
        <%-- 선언문(declaration) --%>
        <%! /* Java block */
        private static final String NAME = "scott"; // 상수 선언.
        %>
        
        <%-- 스크립트릿(scriptlet) --%>
        <% 
        // 지역변수 선언:
        LocalDateTime now = LocalDateTime.now(); // 서버 현재 시간.
        String timeStr = String.format("%d-%02d-%02d %02d:%02d:%02d", 
                now.getYear(), now.getMonthValue(), now.getDayOfMonth(),
                now.getHour(), now.getMinute(), now.getSecond());
        
        System.out.println("intro.jsp - scriptlet");
        %>
        <p>
            <b>시간: <%= timeStr %></b>
            <br/>
            이름: <%= NAME %>
        </p>
        
        <!-- HTML, XML 주석 -->
        <%-- JSP 주석 --%>
        <%--  
          Servlet/JSP 동작 방식:
          1. Servlet: Server + Applet 합성어.
             - 웹 서버에서 실행되는, 요청을 처리하는 작은 Java 프로그램.
             - Java 클래스로 작성. HttpServlet 클래스를 상속.
             - 서블릿 객체의 생성과 서블릿 메서드 호출은 WAS가 담당.
               * 최초 요청: 서블릿 객체 생성 -> doGet, doPost 메서드 호출 -> 응답.
               * 요청: 생성되어 있는 서블릿 객체의 doGet, doPost 메서드 호출 -> 응답.
               
          2. JSP: Java Server Page
             - 서블릿은 순수한 자바 클래스 코드이기 때문에 HTML을 작성하기가 힘듦.
             - HTML 형식의 문서 안에서 자바 코드들이 실행될 수 있도록 만든 Server-side 문법.
             - JSP 실행 과정: jsp -> java -> class -> 객체 생성 -> 메서드 호출 -> 응답.
               * 최초 요청: jsp를 서블릿 클래스(java)로 변환 -> 컴파일해서 class 파일 생성
                 -> 객체 생성 -> 메서드 호출 -> 응답.
               * 요청: 생성되어 있는 객체에서 메서드 호출 -> 응답.
          3. JSP 구성 요소(태그)
             (1) 주석(comment)
             (2) 지시문(directive): <%@ ... %>
                 <%@ page ... %>, <%@ include ... %>, <%@ taglib ... %>
             (3) 선언문(declaration): <%! ... %>
                 JSP가 Java로 변환될 때, 클래스의 필드와 메서드를 선언하는 부분.
             (4) 스크립트릿(scriptlet): <% ... %>
                 JSP가 Java로 변환될 때, _jspService() 메서드 안에 포함되는 자바 코드.
                 지역 변수 선언. 조건문, 반복문, 메서드 호출, ...
             (5) 식, 표현식(expression): <%= ... %>
                 JSP가 Java로 변환될 때, out.print() 메서드의 argument로 전달되는 값.
                 HTML에 바로 삽입되는 "값".
        --%>
        
    </body>
</html>
