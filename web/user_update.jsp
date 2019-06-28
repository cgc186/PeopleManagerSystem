<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>  
<%@ page import="java.sql.*"%>
<!DOCTYPE html>
<html>  
    <head>  
        <title>更新管理员信息</title>
        <link href="css/font-awesome.min.css" rel="stylesheet" type="text/css">
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css">
        <link href="css/bootstrap-theme.min.css" rel="stylesheet" type="text/css">
        <link href="css/templatemo_style.css" rel="stylesheet" type="text/css">  
    </head>  
    <body class="templatemo-bg-image-2">

        <div class="container">
            <div class="col-md-12">			
                <form class="form-horizontal templatemo-contact-form-1" role="form" action="Update_Servlet" method="post">
                    <div class="form-group">
                        <div class="col-md-12">
                            <h1 class="margin-bottom-15">修改密码</h1>
                        </div>
                    </div>				
                    <div class="form-group">
                        <div class="col-md-12">		          	
                            <label for="name" class="control-label">管理员编号 </label>
                            <div class="templatemo-input-icon-container">
                                <i class="fa fa-user"></i>
                                <input type="text" class="form-control" name="userid" readonly="readonly" value="${admin.userid}">
                            </div>		            		            		            
                        </div>              
                    </div>

                    <div class="form-group">
                        <div class="col-md-12">		          	
                            <label for="name" class="control-label">用户名 </label>
                            <div class="templatemo-input-icon-container">
                                <i class="fa fa-user"></i>
                                <input type="text" class="form-control" name="username"  value="${admin.username}">
                            </div>		            		            		            
                        </div>              
                    </div>

                    <div class="form-group">
                        <div class="col-md-12">
                            <label for="email" class="control-label">密码 </label>
                            <div class="templatemo-input-icon-container">
                                <i class="fa fa-envelope-o"></i>
                                <input type="password" class="form-control" name="password">
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-md-12">
                            <input type="submit" value="修改密码" class="btn btn-success pull-right">
                        </div>
                    </div>		    	
                </form>		      
            </div>
        </div>
    </body>
</html> 


