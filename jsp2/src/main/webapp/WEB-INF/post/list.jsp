<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8" />
        <title>Post</title>
    </head>
    <body>
        <header>
            <h1>포스트 목록 페이지</h1>
        </header>
        
        <nav>
            <ul>
                <li>
                    <%-- 상대경로에서 현재 폴더(./)의 의미: context root까지의 주소 
                         http://localhost:8081/post/
                    --%>
                    <a href="./">메인 페이지</a>
                </li>
            </ul>
        </nav>
    </body>
</html>
