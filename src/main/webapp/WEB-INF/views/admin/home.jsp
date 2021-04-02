<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Wapp Team B Admin</title>
    <!-- core:css -->
    <link rel="stylesheet" href="../assets/vendors/core/core.css">
    <!-- endinject -->
    <!-- plugin css for this page -->
    <link rel="stylesheet" href="../assets/vendors/bootstrap-datepicker/bootstrap-datepicker.min.css">
    <!-- end plugin css for this page -->
    <!-- inject:css -->
    <link rel="stylesheet" href="../assets/fonts/feather-font/css/iconfont.css">
    <link rel="stylesheet" href="../assets/vendors/flag-icon-css/css/flag-icon.min.css">
    <!-- endinject -->
    <!-- Layout styles -->
    <link rel="stylesheet" href="../assets/css/demo_1/style.css">
    <!-- End layout styles -->
    <link rel="shortcut icon" href="../assets/images/favicon.png"/>
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
                    <h4 class="mb-3 mb-md-0">Welcome to Dashboard</h4>
                </div>
                <div class="d-flex align-items-center flex-wrap text-nowrap">
                    <div class="input-group date datepicker dashboard-date mr-2 mb-2 mb-md-0 d-md-none d-xl-flex"
                         id="dashboardDate">
                        <span class="input-group-addon bg-transparent"><i data-feather="calendar"
                                                                          class=" text-primary"></i></span>
                        <input type="text" class="form-control">
                    </div>
                    <button type="button" class="btn btn-outline-info btn-icon-text mr-2 d-none d-md-block">
                        <i class="btn-icon-prepend" data-feather="download"></i>
                        Import
                    </button>
                    <button type="button" class="btn btn-outline-primary btn-icon-text mr-2 mb-2 mb-md-0">
                        <i class="btn-icon-prepend" data-feather="printer"></i>
                        Print
                    </button>
                    <button type="button" class="btn btn-primary btn-icon-text mb-2 mb-md-0">
                        <i class="btn-icon-prepend" data-feather="download-cloud"></i>
                        Download Report
                    </button>
                </div>
            </div>

            <div class="row">
                <div class="col-12 col-xl-12 stretch-card">
                    <div class="row flex-grow">
                        <div class="col-md-4 grid-margin stretch-card">
                            <div class="card">
                                <div class="card-body">
                                    <div class="d-flex justify-content-between align-items-baseline">
                                        <h6 class="card-title mb-0">New Customers</h6>
                                        <div class="dropdown mb-2">
                                            <button class="btn p-0" type="button" id="dropdownMenuButton"
                                                    data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                                <i class="icon-lg text-muted pb-3px" data-feather="more-horizontal"></i>
                                            </button>
                                            <div class="dropdown-menu dropdown-menu-right"
                                                 aria-labelledby="dropdownMenuButton">
                                                <a class="dropdown-item d-flex align-items-center" href="#"><i
                                                        data-feather="eye" class="icon-sm mr-2"></i> <span
                                                        class="">View</span></a>
                                                <a class="dropdown-item d-flex align-items-center" href="#"><i
                                                        data-feather="edit-2" class="icon-sm mr-2"></i> <span class="">Edit</span></a>
                                                <a class="dropdown-item d-flex align-items-center" href="#"><i
                                                        data-feather="trash" class="icon-sm mr-2"></i> <span class="">Delete</span></a>
                                                <a class="dropdown-item d-flex align-items-center" href="#"><i
                                                        data-feather="printer" class="icon-sm mr-2"></i> <span class="">Print</span></a>
                                                <a class="dropdown-item d-flex align-items-center" href="#"><i
                                                        data-feather="download" class="icon-sm mr-2"></i> <span
                                                        class="">Download</span></a>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-6 col-md-12 col-xl-5">
                                            <h3 class="mb-2">3,897</h3>
                                            <div class="d-flex align-items-baseline">
                                                <p class="text-success">
                                                    <span>+3.3%</span>
                                                    <i data-feather="arrow-up" class="icon-sm mb-1"></i>
                                                </p>
                                            </div>
                                        </div>
                                        <div class="col-6 col-md-12 col-xl-7">
                                            <div id="apexChart1" class="mt-md-3 mt-xl-0"></div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-4 grid-margin stretch-card">
                            <div class="card">
                                <div class="card-body">
                                    <div class="d-flex justify-content-between align-items-baseline">
                                        <h6 class="card-title mb-0">New Orders</h6>
                                        <div class="dropdown mb-2">
                                            <button class="btn p-0" type="button" id="dropdownMenuButton1"
                                                    data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                                <i class="icon-lg text-muted pb-3px" data-feather="more-horizontal"></i>
                                            </button>
                                            <div class="dropdown-menu dropdown-menu-right"
                                                 aria-labelledby="dropdownMenuButton1">
                                                <a class="dropdown-item d-flex align-items-center" href="#"><i
                                                        data-feather="eye" class="icon-sm mr-2"></i> <span
                                                        class="">View</span></a>
                                                <a class="dropdown-item d-flex align-items-center" href="#"><i
                                                        data-feather="edit-2" class="icon-sm mr-2"></i> <span class="">Edit</span></a>
                                                <a class="dropdown-item d-flex align-items-center" href="#"><i
                                                        data-feather="trash" class="icon-sm mr-2"></i> <span class="">Delete</span></a>
                                                <a class="dropdown-item d-flex align-items-center" href="#"><i
                                                        data-feather="printer" class="icon-sm mr-2"></i> <span class="">Print</span></a>
                                                <a class="dropdown-item d-flex align-items-center" href="#"><i
                                                        data-feather="download" class="icon-sm mr-2"></i> <span
                                                        class="">Download</span></a>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-6 col-md-12 col-xl-5">
                                            <h3 class="mb-2">35,084</h3>
                                            <div class="d-flex align-items-baseline">
                                                <p class="text-danger">
                                                    <span>-2.8%</span>
                                                    <i data-feather="arrow-down" class="icon-sm mb-1"></i>
                                                </p>
                                            </div>
                                        </div>
                                        <div class="col-6 col-md-12 col-xl-7">
                                            <div id="apexChart2" class="mt-md-3 mt-xl-0"></div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-4 grid-margin stretch-card">
                            <div class="card">
                                <div class="card-body">
                                    <div class="d-flex justify-content-between align-items-baseline">
                                        <h6 class="card-title mb-0">Growth</h6>
                                        <div class="dropdown mb-2">
                                            <button class="btn p-0" type="button" id="dropdownMenuButton2"
                                                    data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                                <i class="icon-lg text-muted pb-3px" data-feather="more-horizontal"></i>
                                            </button>
                                            <div class="dropdown-menu dropdown-menu-right"
                                                 aria-labelledby="dropdownMenuButton2">
                                                <a class="dropdown-item d-flex align-items-center" href="#"><i
                                                        data-feather="eye" class="icon-sm mr-2"></i> <span
                                                        class="">View</span></a>
                                                <a class="dropdown-item d-flex align-items-center" href="#"><i
                                                        data-feather="edit-2" class="icon-sm mr-2"></i> <span class="">Edit</span></a>
                                                <a class="dropdown-item d-flex align-items-center" href="#"><i
                                                        data-feather="trash" class="icon-sm mr-2"></i> <span class="">Delete</span></a>
                                                <a class="dropdown-item d-flex align-items-center" href="#"><i
                                                        data-feather="printer" class="icon-sm mr-2"></i> <span class="">Print</span></a>
                                                <a class="dropdown-item d-flex align-items-center" href="#"><i
                                                        data-feather="download" class="icon-sm mr-2"></i> <span
                                                        class="">Download</span></a>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-6 col-md-12 col-xl-5">
                                            <h3 class="mb-2">89.87%</h3>
                                            <div class="d-flex align-items-baseline">
                                                <p class="text-success">
                                                    <span>+2.8%</span>
                                                    <i data-feather="arrow-up" class="icon-sm mb-1"></i>
                                                </p>
                                            </div>
                                        </div>
                                        <div class="col-6 col-md-12 col-xl-7">
                                            <div id="apexChart3" class="mt-md-3 mt-xl-0"></div>
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
                                <h6 class="card-title mb-0">Projects</h6>
                                <div class="dropdown mb-2">
                                    <button class="btn p-0" type="button" id="dropdownMenuButton7"
                                            data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                        <i class="icon-lg text-muted pb-3px" data-feather="more-horizontal"></i>
                                    </button>
                                    <div class="dropdown-menu dropdown-menu-right"
                                         aria-labelledby="dropdownMenuButton7">
                                        <a class="dropdown-item d-flex align-items-center" href="#"><i
                                                data-feather="eye" class="icon-sm mr-2"></i> <span class="">View</span></a>
                                        <a class="dropdown-item d-flex align-items-center" href="#"><i
                                                data-feather="edit-2" class="icon-sm mr-2"></i> <span
                                                class="">Edit</span></a>
                                        <a class="dropdown-item d-flex align-items-center" href="#"><i
                                                data-feather="trash" class="icon-sm mr-2"></i> <span
                                                class="">Delete</span></a>
                                        <a class="dropdown-item d-flex align-items-center" href="#"><i
                                                data-feather="printer" class="icon-sm mr-2"></i> <span
                                                class="">Print</span></a>
                                        <a class="dropdown-item d-flex align-items-center" href="#"><i
                                                data-feather="download" class="icon-sm mr-2"></i> <span class="">Download</span></a>
                                    </div>
                                </div>
                            </div>
                            <div class="table-responsive">
                                <table class="table table-hover mb-0">
                                    <thead>
                                    <tr>
                                        <th class="pt-0">#</th>
                                        <th class="pt-0">Project Name</th>
                                        <th class="pt-0">Start Date</th>
                                        <th class="pt-0">Due Date</th>
                                        <th class="pt-0">Status</th>
                                        <th class="pt-0">Assign</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <tr>
                                        <td>1</td>
                                        <td>NobleUI jQuery</td>
                                        <td>01/01/2020</td>
                                        <td>26/04/2020</td>
                                        <td><span class="badge badge-danger">Released</span></td>
                                        <td>Leonardo Payne</td>
                                    </tr>
                                    <tr>
                                        <td>2</td>
                                        <td>NobleUI Angular</td>
                                        <td>01/01/2020</td>
                                        <td>26/04/2020</td>
                                        <td><span class="badge badge-success">Review</span></td>
                                        <td>Carl Henson</td>
                                    </tr>

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
<script src="../assets/vendors/core/core.js"></script>
<!-- endinject -->
<!-- plugin js for this page -->
<script src="../assets/vendors/chartjs/Chart.min.js"></script>
<script src="../assets/vendors/jquery.flot/jquery.flot.js"></script>
<script src="../assets/vendors/jquery.flot/jquery.flot.resize.js"></script>
<script src="../assets/vendors/bootstrap-datepicker/bootstrap-datepicker.min.js"></script>
<script src="../assets/vendors/apexcharts/apexcharts.min.js"></script>
<script src="../assets/vendors/progressbar.js/progressbar.min.js"></script>
<!-- end plugin js for this page -->
<!-- inject:js -->
<script src="../assets/vendors/feather-icons/feather.min.js"></script>
<script src="../assets/js/template.js"></script>
<!-- endinject -->
<!-- custom js for this page -->
<script src="../assets/js/dashboard.js"></script>
<script src="../assets/js/datepicker.js"></script>
<!-- end custom js for this page -->
</body>
</html>    