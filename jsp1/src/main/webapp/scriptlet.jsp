<%@page import="com.itwill.jsp1.model.Contact"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8" />
        <title>JSP</title>
    </head>
    <body>
        <h1>JSP scriptlet 활용</h1>
        <%-- scriptlet:  
          JSP 안에서 Java 코드들을 작성하기 위한 태그.
          지역 변수 선언, 객체 생성, 메서드 호출, 조건문, 반복문, ...
        --%>
        
        <% // 테이블을 작성할 더미 데이터 생성:
        ArrayList<Contact> data = new ArrayList<>(); // 빈 리스트 생성
        for (int i = 0; i < 10; i++) {
            Contact c = new Contact(i, "이름_" + i, "전화번호_" + i, "email_" + i);
            data.add(c);
        }
        %>
        
        <table>
            <caption>연락처</caption>
            <thead>
                <tr>
                    <th>NO.</th>
                    <th>이름</th>
                    <th>전화번호</th>
                    <th>이메일</th>
                </tr>
            </thead>
            <tbody>
            <% 
            for (Contact c : data) {
                // JSP 내장객체 out을 사용한 HTML 코드 출력.
                out.print("<tr>");
                out.print("<td>" + c.getId() + "</td>");
                out.print("<td>" + c.getName() + "</td>");
                out.print("<td>" + c.getPhone() + "</td>");
                out.print("<td>" + c.getEmail() + "</td>");
                out.print("</tr>");
            }
            %>
            </tbody>
        </table>
        
        <hr />
        
        <h1>scriptlet, expression 활용</h1>
        
        <table>
            <caption>연락처</caption>
            <thead>
                <tr>
                    <th>NO.</th>
                    <th>이름</th>
                    <th>전화번호</th>
                    <th>이메일</th>
                </tr>
            </thead>
            <tbody>
            <% for (Contact c : data) { %>
                <tr>
                    <td><%= c.getId() %></td>
                    <td><%= c.getName() %></td>
                    <td><%= c.getPhone() %></td>
                    <td><%= c.getEmail() %></td>
                </tr>
            <% } %>
            </tbody>
        </table>
        
        <hr />
        
        <h2>Unordered List</h2>
        <%-- ul 만들기: li은 연락처 리스트의 이름. --%>
        <ul>
        <% for (Contact c : data) { %>
            <li><%= c.getName() %></li>
        <% } %>
        </ul>
        
        <h2>Description List</h2>
        <%-- dl 만들기: dt는 연락처에서 이름, dd는 연락처에서 전화번호와 이메일 --%>
        <dl>
        <% for (Contact c : data) { %>
            <dt><%= c.getName() %></dt>
            <dd><%= c.getPhone() %></dd>
            <dd><%= c.getEmail() %></dd>
        <% } %>
        </dl>
        
    </body>
</html>
