<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>  
<%@ page import="java.sql.*"%>  

<html>  
    <head>  
        <title>�����ְְ����Ϣ</title>
        <link href="css/font-awesome.min.css" rel="stylesheet" type="text/css">
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css">
        <link href="css/bootstrap-theme.min.css" rel="stylesheet" type="text/css">
        <link href="css/templatemo_style.css" rel="stylesheet" type="text/css"> 
    </head>  
    <body class="templatemo-bg-image-2">
        <div class="container">
            <div class="col-md-12">			
                <form class="form-horizontal templatemo-contact-form-1" role="form" action="Employees_addServlet?isQuit=${true}" method="post">
                    <div class="form-group">
                        <div class="col-md-12">
                            <h1 class="margin-bottom-15">���ְ����Ϣ</h1>
                        </div>
                    </div>				
                    <div class="form-group">
                        <div class="col-md-12">		          	
                            <label for="name" class="control-label">ְ����� *</label>
                            <div class="templatemo-input-icon-container">
                                <i class="fa fa-user"></i>
                                <input type="text" class="form-control" name="eno">
                            </div>		            		            		            
                        </div>              
                    </div>
                    <div class="form-group">
                        <div class="col-md-12">
                            <label for="email" class="control-label">���� *</label>
                            <div class="templatemo-input-icon-container">
                                <i class="fa fa-envelope-o"></i>
                                <input type="text" class="form-control" name="ename">
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-md-12">
                            <label for="website" class="control-label">����*</label>
                            <div class="templatemo-input-icon-container">
                                <i class="fa fa-globe"></i>
                                <input type="text" class="form-control" name="esal">
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-md-12">
                            <label for="website" class="control-label">�Ա� </label></br>
                            <label class="radio-inline">
                                <input type="radio" name="esex" value="��" checked="checked"> ��
                            </label>
                            <label class="radio-inline">
                                <input type="radio" name="esex" value="Ů"> Ů
                            </label>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-md-12">
                            <label for="subject" class="control-label">����*</label>
                            <div class="templatemo-input-icon-container">
                                <i class="fa fa-info-circle"></i>
                                <input type="text" class="form-control" name="eage">
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-md-12">
                            <label for="message" class="control-label">��ϵ�绰 *</label>
                            <div class="templatemo-input-icon-container">
                                <i class="fa fa-pencil-square-o"></i>
                                <input type="text" class="form-control" name="etel">
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-md-12">
                            <label for="message" class="control-label">����*</label>
                            <div class="templatemo-input-icon-container">
                                <i class="fa fa-pencil-square-o"></i>
                                <input type="text" class="form-control" name="enational">
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-md-12">
                            <label for="message" class="control-label">Ա������ *</label>
                            <div class="templatemo-input-icon-container">
                                <i class="fa fa-pencil-square-o"></i>
                                <input type="text" class="form-control" name="etype">
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-md-12">
                            <label for="message" class="control-label">��ְʱ��*</label>
                            <div class="templatemo-input-icon-container">
                                <i class="fa fa-pencil-square-o"></i>
                                <input type="text" class="form-control" name="eout_date">
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-md-12">
                            <label for="message" class="control-label">ѧ�� *</label>
                            <div class="templatemo-input-icon-container">
                                <i class="fa fa-pencil-square-o"></i>
                                <input type="text" class="form-control" name="eculture">
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-md-12">
                            <label for="message" class="control-label">�������ű�� *</label>
                            <div class="templatemo-input-icon-container">
                                <i class="fa fa-pencil-square-o"></i>
                                <input type="text" class="form-control" name="dno">
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-md-12">
                            <input type="submit" value="���ְ��" class="btn btn-success pull-right">
                        </div>
                    </div>		    	
                </form>		      
            </div>
        </div>
    </body>
</html>  