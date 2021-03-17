<%--
  Created by IntelliJ IDEA.
  User: scg92
  Date: 2021-03-11
  Time: 오전 2:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib  prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>관리자 페이지</h1>
<img src="<spring:url value='/resources/img/test.png'/>">

<form method="post" action="login/upload" enctype="multipart/form-data">
    ​
    <br><br>
    <label>파일:</label>
    <input type="file" name="file1">
    ​
    <br><br>
    <input type="submit" value="upload">
    ​
</form>
</body>
</html>
