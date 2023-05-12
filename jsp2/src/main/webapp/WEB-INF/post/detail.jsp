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
            <h1>포스트 상세보기 페이지</h1>
        </header>
        
        <nav>
            <ul>
                <li>
                    <c:url value="/" var="mainPage" />
                    <a href="${ mainPage }">메인 페이지</a>
                </li>
                <li>
                    <c:url value="/post" var="postList" />
                    <a href="${ postList }">포스트 목록</a>
                </li>
                <li>
                    <a>포스트 수정</a>
                </li>
            </ul>
        </nav>
        
        <main>
            <form>
                <div>
                    <input type="text" value="${ post.id }" readonly />
                </div>
                <div>
                    <input type="text" value="${ post.title }" readonly />
                </div>
                <div>
                    <textarea rows="5" cols="80" readonly>${ post.content }</textarea>
                </div>
                <div>
                    <input type="text" value="${ post.author }" readonly />
                </div>
                <div>
                    <input type="text" value="${ post.createdTime }" readonly />
                </div>
                <div>
                    <input type="text" value="${ post.modifiedTime }" readonly />
                </div>
            </form>
        </main>
    </body>
</html>
