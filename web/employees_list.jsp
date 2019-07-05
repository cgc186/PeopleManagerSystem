<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>


<html ng-app="employees">
    <head>
        <meta charset="utf-8">
        <title>职工管理系统</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="author" content="Bluth Company">
        <link rel="shortcut icon" href="assets/ico/favicon.html">
        <link href="assets/css/bootstrap.css" rel="stylesheet">
        <link href="assets/css/theme.css" rel="stylesheet">
        <link href="assets/css/font-awesome.css" rel="stylesheet">
        <link href="assets/css/alertify.css" rel="stylesheet">
        <link rel="Favicon Icon" href="favicon.ico">
        <script src="js/angular.js"></script>
        <script src="js/T_employees.js"></script>      
    </head>
    <body ng-controller="listctrl">
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
                            <h2>欢迎来到职工管理系统！</h2>
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
                                <a class="accordion-toggle b_C3F7A7" data-toggle="collapse" data-parent="#accordion2" href="Employees_listServlet?isQuit=${false}"><i class="icon-magic"></i> <span>在职员工管理系统</span></a>
                            </div>
                        </div>
                        </br>
                        <div class="accordion-group">
                            <div class="accordion-heading">
                                <a class="accordion-toggle b_9FDDF6 collapsed" href="Employees_listServlet?isQuit=${true}"><i class="icon-reorder"></i> <span>离职员工管理系统</span></a>
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
                            职工管理     
                        </h2>
                    </div>

                    <div class="row-fluid">
                        <div class="widget widget-padding span12">
                            <div class="widget-header">
                                <i class="icon-table"></i>
                                <h5>在职职工列表 </h5>
                                <div class="widget-buttons">
                                    <a href="http://twitter.github.com/bootstrap/base-css.html#tables" data-title="Documentation" class="tip" target="_blank"><i class="icon-external-link"></i></a>
                                    <a href="#" data-title="Collapse" data-collapsed="false" class="tip collapse"><i class="icon-chevron-up"></i></a>
                                </div>
                            </div>  
                            <div class="widget-body">
                                <div class="row-fluid">
                                    <div class="span12">
                                        <table class="table table-bordered">
                                            <thead>
                                                <tr>
                                                    <td>职工编号</td>
                                                    <td>姓名</td>
                                                    <td>工资</td>
                                                    <td>性别</td>
                                                    <td>年龄</td>
                                                    <td>联系方式</td>
                                                    <td>民族</td>
                                                    <td>职工类型</td>
                                                    <td>入职日期</td>
                                                    <td>文化程度</td>
                                                    <td>部门号</td>
                                                    <td>操作</td>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                
                                                <tr class="info" ng-repeat="e in employ">
                                                        <td>{{e.eno}}</td>
                                                        <td>{{e.ename}}</td>
                                                        <td>{{e.esal}}</td>
                                                        <td>{{e.esex}}</td>
                                                        <td>{{e.eage}}</td>
                                                        <td>{{e.etel}}</td>
                                                        <td>{{e.enational}}</td>
                                                        <td>{{e.etype}}</td>
                                                        <td>{{e.ein_date}}</td>
                                                        <td>{{e.eculture}}</td>
                                                        <td>{{e.dno}}</td>
                                                        <td>
                                                            <a class="btn btn-info btn-sm" href="Employees_updateServlet?eno={{e.eno}}">更 新</a>
                                                            <a class="btn btn-danger btn-sm" href="Employees_deleServlet?eno={{e.eno}}">删 除</a>
                                                            <a class="btn btn-info btn-sm" href="Employees_TransferServlet?eno={{e.eno}}">借 调</a>
                                                        </td>
                                                    </tr>
                                                
                                            </tbody>
                                        </table>
                                        <button class="btn btn-success" onclick="window.location.href = 'Employees_addServlet?isQuit=${false}'">添加职工</button>
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


