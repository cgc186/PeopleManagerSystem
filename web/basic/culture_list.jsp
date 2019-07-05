<%-- 
    Document   : culture_list
    Created on : 2019-6-30, 15:14:29
    Author     : 98530
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>

<html lang="en" ng-app="basic">
    <head>
        <meta charset="utf-8">
        <title>文化程度管理</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="author" content="Bluth Company">
        <link rel="shortcut icon" href="../assets/ico/favicon.html">
        <link href="../assets/css/bootstrap.css" rel="stylesheet">
        <link href="../assets/css/theme.css" rel="stylesheet">
        <link href="../assets/css/font-awesome.css" rel="stylesheet">
        <link href="../assets/css/alertify.css" rel="stylesheet">
        <link rel="Favicon Icon" href="favicon.ico">
        <!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
        <!--[if lt IE 9]>
          <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
        <![endif]-->
        <script src="../js/angular.js"></script>
        <script src="../js/T_basic.js"></script>
    </head>
    <body ng-controller="cultrl">
        <div id="wrap">
            <div class="navbar navbar-fixed-top">
                <div class="navbar-inner">
                    <div class="container-fluid">
                        <div class="logo">
                            <img src="assets/img/logo.png" alt="Realm Admin Template">
                        </div>
                        <a class="btn btn-navbar visible-phone" data-toggle="collapse" data-target=".nav-collapse">
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                        </a>
                        <a class="btn btn-navbar slide_menu_left visible-tablet">
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                        </a>
                        <div class="top-menu visible-desktop">
                            <h2>欢迎来到基础信息管理系统！</h2>
                        </div>
                    </div>
                </div>
            </div>

            <div class="container-fluid">

                <!-- Side menu -->  
                <div class="sidebar-nav nav-collapse collapse">
                    <div class="accordion" id="accordion2">
                        </br>
                        </br>
                        <div class="accordion-group">
                            <div class="accordion-heading">
                                <a class="accordion-toggle b_C3F7A7 collapsed" data-toggle="collapse" data-parent="#accordion2" href="basic_listServlet?type=culture"><i class="icon-magic"></i> <span>文化程度信息管理</span></a>
                            </div>
                        </div>
                        </br>
                        <div class="accordion-group">
                            <div class="accordion-heading">
                                <a class="accordion-toggle b_9FDDF6 collapsed" href="basic_listServlet?type=national"><i class="icon-reorder"></i> <span>民族信息管理系统</span></a>
                            </div>
                        </div>
                        </br>
                        <div class="accordion-group">
                            <div class="accordion-heading">
                                <a class="accordion-toggle b_C3F7A7 collapsed" href="basic_listServlet?type=categories"><i class="icon-reorder"></i> <span>职务信息管理系统</span></a>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- /Side menu -->

                <!-- Main window -->
                <div class="main_container" id="tables_page">
                    <div class="row-fluid">
                        <ul class="breadcrumb">
                            <li><a href="index.jsp">Home</a> <span class="divider">/</span></li>
                        </ul>
                        <h2 class="heading">
                            文化程度信息管理    
                        </h2>
                    </div>

                    <div class="row-fluid">
                        <div class="widget widget-padding span12">
                            <div class="widget-header">
                                <i class="icon-table"></i>
                                <h5>在职职工文化程度统计表 </h5>
                                <div class="widget-buttons">
                                    <a href="http://twitter.github.com/bootstrap/base-css.html#tables" data-title="Documentation" class="tip" target="_blank"><i class="icon-external-link"></i></a>
                                    <a href="#" data-title="Collapse" data-collapsed="false" class="tip collapse"><i class="icon-chevron-up"></i></a>
                                </div>
                            </div>  
                            <div class="widget-body" style="width: 500px">
                                <div class="row-fluid">
                                    <div class="span12">
                                        <table class="table table-bordered">
                                            <thead>
                                                <tr>
                                                    <td>名称</td>
                                                    <td>人数</td>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <tr class="info" ng-repeat="Basic in list">
                                                    <td>{{Basic.name}}</td>
                                                    <td>{{Basic.number}}</td>
                                                </tr>
                                            </tbody>
                                        </table>
                                        <button class="btn btn-success" onclick="window.location.href = 'basic/culture_add.jsp'">添加文化级别</button>
                                        <button class="btn btn-success" ng-click="update();">人数更新</button>
                                    </div>
                                </div> 
                            </div><!--/widget-body-->
                        </div> <!-- /widget -->
                    </div> <!-- /row-fluid -->
                </div>
                <!-- /Main window -->

            </div><!--/.fluid-container-->
        </div><!-- wrap ends-->
        <script type="text/javascript" src="assets/js/js/jquery.min.js"></script>
        <script type="text/javascript" src="assets/js/js/jquery-ui.min.js"></script>
        <script type="text/javascript" src="assets/js/js/raphael-min.js"></script>
        <script type="text/javascript" src="assets/js/js/bootstrap.js"></script>
        <script type="text/javascript" src='assets/js/js/sparkline.js'></script>
        <script type="text/javascript" src='assets/js/js/morris.min.js'></script>
        <script type="text/javascript" src="assets/js/js/jquery.dataTables.min.js"></script>   
        <script type="text/javascript" src="assets/js/js/jquery.masonry.min.js"></script>   
        <script type="text/javascript" src="assets/js/js/jquery.imagesloaded.min.js"></script>   
        <script type="text/javascript" src="assets/js/js/jquery.facybox.js"></script>   
        <script type="text/javascript" src="assets/js/js/jquery.alertify.min.js"></script> 
        <script type="text/javascript" src="assets/js/js/jquery.knob.js"></script>
        <script type='text/javascript' src='assets/js/js/fullcalendar.min.js'></script>
        <script type='text/javascript' src='assets/js/js/jquery.gritter.min.js'></script>
        <script type="text/javascript" src="assets/js/js/realm.js"></script>
    </body>
</html>