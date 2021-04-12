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
    <style>
        .multiselect {
            width: 100px;
        }

        .selectBox {
            position: relative;
        }

        .selectBox select {
            width: 100%;
            font-weight: bold;
        }

        .overSelect {
            position: absolute;
            left: 0;
            right: 0;
            top: 0;
            bottom: 0;
        }

        #category-checkboxes {
            display: none;
            border: 1px #dadada solid;
        }

        #category-checkboxes label {
            display: block;
        }

        #category-checkboxes label:hover {
            background-color: #1e90ff;
        }
    </style>
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
                            <button style="font-weight: normal;" onclick="location.href='/social_login'">로그인</button>
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

        <div class="empty-space"></div>

        <div class="best-class">
            <div class="text-box">
                <div>
                    <div>
                        <div class="multiselect">
                            <div class="selectBox" onclick="showCheckboxes()">
                                <select>
                                    <option>Category</option>
                                </select>
                                <div class="overSelect"></div>
                            </div>
                            <div id="category-checkboxes">
                                <c:forEach var="category" items="${categoryList}">
<%--                                    <c:set var="item">${category}</c:set>--%>
                                    <c:choose>
                                        <c:when test="${categories[category] == category}" >
                                            <label><input type="checkbox" name="category" value="${category}" checked />${category}</label>
                                        </c:when>
                                        <c:otherwise>
                                            <label><input type="checkbox" name="category" value="${category}" />${category}</label>
                                        </c:otherwise>
                                    </c:choose>
                                </c:forEach>
                                <button onclick="go_search()">확인</button>
                            </div>
                        </div>
                    </div>
                    <select onchange="go_search()" id="sortKey">
                        <c:forEach var="sort" items="${sortListENG}" varStatus="status">
                            <c:choose>
                                <c:when test="${sort == sortKey}" >
                                    <option value="${sort}" selected>${sortListKOR[status.index]}</option>
                                </c:when>
                                <c:otherwise>
                                    <option value="${sort}" >${sortListKOR[status.index]}</option>
                                </c:otherwise>
                            </c:choose>
                        </c:forEach>
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
                            <button name="lecNo" value="${item.lecNo}" onclick="btn_add_likes_onclick(${item.lecNo})">찜하기</button>
                            <button name="lecNo" value="${item.lecNo}" onclick="btn_del_likes_onclick(${item.lecNo})">찜 해제하기</button>
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
    var show = true;

    function showCheckboxes() {
        var checkboxes = document.getElementById("category-checkboxes");
        if (show) {
            checkboxes.style.display = "block";
            show = false;
        } else {
            checkboxes.style.display = "none";
            show = true;
        }
    }

    function getCheckboxValue(url) {
        const query = 'input[name="category"]:checked';
        var selectOption = document.getElementById("sortKey");
        const selectedEls = document.querySelectorAll(query);

        var sortKey = selectOption.options[selectOption.selectedIndex].value;
        console.log(sortKey);

        url += '&sort='+sortKey;
        console.log(url);

        selectedEls.forEach((el) => {
            url += '&category='+el.value;
            console.log(el.value);
        })

        location.replace(url);
        // window.location.href = url;
    }
    function go_search() {
        var search_url = "/search?";
        var inputVal = document.getElementById('input-search').value;
        console.log(inputVal);
        if (inputVal != null && inputVal !='') {
            search_url += 'query='+inputVal;
        }
        getCheckboxValue(search_url);
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