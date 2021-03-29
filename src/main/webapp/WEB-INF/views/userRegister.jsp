<%--
  Created by IntelliJ IDEA.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>회원가입</title>
</head>
<body>
<div class="col-md-6 grid-margin stretch-card">
    <div class="card">
        <div class="card-body">
            <h6 class="card-title">회원 가입</h6>
            <form class="forms-sample" action="/user/register" enctype="multipart/form-data"
                  method="post">
                <div class="form-group row">
                    <label for="InputUsername" class="col-sm-3 col-form-label">Name</label>
                    <div class="col-sm-9">
                        <input type="text" class="form-control" id="InputUsername"
                               placeholder="아이디" name="userName">
                    </div>
                </div>
                <div class="form-group row">
                    <label for="InputUserEmail" class="col-sm-3 col-form-label">ID</label>
                    <div class="col-sm-9">
                        <input type="email" class="form-control" id="InputUserEmail"
                               placeholder="이메일" name="userEmail">
                    </div>
                </div>
                <div class="form-group row">
                    <label for="InputUserPassword" class="col-sm-3 col-form-label">Password</label>
                    <div class="col-sm-9">
                        <input type="text" class="form-control" id="InputUserPassword"
                               autocomplete="off" placeholder="비밀번호" name="userPw">
                    </div>
                </div>

                <button type="submit" class="btn btn-primary mr-2">등록</button>
            </form>
        </div>
    </div>
</div>
</body>
</html>
