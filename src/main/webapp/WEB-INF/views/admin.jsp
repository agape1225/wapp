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

<form method="post" action="login/upload" enctype="multipart/form-data">

    category: <input type="text" name="lecCategory" /> <br>
    name: <input type="text" name="lecName" /> <br>
    price: <input type="text" name="lecPrice" /> <br>
    <label>파일:</label>
    <input type="file" name="lecImg">
    <input type="submit" value="upload">

    ​
</form>
<h1 style="margin-bottom: 0">데이터 리스트</h1>

</body>
</html>
