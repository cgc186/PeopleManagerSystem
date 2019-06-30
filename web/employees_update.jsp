<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.sql.*"%>
<html>
    <head>
        <title>更新在职职工信息</title>
        <link href="css/font-awesome.min.css" rel="stylesheet" type="text/css">
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css">
        <link href="css/bootstrap-theme.min.css" rel="stylesheet"
              type="text/css">
        <link href="css/templatemo_style.css" rel="stylesheet" type="text/css">
        <link href="css/selectFilter.css" rel="stylesheet" type="text/css">
        <style type="text/css">
            body {
                padding: 30px;
            }

            .item {
                width: 240px;
                height: 32px;
                margin: 100px auto;
            }
        </style>
    </head>
    <body class="templatemo-bg-image-2">
        <div class="container">
            <div class="col-md-12">
                <form class="form-horizontal templatemo-contact-form-1" role="form"
                      action="Employees_updateServlet?isQuit=${false}" method="post">
                    <div class="form-group">
                        <div class="col-md-12">
                            <h1 class="margin-bottom-15">更改职工信息</h1>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-md-12">
                            <label for="name" class="control-label">职工编号 *</label>
                            <div class="templatemo-input-icon-container">
                                <i class="fa fa-user"></i> <input type="text"
                                                                  class="form-control" name="eno" readonly="readonly"
                                                                  value="${employees.eno}">
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-md-12">
                            <label for="email" class="control-label">姓名 *</label>
                            <div class="templatemo-input-icon-container">
                                <i class="fa fa-envelope-o"></i> <input type="text"
                                                                        class="form-control" name="ename" value="${employees.ename}">
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-md-12">
                            <label for="website" class="control-label">工资*</label>
                            <div class="templatemo-input-icon-container">
                                <i class="fa fa-globe"></i> <input type="text"
                                                                   class="form-control" name="esal" value="${employees.esal}">
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-md-12">
                            <label for="website" class="control-label">性别： </label></br>
                            <c:choose>
                                <c:when test="${employees.esex == '男'}">
                                    <label class="radio-inline">
                                        <input type="radio"
                                               name="esex" id="esex" value="男" checked="checked"> 男
                                    </label>
                                    <label class="radio-inline">
                                        <input type="radio"
                                               name="esex" id="esex" value="女"> 女
                                    </label>
                                </c:when>
                            </c:choose>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-md-12">
                            <label for="subject" class="control-label">年龄*</label>
                            <div class="templatemo-input-icon-container">
                                <i class="fa fa-info-circle"></i> <input type="text"
                                                                         class="form-control" name="eage" value="${employees.eage}">
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-md-12">
                            <label for="message" class="control-label">联系电话 *</label>
                            <div class="templatemo-input-icon-container">
                                <i class="fa fa-pencil-square-o"></i>
                                <input type="text"
                                       class="form-control" name="etel" value="${employees.etel}">
                            </div>
                        </div>
                    </div>
                    <label for="message" class="control-label">民族*</label>
                    <div class="filter-box4">
                        <div class="filter-text">
                            <input class="filter-title" name="enational" type="text" 
                                   value="${employees.enational}" />
                            <i class="icon icon-filter-arrow"></i>
                        </div>
                        <select name="filter">
                            <c:forEach items="${nationlist}" var="nation">
                                <option value="${nation}">${nation}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <br>
                    <br>
                    <label for="message" class="control-label">员工类型*</label>
                    <div class="filter-box3">
                        <div class="filter-text">
                            <input class="filter-title" name="etype" type="text" 
                                   value="${employees.etype}" /> <i class="icon icon-filter-arrow"></i>
                        </div>
                        <select name="filter">
                            <c:forEach items="${categorieslist}" var="categories">
                                <option value="${categories}">${categories}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <br>
                    <br>
                    <div class="form-group">
                        <div class="col-md-12">
                            <label for="message" class="control-label">入职时间*</label>
                            <div class="templatemo-input-icon-container">
                                <i class="fa fa-pencil-square-o"></i>
                                <input type="text"
                                       class="form-control" name="ein_date"
                                       value="${employees.ein_date}">
                            </div>
                        </div>
                    </div>
                    <label for="message" class="control-label">学历*</label>
                    <div class="filter-box2">
                        <div class="filter-text">
                            <input class="filter-title" name="eculture" type="text"
                                   placeholder="${employees.eculture}" />
                            <i class="icon icon-filter-arrow"></i>
                        </div>
                        <select name="filter">
                            <c:forEach items="${culturelist}" var="culture">
                                <option value="${culture}">${culture}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <br>
                    <br>
                    <label for="message" class="control-label">部门*</label>
                    <div class="filter-box1">
                        <div class="filter-text">
                            <input class="filter-title" type="text" readonly
                                   name="dno" value="部门编号: ${employees.dno}" />
                            <i class="icon icon-filter-arrow"></i>
                        </div>
                        <select name="filter">
                            <c:forEach items="${deptlist}" var="dept">
                                <option value="${dept.dno}">部门编号: ${dept.dno} 部门名称: ${dept.dname}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <br>
                    <br>
                    <div class="form-group">
                        <div class="col-md-12">
                            <input type="submit" value="更改职工"
                                   class="btn btn-success pull-right">
                        </div>
                    </div>
                </form>
            </div>
        </div>
        <script type="text/javascript" src="js/jquery.min.js"></script>
        <script type="text/javascript" src="js/selectFilter.js"></script>
        <script type="text/javascript">
            //本小插件支持移动端哦

            //这里是初始化
            $('.filter-box1').selectFilter({
                callBack: function (val) {
                    //返回选择的值
                    console.log(val + '-是返回的值')
                }
            });
        </script>
        <script type="text/javascript">
            //本小插件支持移动端哦

            //这里是初始化
            $('.filter-box2').selectFilter({
                callBack: function (val) {
                    //返回选择的值
                    console.log(val + '-是返回的值')
                }
            });
        </script>
        <script type="text/javascript">
            //本小插件支持移动端哦

            //这里是初始化
            $('.filter-box3').selectFilter({
                callBack: function (val) {
                    //返回选择的值
                    console.log(val + '-是返回的值')
                }
            });
        </script>
        <script type="text/javascript">
            //本小插件支持移动端哦

            //这里是初始化
            $('.filter-box4').selectFilter({
                callBack: function (val) {
                    //返回选择的值
                    console.log(val + '-是返回的值')
                }
            });
        </script>
    </body>
</html>
