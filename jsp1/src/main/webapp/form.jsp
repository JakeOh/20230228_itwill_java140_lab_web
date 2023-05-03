<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8" />
        <title>JSP</title>
    </head>
    <body>
        <!-- 요청 방식(method) 
           1. GET: 기본값. 클라이언트에서 서버로 보내는 정보가 질의 문자열(query string)에 포함.
           2. POST: 클라이언트에서 서버로 보내는 정보가 HTTP 패킷에 포함되는 방식.
           (참고) URL 형식
           프로토콜://서버주소:포트/(context root 포함)경로?질의문자열
           http://192.168.20.31:8081/jsp1/form-result.jsp?username=오쌤
        -->
        <form action="form-result.jsp" method="post">
            <input type="text" name="username" placeholder="이름 입력"
                required autofocus />
            <input type="submit" value="전송" />
        </form>
    </body>
</html>
