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
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
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
                            <button style="font-weight: normal;" onclick="location.href='/myPage'">마이페이지</button>
                            <!-- 미구현 -->
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
                <button style="font-weight: normal; margin-right: 0px" onclick="location.href='/baro'">바로 수강</button>
            </div>
        </div>

        <div class="main-banner">
            <div class="blue-banner"></div>
            <div class="wrapper-banner">
                <div class="img-banner"></div>
                <div class="wrapper-ment">
                    <div class="banner-ment">
                        <div class="ment-1">선착순 한정 필수 준비물이 무료!</div>
                        <div class="small-ment">최대 9만원 상당 준비물 전격 지원</div>
                    </div>

                    <div class="banner-bar">
                        <span>02</span>
                        <div class="block"></div>
                        <span style="margin-left: 8px">16</span>
                        <div class="progress" style="height: 2px;">
                            <div class="progress-bar"></div>
                        </div>
                        <button style="background-color:transparent; border: none; margin: 0px 6px 0px 16px;">
                            <svg width="24" height="24">
                                <path fill-rule="evenodd" clip-rule="evenodd"
                                      d="M15.5 5.5l-6 6.5 6 6.5L14 20l-7.5-8L14 4l1.5 1.5z" fill="#1a1a1a"></path>
                            </svg>
                        </button>
                        <button style="background-color:transparent; border: none">
                            <svg width="24" height="24">
                                <path fill-rule="evenodd" clip-rule="evenodd"
                                      d="M8.5 18.5l6-6.5-6-6.5L10 4l7.5 8-7.5 8-1.5-1.5z" fill="#1a1a1a"></path>
                            </svg>
                        </button>
                    </div>
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
                <div class="swiper-container">
                    <div class="swiper-wrapper">
                        <c:forEach varStatus="i" var="item" items="${lectureList}">
                            <div class="swiper-slide">
                                <div class="slide-content">
                                    <img src="${item.lecImg}" class="slide-img">
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
                                        <strong class="monthly-price">월 ??,???원(이벤트가격)</strong>
                                        <span class="total-month"> (?개월)(이벤트기간)</span>
                                    </div>
                                    <button name="lecNo" value="${item.lecNo}" onclick="btn_add_likes_onclick(${item.lecNo})">찜하기</button>
                                    <button name="lecNo" value="${item.lecNo}" onclick="btn_del_likes_onclick(${item.lecNo})">찜 해제하기</button>
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

                <div class="swiper-container">
                    <div class="swiper-wrapper">
                        <c:forEach varStatus="i" begin="0" end="${popularLectureList.size()}" var="item"
                                   items="${popularLectureList}">
                            <div class="swiper-slide">
                                <div class="slide-content">
                                    <img src="${item.lecImg}" class="slide-img">
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
                                    <div class="registered-date">
                                            ${item.lecRegDate}
                                    </div>
                                    <div class="Spacing__Box">
                                        <strong class="monthly-price">월 ??,???원(이벤트가격)</strong>
                                        <span class="total-month"> (?개월)(이벤트기간)</span>
                                    </div>
                                    <button name="lecNo" value="${item.lecNo}" onclick="btn_add_likes_onclick(${item.lecNo})">찜하기</button>
                                    <button name="lecNo" value="${item.lecNo}" onclick="btn_del_likes_onclick(${item.lecNo})">찜 해제하기</button>
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

                <div class="swiper-container">
                    <div class="swiper-wrapper">
                        <div class="swiper-slide">
                            <div class="slide-content">
                                <img src="/files/lectureImage/20210404235159_2.jpg" class="slide-img">
                                <div class="card-tag">디지털 드로잉
                                    <span class="between-tag">・</span>
                                    이지
                                </div>
                                <div class="best-class-name">[단 24시간] 무채색이 주는 다채로움, 이지의 패션 크로키와 데일리룩 기록하기</div>
                            </div>
                        </div>
                        <div class="swiper-slide">
                            <div class="slide-content">
                                <img src="/files/lectureImage/20210404235159_2.jpg" class="slide-img">
                                <div class="card-tag">디지털 드로잉
                                    <span class="between-tag">・</span>
                                    이지
                                </div>
                                <div class="best-class-name">[단 24시간] 무채색이 주는 다채로움, 이지의 패션 크로키와 데일리룩 기록하기</div>
                            </div>
                        </div>
                        <div class="swiper-slide">
                            <div class="slide-content">
                                <img src="/files/lectureImage/20210404235159_2.jpg" class="slide-img">
                                <div class="card-tag">디지털 드로잉
                                    <span class="between-tag">・</span>
                                    이지
                                </div>
                                <div class="best-class-name">[단 24시간] 무채색이 주는 다채로움, 이지의 패션 크로키와 데일리룩 기록하기</div>
                            </div>
                        </div>
                        <div class="swiper-slide">
                            <div class="slide-content">
                                <img src="/files/lectureImage/20210404235159_2.jpg" class="slide-img">
                                <div class="card-tag">디지털 드로잉
                                    <span class="between-tag">・</span>
                                    이지
                                </div>
                                <div class="best-class-name">[단 24시간] 무채색이 주는 다채로움, 이지의 패션 크로키와 데일리룩 기록하기</div>
                            </div>
                        </div>
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

                <div class="swiper-container">
                    <div class="swiper-wrapper">
                        <c:forEach varStatus="i" begin="0" end="6" var="item" items="${newLectureList}">
                            <div class="swiper-slide">
                                <div class="slide-content">
                                    <img src="${item.lecImg}" class="slide-img">
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
                                    <div class="like-number">
                                        찜한 수 ${item.lecLike}
                                    </div>
                                    <div class="Spacing__Box">
                                        <strong class="monthly-price">월 ??,???원(이벤트가격)</strong>
                                        <span class="total-month"> (?개월)(이벤트기간)</span>
                                    </div>
                                    <button name="lecNo" value="${item.lecNo}" onclick="btn_add_likes_onclick(${item.lecNo})">찜하기</button>
                                    <button name="lecNo" value="${item.lecNo}" onclick="btn_del_likes_onclick(${item.lecNo})">찜 해제하기</button>
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
    var swiper = new Swiper('.swiper-container', {
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
            window.location.href = '/user/login';
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
            window.location.href = '/user/login';
        });
    }
</script>
<script src="../js/bootstrap.js"></script>
</body>
</html>