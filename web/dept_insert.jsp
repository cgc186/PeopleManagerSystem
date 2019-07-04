<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>  
<%@ page import="java.sql.*"%>  

<html ng-app="dept">  
    <head>  
        <title>添加部门信息</title>
        <link href="css/font-awesome.min.css" rel="stylesheet" type="text/css">
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css">
        <link href="css/bootstrap-theme.min.css" rel="stylesheet" type="text/css">
        <link href="css/templatemo_style.css" rel="stylesheet" type="text/css">
        <script src="js/angular.js"></script>
        <script src="js/T_dept.js"></script>
    </head>  
    <body class="templatemo-bg-image-2" ng-controller="addctrl">
        <div class="container">
            <div class="col-md-12">			
                <form class="form-horizontal templatemo-contact-form-1" role="form" action="Dept_addServlet" method="post">
                    <div class="form-group">
                        <div class="col-md-12">
                            <h1 class="margin-bottom-15">添加部门信息</h1>
                        </div>
                    </div>				
                    <div class="form-group">
                        <div class="col-md-12">		          	
                            <label for="name" class="control-label">部门编号 *</label>
                            <div class="templatemo-input-icon-container">
                                <i class="fa fa-user"></i>
                                <input type="text" class="form-control" ng-model="dept.dno">
                            </div>		            		            		            
                        </div>              
                    </div>
                    <div class="form-group">
                        <div class="col-md-12">
                            <label for="email" class="control-label">部门名称 *</label>
                            <div class="templatemo-input-icon-container">
                                <i class="fa fa-envelope-o"></i>
                                <input type="text" class="form-control" ng-model="dept.dname">
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-md-12">
                            <label for="website" class="control-label">部门类型*</label>
                            <div class="templatemo-input-icon-container">
                                <i class="fa fa-globe"></i>
                                <input type="text" class="form-control" ng-model="dept.dtype">
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-md-12">
                            <label for="subject" class="control-label">部门花费*</label>
                            <div class="templatemo-input-icon-container">
                                <i class="fa fa-info-circle"></i>
                                <input type="text" class="form-control" ng-model="dept.dcost">
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-md-12">
                            <label for="message" class="control-label">保险基数 *</label>
                            <div class="templatemo-input-icon-container">
                                <i class="fa fa-pencil-square-o"></i>
                                <input type="text" class="form-control" ng-model="dept.dinsurance">
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-md-12">
                            <input type="button" value="添加部门" class="btn btn-success pull-right" ng-click="cc()">
                        </div>
                    </div>		    	
                </form>		      
            </div>
        </div>
    </body>
</html> 



