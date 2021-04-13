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
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="js/bootstrap.js"></script>
    <script type="text/javascript">
        function email_check( email ) {
            var regex=/([\w-\.]+)@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.)|(([\w-]+\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\]?)$/;
            return (email != '' && email != 'undefined' && regex.test(email));
        }
        function idCheckFunction() {
            var uEmail = $('input[name=userEmail]').val();
            if(email_check(uEmail)) {
                var data = {"userEmail": uEmail};
                $.ajax({
                    type: 'POST',
                    url: '/register_check_userEmail',
                    dataType: 'json',
                    contentType: 'application/json; charset=utf-8',
                    data: JSON.stringify(data)
                }).done(function (result) {
                    console.log(result);
                    if (result === 0) {
                        $('#checkMessage').html('<span id="checkMessage" style="color:blue;font-size: 0.8em"> 사용 가능한 아이디입니다. </span>');
                    } else {
                        $('#checkMessage').html('<span id="checkMessage" style="color:orangered; font-size: 0.8em"><i class="fas fa-exclamation-triangle"></i> 사용중인 아이디입니다. 다른 아이디를 입력해주세요.</span>');
                    }
                }).fail(function (error) {
                    alert(error);
                })
            }else{
                $('#checkMessage').html('<span id="checkMessage" style="color:orangered; font-size: 0.8em"><i class="fas fa-exclamation-triangle"></i> 이메일 형식으로 입력해주세요. </span>')
            }
        }

        function checkPasswordMatches(){
            var pw1 = $('#exampleInputPassword1').val();
            var pw2 = $('#exampleInputPassword2').val();
            if(pw1 !== pw2){
                $('#pwMatchCheckMessage').html('<span id="pwMatchCheckMessage" style="color: orangered; font-size: 0.8em"><i class="fas fa-exclamation-triangle"></i>비밀번호가 일치하지 않습니다.</span>');
            }else{
                $('#pwMatchCheckMessage').html('');
            }
        }

        function checkRegister(){
            var email = $('input[name=userEmail]').val();
            var pw = $('input[name=userPw]').val();
            var name = $('input[name=userName]').val();
            var num = pw.search(/[0-9]/g);
            var eng = pw.search(/[a-z]/ig);
            var spe = pw.search(/[`~!@@#$%^&*|₩₩₩'₩";:₩/?]/gi);
            if($('#checkMessage').text() === ' 사용 가능한 아이디입니다. ' ){
                if(pw.length < 8 || pw.length > 32){
                    alert('비밀번호는 8자 이상, 32자 이하로 작성해주세요.');
                    setInputInfo(email, pw, name);
                }else if(pw.search(/\s/) !== -1){
                    alert('비밀번호 내에 공백이 없어야 합니다.');
                    setInputInfo(email, pw, name);
                }else if((num < 0 && eng < 0) || (eng < 0 && spe < 0) || (spe < 0 && num < 0)){
                    alert('영문 대문자/영문 소문자/숫자/특수문자 중 2가지 이상을 조합해야합니다.');
                    setInputInfo(email, pw, name);
                }else if($('#pwMatchCheckMessage').text() === '비밀번호가 일치하지 않습니다.'){
                    alert('비밀번호 확인란을 확인해주세요.');
                    setInputInfo(email, pw, name);
                }else{
                    $('#registerForm').submit();
                }
            }else{
                alert("아이디를 다시 확인해주세요.")
                setInputInfo('', pw, name);
                $('#checkMessage').html('<span id="checkMessage" style="color:orangered; font-size: 0.8em"><i class="fas fa-exclamation-triangle"></i> 이메일 형식으로 입력해주세요. </span>')
            }
        }

        function setInputInfo(email, pw, name){
            $('input[name=userEmail]').val(email);
            $('input[name=userPw]').val(pw);
            $('input[name=userName]').val(name);
        }

        function checkPasswordPreview(){
            var pw = $('input[name=userPw]').val();
            var num = pw.search(/[0-9]/g);
            var eng = pw.search(/[a-z]/ig);
            var special = pw.search(/[`~!@@#$%^&*|₩₩₩'₩";:₩/?]/gi);
            var korean = /[ㄱ-ㅎ|ㅏ-ㅣ|가-힣]/;

            if(pw.length < 8 || pw.length > 32){
                $('#passwordCheckMessage').html('<span id="passwordCheckMessage" style="color: orangered; font-size: 0.8em"><i class="fas fa-exclamation-triangle"></i>비밀번호는 8자 이상, 32자 이하로 작성해주세요.</span>');
            }else if(pw.search(/\s/) !== -1){
                $('#passwordCheckMessage').html('<span id="passwordCheckMessage" style="color: orangered; font-size: 0.8em"><i class="fas fa-exclamation-triangle"></i>비밀번호 내에 공백이 없어야 합니다.</span>');
            }else if((num < 0 && eng < 0) || (eng < 0 && special < 0) || (special < 0 && num < 0)){
                $('#passwordCheckMessage').html('<span id="passwordCheckMessage" style="color: orangered; font-size: 0.8em"><i class="fas fa-exclamation-triangle"></i>영문 대문자/영문 소문자/숫자/특수문자 중 2가지 이상을 조합해야합니다.</span>');
            }else if(korean.test(pw)){
                $('#passwordCheckMessage').html('<span id="passwordCheckMessage" style="color: orangered; font-size: 0.8em"><i class="fas fa-exclamation-triangle"></i>비밀번호에 한글을 사용할 수 없습니다. </span>');
            } else{
                $('#passwordCheckMessage').html('<span id="passwordCheckMessage" style="color: blue; font-size: 0.8em"> 적합한 비밀번호입니다. </span>');
            }
        }
    </script>
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
    <jsp:include page="/WEB-INF/views/partials/searchbar.jsp"/>

    <div>
        <div style="display: flex; justify-content: center; flex-direction: row;">
            <div style="width: 500px">
            <form class="forms-sample" action="/register" enctype="multipart/form-data" method="post" id="registerForm">
                <div class="form-group" style="margin: 70px 0px">
                    <h2>회원가입</h2>
                </div>
                <div class="form-group">
                    <label for="exampleInputEmail1">이름</label>
                    <input type="text" class="form-control" id="exampleInputName" placeholder="홍길동" name="userName" required>
                </div>
                <div class="form-group">
                    <label for="exampleInputEmail1">이메일 주소</label>
                    <input type="email" class="form-control" id="exampleInputEmail1" onkeyup="idCheckFunction()" placeholder="example@example.com" name="userEmail" required>
                    <span id="checkMessage" style="color:orangered; font-size: 0.8em"><i class="fas fa-exclamation-triangle"></i> 이메일 형식으로 입력해주세요. </span>
                </div>
                <div class="form-group">
                    <label for="exampleInputPassword1">비밀번호</label>

                    <input type="password" class="form-control" id="exampleInputPassword1" onkeyup="checkPasswordPreview()" placeholder="********" name="userPw" required>
                    <span id="passwordCheckMessage" style="color: orangered; font-size: 0.8em"><i class="fas fa-exclamation-triangle"></i>영문 대문자/영문 소문자/숫자/특수문자 중 2가지 이상 조합. 8자~32자</span>

<!--                     <input type="password" class="form-control" id="exampleInputPassword1" placeholder="********" name="userPw"> -->

                </div>
                <div class="form-group">
                    <label for="exampleInputPassword2">비밀번호 확인</label>
                    <input type="password" class="form-control" id="exampleInputPassword2" onkeyup="checkPasswordMatches()" placeholder="********" required>
                    <span id="pwMatchCheckMessage" style="color: orangered; font-size: 0.8em"><i class="fas fa-exclamation-triangle"></i>비밀번호가 일치하지 않습니다.</span>
                </div>
                <div class="form-group">
                    <button type="button" onclick="checkRegister()" style="background-color: orangered; color: white; width: 100%; border-radius: 3px">동의하고 회원가입</button>
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
</body>
</html>
