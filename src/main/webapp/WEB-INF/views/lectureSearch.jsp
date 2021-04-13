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

        .checkboxes {
            display: flex;
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


    <jsp:include page="/WEB-INF/views/partials/searchbar.jsp"/>
    <jsp:include page="/WEB-INF/views/partials/navbar.jsp"/>

    <div class="main-wrapper">

        <div class="empty-space"></div>

        <div class="best-class">
            <div class="text-box">
                <div class="checkboxes">
                    <form>
                        <div class="multiselect">
                            <div class="selectBox" onclick="showCheckboxes()">
                                <select>
                                    <option>Category</option>
                                </select>
                                <div class="overSelect"></div>
                            </div>
                            <div id="category-checkboxes">
                                <label><input type="checkbox" name="category" value="취미" />취미</label>
                                <label><input type="checkbox" name="category" value="수익 창출" />수익 창출</label>
                                <label><input type="checkbox" name="category" value="직무교육" />직무교육</label>
                                <label><input type="checkbox" name="category" value="데이터 · 개발" />데이터 · 개발</label>
                                <label><input type="checkbox" name="category" value="시그니처" />시그니처</label>
                                <label><input type="checkbox" name="category" value="키즈" />키즈</label>
                                <button onclick="go_search()">확인</button>
                            </div>
                        </div>
                    </form>
                    <select onchange="go_search()" id="sortKey">
                        <option value="accuracyOrder" selected>정확도순</option>
                        <option value="latestOrder">최신순</option>
                        <option value="likedOrder">인기순</option>
                    </select>
                </div>
            </div>
            <div>
                <div class="empty-space"></div>
                <div class="baro-wrapper">
                    <c:forEach varStatus="i" var="item" items="${lectureList}">
                        <div class="baro-content">
                            <img src="${item.lecImg}" class="baro-img">
                            <div class="card-tag">${item.lecCategory}</div>
                            <div class="best-class-name">${item.lecName}</div>
                            <div class="Spacing__Box">
                                <span class="original-price"><fmt:formatNumber value="${item.lecPrice}" type="currency"
                                                                               currencySymbol=""/>원</span>
                            </div>
                            <div class="Spacing__Box">
                                    <%--                            할부개월수로 나눈 값--%>
                                <strong class="monthly-price">월 <fmt:formatNumber value="${item.lecPrice / 6}" type="currency"
                                                                                  currencySymbol=""/>원</strong><br>
                            </div>
                                <%--                        <form action="/user/login/likes/insert" method="post">--%>
                                <%--                            <button name="lecNo" value="${item.lecNo}" >찜하기</button>--%>
                                <%--                        </form>--%>
                            <button name="lecNo" value="${item.lecNo}" onclick="btn_add_likes_onclick(${item.lecNo})" > 찜하기</button>
                            <button name="lecNo" onclick="btn_del_likes_onclick(${item.lecNo})">찜 해제하기</button>
                        </div>
                    </c:forEach>
                </div>
                <div class="empty-space"></div>
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