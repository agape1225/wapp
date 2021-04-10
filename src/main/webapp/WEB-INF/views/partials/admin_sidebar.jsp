<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<nav class="sidebar">
    <div class="sidebar-header">
        <a href="#" class="sidebar-brand">
            WAPP<span>TeamA&B</span>
        </a>
        <div class="sidebar-toggler not-active">
            <span></span>
            <span></span>
            <span></span>
        </div>
    </div>
    <div class="sidebar-body">

        <ul class="nav">

            <li class="nav-item">
                <a href="/admin" class="nav-link">
                    <i class="link-icon" data-feather="box"></i>
                    <span class="link-title">HOME</span>
                </a>
            </li>

            <li class="nav-item nav-category">MANAGE</li>

            <li class="nav-item">
                <a class="nav-link" data-toggle="collapse" href="#lecture" role="button" aria-expanded="false" aria-controls="lecture">
                    <i class="link-icon" data-feather="pen-tool"></i>
                    <span class="link-title">강의</span>
                    <i class="link-arrow" data-feather="chevron-down"></i>
                </a>
                <div class="collapse" id="lecture">
                    <ul class="nav sub-menu">
                        <li class="nav-item">
                            <a class="nav-link" href="/admin/lecture/form">강의 추가</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="/admin/lecture/data-table">강의 관리</a>
                        </li>
                    </ul>
                </div>
            </li>

            <li class="nav-item">
                <a class="nav-link" data-toggle="collapse" href="#banner" role="button" aria-expanded="false" aria-controls="banner">
                    <i class="link-icon" data-feather="hexagon"></i>
                    <span class="link-title">배너</span>
                    <i class="link-arrow" data-feather="chevron-down"></i>
                </a>
                <div class="collapse" id="banner">
                    <ul class="nav sub-menu">
                        <li class="nav-item">
                            <a class="nav-link" href="/admin/banner/form">배너 추가</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="/admin/banner/data-table">배너 관리</a>
                        </li>
                    </ul>
                </div>
            </li>

            <li class="nav-item">
                <a class="nav-link" data-toggle="collapse" href="#popup" role="button" aria-expanded="false" aria-controls="popup">
                    <i class="link-icon" data-feather="flag"></i>
                    <span class="link-title">팝업</span>
                    <i class="link-arrow" data-feather="chevron-down"></i>
                </a>
                <div class="collapse" id="popup">
                    <ul class="nav sub-menu">
                        <li class="nav-item">
                            <a class="nav-link" href="/admin/popup/form">팝업 추가</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="/admin/popup/data-table">팝업 관리</a>
                        </li>
                    </ul>
                </div>
            </li>

            <li class="nav-item">
                <a class="nav-link" data-toggle="collapse" href="#recommended" role="button" aria-expanded="false" aria-controls="recommended">
                    <i class="link-icon" data-feather="thumbs-up"></i>
                    <span class="link-title">MD 추천</span>
                    <i class="link-arrow" data-feather="chevron-down"></i>
                </a>
                <div class="collapse" id="navigation">
                    <ul class="nav sub-menu">
                        <li class="nav-item">
                            <a class="nav-link" href="/admin/recommended/form">추천 추가</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="/admin/recommended/data-table">추천 관리</a>
                        </li>
                    </ul>
                </div>
            </li>

            <li class="nav-item">
                <a class="nav-link" data-toggle="collapse" href="#benefit" role="button" aria-expanded="false" aria-controls="benefit">
                    <i class="link-icon" data-feather="smile"></i>
                    <span class="link-title">이벤트</span>
                    <i class="link-arrow" data-feather="chevron-down"></i>
                </a>
                <div class="collapse" id="benefit">
                    <ul class="nav sub-menu">
                        <li class="nav-item">
                            <a class="nav-link" href="/admin/benefit/form">이벤트 추가</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="/admin/benefit/data-table">이벤트 관리</a>
                        </li>
                    </ul>
                </div>
            </li>


            <li class="nav-item nav-category">고객 관리</li>
            <li class="nav-item">
                <a class="nav-link" href="/admin/user/data-table">
                    <i class="link-icon" data-feather="user"></i>
                    <span class="link-title">유저 관리</span>
                </a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/admin/inquiry/data-table">
                    <i class="link-icon" data-feather="twitter"></i>
                    <span class="link-title">문의 관리</span>
                </a>
            </li>

            <li class="nav-item nav-category">LOG OUT</li>
            <li class="nav-item">
                <a class="nav-link" href="/admin/logout">
                    <i class="link-icon" data-feather="log-out"></i>
                    <span class="link-title">로그아웃</span>
                </a>
            </li>



        </ul>
    </div>
</nav>
<nav class="settings-sidebar">
    <div class="sidebar-body">
        <a href="#" class="settings-sidebar-toggler">
            <i data-feather="settings"></i>
        </a>
        <h6 class="text-muted">Sidebar:</h6>
        <div class="form-group border-bottom">
            <div class="form-check form-check-inline">
                <label class="form-check-label">
                    <input type="radio" class="form-check-input" name="sidebarThemeSettings" id="sidebarLight" value="sidebar-light" checked>
                    Light
                </label>
            </div>
            <div class="form-check form-check-inline">
                <label class="form-check-label">
                    <input type="radio" class="form-check-input" name="sidebarThemeSettings" id="sidebarDark" value="sidebar-dark">
                    Dark
                </label>
            </div>
        </div>
    </div>
</nav>