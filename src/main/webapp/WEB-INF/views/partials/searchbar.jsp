<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div style="background-color: rgb(255, 255, 255); display: flex;-webkit-box-align: center; align-items: center;">
    <div class="header-container">
        <a href="/">
            <div class="logo"></div>
        </a>
        <span class="search">
                    <input autocomplete="off" maxlength="100" placeholder="찾으시는 취미가 있으신가요?"
                           class="search-ment" id="input-search">
                </span>
        <button onclick="go_search()">검색</button>
        <div class="login-container">

            <c:choose>
                <c:when test="${empty userLogin}">
                    <button style="font-weight: normal;" onclick="location.href='/social_login'">로그인</button>
                </c:when>
                <c:otherwise>
                    <span>${userLogin.userName}님 </span>
                    <button style="font-weight: normal;" onclick="location.href='/user/myPage'">마이페이지</button>
                    <!-- 미구현 -->
                    <button style="font-weight: normal;" onclick="location.href='/logout'">로그아웃</button>
                </c:otherwise>
            </c:choose>
        </div>
    </div>
</div>
