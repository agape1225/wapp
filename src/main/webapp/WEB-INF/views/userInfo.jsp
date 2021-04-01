<%--
  Created by IntelliJ IDEA.
  User: HM
  Date: 2021-04-02
  Time: 오전 12:22
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>조회 결과</title>
</head>
<body>
<div class="col-md-6 grid-margin stretch-card">
    <div class="card">
        <div class="card-body">
            <h6 class="card-title">유저 목록</h6>
            <form class="forms-sample">
                <ul>
                    <c:forEach varStatus="i" var="item" items="${userList}">

                        <li class="data">

                            <p style="display: inline">${item.userNo}</p>
                            <p style="display: inline">/${item.userName}</p>
                            <p style="display: inline">/${item.userEmail}</p>
                            <p style="display: inline">/${item.userRegDate}</p>
                            <div style="float: right;">
                                <button class="btn btn-primary mr-2"
                                        onclick="location.href='/userInfo/userDelete?userNo=${item.userNo}'">
                                    삭제
                                </button>
                            </div>
                            <br><br>
                        </li>
                    </c:forEach>
                </ul>
            </form>
        </div>
    </div>
</div>
</div>
</body>
</html>