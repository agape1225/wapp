<%--
  Created by IntelliJ IDEA.
  User: rbqls
  Date: 2021-03-27
  Time: 오전 3:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form action="/user/login" method="post">
    <h3>로그인</h3>
    <input type="text" name="userEmail" placeholder="id"/>
    <input type="password" name="userPw" placeholder="****"/>
    <button>로그인</button>
</form>
<form action="/user/register" method="get">
    <button>회원가입</button>
</form>

</body>
</html>