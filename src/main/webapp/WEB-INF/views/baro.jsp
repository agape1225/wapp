<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="../css/bootstrap.css">
    <link href='http://fonts.googleapis.com/css?family=Roboto:400,100,300,100italic,300italic,400italic,500italic,500,700,700italic,900,900italic'
          rel='stylesheet' type='text/css'>
    <link rel="stylesheet" href="../css/style.css">
    <link rel="stylesheet" href="https://unpkg.com/swiper/swiper-bundle.css">
    <link rel="stylesheet" href="https://unpkg.com/swiper/swiper-bundle.min.css"/>
    <script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
    <script>
        $(document).ready(function(){
            $('#category option[value="${selectedCategory}"]').prop('selected', true);
            $('#sortkey option[value="${selectedSortkey}"]').prop('selected', true);
        });
        function forGetMethod() {
            var categoryElement = document.getElementById("category");
            var sortkeyElement = document.getElementById("sortkey");

            var category = categoryElement.options[categoryElement.selectedIndex].value;
            var sortkey = sortkeyElement.options[sortkeyElement.selectedIndex].value;
            window.location.href = "/baro?category=" + category + "&"+"sort=" + sortkey;
        }
    </script>
    <title>class101</title>
</head>

<body>

<div class="main-page">
    <div>
        <div class="blue-header">
            <div class="blue-header-container">
                <div class="blue-header-ment">지금 로그인하고 1000만원 당첨에 도전하기</div>
            </div>
        </div>
    </div>


    <div class="header">
        <div style="background-color: rgb(255, 255, 255); display: flex;-webkit-box-align: center; align-items: center;">
            <div class="header-container">
                <div class="logo"></div>
                <form action="" class="search">
                    <input type="search" autocomplete="off" maxlength="100" placeholder="찾으시는 취미가 있으신가요?"
                           class="search-ment">
                </form>
                <div class="login-container">

                    <c:choose>
                        <c:when test="${empty userLogin}">
                            <button style="font-weight: normal;" onclick="location.href='/user'">로그인 ${selectedCategory}</button>
                        </c:when>
                        <c:otherwise>
                            <span>${userLogin.userName}님 </span>
                            <button style="font-weight: normal;" onclick="location.href='/myPage'">마이페이지</button> <!-- 미구현 -->
                            <button style="font-weight: normal;" onclick="location.href='/logout'">로그아웃</button>
                        </c:otherwise>
                    </c:choose>

                </div>
            </div>

        </div>

        <div class="navbar">
            <div class="navbar-container">
                <button>취미</button>
                <button>수익 창출</button>
                <button>직무 ・ 자기개발</button>
                <button>시그니처</button>
                <button>아동 교육</button>
                <button>Created by</button>
                <button>DIY ・ 키트</button>
                <div class="gap"></div>
                <button style="font-weight: normal; color: #1D4EFA;">101월드</button>
                <button style="font-weight: normal; margin-right: 0px">바로 수강</button>
            </div>
        </div>

    </div>

    <div class="main-wrapper">

        <div class="empty-space"></div>

        <div class="best-class">
            <div class="text-box">
                <div>
                    <select onchange="forGetMethod()" id="category">
                        <option value="all">모두보기</option>
                        <option value="취미">취미</option>
                        <option value="수익 창출">수익 창출</option>
                        <option value="직무교육">직무교육</option>
                        <option value="데이터 · 개발">데이터 · 개발</option>
                        <option value="시그니처">시그니처</option>
                        <option value="키즈">키즈</option>
                    </select>
                    <select onchange="forGetMethod()" id="sortkey">
                        <option value="latest">최신순</option>
                        <option value="popular">인기순</option>
                    </select>
                </div>
            </div>
            <div>
                <div class="baro-wrapper">
                    <c:forEach varStatus="i" var="item" items="${lectureList}">
                    <div class="baro-content">
                        <img src="${item.lecImg}" class="baro-img">
                        <div class="card-tag">${item.lecCategory}
                            <span class="between-tag">・</span>
                            (강사이름)
                        </div>
                        <div class="best-class-name">${item.lecName}</div>
                        <div class="Spacing__Box">
                            <span class="original-price"><fmt:formatNumber value="${item.lecPrice}" type="currency" currencySymbol="" />원</span>
                        </div>
                        <div class="Spacing__Box">
                            <strong class="monthly-price">월 ??,???원(이벤트가격)</strong><br>
                            <span class="total-month"> (?개월)(이벤트기간)</span>
                        </div>
                        <form action="/user/login/likes/insert" method="post">
                            <button name="lecNo" value="${item.lecNo}">찜하기</button>
                        </form>
                        <form action="/user/login/likes/delete" method="post">
                            <button name="lecNo" value="${item.lecNo}">찜 해제하기</button>
                        </form>
                    </div>
                    </c:forEach>
                </div>
            </div>
        </div>
    </div>
</div>


<jsp:include page="/WEB-INF/views/partials/footer.jsp"/>

<script src="https://unpkg.com/swiper/swiper-bundle.js"></script>
<script src="https://unpkg.com/swiper/swiper-bundle.min.js"></script>
<script>
    // function add_like_btn(item){
    //     alert('아');
    //
    //     $.ajax({
    //         url: '/user/login/likes/insert',
    //         type: 'POST',
    //         data: JSON.stringify(item),
    //         dataType: 'json',
    //         contentType: 'application/json; charset=utf-8',
    //         success : function (data) {
    //             alert('성공');
    //         }
    //     }).done(function () {
    //         alert('찜이 추가되었습니다.');
    //         window.location.href = '/';
    //     }).fail(function (error) {
    //         alert(JSON.stringify(error));
    //     });
    // };
    // function del_like_btn(item){
    //     alert(s);
    //     $.ajax({
    //         url: '/user/login/likes/delete',
    //         type: 'POST',
    //         dataType: 'json',
    //         contentType: 'application/json; charset=utf-8',
    //         data: JSON.stringify(s)
    //     }).done(function () {
    //         window.location.href = '/';
    //     }).fail(function (error) {
    //         alert(JSON.stringify(error));
    //     });
    // };
</script>
<script src="../js/bootstrap.js"></script>
</body>
</html>