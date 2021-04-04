
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
                            <button style="font-weight: normal;" onclick="location.href='/user'">로그인</button>
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
                    <select id="exampleInputText1" name="Category" oninput="btn_status()">
                        <option value="취미">취미</option>
                        <option value="수익 창출">수익 창출</option>
                        <option value="직무교육">직무교육</option>
                        <option value="데이터 · 개발">데이터 · 개발</option>
                        <option value="시그니처">시그니처</option>
                        <option value="키즈">키즈</option>
                    </select>
                    <select id="exampleInputText2" name="sort" oninput="btn_status()">
                        <option value="최신순">최신순</option>
                        <option value="인기순">인기순</option>
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
                            <strong class="monthly-price">월 ??,???원(이벤트가격)</strong>
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

<%--<div class="recent-book">

        <a href="/bookboard?book=1186343133 9791186343135">
            <div class="recent-book__info">
                <div class="recent-book__info__detail"><img class="recent-book__image" src="https://search1.kakaocdn.net/thumb/R120x174.q85/?fname=http%3A%2F%2Ft1.daumcdn.net%2Flbook%2Fimage%2F5462088%3Ftimestamp%3D20201212154728">
                </div>
                <div class="recent-book__info__detail">
                    <div class="recent-book__title">그림의 힘(리커버 에디션)</div>
                    <div class="recent-book__author">김선현

                    </div>
                </div>
            </div>
        </a>

        <a href="/bookboard?book=1190090015 9791190090018">
            <div class="recent-book__info">
                <div class="recent-book__info__detail"><img class="recent-book__image" src="https://search1.kakaocdn.net/thumb/R120x174.q85/?fname=http%3A%2F%2Ft1.daumcdn.net%2Flbook%2Fimage%2F4966995%3Ftimestamp%3D20201102141955">
                </div>
                <div class="recent-book__info__detail">
                    <div class="recent-book__title">우리가 빛의 속도로 갈 수 없다면(양장본 HardCover)</div>
                    <div class="recent-book__author">김초엽

                    </div>
                </div>
            </div>
        </a>

        <a href="/bookboard?book=8937473097 9788937473098">
            <div class="recent-book__info">
                <div class="recent-book__info__detail"><img class="recent-book__image" src="https://search1.kakaocdn.net/thumb/R120x174.q85/?fname=http%3A%2F%2Ft1.daumcdn.net%2Flbook%2Fimage%2F541125%3Ftimestamp%3D20201031140640">
                </div>
                <div class="recent-book__info__detail">
                    <div class="recent-book__title">보건교사 안은영(오늘의 젊은 작가 9)(양장본 HardCover)</div>
                    <div class="recent-book__author">정세랑

                    </div>
                </div>
            </div>
        </a>

    </div>--%>