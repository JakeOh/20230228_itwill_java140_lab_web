<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8" />
        <title>Spring 2</title>
    </head>
    <body>
        <header>
            <h1>포스트 목록 페이지</h1>
        </header>
        
        <nav>
            <ul>
                <li>
                    <c:url var="mainPage" value="/" />
                    <a href="${ mainPage }">메인 페이지</a>
                </li>
                <li>
                    <c:url var="postCreatePage" value="/post/create" />
                    <a href="${ postCreatePage       }">새 포스트 작성</a>
                </li>
            </ul>
        </nav>
        
        <main>
            <div>
                <table>
                    <thead>
                        <tr>
                            <th>번호</th>
                            <th>제목</th>
                            <th>내용</th>
                            <th>작성시간</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${ posts }" var="post">
                            <tr>
                                <td>${ post.id }</td>
                                <td>${ post.title }</td>
                                <td>${ post.content }</td>
                                <td>${ post.created_time }</td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </main>
    </body>
</html>
