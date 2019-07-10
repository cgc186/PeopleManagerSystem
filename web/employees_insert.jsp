<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.sql.*"%>

<%
    request.setCharacterEncoding("utf-8");
%>
<html ng-app="employees">
    <head>
        <title>添加在职职工信息</title>
        <link href="css/font-awesome.min.css" rel="stylesheet" type="text/css">
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css">
        <link href="css/bootstrap-theme.min.css" rel="stylesheet"
              type="text/css">
        <link href="css/templatemo_style.css" rel="stylesheet" type="text/css">
        <link href="css/xll.css" rel="stylesheet" type="text/css">
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
        
        <script src="js/angular.js"></script>
        <script src="js/T_employees.js"></script>
    </head>
    <body class="templatemo-bg-image-2" ng-controller="addctrl">
        <div class="container">
            <div class="col-md-12">
                <form class="form-horizontal templatemo-contact-form-1" role="form">
                    <div class="form-group">
                        <div class="col-md-12">
                            <h1 class="margin-bottom-15">添加职工信息</h1>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-md-12">
                            <label for="name" class="control-label">职工编号*</label>
                            <div class="templatemo-input-icon-container">
                                <i class="fa fa-user"></i>
                                <input type="text"
                                       class="form-control" name="eno" ng-model="employee.eno">
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-md-12">
                            <label for="email" class="control-label">姓名 *</label>
                            <div class="templatemo-input-icon-container">
                                <i class="fa fa-envelope-o"></i>
                                <input type="text"
                                       class="form-control" name="ename" ng-model="employee.ename">
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-md-12">
                            <label for="website" class="control-label">工资*</label>
                            <div class="templatemo-input-icon-container">
                                <i class="fa fa-globe"></i>
                                <input type="text"
                                       class="form-control" name="esal" ng-model="employee.esal">
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-md-12">
                            <label for="website" class="control-label">性别：</label></br>
                            <label class="radio-inline">
                                <input type="radio" name="esex"
                                       value="男" checked="checked" ng-model="employee.esex"> 男
                            </label>
                            <label class="radio-inline">
                                <input type="radio"
                                       name="esex" value="女" ng-model="employee.esex"> 女
                            </label>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-md-12">
                            <label for="subject" class="control-label">年龄*</label>
                            <div class="templatemo-input-icon-container">
                                <i class="fa fa-info-circle"></i>
                                <input type="text"
                                       class="form-control" name="eage" ng-model="employee.eage">
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-md-12">
                            <label for="message" class="control-label">联系电话 *</label>
                            <div class="templatemo-input-icon-container">
                                <i class="fa fa-pencil-square-o"></i>
                                <input type="text"
                                       class="form-control" name="etel" ng-model="employee.etel">
                            </div>
                        </div>
                    </div>
                    <label for="message" class="control-label">民族*</label>
                    <div class="select1">
                        <select ng-model="employee.enational" ng-options="n.name as n.name for n in nationlist" ng-selected="n.name === employee.enational">
                        </select>
                    </div>
                    <br>
                    <br>
                    <label for="message" class="control-label">员工类型*</label>
                   <div class="select1">
                        <select ng-model="employee.etype" ng-options="c.name as c.name for c in categorieslist" ng-selected="cu.name === employee.etype">
                        </select>
                    </div>
                    <br>
                    <br>
                    <label for="message" class="control-label">入职时间*</label>
                    <div class="form-group">
                        <div class="col-md-12">
                            <div class="templatemo-input-icon-container">
                                <i class="fa fa-pencil-square-o"></i>
                                <input type="text"
                                       class="form-control" name="ein_date" ng-model="employee.ein_date">
                            </div>
                        </div>
                    </div>
                    <label for="message" class="control-label">学历*</label>
                    <div class="select1">
                        <select ng-model="employee.eculture" ng-options="cul.name as cul.name for cul in culturelist" ng-selected="cul.name === employee.eculture">
                        </select>
                    </div>
                    <br>
                    <br>
                    <label for="message" class="control-label">部门*</label>
                    <div class="select1">
                        <select ng-model="employee.dno" ng-options="d.dept.dno as d.dept.dname for d in deptlist" ng-selected="d.dept.dno === employee.dno">
                        </select>
                    </div>
                    <br>
                    <br>
                    <div class="form-group">
                        <div class="col-md-12">
                            <input type="button" value="添加职工"
                                   class="btn btn-success pull-right" ng-click="add();">
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </body>
</html>