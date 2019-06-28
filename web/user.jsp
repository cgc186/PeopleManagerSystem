<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>

    <head>
        <meta charset="utf-8">
        <title>管理员管理系统</title>
        <link href="css/font-awesome.min.css" rel="stylesheet" type="text/css">
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css">
        <link href="css/bootstrap-theme.min.css" rel="stylesheet" type="text/css">
        <link href="css/templatemo_style.css" rel="stylesheet" type="text/css">
    </head>

    <body class="templatemo-bg-image-3">
        <div class="container">
            <div class="col-md-12">
                <h1>管理员列表</h1><br>
                <table class="table">
                    <thead>
                    <td>管理员编号</td>
                    <td>用户名</td>
                    <td>密码</td>
                    </thead>
                    <tbody>
                        <c:forEach items="${adminlist}" var="user">
                            <tr>
                                <td>${user.userid}</td>
                                <td>${user.username}</td>
                                <td>${user.password}</td>
                                <td>
                                    <a class="btn btn-info btn-sm" href="Update_Servlet?userid=${user.userid}">修改密码</a>

                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
                <button class="btn btn-info" onclick="window.location.href = '/'">管理员列表</button>
            </div>
        </div>
    </body>

</html>