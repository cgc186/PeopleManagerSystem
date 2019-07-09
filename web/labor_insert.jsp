<%-- 
    Document   : labor_insert
    Created on : 2019-7-8, 22:45:06
    Author     : 98530
--%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.sql.*"%>

<%
    request.setCharacterEncoding("utf-8");
%>
<html ng-app="labor">
    <head>
        <title>添加合同信息</title>
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
        <script src="js/T_labor.js"></script>
    </head>
    <body class="templatemo-bg-image-2" ng-controller="addctrl">
        <div class="container">
            <div class="col-md-12">
                <form class="form-horizontal templatemo-contact-form-1" role="form">
                    <div class="form-group">
                        <div class="col-md-12">
                            <h1 class="margin-bottom-15">添加合同信息</h1>
                        </div>
                    </div>
                    <label for="message" class="control-label">员工编号*</label>
                    <div class="select1">
                        <select ng-model="labor.eno" ng-options="e.employee.eno as e.employee.ename for e in employeelist">
                        </select>
                    </div>
                    <label for="message" class="control-label">员工类型*</label>
                    <div class="select1">
                        <select ng-model="labor.category" ng-options="c.name as c.name for c in categorieslist" ng-selected="c.name === labor.category">
                        </select>
                    </div>
                    <label for="message" class="control-label">部门*</label>
                    <div class="select1">
                        <select ng-model="labor.dno" ng-options="d.dept.dno as d.dept.dname for d in deptlist" ng-selected="d.dept.dno === labor.dno">
                        </select>
                    </div>
                    <label for="message" class="control-label">入职时间*</label>
                    <div class="form-group">
                        <div class="col-md-12">
                            <div class="templatemo-input-icon-container">
                                <i class="fa fa-pencil-square-o"></i>
                                <input type="text"
                                       class="form-control" name="startTime" ng-model="labor.startTime">
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-md-12">
                            <label for="website" class="control-label">月工资{{e.msal}}*</label>
                            <div class="templatemo-input-icon-container">
                                <i class="fa fa-globe"></i>
                                <input type="text"
                                       class="form-control" name="msal" ng-model="labor.msal" readonly="readonly">
                            </div>
                        </div>
                    </div>
                    <label for="message" class="control-label">终止时间*</label>
                    <div class="form-group">
                        <div class="col-md-12">
                            <div class="templatemo-input-icon-container">
                                <i class="fa fa-pencil-square-o"></i>
                                <input type="text"
                                       class="form-control" name="endtime" ng-model="labor.endTime">
                            </div>
                        </div>
                    </div>
                    
                    
                    <br>
                    <br>
                    <div class="form-group">
                        <div class="col-md-12">
                            <input type="button" value="添加合同"
                                   class="btn btn-success pull-right" ng-click="add();">
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </body>
</html>
