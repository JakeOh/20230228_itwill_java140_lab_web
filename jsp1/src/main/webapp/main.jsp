<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8" />
        <title>JSP</title>
        <style>
        .header {
            background-color: black;
            color: white;
            padding: 32px;
            text-align: center;
        }
        .footer {
            background-color: lightgray;
            padding: 8px;
            font-size: 50%;
        }
        </style>
    </head>
    <body>
        <%-- include 지시문를 사용한 jspf 파일 삽입: 
          incluce 지시문이 사용된 위치에 jsp, jspf, html 파일의 내용을 삽입하고,
          하나의 자바 클래스 파일로 변환되고 컴파일됨.
        --%>
        <%@ include file="header.jsp" %>
        
        <main>
            <h1>메인 페이지</h1>
            <a href="./">인덱스 페이지</a>
        </main>
        
        <%@ include file="footer.jspf" %>
        
    </body>
</html>
