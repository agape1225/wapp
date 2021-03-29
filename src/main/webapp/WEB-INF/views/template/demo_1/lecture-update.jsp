<%--
  Created by IntelliJ IDEA.
  User: rbqls
  Date: 2021-03-21
  Time: 오전 1:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>강의 수정</title>
</head>
<body>
<h1>강의 수정 페이지</h1>

<div>
    <div>
        <form action="/admin/login/update/${lecNo}" method="post">
            <div>
                <label for="lecNo"> 강의 번호 </label>
                <input type="text" id="lecNo" value="${lecture.lecNo}" readonly>
            </div>
            <div>
                <label for="lecName"> 강의 이름 </label>
                <input type="text" id="lecName" name="lecName" value="${lecture.lecName}">
            </div>
            <div>
                <label for="lecCategory"> 카테고리 </label>
                <input type="text" id="lecCategory" name="lecCategory" value="${lecture.lecCategory}" >
            </div>
            <div>
                <label for="lecRegDate"> 생성 날짜 </label>
                <input type="text" id="lecRegDate" value="${lecture.lecRegDate}" readonly>
            </div>
            <div>
                <label for="lecImg"> 이미지 </label>
                <input type="text" id="lecImg" name="lecImg" value="${lecture.lecImg}">
            </div>
            <div>
                <label for="lecPrice"> 가격 </label>
                <input type="text" id="lecPrice" name="lecPrice" value="${lecture.lecPrice}">
            </div>
            <button type="button">수정 완료</button>
        </form>
        <a href="/admin" role="button">취소</a>
    </div>
</div>

</body>
</html>
