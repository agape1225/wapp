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
    <!-- check here -->
    <%--    <link rel="stylesheet" href="../css/contents.css">--%>

    <link
            rel="stylesheet"
            href="https://cdn.jsdelivr.net/gh/FortAwesome/FontAwesome@5.14.0/css/all.min.css"
    />

    <!-- check here -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <!-- check here -->
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
                <a href="/">
                    <div class="logo"></div>
                </a>
                <span class="search">
                    <input autocomplete="off" maxlength="100" placeholder="찾으시는 취미가 있으신가요?"
                           class="search-ment" id="input-search">
                    <button onclick="go_search()">검색</button>
                </span>
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

        <div class="navbar">
            <div class="navbar-container">
                <div class="dropdown" style="float:left;">
                    <button class="dropbtn">취미</button>
                    <div class="dropdown-content">
                        <a href="#">미술</a>
                        <a href="#">공예</a>
                        <a href="#">디지털 드로잉</a>
                        <a href="#">라이프 스타일</a>
                        <a href="#">사진/영상</a>
                        <a href="#">요리/음료</a>
                    </div>
                </div>
                <div class="dropdown">
                    <button class="dropbtn">수익 창출</button>
                    <div class="dropdown-content">
                        <a href="#">부동산/주식</a>
                        <a href="#">재테크</a>
                        <a href="#">온라인 쇼핑몰</a>
                        <a href="#">SNS/콘텐츠</a>
                        <a href="#">창업</a>
                        <a href="#">마인드/자기계발</a>
                    </div>
                </div>
                <div class="dropdown">
                    <button class="dropbtn">직무교육</button>
                    <div class="dropdown-content">
                        <a href="#">비즈니스/생산성</a>
                        <a href="#">영상/디자인</a>
                        <a href="#">글쓰기/콘텐츠</a>
                        <a href="#">어학/외국어</a>
                        <a href="#">기타</a>
                    </div>
                </div>
                <div class="dropdown">
                    <button class="dropbtn">데이터 ・ 개발</button>
                </div>
                <div class="dropdown">
                    <button class="dropbtn">Created by</button>
                </div>
                <div class="dropdown">
                    <button class="dropbtn">시그니쳐</button>
                </div>
                <div class="dropdown">
                    <button class="dropbtn">키즈</button>
                </div>
                <div class="dropdown">
                    <button class="dropbtn">DIY ・ 키트</button>
                    <div class="dropdown-content">
                        <a href="#">공예키트</a>
                        <a href="#">미술키트</a>
                        <a href="#">밀키트</a>
                        <a href="#">키즈키트</a>
                        <a href="#">굿즈</a>
                        <a href="#">재료&도구</a>
                    </div>
                </div>
                <div class="gap"></div>
                <button style="font-weight: normal; color: #1D4EFA;">101월드</button>
                <button style="font-weight: normal; margin-right: 0px" onclick="location.href='/baro'">바로 수강</button>
            </div>
        </div>

        <div class="main-banner">
            <div class="blue-banner"></div>
            <div class="swiper-container swiper3">
                <div class="swiper-wrapper">
                    <c:forEach var="i" begin="1" end="${bannerList.size()}">
                        <div class="swiper-slide">
                            <div class="wrapper-banner">
                                <div class="img-banner-wrapper"><img src="${bannerList[i-1].banImg}" class="img-banner">
                                </div>
                                <div class="wrapper-ment">
                                    <div class="banner-ment">
                                        <div class="ment-1">${bannerList[i-1].banTitle}</div>
                                        <div class="small-ment">${bannerList[i-1].banContent}</div>
                                    </div>
                                    <div class="banner-bar">
                                        <span>${i}</span>
                                        <div class="block"></div>
                                        <span style="margin-left: 8px">${bannerList.size()}</span>
                                        <div class="progress" style="height: 2px;">
                                            <div class="progress-bar"></div>
                                        </div>
                                        <button style="background-color:transparent; border: none; margin: 0px 6px 0px 16px;">
                                            <svg width="24" height="24">
                                                <path fill-rule="evenodd" clip-rule="evenodd"
                                                      d="M15.5 5.5l-6 6.5 6 6.5L14 20l-7.5-8L14 4l1.5 1.5z"
                                                      fill="#1a1a1a"></path>
                                            </svg>
                                        </button>
                                        <button style="background-color:transparent; border: none">
                                            <svg width="24" height="24">
                                                <path fill-rule="evenodd" clip-rule="evenodd"
                                                      d="M8.5 18.5l6-6.5-6-6.5L10 4l7.5 8-7.5 8-1.5-1.5z"
                                                      fill="#1a1a1a"></path>
                                            </svg>
                                        </button>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </c:forEach>

                    <div class="swiper-button-next"></div>
                    <div class="swiper-button-prev"></div>
                </div>
            </div>
        </div>
    </div>

    <div class="main-wrapper">
        <div class="Categories">
            <div class="container">
                <div class="container-box">
                    <img src="../img/im-101-world-free-klass.png" class="img-responsive" alt="Responsive image">
                    <div class="image-text">오늘의 0원</div>
                </div>
                <div class="container-box">
                    <img src="../img/im-101-world-24hours.png" class="img-responsive" alt="Responsive image">
                    <div class="image-text">단 24시간</div>

                </div>
                <div class="container-box">
                    <img src="../img/im-101-world-65percent.png" class="img-responsive" alt="Responsive image">
                    <div class="image-text">최대 65%</div>

                </div>
                <div class="container-box">
                    <img src="../img/im-101-world-free-kit.png" class="img-responsive" alt="Responsive image">
                    <div class="image-text">준비물 무료</div>

                </div>
                <div class="container-box">
                    <img src="../img/im-101-world-big.png" class="img-responsive" alt="Responsive image">
                    <div class="image-text">BIG 이용권</div>

                </div>
                <div class="container-box">
                    <img src="../img/im-101-world-kids.png" class="img-responsive" alt="Responsive image">
                    <div class="image-text">키즈존 할인</div>
                </div>
            </div>
        </div>

        <div class="banner">
            <div type="ResponsiveBanner" class="banner-box">
                <div style="color:white" class="banner-title">준비물까지 챙겨주는 클래스101</div>
                <div style="color:white" class="banner-description">부업 클래스 단독 최대 할인! ></div>
            </div>
            <div class="banner-img">
                <img src="../img/375xauto.webp" class="banner-img" alt="Responsive image">
            </div>
        </div>

        <div class="empty-space"></div>

        <div class="time-sale">
            <div class="text-box">
                <div class="class-title">
                    <div class="class-text" style="float: left; margin-right:19px; font-weight: bold">오늘의 0원 종료까지</div>
                    <div id="class-time" style="color: blue; font-weight: bold"></div>
                </div>
                <div style="color: gray" class="class-description">매일 오후 2시! 다른 클래스와 함께 구매시 오늘만 무료</div>
            </div>
            <div class="class-advertise">
                <div class="class-img-wrapper">
                    <img src="../../resources/../img/screencap.PNG" class="class-img" alt="Responsive image">
                </div>
                <div class="class-info">
                    <div style="font-size: 20px" class="creater-name">보람</div>
                    <div style="font-size: 26px; font-weight: bold" class="lecture-name">연필과 종이로 만들어내는 동화 일러스트</div>
                    <div class="price-box">
                        <div style="text-decoration-line: line-through; color: #3c3c3c" class="cost">279,000
                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;>
                        </div>
                        <div style="color: blue; font-weight: bold;" class="free-text">오늘만 0원</div>
                    </div>
                    <button type="button" class="btn btn-primary btn-lg btn-block">지금 마법 카트에 담기</button>

                </div>
            </div>
        </div>
        <div class="empty-space"></div>


        <div class="card-wrapper">
            <div class="best-class">
                <div class="text-box">
                    <div class="class-title">
                        <div class="class-text" style="margin-right:19px; font-weight: bold">MD 추천 클래스
                        </div>
                    </div>
                    <div style="color: gray" class="class-description"></div>
                </div>
                <div class="swiper-container swiper1">
                    <div class="swiper-wrapper">
                        <c:forEach varStatus="i" var="item" items="${lectureList}">
                            <div class="swiper-slide">
                                <div class="slide-content">
                                    <img src="${item.lecImg}" class="slide-img">
                                    <div class="class-box__heart"><i
                                            class="far fa-heart class-box__heart-btn"></i>
                                    </div>
                                    <div class="card-tag">${item.lecCategory}
                                    </div>
                                    <div class="best-class-name">${item.lecName}</div>
                                    <div class="Spacing__Box">
                                        <strong class="original-price"><fmt:formatNumber value="${item.lecPrice}"
                                                                                         type="currency"
                                                                                         currencySymbol=""/>원</strong>
                                    </div>
                                    <button name="lecNo" value="${item.lecNo}"
                                            onclick="btn_add_likes_onclick(${item.lecNo})">찜하기
                                    </button>
                                    <button name="lecNo" value="${item.lecNo}"
                                            onclick="btn_del_likes_onclick(${item.lecNo})">찜 해제하기
                                    </button>
                                </div>
                            </div>
                        </c:forEach>
                    </div>
                    <!-- Add Arrows -->
                    <div class="swiper-button-next"></div>
                    <div class="swiper-button-prev"></div>
                </div>
            </div>
            <div class="empty-space"></div>

            <%--        Mainpage Top Tutor Cards        --%>
            <div class="tutor-card">
                <div class="text-box">
                    <div class="class-title">
                        <div class="class-text" style="margin-right:19px; font-weight: bold">실시간 TOP 10 클래스
                        </div>
                    </div>
                    <div style="color: gray" class="class-description"></div>
                </div>

                <div class="swiper-container swiper1">
                    <div class="swiper-wrapper">
                        <c:forEach varStatus="i" begin="0" end="${popularLectureList.size()}" var="item"
                                   items="${popularLectureList}">
                            <div class="swiper-slide">
                                <div class="slide-content">
                                    <img src="${item.lecImg}" class="slide-img">
                                    <div class="card-tag">${item.lecCategory}
                                    </div>
                                    <div class="best-class-name">${item.lecName}</div>
                                    <div class="Spacing__Box">
                                        <strong class="original-price"><fmt:formatNumber value="${item.lecPrice}"
                                                                                         type="currency"
                                                                                         currencySymbol=""/>원</strong>
                                    </div>
                                    <button name="lecNo" value="${item.lecNo}"
                                            onclick="btn_add_likes_onclick(${item.lecNo})">찜하기
                                    </button>
                                    <button name="lecNo" value="${item.lecNo}"
                                            onclick="btn_del_likes_onclick(${item.lecNo})">찜 해제하기
                                    </button>
                                </div>
                            </div>
                        </c:forEach>
                    </div>
                    <!-- Add Arrows -->
                    <div class="swiper-button-next"></div>
                    <div class="swiper-button-prev"></div>
                </div>
            </div>
            <div class="empty-space"></div>

            <%--        Mainpage This Month Promotion Cards        --%>
            <div class="promotion-card">
                <div class="text-box">
                    <div class="class-title">
                        <div class="class-text" style="margin-right:19px; font-weight: bold">101월드, 모든 혜택 모아보기</div>
                        <div style="color: gray" class="class-description"></div>
                    </div>
                </div>

                <div class="swiper-container swiper2">
                    <div class="swiper-wrapper">
                        <%--현재시간을 date타입 변수로 불러오기--%>
                        <c:set var="currentTime" value="<%=new java.util.Date()%>"/>

                        <c:forEach var="item" items="${benefitList}">
                            <%-- statrTime, endTime을 Date타입 변수로 변환 --%>
                            <fmt:parseDate var="startTime" value="${item.benStartTime}" pattern="yyyy-MM-dd"/>
                            <fmt:parseDate var="endTime" value="${item.benEndTime}" pattern="yyyy-MM-dd"/>
                            <%-- statrTime, endTime을 Day(integer)로 변환 --%>
                            <fmt:parseNumber value="${currentTime.time/(1000*60*60*24)}" integerOnly="true" var="today"
                                             scope="request"/>
                            <fmt:parseNumber value="${endTime.time/(1000*60*60*24)}" integerOnly="true" var="endDay"
                                             scope="request"/>
                            <fmt:parseNumber value="${startTime.time/(1000*60*60*24)}" integerOnly="true" var="startDay"
                                             scope="request"/>
                            <%-- 시작, 종료까지 남은날짜 계산 --%>
                            <c:set value="${endDay-today+1}" var="Dday"/>
                            <c:set value="${today-startDay-1}" var="timeLeft"/>

                            <c:choose>
                                <%-- Dday가 0보다 클때 && timeLeft이 0 이상일때만 표시--%>
                                <c:when test="${(Dday >= 0) && (timeLeft >= 0)}">
                                    <div class="swiper-slide benefits">
                                        <div class="slide-content benefit">
                                            <img src="${item.benImg}" class="slide-img">
                                            <div class="best-class-name">${item.benTitle}</div>
                                            <div class="Spacing__Box">
                                                <span class="total-month"
                                                      style="color: rgb(253, 48, 73); font-weight: bold">D-${Dday}</span>
                                                <fmt:formatDate value="${startTime}" pattern="MM.dd (E)"/>~
                                                <fmt:formatDate value="${endTime}" pattern="MM.dd (E)"/>
                                            </div>
                                        </div>
                                    </div>
                                </c:when>
                            </c:choose>
                        </c:forEach>
                    </div>
                    <!-- Add Arrows -->
                    <div class="swiper-button-next"></div>
                    <div class="swiper-button-prev"></div>
                </div>
            </div>
            <div class="empty-space"></div>

            <%--        Mainpage Popular Item  Cards        --%>
            <div class="popular-card">
                <div class="text-box">
                    <div class="class-title">
                        <div class="class-text" style="margin-right:19px; font-weight: bold">인기있는 신규 클래스</div>
                    </div>
                    <div style="color: gray" class="class-description">얼리버드 기간에만 받을 수 있는 최저가 할인 중이에요.</div>
                </div>

                <div class="swiper-container swiper1">
                    <div class="swiper-wrapper">
                        <c:forEach varStatus="i" begin="0" end="6" var="item" items="${newLectureList}">
                            <div class="swiper-slide">
                                <div class="slide-content">
                                    <img src="${item.lecImg}" class="slide-img">
                                    <div class="card-tag">${item.lecCategory}
                                            <%--                                        <span class="between-tag">・</span>--%>
                                            <%--                                        (강사이름)--%>
                                    </div>
                                    <div class="best-class-name">${item.lecName}</div>
                                    <div class="Spacing__Box">
                                        <strong class="original-price"><fmt:formatNumber value="${item.lecPrice}"
                                                                                         type="currency"
                                                                                         currencySymbol=""/>원</strong>
                                    </div>
                                    <div class="like-number">
                                        ♥${item.lecLike}
                                    </div>
                                        <%--                                    <div class="Spacing__Box">--%>
                                        <%--                                        <strong class="monthly-price">월 ??,???원(이벤트가격)</strong>--%>
                                        <%--                                        <span class="total-month"> (?개월)(이벤트기간)</span>--%>
                                        <%--                                    </div>--%>
                                    <button name="lecNo" value="${item.lecNo}"
                                            onclick="btn_add_likes_onclick(${item.lecNo})">찜하기
                                    </button>
                                    <button name="lecNo" value="${item.lecNo}"
                                            onclick="btn_del_likes_onclick(${item.lecNo})">찜 해제하기
                                    </button>
                                </div>
                            </div>
                        </c:forEach>
                    </div>
                    <!-- Add Arrows -->
                    <div class="swiper-button-next"></div>
                    <div class="swiper-button-prev"></div>
                </div>
            </div>
            <div class="empty-space"></div>
        </div>


    </div>
</div>


<jsp:include page="/WEB-INF/views/partials/footer.jsp"/>


<script>
    const countDownTimer = function (id, date) {
        var _vDate = new Date(date);// 전달받은 일자
        var _second = 1000;
        var _minute = _second * 60;
        var _hour = _minute * 60;
        var timer;

        function showRemaining() {
            var now = new Date();
            var distDt = _vDate - now;

            var hours = Math.floor((distDt % _hour * 24) / _hour);
            var minutes = Math.floor((distDt % _hour) / _minute);
            var seconds = Math.floor((distDt % _minute) / _second);

            document.getElementById(id).textContent = ' ';
            document.getElementById(id).textContent += hours;
            document.getElementById(id).textContent += ((minutes < 10) ? ":0" : ":") + minutes;
            document.getElementById(id).textContent += ((seconds < 10) ? ":0" : ":") + seconds;
        }

        timer = setInterval(showRemaining, 1000);
    }

    var dateObj = new Date();
    dateObj.setDate(dateObj.getDate() + 1);
    countDownTimer('class-time', dateObj);
</script>


<script src="https://unpkg.com/swiper/swiper-bundle.js"></script>
<script src="https://unpkg.com/swiper/swiper-bundle.min.js"></script>
<script>
    var swiper = new Swiper('.swiper1', {
        slidesPerView: 4,
        spaceBetween: 30,
        slidesPerGroup: 1,
        loop: true,
        loopFillGroupWithBlank: true,
        pagination: {
            el: '.swiper-pagination',
            clickable: true,
        },
        navigation: {
            nextEl: '.swiper-button-next',
            prevEl: '.swiper-button-prev',
        },
    });

    var swiper = new Swiper('.swiper2', {
        slidesPerView: 3,
        spaceBetween: 30,
        slidesPerGroup: 1,
        loop: true,
        loopFillGroupWithBlank: true,
        pagination: {
            el: '.swiper-pagination',
            clickable: true,
        },
        navigation: {
            nextEl: '.swiper-button-next',
            prevEl: '.swiper-button-prev',
        },
    });

    var swiper = new Swiper('.swiper3', {
        slidesPerView: 1,
        spaceBetween: 30,
        slidesPerGroup: 1,
        loop: true,
        loopFillGroupWithBlank: true,

        autoplay: {delay: 10000},

        pagination: {
            el: '.swiper-pagination',
            clickable: true,
        },
        navigation: {
            nextEl: '.swiper-button-next',
            prevEl: '.swiper-button-prev',
        },
    });


</script>


<script>
    function btn_add_likes_onclick(lecNo) {
        console.log(lecNo);
        var data = {"lecNo": lecNo};
        $.ajax({
            type: 'POST',
            url: '/user/likes/insert',
            dataType: 'json',
            contentType: 'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function (result) {
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
            contentType: 'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function (result) {
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
    function go_search() {
        var search_url = "/search?";
        var inputVal = document.getElementById('input-search').value;
        if (inputVal != null && inputVal !='') {
            search_url += 'query='+inputVal;
        }
        window.location.href = search_url;

    }
</script>
<script src="../js/bootstrap.js"></script>
</body>
</html>