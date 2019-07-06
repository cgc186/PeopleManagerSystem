<%-- 
    Document   : transfer
    Created on : 2019-7-6, 17:39:26
    Author     : 98530
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<!DOCTYPE html>
<html ng-app="trans">
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
    <body class="templatemo-bg-image-2" ng-controller="transtrl">
        <div class="container">
            <div class="col-md-12">
                <form class="form-horizontal templatemo-contact-form-1" role="form"
                      action="#" method="post">
                    <div class="form-group">
                        <div class="col-md-12">
                            <h1 class="margin-bottom-15">职工借调</h1>
                        </div>
                    </div>
                    <label for="message" class="control-label">部门{{dno}}*</label>
                    <div>
                        <select ng-model="dno" ng-options="d.dept.dno as d.dept.dname for d in deptlist" ng-selected="d.dept.dno === dno">
                        </select>
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
                        <div>
                            <select ng-model="dno" ng-options="d.dept.dno as d.dept.dname for d in deptlist" ng-selected="d.dept.dno === dno">
                            </select>
                        </div>
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


    </body>
</html>
