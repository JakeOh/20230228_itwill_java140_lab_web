<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8" />
        <title>JSP</title>
    </head>
    <body>
        <h1>요청 결과 처리</h1>
        
        <%-- 클라이언트에서 보낸 요청 파라미터의 값을 찾는 방법: --%>
        <%
        String username = request.getParameter("username");
        %>
        <h2>안녕하세요, <%= username %>!</h2>
        
        <%-- JSP 내장 객체:
          JSP가 Java로 변환될 때 _jspService(request, response) 메서드 안에서 선언되는 변수들.
          JSP에서 별도의 변수 선언 없이 JSP 태그 안에서 언제든지 사용할 수 있는 변수들.
          * request: 클라이언트에서 서버로 보내는 정보들이 포함된 객체.
          * response: 서버에서 응답을 만들어내기 위한 객체.
          * pageContext: JSP 페이지의 정보들을 저장하는 객체. 
          * session: 세션이 유지되는 동안 정보들을 저장하기 위한 객체.
          * application: 애플리케이션이 동작 중에 필요한 정보들을 저장하기 위한 객체.
          * config: 서블릿 환경 설정 정보를 가지고 있는 객체.
          * out: HTML writer.
        --%>
        
    </body>
</html>
