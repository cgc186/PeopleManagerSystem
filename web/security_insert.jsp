<%-- 
    Document   : security_insert
    Created on : 2019-7-11, 8:38:08
    Author     : 98530
--%>

<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.sql.*"%>

<%
    request.setCharacterEncoding("utf-8");
%>
<html ng-app="security">
    <head>
        <title>添加社保信息</title>
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
        <script src="js/T_security.js"></script>
    </head>
    <body class="templatemo-bg-image-2" ng-controller="addctrl">
        <div class="container">
            <div class="col-md-12">
                <form class="form-horizontal templatemo-contact-form-1" role="form">
                    <div class="form-group">
                        <div class="col-md-12">
                            <h1 class="margin-bottom-15">添加社保信息</h1>
                        </div>
                    </div>
                    <label for="message" class="control-label">社会保险序号*</label>
                    <div class="templatemo-input-icon-container">
                        <i class="fa fa-globe"></i>
                        <input type="text"
                               class="form-control" name="msal" ng-model="security.id">
                    </div>
                    <label for="message" class="control-label">员工编号{{security.eno}}*</label>
                    <div class="select1">
                        <select ng-model="security.eno" ng-options="e.eno as e.eno for e in employeelist">
                            <option value="">请选择员工编号</option>
                        </select>
                    </div>
                    <label for="message" class="control-label">员工姓名*</label>
                    <div class="form-group">
                        <div class="col-md-12">
                            <div class="templatemo-input-icon-container">
                                <i class="fa fa-pencil-square-o"></i>
                                <input type="text"
                                       class="form-control" name="name" ng-model="security.name" readonly="readonly">
                            </div>
                        </div>
                    </div>
                    <label for="message" class="control-label">身份证号码*</label>
                    <div class="form-group">
                        <div class="col-md-12">
                            <div class="templatemo-input-icon-container">
                                <i class="fa fa-pencil-square-o"></i>
                                <input type="text"
                                       class="form-control" name="name" ng-model="security.number">
                            </div>
                        </div>
                    </div>
                    <label for="message" class="control-label">投保状态*</label>
                    <div class="select1">
                        <select ng-model="security.state">
                            <option value="投保中">投保中</option>
                            <option value="已过保">已过保</option>
                        </select>
                    </div>
                    <label for="message" class="control-label">起保时间*</label>
                    <div class="form-group">
                        <div class="col-md-12">
                            <div class="templatemo-input-icon-container">
                                <i class="fa fa-pencil-square-o"></i>
                                <input type="text"
                                       class="form-control" name="starttime" ng-model="security.starttime">
                            </div>
                        </div>
                    </div>
                    <label for="message" class="control-label">停保时间*</label>
                    <div class="form-group">
                        <div class="col-md-12">
                            <div class="templatemo-input-icon-container">
                                <i class="fa fa-pencil-square-o"></i>
                                <input type="text"
                                       class="form-control" name="endtime" ng-model="security.endtime">
                            </div>
                        </div>
                    </div>
                    <label for="message" class="control-label">缴费月数*</label>
                    <div class="form-group">
                        <div class="col-md-12">
                            <div class="templatemo-input-icon-container">
                                <i class="fa fa-pencil-square-o"></i>
                                <input type="text"
                                       class="form-control" name="month" ng-model="security.month">
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-md-12">
                            <label for="website" class="control-label">月工资*</label>
                            <div class="templatemo-input-icon-container">
                                <i class="fa fa-globe"></i>
                                <input type="text"
                                       class="form-control" name="esal" ng-model="security.esal" readonly="readonly">
                            </div>
                        </div>
                    </div>

                    <br>
                    <br>
                    <div class="form-group">
                        <div class="col-md-12">
                            <input type="button" value="添加"
                                   class="btn btn-success pull-right" ng-click="add();">
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </body>
</html>
