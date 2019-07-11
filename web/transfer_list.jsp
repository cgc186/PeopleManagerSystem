<%-- 
    Document   : transfer_list
    Created on : 2019-7-11, 16:31:37
    Author     : 98530
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en" ng-app="trans">
    <head>
        <meta charset="utf-8">
        <title>借调情况记录表</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="author" content="Bluth Company">
        <link rel="shortcut icon" href="assets/ico/favicon.html">
        <link href="assets/css/bootstrap.css" rel="stylesheet">
        <link href="assets/css/theme.css" rel="stylesheet">
        <link href="assets/css/font-awesome.css" rel="stylesheet">
        <link href="assets/css/alertify.css" rel="stylesheet">
        <link rel="Favicon Icon" href="favicon.ico">
        <script src="js/angular.js"></script>
        <script src="js/T_transfer.js"></script>
    </head>
    <body ng-controller="listctrl">
        <div id="wrap">

            <div class="container-fluid">


                    <div class="row-fluid">
                        <div class="widget widget-padding span12">
                            <div class="widget-header">
                                <i class="icon-table"></i>
                                <h5>借调情况记录表 </h5>
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
                                                    <td>员工编号{{test}}</td>
                                                    <td>先前部门</td>
                                                    <td>当前部门</td>
                                                    <td>借调时间</td>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                    <tr class="info" ng-repeat="t in transfer">
                                                        <td>{{t.transfer.eno}}</td>
                                                        <td>{{t.transfer.prevdept}}</td>
                                                        <td>{{t.transfer.currdept}}</td>
                                                        <td>{{t.transfer.time}}</td>
                                                    </tr>
                                            </tbody>
                                        </table>
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

