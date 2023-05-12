<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8" />
        <title>Post</title>
    </head>
    <body>
        <header>
            <h1>새 포스트 작성 페이지</h1>
        </header>
        
        <nav>
            <ul>
                <li>
                    <%-- <c:url>에서 "/" 요청주소는 context root까지. --%>
                    <c:url var="mainPage" value="/"></c:url>
                    <a href="${ mainPage }">메인 페이지</a>
                </li>
                <li>
                    <c:url var="postList" value="/post"></c:url>
                    <a href="${ postList }">포스트 목록</a>
                </li>
            </ul>
        </nav>
        
        <main>
            <c:url value="/post/create" var="postCreate" />
            <form action="${ postCreate }" method="post">
                <div>
                    <input type="text" name="title" placeholder="제목 입력"
                        required autofocus />
                </div>
                <div>
                    <textarea rows="5" cols="80" name="content" placeholder="내용 입력"
                        required></textarea>
                </div>
                <div>
                    <input type="text" name="author" placeholder="아이디 입력" required />
                </div>
                <div>
                    <input type="submit" value="작성 완료" />
                </div>
            </form>
        </main>
    </body>
</html>
