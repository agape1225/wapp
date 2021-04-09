<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Wapp Team Admin</title>
    <!-- core:css -->
    <link rel="stylesheet" href="../../assets/vendors/core/core.css">
    <!-- endinject -->
    <!-- plugin css for this page -->
    <link rel="stylesheet" href="../../assets/vendors/bootstrap-datepicker/bootstrap-datepicker.min.css">
    <!-- end plugin css for this page -->
    <!-- inject:css -->
    <link rel="stylesheet" href="../../assets/fonts/feather-font/css/iconfont.css">
    <link rel="stylesheet" href="../../assets/vendors/flag-icon-css/css/flag-icon.min.css">
    <!-- endinject -->
    <!-- Layout styles -->
    <link rel="stylesheet" href="../../assets/css/demo_1/style.css">
    <!-- End layout styles -->
    <link rel="shortcut icon" href="../../assets/images/favicon.png"/>
</head>
<body class="sidebar-dark">
<div class="main-wrapper">
    <!-- partial:partials/_sidebar.html -->
    <jsp:include page="/WEB-INF/views/partials/admin_sidebar.jsp"/>
    <!-- partial -->

    <div class="page-wrapper">

        <!-- partial:partials/_navbar.html -->
        <jsp:include page="/WEB-INF/views/partials/admin_navbar.jsp"/>
        <!-- partial -->

        <div class="page-content">

            <div class="d-flex justify-content-between align-items-center flex-wrap grid-margin">
                <div>
                    <h4 class="mb-3 mb-md-0">Welcome to Admin Pages</h4>
                </div>
                <div class="d-flex align-items-center flex-wrap text-nowrap">
                    <div class="input-group date datepicker dashboard-date mr-2 mb-2 mb-md-0 d-md-none d-xl-flex"
                         id="dashboardDate">
                        <span class="input-group-addon bg-transparent"><i data-feather="calendar"
                                                                          class=" text-primary"></i></span>
                        <input type="text" class="form-control">
                    </div>
                </div>
            </div>

            <div class="row">
                <div class="col-12 col-xl-12 stretch-card">
                    <div class="row flex-grow">
                        <div class="col-md-4 grid-margin stretch-card">
                            <div class="card">
                                <div class="card-body">
                                    <div class="d-flex justify-content-between align-items-baseline">
                                        <h6 class="card-title mb-0">Total Class</h6>
                                    </div>
                                    <div class="row">
                                        <div class="col-6 col-md-12 col-xl-5">
                                            <table>
                                                <c:set var="HomeLectureList" value="${HomeLectureList}"/>
                                                <c:forEach var="i" begin = "${HomeLectureList.size()}" end = "${HomeLectureList.size()}">
                                                    <tr>
                                                        <h2>${i}</h2>

                                                    </tr>
                                                </c:forEach>
                                            </table>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-4 grid-margin stretch-card">
                            <div class="card">
                                <div class="card-body">
                                    <div class="d-flex justify-content-between align-items-baseline">
                                        <h6 class="card-title mb-0">Total User</h6>

                                    </div>
                                    <div class="row">
                                        <div class="col-6 col-md-12 col-xl-5">
                                            <table>
                                                <c:set var="HomeUserList" value="${HomeUserList}"/>
                                                <c:forEach var="i" begin = "${HomeUserList.size()}" end = "${HomeUserList.size()}">
                                                    <tr>
                                                        <h2>${i}</h2>

                                                    </tr>
                                                </c:forEach>
                                            </table>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-4 grid-margin stretch-card">
                            <div class="card">
                                <div class="card-body">
                                    <div class="d-flex justify-content-between align-items-baseline">
                                        <h6 class="card-title mb-0">Total Inquiry</h6>

                                    </div>
                                    <div class="row">
                                        <div class="col-6 col-md-12 col-xl-5">
                                            <table>
                                                <c:set var="HomeInquiryList" value="${HomeInquiryList}"/>
                                                <c:forEach var="i" begin = "${HomeInquiryList.size()}" end = "${HomeInquiryList.size()}">
                                                    <tr>
                                                        <h2>${i}</h2>
                                                    </tr>
                                                </c:forEach>
                                            </table>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div> <!-- row -->

            <div class="row">
                <div class="col-lg-7 col-xl-8 stretch-card">
                    <div class="card">
                        <div class="card-body">
                            <div class="d-flex justify-content-between align-items-baseline mb-2">
                                <h6 class="card-title mb-0">MD 추천 수업</h6>
                            </div>
                            <br>
                            <div class="table-responsive">
                                <table class="table table-hover mb-0">
                                    <thead>
                                    <tr>

                                        <th class="pt-0">No</th>
                                        <th class="pt-0">Category</th>
                                        <th class="pt-0">Class Name</th>
                                        <th class="pt-0">Price</th>
                                        <th class="pt-0">Date</th>
                                        <th class="pt-0">Image</th>
                                        <th class="pt-0">Status</th>

                                    </tr>
                                    </thead>

                                    <tbody>
                                    <c:set var="ReclectureList" value="${ReclectureList}"/>
                                    <c:forEach var="i" begin = "1" end = "${ReclectureList.size()}">
                                        <tr>
                                            <td>${i}</td>
                                            <td>${ReclectureList[i-1].lecCategory}</td>
                                            <td>${ReclectureList[i-1].lecName}</td>
                                            <td>${ReclectureList[i-1].lecPrice}</td>
                                            <td>${ReclectureList[i-1].lecRegDate}</td>
                                            <c:choose>
                                                <c:when test="${empty ReclectureList[i-1].lecImg}">
                                                    <td>이미지 없음</td>
                                                </c:when>
                                                <c:otherwise>
                                                    <td><button class="btn btn-primary" onclick="window.open('${ReclectureList[i-1].lecImg}')">이미지 보기</button></td>
                                                </c:otherwise>
                                            </c:choose>
                                            <td><span class="badge badge-success">Recommend</span></td>
                                        </tr>
                                    </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
            </div> <!-- row -->

        </div>

        <!-- partial:partials/_footer.html -->
        <jsp:include page="/WEB-INF/views/partials/admin_footer.jsp"/>
        <!-- partial -->

    </div>
</div>

<!-- core:js -->
<script src="../../assets/vendors/core/core.js"></script>
<!-- endinject -->
<!-- plugin js for this page -->
<script src="../../assets/vendors/chartjs/Chart.min.js"></script>
<script src="../../assets/vendors/jquery.flot/jquery.flot.js"></script>
<script src="../../assets/vendors/jquery.flot/jquery.flot.resize.js"></script>
<script src="../../assets/vendors/bootstrap-datepicker/bootstrap-datepicker.min.js"></script>
<script src="../../assets/vendors/apexcharts/apexcharts.min.js"></script>
<script src="../../assets/vendors/progressbar.js/progressbar.min.js"></script>
<!-- end plugin js for this page -->
<!-- inject:js -->
<script src="../../assets/vendors/feather-icons/feather.min.js"></script>
<script src="../../assets/js/template.js"></script>
<!-- endinject -->
<!-- custom js for this page -->
<script src="../../assets/js/dashboard.js"></script>
<script src="../../assets/js/datepicker.js"></script>
<!-- end custom js for this page -->
</body>
</html>    