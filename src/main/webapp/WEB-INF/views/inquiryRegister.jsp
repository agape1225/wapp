<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8"/>
    <meta name="viewport" content="width=device-width"/>
    <title>클래스 101 | 꿈과 역대급 혜택으로 가득한 101월드 이벤트 중</title>
    <link
            rel="shortcut icon"
            sizes="16x16 32x32 64x64"
            href="https://class101.net/images/favicon-64x64.png"
    />
    <link
            rel="stylesheet"
            href="https://cdn.jsdelivr.net/npm/reset-css@5.0.1/reset.min.css"
    />
    <link
            rel="stylesheet"
            href="https://cdn.jsdelivr.net/gh/FortAwesome/Font-Awesome@5.14.0/css/all.min.css"
    />
    <link rel="stylesheet" href="../css/inquiryRegister.css"/>
    <link rel="stylesheet" href="../css/style.css"/>

    <link
            href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css"
            rel="stylesheet"
            integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl"
            crossorigin="anonymous"
    />
</head>
<body>
<header id="main_header">
    <div class="bar__column">
        <svg
                class="Logo__MainLogoSvg-juoklg-1 kjEHil"
                width="100%"
                height="100%"
                viewBox="0 0 152 32"
                preserveAspectRatio="xMidYMid slice"
                fill="none"
                xmlns="http://www.w3.org/2000/svg"
        >
            <path
                    d="M128.059 5C121.984 5 117.059 9.9247 117.059 16C117.059 22.0753 121.984 27 128.059 27C134.134 27 139.059 22.0753 139.059 16C139.059 9.9247 134.133 5 128.059 5ZM132.363 20.4781C131.212 21.6617 129.776 22.2535 128.058 22.2535C126.34 22.2535 124.904 21.6617 123.753 20.4781C122.6 19.2945 122.023 17.8117 122.023 16.0308C122.023 14.229 122.6 12.7297 123.753 11.5362C124.904 10.3427 126.34 9.7454 128.058 9.7454C129.776 9.7454 131.211 10.3427 132.363 11.5362C133.516 12.7308 134.093 14.229 134.093 16.0308C134.093 17.8128 133.516 19.2945 132.363 20.4781Z"
                    fill="#000"
            ></path>
            <path
                    d="M140.159 5.44V10.4835H143.916V26.56H148.959V5.44H140.159Z"
                    fill="#000"
            ></path>
            <path
                    d="M106.059 5.44V10.4835H109.816V26.56H114.859V5.44H106.059Z"
                    fill="#000"
            ></path>
            <path
                    d="M51.741 5.44L42.9146 26.56H48.4938L49.9755 22.7144H58.8646L60.3463 26.56H65.8947L57.0683 5.44H51.741ZM51.741 18.2385L54.4206 11.303L57.131 18.2385H51.741Z"
                    fill="#000"
            ></path>
            <path
                    d="M77.9936 14.0508L73.6255 13.0773C72.4947 12.8254 71.9282 12.2391 71.9282 11.3162C71.9282 10.709 72.19 10.2008 72.7136 9.7916C73.2372 9.3824 73.9181 9.1789 74.7574 9.1789C75.6374 9.1789 76.4228 9.4363 77.1147 9.9489C77.8055 10.4626 78.2455 11.1908 78.4347 12.1335L83.5255 11.0962C83.1273 9.1888 82.1527 7.6972 80.6028 6.617C79.0529 5.539 77.1246 5 74.8201 5C72.3264 5 70.3156 5.5973 68.7855 6.7908C67.2554 7.9854 66.492 9.598 66.492 11.6308C66.492 14.8362 68.3785 16.869 72.1482 17.7281L76.5482 18.6708C77.2819 18.8182 77.7901 19.0371 78.0728 19.3308C78.3566 19.6245 78.4974 20.0216 78.4974 20.5243C78.4974 21.1744 78.2202 21.698 77.6647 22.0962C77.1092 22.4944 76.3502 22.6935 75.3866 22.6935C73.1239 22.6935 71.7412 21.6562 71.2385 19.5827L65.8947 20.62C66.1675 22.6319 67.1575 24.1972 68.8647 25.3181C70.5719 26.439 72.6509 27 75.1028 27C77.5745 27 79.6381 26.4016 81.2947 25.2081C82.9491 24.0146 83.7774 22.3382 83.7774 20.18C83.7763 16.9526 81.8491 14.911 77.9936 14.0508Z"
                    fill="#000"
            ></path>
            <path
                    d="M98.0763 14.0508L93.7082 13.0773C92.5774 12.8254 92.0109 12.2391 92.0109 11.3162C92.0109 10.709 92.2727 10.2008 92.7963 9.7916C93.3199 9.3824 94.0008 9.1789 94.8401 9.1789C95.7201 9.1789 96.5055 9.4363 97.1974 9.9489C97.8882 10.4626 98.3282 11.1908 98.5163 12.1335L103.608 11.0962C103.21 9.1888 102.235 7.6972 100.686 6.617C99.1345 5.539 97.2062 5 94.9017 5C92.408 5 90.3972 5.5973 88.8671 6.7908C87.337 7.9854 86.5736 9.598 86.5736 11.6308C86.5736 14.8362 88.459 16.869 92.2309 17.7281L96.6298 18.6708C97.3635 18.8182 97.8717 19.0371 98.1544 19.3308C98.4382 19.6245 98.579 20.0216 98.579 20.5243C98.579 21.1744 98.3018 21.698 97.7463 22.0962C97.1908 22.4944 96.4318 22.6935 95.4682 22.6935C93.2055 22.6935 91.8228 21.6562 91.3201 19.5827L85.9763 20.62C86.2491 22.6319 87.2391 24.1972 88.9463 25.3181C90.6535 26.439 92.7336 27 95.1855 27C97.6572 27 99.7208 26.4016 101.377 25.2081C103.032 24.0146 103.86 22.3382 103.86 20.18C103.859 16.9526 101.932 14.911 98.0763 14.0508Z"
                    fill="#000"
            ></path>
            <path
                    d="M17.7246 21.1062C16.75 21.8927 15.5719 22.2843 14.1892 22.2843C12.5128 22.2843 11.0938 21.6826 9.9311 20.4781C8.7673 19.2736 8.1854 17.7809 8.1854 16C8.1854 14.2191 8.7673 12.7319 9.93 11.5373C11.0927 10.3438 12.5117 9.7465 14.1881 9.7465C15.5917 9.7465 16.7808 10.1282 17.7543 10.8927C18.4462 11.4361 18.9632 12.1709 19.3218 13.0773H24.78C24.2773 10.6254 23.0464 8.6674 21.0873 7.2C19.1271 5.7337 16.8281 5 14.1892 5C11.0663 5 8.4219 6.0637 6.2527 8.19C4.0835 10.3163 3 12.92 3 16C3 19.1009 4.0846 21.7101 6.2527 23.8265C8.4219 25.9407 11.0663 27 14.1892 27C16.9337 27 19.2701 26.2553 21.1973 24.7681C23.1256 23.2809 24.3301 21.2382 24.8119 18.64H19.4175C19.0325 19.6795 18.4704 20.5045 17.7246 21.1062Z"
                    fill="#000"
            ></path>
            <path
                    d="M32.1808 5.44H26.98V26.56H40.7146L42.5824 22.0203H32.1808V5.44Z"
                    fill="#000"
            ></path>
        </svg>
        <form class="input">
            <input type="text" placeholder="찾으시는 취미가 있으신가요?"/>
            <a href="#"><i class="fas fa-search"></i></a>
        </form>
    </div>
    <div class="bar__column">
        <span>크리에이터 지원</span>
        <span>내클래스</span>
        <i class="far fa-heart"></i>
        <i class="fas fa-ticket-alt"></i>
        <i class="fas fa-user-circle fa-2x"></i>
        <i class="fas fa-chevron-down"></i>
    </div>
</header>
<div class="main-wrapper">
    <div id="content">
        <form action="/inquiry/addInquiry" method="post" enctype="multipart/form-data">
            <div id="inquiry_section">
                <div id="inquiry_title">
                    <h1>견적에 대한 문의가 필요한가요?</h1>
                    <h3>질문 또는 언급할게 있다면 여길 이용해주세요!</h3>
                </div>
                <div id="inquiry_contents">

                    <h1>문의 내용을 작성해주세요.</h1>
                    <input type="text" oninput="btn_status()"
                           id="exampleInputText1" placeholder="제목" name="inqTitle"/>
                    <div class="inquiry_contents_twobox">
                        <input type="text" oninput="btn_status()"
                               id="exampleInputText2" name="inqUserName" placeholder="이름"/>
                        <input type="email" oninput="btn_status()"
                               id="exampleInputText3" name="inqEmail" placeholder="회신 이메일" required/>
                    </div>
                    <input
                            class="inquiry_contents_content"
                            oninput="btn_status()"
                            id="exampleInputText4"
                            type="text"
                            placeholder="내용을 작성해주세요."
                            name="inqQuestion"
                    />
                    <input class="btn btn-primary" type="submit" id="sub_btn" disabled="disabled"  value="문의하기"/>


                </div>
            </div>
        </form>
        <div id="inquiry_aside">
            <h1>회사 정보</h1>
            <div class="inquiry_aside_information">
                <i class="fas fa-phone-alt"></i>
                <span>(+82) 010-1234-5678</span>
            </div>
            <div class="inquiry_aside_information">
                <i class="fas fa-envelope"></i>
                <span>support@abcbiotech.com</span>
            </div>
            <div class="inquiry_aside_information">
                <i class="fas fa-map-marker-alt"></i>
                <span>서울특별시 강남구 상회동 201-4 2F, Abcbiotech</span>
            </div>
        </div>
    </div>
</div>


<script>

    function btn_status() {
        if (document.getElementById("exampleInputText1").value !== '' &&
            document.getElementById("exampleInputText2").value !== '' &&
            document.getElementById("exampleInputText3").value !== '' &&
            document.getElementById("exampleInputText4").value !== '') {
            document.getElementById("sub_btn").disabled = false;
        } else {
            document.getElementById("sub_btn").disabled = true;
        }
    }
</script>
<!-- core:js -->
<script src="../../../assets/vendors/core/core.js"></script>
<!-- endinject -->
<!-- plugin js for this page -->
<!-- end plugin js for this page -->
<!-- inject:js -->
<script src="../../../assets/vendors/feather-icons/feather.min.js"></script>
<script src="../../../assets/js/template.js"></script>
<!-- endinject -->
<!-- custom js for this page -->
<script src="../../../assets/js/file-upload.js"></script>
<!-- end custom js for this page -->
</body>
</html>