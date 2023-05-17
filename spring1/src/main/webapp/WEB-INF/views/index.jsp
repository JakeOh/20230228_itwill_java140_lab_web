<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8" />
        <title>Spring 1</title>
    </head>
    <body>
        <header>
            <h1>메인 페이지</h1>
            <h2>${ now }</h2>
        </header>
        
        <nav>
            <ul>
                <li>
                    <c:url var="ex1" value="/ex1" />
                    <a href="${ ex1 }">Example 1</a>
                </li>
                <li>
                    <c:url var="sample" value="/sample" />
                    <a href="${ sample }">Sample</a>
                </li>
                <li>
                    <c:url var="forwardTest" value="/forward" />
                    <a href="${ forwardTest }">포워드 테스트</a>
                </li>
                <li>
                    <c:url var="redirectTest" value="/redirect" />
                    <a href="${ redirectTest }">리다이렉트 테스트</a>
                </li>
            </ul>
        </nav>
    </body>
</html>
