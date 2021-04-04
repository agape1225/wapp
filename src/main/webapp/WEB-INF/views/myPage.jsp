<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: rbqls
  Date: 2021-04-01
  Time: 오후 9:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>마이 페이지</title>
</head>
<body>
<table>
    <tr>
        <th>lecNo</th>
        <th>lecCategory</th>
        <th>lecName</th>
        <th>lecPrice</th>
        <th>lecRegDate</th>
        <th>lecImg</th>
    </tr>
    <c:forEach var="lecInfo" items="${lectureList}">
        <tr>
            <td>${lecInfo.lecNo}</td>
            <td>${lecInfo.lecCategory}</td>
            <td>${lecInfo.lecName}</td>
            <td>${lecInfo.lecPrice}</td>
            <td>${lecInfo.lecRegDate}</td>
            <td>${lecInfo.lecImg}</td>
        </tr>
    </c:forEach>
</table>

<button style="font-weight: normal;" onclick="location.href='/logout'">로그아웃</button>

</body>
</html>
