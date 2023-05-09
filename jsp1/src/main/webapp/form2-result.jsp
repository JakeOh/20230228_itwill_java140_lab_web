<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8" />
        <title>JSP</title>
        
        <% 
        // 요청 파라미터의 한글이 깨지지 않도록 하기 위해서:
        request.setCharacterEncoding("UTF-8");
        
        // 요청 파라미터 값 찾기:
        String username = request.getParameter("username");
        String color = request.getParameter("color");
        String colorValue = "black";
        if (color.equals("r")) {
            colorValue = "crimson";
        } else if (color.equals("g")) {
            colorValue = "darkgreen";
        } else if (color.equals("b")) {
            colorValue = "dodgerblue";
        }
        %>
        
        <c:set var="colorValue2" value="black"></c:set>
        <c:if test="${ param.color == 'r' }">
            <c:set var="colorValue2" value="red"></c:set>
        </c:if>
        <c:if test="${ param.color == 'g' }">
            <c:set var="colorValue2" value="green"></c:set>
        </c:if>
        <c:if test="${ param.color == 'b' }">
            <c:set var="colorValue2" value="blue"></c:set>
        </c:if>
        
        <style>
        span#span1 {
            color: <%= colorValue %>;
        }
        
        span#span2 {
            color: ${ colorValue2 };
            <%-- JSTL의 <c:set> 태그에서 선언한 변수는 EL에서 사용 가능. --%>
        }
        </style>
    </head>
    <body>
        <h1>요청 결과 페이지</h1>
        <h2>JSP</h2>
        <h3>아이디: 
            <span id="span1"><%= username %></span>
        </h3>
        
        <hr />
        <h2>JSTL, EL</h2>
        <h3>아이디:
            <span id="span2">${ param.username }</span>
        </h3>
        
        <hr />
        <c:choose>
            <c:when test="${ param.username == 'admin' }">
                <h2>관리자 페이지</h2>
            </c:when>
            <c:otherwise>
                <h2>일반 사용자 페이지</h2>
            </c:otherwise>
        </c:choose>
    </body>
</html>
