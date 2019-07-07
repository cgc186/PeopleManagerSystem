<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <title>部门管理系统</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="author" content="Bluth Company">
        <link rel="shortcut icon" href="assets/ico/favicon.html">
        <link href="assets/css/bootstrap.css" rel="stylesheet">
        <link href="assets/css/theme.css" rel="stylesheet">
        <link href="assets/css/font-awesome.css" rel="stylesheet">
        <link href="assets/css/alertify.css" rel="stylesheet">
        <link rel="Favicon Icon" href="favicon.ico">
        <!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
        <!--[if lt IE 9]>
          <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
        <![endif]-->
    </head>
    <body>
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
                            <h2>欢迎来到部门结算系统！</h2>
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
                                <a class="accordion-toggle b_F6F1A2" href="/PeopleManagerSystem/dept_list.jsp"><i class="icon-tasks"></i> <span>部门管理系统</span></a>
                            </div>
                        </div>
                        </br>
                        <div class="accordion-group">
                            <div class="accordion-heading">
                                <a class="accordion-toggle b_C1F8A9" data-toggle="collapse" data-parent="#accordion2" href=href="Pay_listServlet"><i class="icon-bar-chart"></i> <span>部门结算系统</span></a>
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
                            部门管理     
                        </h2>
                    </div>
                    <img src="<%=request.getContextPath()%>/Pay_chartServlet?dno=all">
                    <div class="row-fluid">
                        <div class="widget widget-padding span12">
                            <div class="widget-header">
                                <i class="icon-table"></i>
                                <h5>部门预算列表 </h5>
                                <div class="widget-buttons">
                                    <a href="http://twitter.github.com/bootstrap/base-css.html#tables" data-title="Documentation" class="tip" target="_blank"><i class="icon-external-link"></i></a>
                                    <a href="#" data-title="Collapse" data-collapsed="false" class="tip collapse"><i class="icon-chevron-up"></i></a>
                                </div>
                            </div>  
                            <div class="widget-body">
                                <div class="row-fluid">
                                    <div class="span10">
                                        <table class="table table-bordered">
                                            <thead>
                                                <tr>
                                                    <td>部门编号</td>
                                                    <td>部门预算</td>
                                                    <td>部门花销</td>
                                                    <td>操作</td>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <c:forEach items="${deptpay}" var="dept">
                                                    <tr class="info">
                                                        <td>${dept.dno}</td>
                                                        <td>${dept.budget}</td>
                                                        <td>${dept.actualBudget}</td>
                                                        <td>
                                                          <a class="btn btn-info btn-sm" href="Pay_chartServlet?dno=${dept.dno}">查看单部门对比图</a>
                                                        </td>
                                                    </tr>
                                                </c:forEach>
                                            </tbody>
                                        </table>
                                        <a class="btn btn-info btn-sm" href="Pay_updateServlet">点 击 更 新 </a>
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
