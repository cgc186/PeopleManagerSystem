<%-- 
    Document   : national_add
    Created on : 2019-6-30, 16:14:40
    Author     : 98530
--%>

<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>  
<%@ page import="java.sql.*"%>  

<html ng-app="basic">  
    <head>  
        <title>添加文化</title>
        <link href="../css/font-awesome.min.css" rel="stylesheet" type="text/css">
        <link href="../css/bootstrap.min.css" rel="stylesheet" type="text/css">
        <link href="../css/bootstrap-theme.min.css" rel="stylesheet" type="text/css">
        <link href="../css/templatemo_style.css" rel="stylesheet" type="text/css">
        <script src="../js/angular.js"></script>
        <script src="../js/T_basic.js"></script>
    </head>  
    <body class="templatemo-bg-image-2" ng-controller="cultrl">
        <div class="container">
            <div class="col-md-12">			
                <form class="form-horizontal templatemo-contact-form-1" role="form" action="../basic_addServlet?type=culture" method="post">
                    <div class="form-group">
                        <div class="col-md-12">
                            <h1 class="margin-bottom-15">添加文化</h1>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-md-12">
                            <label for="email" class="control-label">名称*</label>
                            <div class="templatemo-input-icon-container">
                                <i class="fa fa-envelope-o"></i>
                                <input type="text" class="form-control" name="name" ng-model="name">
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-md-12">
                            <input type="button" value="添加" class="btn btn-success pull-right" ng-click="add();">
                        </div>
                    </div>		    	
                </form>		      
            </div>
        </div>
    </body>
</html>  