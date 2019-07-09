<%-- 
    Document   : event_list
    Created on : 2019-7-8, 8:57:38
    Author     : 98530
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<!DOCTYPE html>

<html ng-app="event">
    <head>
        <meta charset="utf-8">
        <title>事件列表</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="author" content="Bluth Company">
        <link rel="shortcut icon" href="assets/ico/favicon.html">
        <link href="assets/css/bootstrap.css" rel="stylesheet">
        <link href="assets/css/theme.css" rel="stylesheet">
        <link href="assets/css/font-awesome.css" rel="stylesheet">
        <link href="assets/css/alertify.css" rel="stylesheet">
        <link rel="Favicon Icon" href="favicon.ico">
        <link href="css/xlb.css" rel="stylesheet">
        <script src="js/angular.js"></script>
        <script src="js/T_event.js"></script>
    </head>
    <body ng-controller="search">
        <div id="wrap">
            <!-- Main window -->
            <div id="tables_page">
                <div id="bt">
                    <div class="row-fluid">
                        <h2 class="heading">事件查询</h2>
                    </div>
                    <!--
                    <div>
                        <form action="">
                            <input type="text" placeholder="起始日期" ng-model="begintime"> &nbsp<input
                                type="text" placeholder="终止日期" ng-model="endtime">&nbsp &nbsp &nbsp &nbsp<input
                                type="button" class="btn btn-success" ng-click="search();" value="搜索">
                        </form>
                    </div>
                    -->
                    <div id="check">
                        <span>
                            <input type="checkbox" class="input_check"
                                   id="check1" ng-model="c1"> <label for="check1">根据时间搜索</label>

                            <input type="checkbox" class="input_check"
                                   id="check2" ng-model="c2"> <label for="check2">根据类型搜索</label>
                        </span>
                        <br>
                    </div>
                    <br>
                    <div>

                        <div class="tonghang" ng-show="c1">
                            <select ng-model="begintime">
                                <option value="">请选择起始时间</option>
                                <option ng-repeat="e in eventlist" value="{{e.event.time}}">{{e.event.time}}</option>
                            </select>
                            <select ng-model="endtime">
                                <option value="">请选择末尾时间</option>
                                <option ng-repeat="e in eventlist" value="{{e.event.time}}">{{e.event.time}}</option>
                            </select>
                            
                        </div>
                        <div class="tonghang" ng-show="c2">
                            <select ng-model="endtime">
                                <option value="">请选择类型</option>
                                <option ng-repeat="e in eventlist" value="{{e.event.type}}">{{e.event.type}}</option>
                            </select>
                        </div>
                        <input type="button" class="btn btn-success" value="搜索">

                    </div>
                </div>
                <br>
                <div class="row-fluid">
                    <div class="widget widget-padding span12">
                        <div class="widget-header">
                            <i class="icon-table"></i>
                            <h5>事件列表</h5>
                            <div class="widget-buttons">
                                <a
                                    href="http://twitter.github.com/bootstrap/base-css.html#tables"
                                    data-title="Documentation" class="tip" target="_blank"><i
                                        class="icon-external-link"></i></a> <a href="#"
                                                                       data-title="Collapse" data-collapsed="false"
                                                                       class="tip collapse"><i class="icon-chevron-up"></i></a>
                            </div>
                        </div>
                        <div class="widget-body">
                            <div class="row-fluid">
                                <div class="span12">
                                    <table class="table table-bordered">
                                        <thead>
                                            <tr>
                                                <td>操作时间</td>
                                                <td>操作内容</td>
                                                <td>类型</td>
                                                <td>操作管理员id</td>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <tr class="info" ng-repeat="e in event">
                                                <td>{{e.event.time}}</td>
                                                <td>{{e.event.content}}</td>
                                                <td>{{e.event.type}}</td>
                                                <td>{{e.event.operator}}</td>
                                            </tr>
                                        </tbody>
                                    </table>
                                    <button class="btn btn-success"
                                            onclick="window.location.href = 'employees_insert.jsp'">###</button>
                                </div>
                            </div>
                        </div>
                        <!--/widget-body-->
                    </div>
                    <!-- /widget -->
                </div>
                <!-- /row-fluid -->
            </div>
            <!-- /Main window -->

        </div>
        <!--/.fluid-container-->
    </body>
</html>
