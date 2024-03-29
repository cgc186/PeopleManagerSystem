<%-- 
    Document   : categories_add
    Created on : 2019-6-30, 16:14:29
    Author     : 98530
--%>

<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>  
<%@ page import="java.sql.*"%>  

<html ng-app="basic">  
    <head>  
        <title>职务信息更新</title>
        <link href="../css/font-awesome.min.css" rel="stylesheet" type="text/css">
        <link href="../css/bootstrap.min.css" rel="stylesheet" type="text/css">
        <link href="../css/bootstrap-theme.min.css" rel="stylesheet" type="text/css">
        <link href="../css/templatemo_style.css" rel="stylesheet" type="text/css">
        <script src="../js/angular.js"></script>
        <script src="../js/T_basic.js"></script>
    </head>  
    <body class="templatemo-bg-image-2" ng-controller="cadeltrl">
        <div class="container">
            <div class="col-md-12">
                <form class="form-horizontal templatemo-contact-form-1" role="form" action="categories_updateServlet" method="post">
                    <div class="form-group">
                        <div class="col-md-12">
                            <h1 class="margin-bottom-15">修改职务</h1>
                        </div>
                    </div>
                    <div class="form-group">
                        <input type="hidden" name="id" value="" ng-model="id">
                        <div class="col-md-12">
                            <label for="email" class="control-label">名称*</label>
                            <div class="templatemo-input-icon-container">
                                <i class="fa fa-envelope-o"></i>
                                <input type="text" class="form-control" name="name" value="" ng-model="jobTitle">
                            </div>
                        </div>
                        <div class="col-md-12">
                            <label for="email" class="control-label">薪资*</label>
                            <div class="templatemo-input-icon-container">
                                <i class="fa fa-envelope-o"></i>
                                <input type="text" class="form-control" name="PostAllowance" value="" ng-model="postAllowance">
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-md-12">
                            <input type="button" value="修改" class="btn btn-success pull-right" ng-click="update();">
                        </div>
                    </div>
                </form>		      
            </div>
        </div>
    </body>
</html>