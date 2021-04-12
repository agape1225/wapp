<%--
  Created by IntelliJ IDEA.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="../css/bootstrap.css">
    <link href='http://fonts.googleapis.com/css?family=Roboto:400,100,300,100italic,300italic,400italic,500italic,500,700,700italic,900,900italic'
          rel='stylesheet' type='text/css'>
    <link rel="stylesheet" href="../css/style.css">
    <link rel="stylesheet" href="https://unpkg.com/swiper/swiper-bundle.css">
    <link rel="stylesheet" href="https://unpkg.com/swiper/swiper-bundle.min.css"/>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
    <title>회원가입</title>

</head>
<style>
    body{
        height: 1000px;
    }
    .purple-header{
        width: 100%;
        height: 44px;
        top: 0px;
        background: mediumpurple;
        border-radius: 0px;
        cursor: pointer;
        padding-left: 24px;
        padding-right: 24px;
    }

</style>
<body>
<div class="main-page">
<div>
    <div class="purple-header">
        <div class="blue-header-container">
            <div class="blue-header-ment">딱 10초만에 내 취향 분석받자!</div>
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
                    <button style="font-weight: normal;">크리에이터 지원</button>
                    <c:choose>
                        <c:when test="${empty userLogin}">
                            <button style="font-weight: normal;" onclick="location.href='/user'">로그인</button>
                        </c:when>
                    </c:choose>
                </div>
            </div>
        </div>
    </div>

    <div>
        <div style="display: flex; justify-content: center; flex-direction: row;">
            <div style="width: 500px">
            <form class="forms-sample" action="/register" enctype="multipart/form-data" method="post">
                <div class="form-group" style="margin: 70px 0px">
                    <h2>회원가입</h2>
                </div>
                <div class="form-group">
                    <label for="exampleInputEmail1">이름</label>
                    <input type="text" class="form-control" id="exampleInputName" placeholder="홍길동" name="userName">
                </div>
                <div class="form-group">
                    <label for="exampleInputEmail1">이메일 주소</label>
                    <input type="email" class="form-control" id="exampleInputEmail1" placeholder="example@example.com" name="userEmail">
                </div>
                <div class="form-group">
                    <label for="exampleInputPassword1">비밀번호</label>

                    <input type="password" class="form-control" id="exampleInputPassword1" placeholder="********" name="userPw">
                    <span style="color: orangered; font-size: 0.8em"><i class="fas fa-exclamation-triangle"></i>영문 대문자/영문 소문자/숫자/특수문자 중 2가지 이상 조합. 8자~32자</span>

<!--                     <input type="password" class="form-control" id="exampleInputPassword1" placeholder="********" name="userPw"> -->

                </div>
                <div class="form-group">
                    <label for="exampleInputPassword2">비밀번호 확인</label>
                    <input type="password" class="form-control" id="exampleInputPassword2" placeholder="********">
                </div>
                <div class="form-group">
                    <button type="submit" style="background-color: orangered; color: white; width: 100%; border-radius: 3px">동의하고 회원가입</button>
                </div>
                <div class="form-group" style="font-size: 0.8em; text-align: center;">
                    <a href="https://class101.net/docs/terms" style="color: dodgerblue">이용약관</a>, &nbsp
                    <a href="https://class101.net/docs/privacy/collect" style="color: dodgerblue">개인정보 수집 및 이용</a>,&nbsp
                    <a href="https://class101.net/docs/privacy/provide" style="color: dodgerblue">개인정보 제공</a> &nbsp
                    <span style="color: #868e96">내용을 확인하였고 동의합니다.</span>
                </div>
                <hr>
                <div class="form-group">
                    <button onclick="location.href = 'https://kauth.kakao.com/oauth/authorize?client_id=6ea961726165307daa0af03f7cca7d1a&redirect_uri=http://localhost:8080/kakao_login&response_type=code&prompt=login'"
                            style="background-color: #fef01b; color: black; width: 100%; border-radius: 3px"><i class="fas fa-comment"></i>&nbsp카카오로 3초만에 시작하기</button>
                </div>
            </form>
        </div>
        </div>
    </div>
</div>
<div class="empty-space"></div>
<jsp:include page="/WEB-INF/views/partials/footer.jsp"/>
</body>
</html>
