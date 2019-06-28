<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>  
<%@ page import="java.sql.*"%>    
<html>  
    <head>  
        <title>更新离职职工信息</title>
        <link href="css/font-awesome.min.css" rel="stylesheet" type="text/css">
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css">
        <link href="css/bootstrap-theme.min.css" rel="stylesheet" type="text/css">
        <link href="css/templatemo_style.css" rel="stylesheet" type="text/css">  
    </head>  
    <body class="templatemo-bg-image-2">
        <div class="container">
            <div class="col-md-12">			
                <form class="form-horizontal templatemo-contact-form-1" role="form" action="Employees_updateServlet?isQuit=${true}" method="post">
                    <div class="form-group">
                        <div class="col-md-12">
                            <h1 class="margin-bottom-15">更改职工信息</h1>
                        </div>
                    </div>				
                    <div class="form-group">
                        <div class="col-md-12">		          	
                            <label for="name" class="control-label">职工编号 *</label>
                            <div class="templatemo-input-icon-container">
                                <i class="fa fa-user"></i>
                                <input type="text" class="form-control" name="eno" readonly="readonly" value="${employees.eno}">
                            </div>		            		            		            
                        </div>              
                    </div>
                    <div class="form-group">
                        <div class="col-md-12">
                            <label for="email" class="control-label">姓名 *</label>
                            <div class="templatemo-input-icon-container">
                                <i class="fa fa-envelope-o"></i>
                                <input type="text" class="form-control" name="ename" value="${employees.ename}">
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-md-12">
                            <label for="website" class="control-label">工资*</label>
                            <div class="templatemo-input-icon-container">
                                <i class="fa fa-globe"></i>
                                <input type="text" class="form-control" name="esal" value="${employees.esal}">
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-md-12">
                            <label for="website" class="control-label">性别： </label></br>
                            <c:choose>
                                <c:when test="${employees.esex == "男"}">
                                    <label class="radio-inline">
                                        <input type="radio" name="esex" id="esex" value="男" checked="checked"> 男
                                    </label>
                                    <label class="radio-inline">
                                        <input type="radio" name="esex" id="esex" value="女"> 女
                                    </label>
                                </c:when>
                            </c:choose>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-md-12">
                            <label for="subject" class="control-label">年龄*</label>
                            <div class="templatemo-input-icon-container">
                                <i class="fa fa-info-circle"></i>
                                <input type="text" class="form-control" name="eage" value="${employees.eage}">
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-md-12">
                            <label for="message" class="control-label">联系电话 *</label>
                            <div class="templatemo-input-icon-container">
                                <i class="fa fa-pencil-square-o"></i>
                                <input type="text" class="form-control" name="etel" value="${employees.etel}">
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-md-12">
                            <label for="message" class="control-label">民族*</label>
                            <div class="templatemo-input-icon-container">
                                <i class="fa fa-pencil-square-o"></i>
                                <input type="text" class="form-control" name="enational" value="${employees.enational}">
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-md-12">
                            <label for="message" class="control-label">员工类型 *</label>
                            <div class="templatemo-input-icon-container">
                                <i class="fa fa-pencil-square-o"></i>
                                <input type="text" class="form-control" name="etype" value="${employees.etype}">
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-md-12">
                            <label for="message" class="control-label">离职时间*</label>
                            <div class="templatemo-input-icon-container">
                                <i class="fa fa-pencil-square-o"></i>
                                <input type="text" class="form-control" name="ein_date" value="${employees.eout_date}">
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-md-12">
                            <label for="message" class="control-label">学历 *</label>
                            <div class="templatemo-input-icon-container">
                                <i class="fa fa-pencil-square-o"></i>
                                <input type="text" class="form-control" name="eculture" value="${employees.eculture}">
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-md-12">
                            <label for="message" class="control-label">所属部门编号 *</label>
                            <div class="templatemo-input-icon-container">
                                <i class="fa fa-pencil-square-o"></i>
                                <input type="text" class="form-control" name="dno" value="${employees.dno}">
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-md-12">
                            <input type="submit" value="更改职工" class="btn btn-success pull-right">
                        </div>
                    </div>		    	
                </form>		      
            </div>
        </div>
    </body>
</html> 
