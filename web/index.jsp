<%-- 
    Document   : index
    Created on : 2019-6-26, 15:40:19
    Author     : 98530
--%>

<!doctype html>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>  
<html class="no-js" lang="en">

    <head>
        <!-- meta data -->
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->

        <!--font-family-->


        <!-- title of site -->
        <title>Directory Landing Page</title>

        <!-- For favicon png -->
        <link rel="shortcut icon" type="image/icon" href="assets/logo/favicon.png"/>

        <!--font-awesome.min.css-->
        <link rel="stylesheet" href="assets/css/font-awesome.min.css">

        <!--linear icon css-->
        <link rel="stylesheet" href="assets/css/linearicons.css">

        <!--animate.css-->
        <link rel="stylesheet" href="assets/css/animate.css">

        <!--flaticon.css-->
        <link rel="stylesheet" href="assets/css/flaticon.css">

        <!--slick.css-->
        <link rel="stylesheet" href="assets/css/slick.css">
        <link rel="stylesheet" href="assets/css/slick-theme.css">

        <!--bootstrap.min.css-->
        <link rel="stylesheet" href="assets/css/bootstrap.min.css">

        <!-- bootsnav -->
        <link rel="stylesheet" href="assets/css/bootsnav.css" >	

        <!--style.css-->
        <link rel="stylesheet" href="assets/css/style.css">

        <!--responsive.css-->
        <link rel="stylesheet" href="assets/css/responsive.css">

        <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->

        <!--[if lt IE 9]>
                        <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
                        <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
        <![endif]-->

    </head>

    <body>
        <!--[if lte IE 9]>
    <p class="browserupgrade">You are using an <strong>outdated</strong> browser. Please <a href="https://browsehappy.com/">upgrade your browser</a> to improve your experience and security.</p>
<![endif]-->


        <!-- top-area Start -->
        <section class="top-area">
            <div class="header-area">
                <!-- Start Navigation -->
                <nav class="navbar navbar-default bootsnav  navbar-sticky navbar-scrollspy"  data-minus-value-desktop="70" data-minus-value-mobile="55" data-speed="1000">

                    <div class="container">

                        <!-- Start Header Navigation -->
                        <div class="navbar-header">
                            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#navbar-menu">
                                <i class="fa fa-bars"></i>
                            </button>
                            <a class="navbar-brand" href="index.html">list<span>race</span></a>

                        </div><!--/.navbar-header-->
                        <!-- End Header Navigation -->

                        <!-- Collect the nav links, forms, and other content for toggling -->
                        <div class="collapse navbar-collapse menu-ui-design" id="navbar-menu">
                            <ul class="nav navbar-nav navbar-right" data-in="fadeInDown" data-out="fadeOutUp">
                                <li class=" scroll active"><a href="#home">home</a></li>
                                <li ><a href="login.jsp">注销</a></li>
                                <li ><a href="register.jsp">注册</a></li>
                                <li><a href="#">修改密码</a></li>
                            </ul><!--/.nav -->
                        </div><!-- /.navbar-collapse -->
                    </div><!--/.container-->
                </nav><!--/nav-->
                <!-- End Navigation -->
            </div><!--/.header-area-->
            <div class="clearfix"></div>

        </section><!-- /.top-area-->
        <!-- top-area End -->

        <!--welcome-hero start -->
        <section id="home" class="welcome-hero">
            <div class="container">
                <div class="welcome-hero-txt">
                    <h2>基础信息管理页面 </h2>
                    <p>
                        人工智能实训第四小组！！！ 
                    </p>
                </div>
                <div class="welcome-hero-serch-box">
                    <div class="welcome-hero-form">
                        <div class="single-welcome-hero-form">
                            <h3>what?</h3>
                            <form action="index.html">
                                <input type="text" placeholder="Ex: palce, resturent, food, automobile" />
                            </form>
                            <div class="welcome-hero-form-icon">
                                <i class="flaticon-list-with-dots"></i>
                            </div>
                        </div>
                        <div class="single-welcome-hero-form">
                            <h3>location</h3>
                            <form action="index.html">
                                <input type="text" placeholder="Ex: london, newyork, rome" />
                            </form>
                            <div class="welcome-hero-form-icon">
                                <i class="flaticon-gps-fixed-indicator"></i>
                            </div>
                        </div>
                    </div>
                    <div class="welcome-hero-serch">
                        <button class="welcome-hero-btn" onclick="window.location.href = '#'">
                            search  <i data-feather="search"></i> 
                        </button>
                    </div>
                </div>
            </div>

        </section><!--/.welcome-hero-->
        <!--welcome-hero end -->

        <!--list-topics start -->
        <section id="list-topics" class="list-topics">
            <div class="container">
                <div class="list-topics-content">
                    <ul>
                        <li>
                            <div class="single-list-topics-content">
                                <div class="single-list-topics-icon">
                                    <i class="flaticon-restaurant"></i>
                                </div>
                                <h2><a href="Employees_listServlet?isQuit=${false}">在职员工信息管理</a></h2>
                                <p>150 listings</p>
                            </div>
                        </li>
                        <li>
                            <div class="single-list-topics-content">
                                <div class="single-list-topics-icon">
                                    <i class="flaticon-travel"></i>
                                </div>
                                <h2><a href="Employees_listServlet?isQuit=${true}">离职员工信息管理</a></h2>
                                <p>214 listings</p>
                            </div>
                        </li>
                        <li>
                            <div class="single-list-topics-content">
                                <div class="single-list-topics-icon">
                                    <i class="flaticon-building"></i>
                                </div>
                                <h2><a href="Dept_listServlet">部门管理系统</a></h2>
                                <p>185 listings</p>
                            </div>
                        </li>
                        <li>
                            <div class="single-list-topics-content">
                                <div class="single-list-topics-icon">
                                    <i class="flaticon-pills"></i>
                                </div>
                                <h2><a href="dept_Settlement.jsp">部门结算系统</a></h2>
                                <p>200 listings</p>
                            </div>
                        </li>
                        <li>
                            <div class="single-list-topics-content">
                                <div class="single-list-topics-icon">
                                    <i class="flaticon-pills"></i>
                                </div>
                                <h2><a href="basic_listServlet?type=culture">文化程度管理系统</a></h2>
                                <p>200 listings</p>
                            </div>
                        </li>
                        <li>
                            <div class="single-list-topics-content">
                                <div class="single-list-topics-icon">
                                    <i class="flaticon-pills"></i>
                                </div>
                                <h2><a href="basic_listServlet?type=national">民族信息管理系统</a></h2>
                                <p>200 listings</p>
                            </div>
                        </li>
                        <li>
                            <div class="single-list-topics-content">
                                <div class="single-list-topics-icon">
                                    <i class="flaticon-pills"></i>
                                </div>
                                <h2><a href="basic_listServlet?type=categories">职务信息管理系统</a></h2>
                                <p>200 listings</p>
                            </div>
                        </li>
                        <li>
                            <div class="single-list-topics-content">
                                <div class="single-list-topics-icon">
                                    <i class="flaticon-transport"></i>
                                </div>
                                <h2><a href="List_Servlet">管理员信息管理</a></h2>
                                <p>120 listings</p>
                            </div>
                        </li>
                    </ul>
                </div>
            </div><!--/.container-->
        </section><!--/.list-topics-->
        <!--list-topics end-->
       

        <!-- Include all js compiled plugins (below), or include individual files as needed -->

        <script src="assets/js/jquery.js"></script>

        <!--modernizr.min.js-->
        <script src="https://cdnjs.cloudflare.com/ajax/libs/modernizr/2.8.3/modernizr.min.js"></script>

        <!--bootstrap.min.js-->
        <script src="assets/js/bootstrap.min.js"></script>

        <!-- bootsnav js -->
        <script src="assets/js/bootsnav.js"></script>

        <!--feather.min.js-->
        <script  src="assets/js/feather.min.js"></script>

        <!-- counter js -->
        <script src="assets/js/jquery.counterup.min.js"></script>
        <script src="assets/js/waypoints.min.js"></script>

        <!--slick.min.js-->
        <script src="assets/js/slick.min.js"></script>

        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.4.1/jquery.easing.min.js"></script>

        <!--Custom JS-->
        <script src="assets/js/custom.js"></script>

    </body>

</html>