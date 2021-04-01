<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <!-- end plugin css for this page -->
    <!-- inject:css -->
    <link rel="stylesheet" href="../../../assets/fonts/feather-font/css/iconfont.css">
    <link rel="stylesheet" href="../../../assets/vendors/flag-icon-css/css/flag-icon.min.css">
    <!-- endinject -->
    <!-- Layout styles -->
    <link rel="stylesheet" href="../../../assets/css/demo_1/style.css">
    <!-- End layout styles -->
    <link rel="shortcut icon" href="../../../assets/images/favicon.png" />
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
                    <li class="breadcrumb-item"><a href="#">Forms</a></li>
                </ol>
            </nav>

            <div class="row">
                <div class="col-md-12 grid-margin stretch-card">
                    <div class="card">
                        <div class="card-body">
                            <h6 class="card-title">Banner</h6>
                            <c:set var="banner" value="${banner}"/>
                            <form action="/admin/editBanner.do?banNo=${banner.banNo}" method="post" enctype="multipart/form-data">
                                <div class="form-group">
                                    <label for="exampleInputText1">Title</label>
                                    <input type="text" oninput="btn_status()" class="form-control" id="exampleInputText1" placeholder="Lecture Category" name="banTitle" value="${banner.banTitle}">
                                </div>
                                <div class="form-group">
                                    <label for="exampleInputText2">Content</label>
                                    <input type="text" oninput="btn_status()" class="form-control" id="exampleInputText2" placeholder="Lecture Name" name="banContent" value="${banner.banContent}">
                                </div>

                                <div class="form-group">
                                    <label>File upload</label>
                                    <input type="file" oninput="btn_status()" name="banImage" id="exampleImage1" class="file-upload-default">
                                    <div class="input-group col-xs-12">
                                        <c:set var="banImg" value="${banner.banImg.replaceAll('/files/banner/','')}"/>
                                        <input type="text" class="form-control file-upload-info" disabled="" placeholder="Upload Image"  value="${banImg}">
                                        <span class="input-group-append">
												<button class="file-upload-browse btn btn-primary" type="button">Upload</button>
											</span>
                                    </div>
                                </div>
                                <button class="btn btn-primary" type="submit" disabled="disabled" id="sub_btn">수정</button>
                                <button class="btn btn-primary" type="button" onclick="location.href='/admin/banner/data-table.do'">취소</button>
                            </form>
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

<script>

    function btn_status() {
        if (document.getElementById("exampleInputText1").value !== '' &&
            document.getElementById("exampleInputText2").value !== '') {
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