<%--
  Created by IntelliJ IDEA.
  User: scg92
  Date: 2021-03-10
  Time: 오후 2:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>update</title>
</head>
<body>
    <h6>
        update date
    </h6>
    <form action="/update.do/update" method="POST">
        <h3> ${number}번 데이터 수정</h3>
        <input type="text" name="data" />
        <input type="hidden" value="${number}" name="number"/>
        <button>수정</button>
    </form>

</body>
</html>
