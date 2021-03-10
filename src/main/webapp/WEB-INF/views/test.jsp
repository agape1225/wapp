<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ysw02
  Date: 2021-01-31
  Time: 오후 7:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/get.do" method="get">
    <h3>Form 데이터 GET방식</h3>
    <input type="text" name="data" />
    <button>제출</button>
</form>

<form action="/post.do" method="post">
    <h3>Form 데이터 POST방식</h3>
    <input type="text" name="data" />
    <button>제출</button>
</form>

<h1 style="margin-bottom: 0">데이터 리스트</h1>
<div class="dataList">
    <div class="data">
        <ul>
            <c:forEach varStatus="i" var="item" items="${itemList}">
                <li class="data">
                    <p style="display: inline">${item.data}</p>
                    <button onclick="location.href='/delete.do?number=${item.number}'">삭제</button>
                    <button onclick="location.href='/update.do?number=${item.number}'">수정</button>
                </li>
            </c:forEach>
        </ul>
    </div>
</div>

<h1>카테고리</h1>
<div class="categoryList">
    <div class="data">
        <ol>
            <c:forEach varStatus="i" var="item" items="${categoryList}">
                <li class="data">
                    <p style="display: inline">${item.name}</p>
                </li>
            </c:forEach>
        </ol>

    </div>

</div>
</body>
</html>
