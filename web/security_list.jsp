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
        <script src="js/T_labor.js"></script>      
    </head>
    <body ng-controller="listtrl">
        <div id="wrap">
                    <div class="row-fluid">
                        <div class="widget widget-padding span12">
                            <div class="widget-header">
                                <i class="icon-table"></i>
                                <h5>劳动合同列表 </h5>
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
                                                    <td>操作</td>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <tr class="info" ng-repeat="l in laborlist">
                                                    <td>{{l.labor.id}}</td>
                                                    <td>{{l.labor.eno}}</td>
                                                    <td>{{l.labor.category}}</td>
                                                    <td>{{l.labor.dno}}</td>
                                                    <td>{{l.labor.startTime}}</td>
                                                    <td>{{l.labor.signingTime}}</td>
                                                    <td>{{l.labor.msal}}</td>
                                                    <td>{{l.labor.endtime}}</td>
                                                    <td>{{l.labor.renewalTime}}</td>
                                                    <td>{{l.labor.releaseTime}}</td>
                                                    <td>
                                                        <a class="btn btn-info btn-sm"  ng-click="update(l.labor.id);">续 订</a>
                                                        <a class="btn btn-danger btn-sm" ng-click="delete(l.labor.id,l.labor.eno,l.labor.releaseTime);">解 除</a>
                                                    </td>
                                                </tr>
                                            </tbody>
                                        </table>
                                        <button class="btn btn-success" onclick="window.location.href = '/PeopleManagerSystem/labor_insert.jsp'">添加合同</button>
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
