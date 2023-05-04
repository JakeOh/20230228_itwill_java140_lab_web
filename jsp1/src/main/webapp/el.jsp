<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8" />
        <title>JSP</title>
    </head>
    <body>
        <h1>EL(Expression Language)</h1>
        <%-- EL
          JSP expression 태그(<%= %>)를 대체하는 문법:
          ${ 식 }
          * 지시문 <%@ %> 안에서는 사용할 수 없음.
          * 선언문 <%! %> 안에서는 사용할 수 없음.
          * 스크립트릿 <% %> 안에서는 사용할 수 없음.
          * 식 <%= %> 안에서는 사용할 수 없음.
          * 그 이외의 JSP 안에서는 언제든지 사용 가능.
            - HTML 태그의 컨텐트
            - HTML 태그의 속성 값
            - CSS 프로퍼티 값
            - JavaScript 코드의 일부.
        --%>
        
        <p><%= 1 + 2 %></p>
        <p>${ 1 + 2 }</p>
    </body>
</html>
