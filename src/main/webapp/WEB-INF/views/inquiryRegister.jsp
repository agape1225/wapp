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


    <div class="page-wrapper">



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
                            <h6 class="card-title">Inquiry</h6>
                            <form action="/inquiry/addInquiry" method="post" enctype="multipart/form-data">
                                <div class="form-group">
                                    <label for="exampleInputText1">TITLE</label>
                                    <input type="text" oninput="btn_status()" class="form-control"
                                           id="exampleInputText1"
                                           placeholder="Inquiry Title" name="inqTitle">
                                </div>
                                <div class="form-group">
                                    <label for="exampleInputText2">NAME</label>
                                    <input type="text" oninput="btn_status()" class="form-control"
                                           id="exampleInputText2"
                                           placeholder="Inquiry User Name" name="inqUserName">
                                </div>
                                <div class="form-group">
                                    <label for="exampleInputText3">EMAIL</label>
                                    <input type="text" oninput="btn_status()" class="form-control"
                                           id="exampleInputText3"
                                           placeholder="Inquiry Email" name="inqEmail">
                                </div>
                                <div class="form-group">
                                    <label for="exampleInputText4">Question</label>
                                    <input type="text" oninput="btn_status()" class="form-control"
                                           id="exampleInputText4"
                                           placeholder="Inquiry Question" name="inqQuestion">
                                </div>


                                <button class="btn btn-primary" type="submit" id="sub_btn" disabled="disabled">문의
                                </button>
                            </form>
                        </div>
                    </div>
                </div>
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