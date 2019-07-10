
<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<html ng-app="user">
<head>
    <title>注册</title>
    <meta name="keywords" content="" />
    <meta name="description" content="" />
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css">
    <link href="css/bootstrap-theme.min.css" rel="stylesheet" type="text/css">
    <link href="css/templatemo_style.css" rel="stylesheet" type="text/css">
    <script>
        function validateForm() {
        var name = document.forms["register"]["username"].value;
        if (name === "") {
        alert("必须填写用户名！");
        return false;
        }
        var pw = document.forms["register"]["password"].value;
        var repw = document.forms["register"]["repassword"].value;
        if (pw === "" || repw === "") {
        alert("必须填写密码！");
        return false;
        }
        if (name.length > 20 || name.length < 1) {
        alert("用户名请输入1-20位字符");
        return false;
        }
        if (pw.length > 20 || pw.length < 1) {
        alert("密码请输入1-20位字符");
        return false;
        }
        if (repw.length > 20 || repw.length < 1) {
        alert("密码请输入1-20位字符");
        return false;
        }
        if (pw !== repw) {
        alert("两次密码必须相等");
        return false;
        }
        return true;
        }
    </script>
    <script src="js/angular.js"></script>
    <script src="js/T_user.js"></script>
</head>
<body class="templatemo-bg-image-1" ng-controller="regctl">
    <h1 class="margin-bottom-15">创建帐户</h1>
    <div class="container">
        <div class="col-md-12">			
            <form class="form-horizontal templatemo-contact-form-1" 
                  role="form" action="#" method="post"
                  name="register" onsubmit="return validateForm()">
                <div class="form-inner">
                    <div class="form-group">
                        <div class="col-md-12">	
                            <br><br>
                            <label for="username" class="control-label">用户名</label>
                            <input type="text" class="form-control" name="username" ng-model="uname">		            		            		            
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-md-12">
                            <label for="password" class="control-label">密码</label>
                            <input type="password" class="form-control" name="password" ng-model="upwd">
                        </div>
                        <div class="col-md-12">
                            <label for="password" class="control-label">确认密码</label>
                            <input type="password" class="form-control" name="repassword" ng-model="rupwd">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-md-12">
                            <label><input type="checkbox">同意以下协议 <a href="javascript:;" data-toggle="modal" data-target="#templatemo_modal">Terms of Service.</a> </label>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-md-12">
                            <input type="button" value="创建帐户" class="btn btn-info" ng-click="reg();">
                            <a href="login.jsp" class="pull-right">登录</a>
                        </div>
                    </div>	
                </div>				    	
            </form>		      
        </div>
    </div>
    <!-- Modal -->
    <div class="modal fade" id="templatemo_modal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
                    <h4 class="modal-title" id="myModalLabel">Terms of Service</h4>
                </div>
                <div class="modal-body">
                    <p>This form is provided by <a rel="nofollow" href="http://www.cssmoban.com/page/1">Free HTML5 Templates</a> that can be used for your websites. Cras mattis consectetur purus sit amet fermentum. Cras justo odio, dapibus ac facilisis in, egestas eget quam. Morbi leo risus, porta ac consectetur ac, vestibulum at eros.</p>
                    <p>Praesent commodo cursus magna, vel scelerisque nisl consectetur et. Vivamus sagittis lacus vel augue laoreet rutrum faucibus dolor auctor. Aenean lacinia bibendum nulla sed consectetur. Praesent commodo cursus magna, vel scelerisque nisl consectetur et. Donec sed odio dui. Donec ullamcorper nulla non metus auctor fringilla. Cras mattis consectetur purus sit amet fermentum. Cras justo odio, dapibus ac facilisis in, egestas eget quam.</p>
                    <p>Morbi leo risus, porta ac consectetur ac, vestibulum at eros. Praesent commodo cursus magna, vel scelerisque nisl consectetur et. Vivamus sagittis lacus vel augue laoreet rutrum faucibus dolor auctor.</p>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                </div>
            </div>
        </div>
    </div>
    <script type="text/javascript" src="js/jquery-1.11.1.min.js"></script>
    <script type="text/javascript" src="js/bootstrap.min.js"></script>
</body>
</html>