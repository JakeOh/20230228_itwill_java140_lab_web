<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8" />
        <title>JSP</title>
    </head>
    <body>
        <h1>Index</h1>
        
        <ul>
            <li>
                <a href="ex1">첫번째 Servlet</a>
            </li>
            <li>
                <a href="ex2">두번째 Servlet</a>
            </li>
            <li>
                <a href="ex3">포워드</a>
            </li>
            <li>
                <a href="ex4">리다이렉트</a>
            </li>
            <li>
                <!-- URL 상대경로: 
                http://localhost:8081/contextRoot/ 까지를 현재 작업 디렉토리로 하고, 
                그 이후 주소만 표기 -->
                <a href="intro.jsp">JSP 소개</a>
            </li>
            <li>
                <a href="form.jsp">form 제출</a>
            </li>
        </ul>
    </body>
</html>
