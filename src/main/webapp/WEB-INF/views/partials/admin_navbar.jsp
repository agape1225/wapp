<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<nav class="navbar">
    <a href="#" class="sidebar-toggler">
        <i data-feather="menu"></i>
    </a>
    <div class="navbar-content">
        <form class="search-form">
            <div class="input-group">
                <div class="input-group-prepend">
                    <div class="input-group-text">
                        <i data-feather="database"></i>
                        <input type="text" class="form-control" id="navbarForm" value="CLASS 101 관리자 페이지">
                    </div>
                </div>

            </div>
        </form>
        <ul class="navbar-nav">
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="languageDropdown" role="button"
                   data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    <i class="flag-icon flag-icon-kr mt-1" title="kr"></i> <span
                        class="font-weight-medium ml-1 mr-1">Korea</span>
                </a>
            </li>
        </ul>
    </div>
</nav>