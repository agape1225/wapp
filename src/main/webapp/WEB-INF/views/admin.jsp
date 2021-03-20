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
<!--<img src="<spring:url value='${img}'/>">-->

<form method="post" action="/admin/login/lecUpload" enctype="multipart/form-data">

    category: <input type="text" name="lecCategory" /> <br>
    name: <input type="text" name="lecName" /> <br>
    price: <input type="text" name="lecPrice" /> <br>
    <label>파일:</label>
    <input type="file" name="lecImg">
    <input type="submit" value="upload">
    ​
</form>

<form method="post" action="/admin/login/banUpload" enctype="multipart/form-data">

    title: <input type="text" name="banTitle" /> <br>
    content: <input type="text" name="banContent" /> <br>
    <label>파일:</label>
    <input type="file" name="banImg">
    <input type="submit" value="upload">
    ​
</form>
</body>
</html>
