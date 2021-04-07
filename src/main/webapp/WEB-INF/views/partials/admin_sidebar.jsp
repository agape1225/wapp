<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<nav class="sidebar">
    <div class="sidebar-header">
        <a href="#" class="sidebar-brand">
            WAPP<span>TeamB</span>
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
                <a href="/admin/home" class="nav-link">
                    <i class="link-icon" data-feather="box"></i>
                    <span class="link-title">HOME</span>
                </a>
            </li>

            <li class="nav-item nav-category">MANAGE</li>

            <li class="nav-item">
                <a class="nav-link" href="/admin/lecture/form">
                    <i class="link-icon" data-feather="feather"></i>
                    <span class="link-title">강의 추가</span>
                </a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/admin/lecture/data-table">
                    <i class="link-icon" data-feather="anchor"></i>
                    <span class="link-title">강의 관리</span>
                </a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/admin/banner/form">
                    <i class="link-icon" data-feather="inbox"></i>
                    <span class="link-title">배너 추가</span>
                </a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/admin/banner/data-table">
                    <i class="link-icon" data-feather="layout"></i>
                    <span class="link-title">배너 관리</span>
                </a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/admin/popup/form">
                    <i class="link-icon" data-feather="inbox"></i>
                    <span class="link-title">팝업 추가</span>
                </a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/admin/popup/data-table">
                    <i class="link-icon" data-feather="layout"></i>
                    <span class="link-title">팝업 관리</span>
                </a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/admin/inquiry/data-table">
                    <i class="link-icon" data-feather="inbox"></i>
                    <span class="link-title">문의 관리</span>
                <a class="nav-link" href="/admin/recommended/form">
                    <i class="link-icon" data-feather="inbox"></i>
                    <span class="link-title">추천 추가</span>
                </a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/admin/recommended/data-table">
                    <i class="link-icon" data-feather="layout"></i>
                    <span class="link-title">추천 관리</span>
                </a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/admin/user/data-table">
                    <i class="link-icon" data-feather="layout"></i>
                    <span class="link-title">유저 관리</span>
                </a>
            </li>
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