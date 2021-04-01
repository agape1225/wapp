<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>NobleUI Responsive Bootstrap 4 Dashboard Template</title>
    <!-- core:css -->
    <link rel="stylesheet" href="${path}/resources/assets/vendors/core/core.css">
    <!-- endinject -->
    <!-- plugin css for this page -->
    <link rel="stylesheet" href="${path}/resources/assets/vendors/bootstrap-datepicker/bootstrap-datepicker.min.css">
    <!-- end plugin css for this page -->
    <!-- inject:css -->
    <link rel="stylesheet" href="${path}/resources/assets/fonts/feather-font/css/iconfont.css">
    <link rel="stylesheet" href="${path}/resources/assets/vendors/flag-icon-css/css/flag-icon.min.css">
    <!-- endinject -->
    <!-- Layout styles -->
    <link rel="stylesheet" href="${path}/resources/assets/css/demo_1/style.css">
    <!-- End layout styles -->
    <link rel="shortcut icon" href="${path}/resources/assets/images/favicon.png" />
</head>

<body>
<div class="main-wrapper">

    <!-- partial:partials/_sidebar.html -->
    <nav class="sidebar">
        <div class="sidebar-header">
            <a href="admin-page.jsp" class="sidebar-brand">
                Noble<span>UI</span>
            </a>
            <div class="sidebar-toggler not-active">
                <span></span>
                <span></span>
                <span></span>
            </div>
        </div>
        <div class="sidebar-body">
            <ul class="nav">
                <li class="nav-item nav-category">HOME</li>
                <li class="nav-item">
                    <a href="/admin/login/admin-page" class="nav-link">
                        <i class="link-icon" data-feather="box"></i>
                        <span class="link-title">Home</span>
                    </a>
                </li>
                <li class="nav-item nav-category">MANAGE</li>

                <li class="nav-item">
                    <a href="/admin/login/manage-lecture" class="nav-link">
                        <i class="link-icon" data-feather="message-square"></i>
                        <span class="link-title">강의</span>
                    </a>
                </li>
                <li class="nav-item">
                    <a href="/admin/login/manage-category" class="nav-link">
                        <i class="link-icon" data-feather="calendar"></i>
                        <span class="link-title">카테고리</span>
                    </a>
                </li>

                <li class="nav-item">
                    <a href="/admin/login/manage-banner" class="nav-link">
                        <i class="link-icon" data-feather="feather"></i>
                        <span class="link-title">배너</span>
                    </a>
                </li>

                <li class="nav-item">
                    <a href="/admin/login/manage-popup" class="nav-link">
                        <i class="link-icon" data-feather="feather"></i>
                        <span class="link-title">팝업</span>
                    </a>
                </li>

                <li class="nav-item">
                    <a href="/admin/login/manage-user" class="nav-link">
                        <i class="link-icon" data-feather="message-square"></i>
                        <span class="link-title">유저</span>
                    </a>
                </li>
            </ul>
        </div>
    </nav>

    <!-- partial -->

    <div class="page-wrapper">

        <!-- partial:partials/_navbar.html -->
        <nav class="navbar">
            <a href="#" class="sidebar-toggler">
                <i data-feather="menu"></i>
            </a>
            <div class="navbar-content">
                <form class="search-form">
                    <div class="input-group">
                        <div class="input-group-prepend">
                            <div class="input-group-text">
                                <i data-feather="search"></i>
                            </div>
                        </div>
                        <input type="text" class="form-control" id="navbarForm" placeholder="Search here...">
                    </div>
                </form>
            </div>
        </nav>

        <!-- partial -->

        <div class="page-content">

            <nav class="page-breadcrumb">
                <ol class="breadcrumb">
                    <li class="breadcrumb-item"><a href="#">MANAGE</a></li>
                    <li class="breadcrumb-item active" aria-current="page"> 유저 목록 </li>
                </ol>
            </nav>
            <div class="row">

                <div class="col-md-6 grid-margin stretch-card">
                    <div class="card">
                        <div class="card-body">
                            <c:forEach varStatus="i" var="item" items="${userList}">

                                <li class="data">

                                    <p style="display: inline">${item.userNo}</p>
                                    <p style="display: inline">/${item.userName}</p>
                                    <p style="display: inline">/${item.userEmail}</p>
                                    <p style="display: inline">/${item.userRegDate}</p>
                                    <div style="float: right;">
                                        <button class="btn btn-primary mr-2"
                                                onclick="location.href='/admin/login/manage-user/userDelete?userNo=${item.userNo}'">
                                            삭제
                                        </button>
                                    </div>
                                    <br><br>
                                </li>
                            </c:forEach>
                        </div>
                    </div>
                </div>
            </div>
        </div>


        <!-- partial:partials/_footer.html -->
        <footer class="footer d-flex flex-column flex-md-row align-items-center justify-content-between">
            <p class="text-muted text-center text-md-left">Copyright © 2020 <a href="https://www.nobleui.com"
                                                                               target="_blank">NobleUI</a>. All rights reserved</p>
            <p class="text-muted text-center text-md-left mb-0 d-none d-md-block">Handcrafted With <i
                    class="mb-1 text-primary ml-1 icon-small" data-feather="heart"></i></p>
        </footer>
        <!-- partial -->

    </div>
</div>

<!-- core:js -->
<script src="${path}/resources/assets/vendors/core/core.js"></script>
<!-- endinject -->
<!-- plugin js for this page -->
<script src="${path}/resources/assets/vendors/chartjs/Chart.min.js"></script>
<script src="${path}/resources/assets/vendors/jquery.flot/jquery.flot.js"></script>
<script src="${path}/resources/assets/vendors/jquery.flot/jquery.flot.resize.js"></script>
<script src="${path}/resources/assets/vendors/bootstrap-datepicker/bootstrap-datepicker.min.js"></script>
<script src="${path}/resources/assets/vendors/apexcharts/apexcharts.min.js"></script>
<script src="${path}/resources/assets/vendors/progressbar.js/progressbar.min.js"></script>
<!-- end plugin js for this page -->
<!-- inject:js -->
<script src="${path}/resources/assets/vendors/feather-icons/feather.min.js"></script>
<script src="${path}/resources/assets/js/template.js"></script>
<!-- endinject -->
<!-- custom js for this page -->
<script src="${path}/resources/assets/js/dashboard.js"></script>
<script src="${path}/resources/assets/js/datepicker.js"></script>
<!-- end custom js for this page -->
</body>

</html>