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
    <link rel="stylesheet" href="../css/contents.css">
    <link rel="stylesheet" href="https://unpkg.com/swiper/swiper-bundle.css">
    <link rel="stylesheet" href="https://unpkg.com/swiper/swiper-bundle.min.css"/>
    <link
            rel="stylesheet"
            href="https://cdn.jsdelivr.net/gh/FortAwesome/Font-Awesome@5.14.0/css/all.min.css"
    />
    <script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
    <script>
        $(document).ready(function () {
            $('#category option[value="${selectedCategory}"]').prop('selected', true);
            $('#sortkey option[value="${selectedSortkey}"]').prop('selected', true);
        });

        function forGetMethod() {
            var categoryElement = document.getElementById("category");
            var sortkeyElement = document.getElementById("sortkey");

            var category = categoryElement.options[categoryElement.selectedIndex].value;
            var sortkey = sortkeyElement.options[sortkeyElement.selectedIndex].value;
            window.location.href = "/baro?category=" + category + "&" + "sort=" + sortkey;
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
                <a href="/"><div class="logo"></div></a>
                <span class="search">
                    <c:choose>
                        <c:when test="${empty query}">
                            <input autocomplete="off" maxlength="100" placeholder="찾으시는 취미가 있으신가요?"
                                   class="search-ment" id="input-search">
                        </c:when>
                        <c:otherwise>
                            <input autocomplete="off" maxlength="100" value="${query}"
                                   class="search-ment" id="input-search">
                        </c:otherwise>
                    </c:choose>
                    <button onclick="go_search()">검색</button>
                </span>
                <div class="login-container">

                    <c:choose>
                        <c:when test="${empty userLogin}">
                            <button style="font-weight: normal;" onclick="location.href='/social_login'">로그인 ${selectedCategory}</button>
                        </c:when>
                        <c:otherwise>
                            <span>${userLogin.userName}님 </span>
                            <button style="font-weight: normal;" onclick="location.href='/user/myPage'">마이페이지</button> <!-- 미구현 -->
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
        <div class="baro-page">
            <div class="empty-space"></div>
                <div class="text-box">
                    <div>
                        <div class="dropdown" style="float:left">
                            <button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu1"
                                    data-toggle="dropdown" aria-haspopup="false" aria-expanded="true">
                                모두보기
                                <span class="caret"></span>
                            </button>
                            <div class="dropdown-menu" aria-labelledby="dropdownMenu1">
                                <li role="presentation"><a role="menuitem" tabindex="-1" href="#">취미</a></li>
                                <li role="presentation"><a role="menuitem" tabindex="-1" href="#">수익 창출</a></li>
                                <li role="presentation"><a role="menuitem" tabindex="-1" href="#">직무교육</a></li>
                                <li role="presentation"><a role="menuitem" tabindex="-1" href="#">데이터 · 개발</a></li>
                                <li role="presentation"><a role="menuitem" tabindex="-1" href="#">시그니처</a></li>
                                <li role="presentation"><a role="menuitem" tabindex="-1" href="#">키즈</a></li>
                            </div>
                        </div>
                        <div class="dropdown">
                            <button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu2"
                                    data-toggle="dropdown" aria-haspopup="false" aria-expanded="true">
                                최신순
                                <span class="caret"></span>
                            </button>
                            <div class="dropdown-menu" aria-labelledby="dropdownMenu2">
                                <li role="presentation"><a role="menuitem" tabindex="-1" href="#">최신순</a></li>
                                <li role="presentation"><a role="menuitem" tabindex="-1" href="#">인기순</a></li>
                            </div>
                        </div>
<%--                        <select onchange="forGetMethod()" id="category">--%>
<%--                            <option value="all">모두보기</option>--%>
<%--                            <option value="취미">취미</option>--%>
<%--                            <option value="수익 창출">수익 창출</option>--%>
<%--                            <option value="직무교육">직무교육</option>--%>
<%--                            <option value="데이터 · 개발">데이터 · 개발</option>--%>
<%--                            <option value="시그니처">시그니처</option>--%>
<%--                            <option value="키즈">키즈</option>--%>
<%--                        </select>--%>
<%--                        <select onchange="forGetMethod()" id="sortkey">--%>
<%--                            <option value="latest">최신순</option>--%>
<%--                            <option value="popular">인기순</option>--%>
<%--                        </select>--%>
                    </div>
                </div>
                <div class="empty-space"></div>
                <div class="baro-wrapper">
                    <div class="baro-content">
                        <c:forEach varStatus="i" var="item" items="${lectureList}">
                            <div class="baro-content">
                                <img src="${item.lecImg}" class="baro-img">
                                <div class="card-tag">${item.lecCategory}
                                    <span class="between-tag">・</span>
                                    (강사이름)
                                </div>
                                <div class="best-class-name">${item.lecName}</div>
                                <div class="Spacing__Box">
                                                <span class="original-price"><fmt:formatNumber value="${item.lecPrice}"
                                                                                               type="currency"
                                                                                               currencySymbol=""/>원</span>
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
                    <div class="baro-content">
                        <img src="../img/hahaha.png" class="baro-img">
                        <div class="card-tag">디지털 드로잉
                            <span class="between-tag">・</span>
                            이지
                        </div>
                        <div class="best-class-name">[단 24시간] 무채색이 주는 다채로움, 이지의 패션 크로키와 데일리룩 기록하기</div>
                        <div class="Spacing__Box">
                                <span class="original-price"><fmt:formatNumber value="${item.lecPrice}" type="currency"
                                                                               currencySymbol=""/>원</span>
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
                    <div class="baro-content">
                        <img src="../img/hahaha.png" class="baro-img">
                        <div class="card-tag">디지털 드로잉
                            <span class="between-tag">・</span>
                            이지
                        </div>
                        <div class="best-class-name">[단 24시간] 무채색이 주는 다채로움, 이지의 패션 크로키와 데일리룩 기록하기</div>
                        <div class="Spacing__Box">
                                <span class="original-price"><fmt:formatNumber value="${item.lecPrice}" type="currency"
                                                                               currencySymbol=""/>원</span>
                        </div>
                        <div class="Spacing__Box">
                            <strong class="monthly-price">월 ??,???원(이벤트가격)</strong><br>
                            <span class="total-month"> (?개월)(이벤트기간)</span>
                        </div>
                        <button name="lecNo" value="${item.lecNo}" onclick="btn_add_likes_onclick(${item.lecNo})">찜하기</button>
                        <button name="lecNo" value="${item.lecNo}" onclick="btn_del_likes_onclick(${item.lecNo})">찜 해제하기</button>
                    </div>
                </div>
                <div class="empty-space"></div>

        </div>
    </div>
</div>


<jsp:include page="/WEB-INF/views/partials/footer.jsp"/>

<script src="https://unpkg.com/swiper/swiper-bundle.js"></script>
<script src="https://unpkg.com/swiper/swiper-bundle.min.js"></script>
<script>
    function go_search() {
        var search_url = "/search?";
        var inputVal = document.getElementById('input-search').value;
        console.log(inputVal);
        if (inputVal != null && inputVal !='') {
            search_url += 'query='+inputVal;
        }
        location.replace(search_url);
    }
</script>
<script>
    function btn_add_likes_onclick(lecNo) {
        console.log(lecNo);
        var data = {"lecNo": lecNo};
        $.ajax({
            type: 'POST',
            url: '/user/likes/insert',
            dataType: 'json',
            contentType:'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function(result) {
            console.log(result);
            if (result === true) {
                alert('찜이 추가되었습니다.');
            } else {
                alert('이미 찜하기한 강의입니다.');
            }
        }).fail(function (error) {
            window.location.href = '/login';
        });
    }
    function btn_del_likes_onclick(lecNo) {
        console.log(lecNo);
        var data = {"lecNo": lecNo};
        $.ajax({
            type: 'POST',
            url: '/user/likes/delete',
            dataType: 'json',
            contentType:'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function(result) {
            console.log(result);
            if (result === true) {
                alert('찜이 해제되었습니다.');
            } else {
                alert('찜하지 않은 강의입니다.');
            }
        }).fail(function (error) {
            window.location.href = '/login';
        });
    }
</script>
<script src="../js/bootstrap.js"></script>
</body>
</html>