<%@ page import="java.sql.Timestamp"%>
<%@ page import="java.time.LocalDateTime"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8" />
        <title>JSP</title>
    </head>
    <body>
        <h1>JSTL fmt</h1>
        
        <%-- JSTL <fmt:formatDate> 태그는 
             java.sql.Date, java.sql.Timestamp 타입의 객체들을 원하는 형식으로 포맷팅.
             java.time.LocalDate, java.time.LocalDateTime 객체들은 포맷팅을 못함.
        --%>
        <%-- JSTL을 사용한 변수 선언 --%>
        <c:set var="now" value="<%= Timestamp.valueOf(LocalDateTime.now()) %>"></c:set>
        
        <h2>${ now }</h2>
        <h2>date: 
            <fmt:formatDate value="${ now }" type="date" />
        </h2>
        <h2>time:
            <fmt:formatDate value="${ now }" type="time" />
        </h2>
        <h2>date &amp; time:
            <fmt:formatDate value="${ now }" type="both" />
        </h2>
        <h2>
            <fmt:formatDate value="${ now }" type="both" 
                dateStyle="full" timeStyle="full" />
        </h2>
        <h2>
            <fmt:formatDate value="${ now }" type="both" 
                dateStyle="short" timeStyle="short" />
        </h2>
        <h2>
            <fmt:formatDate value="${ now }" pattern="yyyy/MM/dd HH:mm:ss" />
        </h2>
        
    </body>
</html>
