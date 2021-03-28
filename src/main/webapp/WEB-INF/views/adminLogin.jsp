<%--
  Created by IntelliJ IDEA.
  User: scg92
  Date: 2021-03-11
  Time: 오전 1:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form action="/admin/login" method="post">
    <h3>관리자 로그인</h3>
    <input type="text" name="id" />
    <input type="text" name="password" />
    <button>로그인</button>
</form>

<div class="col-md-6 grid-margin stretch-card">
    <div class="card">
        <div class="card-body">
            <h6 class="card-title">회원 가입</h6>
            <form class="forms-sample" action="/admin/register" enctype="multipart/form-data"
                  method="post">
                <div class="form-group row">
                    <label for="exampleInputUsername2" class="col-sm-3 col-form-label">ID</label>
                    <div class="col-sm-9">
                        <input type="text" class="form-control" id="exampleInputUsername2"
                               placeholder="아이디" name="adminId">
                    </div>
                </div>
                <div class="form-group row">
                    <label for="exampleInputEmail2" class="col-sm-3 col-form-label">Password</label>
                    <div class="col-sm-9">
                        <input type="text" class="form-control" id="exampleInputEmail2"
                               autocomplete="off" placeholder="비밀번호" name="adminPassword">
                    </div>
                </div>

                <button type="submit" class="btn btn-primary mr-2">등록</button>
            </form>
        </div>
    </div>
</div>

</body>
</html>
