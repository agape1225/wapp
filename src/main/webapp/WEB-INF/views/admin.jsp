<%--
  Created by IntelliJ IDEA.
  User: scg92
  Date: 2021-03-11
  Time: 오전 2:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib  prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <link href="${path}/resources/css/color.css" rel="stylesheet"/>
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

<h1 style="margin-bottom: 0">강의 리스트</h1>
<div class="dataList">
    <div class="data">
        <ul>
            <c:forEach varStatus="i" var="lecture" items="${Lecture_Detail}">
                <li class="data">
                    <p style="display: inline">${lecture.lecCategory}</p>
                    <p style="display: inline">${lecture.lecName}</p>
                    <p style="display: inline">${lecture.lecPrice}</p>
                    <p style="display: inline">${lecture.lecRegDate}</p>
                    <button onclick="location.href='/delete?lecNo=${lecture.lecNo}'">삭제</button>
                </li>
            </c:forEach>
        </ul>
    </div>
</div>

<form action="/admin/login/specific_search" method="get">
    <h3>이름 검색</h3>
    <input type="text" name="LecName" />
    <button>검색</button>
</form>
<form action="/admin/login/specific_search" method="get">
    <h3>카테고리 검색</h3>
    <input type="text" name="LecCategory" />
    <button>검색</button>
</form>
<form action="/admin/login/specific_search" method="get">
    <h3>가격 검색</h3>
    <input type="text" name="minPrice"/>
    <input type="text" name="maxPrice"/>
    <button>검색</button>
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
