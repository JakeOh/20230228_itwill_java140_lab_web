<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
            <li>
                <a href="main.jsp">include 지시문(directive)</a>
            </li>
            <li>
                <a href="scriptlet.jsp">스크립트릿(scriptlet)</a>
            </li>
            <li>
                <a href="actiontag.jsp">액션 태그(action tag)</a>
            </li>
            <li>
                <a href="el.jsp">EL(Expression Language)</a>
            </li>
            <li>
                <a href="jstl.jsp">JSTL</a>
            </li>
            <li>
                <a href="form2.jsp">form 제출</a>
            </li>
            <li>
                <a href="form2-result.jsp?username=adm&in&color=b">클릭 1</a>
            </li>
            <li>
                <c:url var="reqURL" value="form2-result.jsp">
                    <c:param name="username" value="adm&in"></c:param>
                    <c:param name="color" value="g"></c:param>
                </c:url>
                <a href="${ reqURL }">클릭 2</a>
            </li>
            <li>
                <a href="format.jsp">포맷팅</a>
            </li>
            <li>
                <a href="mvc">MVC pattern</a>
            </li>
        </ul>
    </body>
</html>
