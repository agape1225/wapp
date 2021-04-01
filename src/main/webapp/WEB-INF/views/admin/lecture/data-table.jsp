<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Wapp Team B Admin</title>
    <!-- core:css -->
    <link rel="stylesheet" href="../../../assets/vendors/core/core.css">
    <!-- endinject -->
    <!-- plugin css for this page -->
    <link rel="stylesheet" href="../../../assets/vendors/datatables.net-bs4/dataTables.bootstrap4.css">
    <!-- end plugin css for this page -->
    <!-- inject:css -->
    <link rel="stylesheet" href="../../../assets/fonts/feather-font/css/iconfont.css">
    <link rel="stylesheet" href="../../../assets/vendors/flag-icon-css/css/flag-icon.min.css">
    <!-- endinject -->
    <!-- Layout styles -->
    <link rel="stylesheet" href="../../../assets/css/demo_1/style.css">
    <!-- End layout styles -->
    <link rel="shortcut icon" href="../../../assets/images/favicon.png"/>
</head>
<body class="sidebar-dark">
<div class="main-wrapper">

    <!-- partial:../../partials/_sidebar.html -->
    <jsp:include page="/WEB-INF/views/partials/admin_sidebar.jsp"/>
    <!-- partial -->

    <div class="page-wrapper">

        <!-- partial:../../partials/_navbar.html -->
        <jsp:include page="/WEB-INF/views/partials/admin_navbar.jsp"/>
        <!-- partial -->

        <div class="page-content">

            <nav class="page-breadcrumb">
                <ol class="breadcrumb">
                    <li class="breadcrumb-item"><a href="#">Lectures</a></li>
                </ol>
            </nav>

            <div class="row">
                <div class="col-md-12 grid-margin stretch-card">
                    <div class="card">
                        <div class="card-body">
                            <h6 class="card-title">Lecture Table</h6>
                            <div class="table-responsive">
                                <table id="dataTableExample" class="table">
                                    <thead>
                                    <tr>
                                        <th>No</th>
                                        <th>카테고리</th>
                                        <th>이름</th>
                                        <th>가격</th>
                                        <th>등록 날짜</th>
                                        <th>이미지</th>
                                        <th>Edit</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <c:set var="lectureList" value="${lectureList}"/>
                                    <c:forEach var="i" begin = "1" end = "${lectureList.size()}">
                                        <tr>
                                            <td>${i}</td>
                                            <td>${lectureList[i-1].lecCategory}</td>
                                            <td>${lectureList[i-1].lecName}</td>
                                            <td style="text-align: right"><fmt:formatNumber value="${lectureList[i-1].lecPrice}" type="currency" currencySymbol="" />원</td>
                                            <td><fmt:formatDate value="${lectureList[i-1].lecRegDate}" pattern="yyyy-MM-dd" /></td>
                                            <c:choose>
                                            <c:when test="${empty lectureList[i-1].lecImg}">
                                                <td>이미지 없음</td>
                                            </c:when>
                                            <c:otherwise>
                                                <td><button class="btn btn-primary" onclick="window.open('${lectureList[i-1].lecImg}')">이미지 보기</button></td>
                                            </c:otherwise>
                                            </c:choose>
                                            <td>
                                                <div class="btn-group" role="group" aria-label="Basic example">
                                                <button class="btn btn-primary" onclick="location.href='/admin/lecture/edit.do?lecNo=${lectureList[i-1].lecNo}'">수정</button>
                                                <button class="btn btn-secondary" onclick="if(confirm('정말 삭제하시겠습니까?')){location.href='/admin/lecture/delete.do?lecNo=${lectureList[i-1].lecNo}';} else {return false;}">삭제</button>
                                                </div>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

        </div>

        <!-- partial:../../partials/_footer.html -->
        <jsp:include page="/WEB-INF/views/partials/admin_footer.jsp"/>
        <!-- partial -->

    </div>
</div>

<!-- core:js -->
<script src="../../../assets/vendors/core/core.js"></script>
<!-- endinject -->
<!-- plugin js for this page -->
<script src="../../../assets/vendors/datatables.net/jquery.dataTables.js"></script>
<script src="../../../assets/vendors/datatables.net-bs4/dataTables.bootstrap4.js"></script>
<!-- end plugin js for this page -->
<!-- inject:js -->
<script src="../../../assets/vendors/feather-icons/feather.min.js"></script>
<script src="../../../assets/js/template.js"></script>
<!-- endinject -->
<!-- custom js for this page -->
<script src="../../../assets/js/data-table.js"></script>
<!-- end custom js for this page -->
</body>
</html>