<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html ng-app="employees">
    <head>
        <title>职工借调</title>
        <link href="css/font-awesome.min.css" rel="stylesheet" type="text/css">
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css">
        <link href="css/bootstrap-theme.min.css" rel="stylesheet"
              type="text/css">
        <link href="css/templatemo_style.css" rel="stylesheet" type="text/css">
        <link href="css/selectFilter.css" rel="stylesheet" type="text/css">
        <style type="text/css">
            body {
                padding: 30px;
            }

            .item {
                width: 240px;
                height: 32px;
                margin: 100px auto;
            }
        </style>
        <script src="js/angular.js"></script>
        <script src="js/T_employees.js"></script>
    </head>
    <body class="templatemo-bg-image-2" ng-controller="transferctrl">
        <div class="container">
            <div class="col-md-12">
                <form class="form-horizontal templatemo-contact-form-1" role="form"
                      action="#" method="post">
                    <div class="form-group">
                        <div class="col-md-12">
                            <h1 class="margin-bottom-15">职工借调</h1>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-md-12">
                            <label for="name" class="control-label">职工编号 </label>
                            <div class="templatemo-input-icon-container">
                                <i class="fa fa-user"></i>
                                <input type="text"
                                       class="form-control" name="eno"
                                       value="" ng-model="employee.eno">
                            </div>
                        </div>
                    </div>
                    </br> <br>
                    <div class="form-group">
                        <div class="col-md-12">
                            <label for="name" class="control-label">姓名 </label>
                            <div class="templatemo-input-icon-container">
                                <i class="fa fa-user"></i>
                                <input type="text"
                                       class="form-control" name="ename" readonly="readonly"
                                       value="" ng-model="employee.ename">
                            </div>
                        </div>
                        <br>
                        <br>
                        <br>
                        <br><br><br>

                        <label for="message" class="control-label">部门{{dno}}*</label>
                        <!--
                        <div>
                            <select ng-model="dno">
                                <option ng-repeat="dept in deptlist" value="{{dept.dept.dno}}">编号: {{dept.dept.dno}}  名称:{{dept.dept.dname}}</option>
                            </select>
                        </div>
                        -->
                        <div>
                            <select ng-model="dno" ng-options="d.dept.dno as d.dept.dname for d in deptlist" ng-selected="d.dept.dno===dno">
                            </select>
                        </div>
                        
                        <!--
                        <div class="filter-box">
                            <div class="filter-text">
                                <input class="filter-title" type="text" name="dno"
                                       placeholder="请选择部门" />
                                <i class="icon icon-filter-arrow"></i>
                            </div>
                            <select name="filter">
                                
                            </select>
                        </div>
                        -->
                        </br> <br>
                        <div class="form-group">
                            <div class="col-md-12">
                                <input type="button" value="借调"
                                       class="btn btn-success pull-right" ng-click="transfer();">
                            </div>
                        </div>
                </form>
            </div>
        </div>
        <script type="text/javascript" src="js/jquery.min.js"></script>
        <script type="text/javascript" src="js/selectFilter.js"></script>
        <script type="text/javascript">
                                    //本小插件支持移动端哦

                                    //这里是初始化
                                    $('.filter-box').selectFilter({
                                        callBack: function (val) {
                                            //返回选择的值
                                            console.log(val + '-是返回的值')
                                        }
                                    });
        </script>

    </body>
</html>
