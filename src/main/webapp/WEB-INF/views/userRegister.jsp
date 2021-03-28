<%--
  Created by IntelliJ IDEA.
  User: rbqls
  Date: 2021-03-27
  Time: 오전 3:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form action="/user/register" method="post">
    <h3>회원가입</h3>
    <input type="text" name="userName" placeholder="이름"/>
    <input type="text" name="userEmail" placeholder="AAAA@BBBB.com"/>
    <input type="password" name="userPw" placeholder="**********"/>
    <button>가입</button>
</form>

</body>
</html>