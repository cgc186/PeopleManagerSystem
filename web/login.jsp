<%@page contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<%request.setCharacterEncoding("utf-8");%>

<!DOCTYPE html>
<head>
    <title>登录</title>
    <script>
        function validateForm() {
            var name = document.forms["longin"]["username"].value;
            if (name === "") {
                alert("必须填写用户名！");
                return false;
            }
            var pw = document.forms["longin"]["password"].value;
            if (pw === "") {
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
        }
    </script>
    <link href="css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css">
    <link href="css/bootstrap-theme.min.css" rel="stylesheet" type="text/css">
    <link href="css/bootstrap-social.css" rel="stylesheet" type="text/css">	
    <link href="css/templatemo_style.css" rel="stylesheet" type="text/css">	
</head>
<body class="templatemo-bg-image-1">
    <div class="container">
        <div class="col-md-12">			
            <form name="longin" class="form-horizontal templatemo-login-form-2" role="form" 
                  action="Login_Servlet" method="post" onsubmit="return validateForm()">
                <div class="row">
                    <div class="col-md-12">
                        <h1>登录页面</h1>
                    </div>
                </div>
                <div class="row">
                    <div class="templatemo-one-signin col-md-6">
                        <div class="form-group">
                            <div class="col-md-12">		          	
                                <label for="username" class="control-label">用户名</label>
                                <div class="templatemo-input-icon-container">
                                    <i class="fa fa-user"></i>
                                    <input type="text" class="form-control" name="username">
                                </div>		            		            		            
                            </div>              
                        </div>
                        <div class="form-group">
                            <div class="col-md-12">
                                <label for="password" class="control-label">密码</label>
                                <div class="templatemo-input-icon-container">
                                    <i class="fa fa-lock"></i>
                                    <input type="password" class="form-control" name="password">
                                </div>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-md-12">
                                <div class="checkbox">
                                    <label>
                                        <input type="checkbox"> 记住
                                    </label>
                                </div>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-md-12">
                                <input type="submit" value="登录" class="btn btn-warning">
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-md-12">
                                <a href="register.jsp" class="text-center">注册</a>
                            </div>
                        </div>
                    </div>
                    <div class="templatemo-other-signin col-md-6">
                        <label class="margin-bottom-15">
                            一键登录：
                        </label>
                        <a class="btn btn-block btn-social btn-facebook margin-bottom-15" href="face.jsp">
                             尝试人脸登录
                        </a>
                        <a class="btn btn-block btn-social btn-twitter margin-bottom-15">
                            <i class="fa fa-twitter"></i> Sign in with Twitter
                        </a>
                        <a class="btn btn-block btn-social btn-google-plus">
                            <i class="fa fa-google-plus"></i> Sign in with Google
                        </a>
                    </div>   
                </div>				 	
            </form>		      		      
        </div>
    </div>
</body>
</html>
