<%-- 
    Document   : security_list
    Created on : 2019-7-10, 23:04:13
    Author     : 98530
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>

<html ng-app="security">
    <head>
        <meta charset="utf-8">
        <title>社保列表</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="author" content="Bluth Company">
        <link rel="shortcut icon" href="assets/ico/favicon.html">
        <link href="assets/css/bootstrap.css" rel="stylesheet">
        <link href="assets/css/theme.css" rel="stylesheet">
        <link href="assets/css/font-awesome.css" rel="stylesheet">
        <link href="assets/css/alertify.css" rel="stylesheet">
        <link rel="Favicon Icon" href="favicon.ico">
        <script src="js/angular.js"></script>
        <script src="js/T_security.js"></script>      
    </head>
    <body ng-controller="listtrl">
        <div id="wrap">
                    <div class="row-fluid">
                        <div class="widget widget-padding span12">
                            <div class="widget-header">
                                <i class="icon-table"></i>
                                <h5>社保信息列表 </h5>
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
                                                    <td>社会保障序号</td>
                                                    <td>员工姓名</td>
                                                    <td>员工编号</td>
                                                    <td>身份证号码</td>
                                                    <td>投保状态</td>
                                                    <td>起保时间</td>
                                                    <td>停保时间</td>
                                                    <td>缴费月数</td>
                                                    <td>基本工资</td>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <tr class="info" ng-repeat="l in securitylist">
                                                    <td>{{l.security.id}}</td>
                                                    <td>{{l.security.eno}}</td>
                                                    <td>{{l.security.name}}</td>
                                                    <td>{{l.security.number}}</td>
                                                    <td>{{l.security.state}}</td>
                                                    <td>{{l.security.starttime}}</td>
                                                    <td>{{l.security.endtime}}</td>
                                                    <td>{{l.security.month}}</td>
                                                    <td>{{l.security.esal}}</td>
                                                    
                                                </tr>
                                            </tbody>
                                        </table>
                                        <button class="btn btn-success" onclick="window.location.href = '/PeopleManagerSystem/security_insert.jsp'">添加合同</button>
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
