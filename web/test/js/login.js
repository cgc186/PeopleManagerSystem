var a=angular.module("log",[]);

a.controller("actrl",function($scope,$http){
    $scope.uname="";
    $scope.upwd="";

    $scope.cc=function(){
        //连接servlet，向服务器发送request请求
        var f=$http.get("login.jspx?uname="+$scope.uname+"&upwd="+$scope.upwd);
        //接收服务器servlet返回结果
        f.success(function(data){//data代表服务器servlet返回的JSON对象（已将字符串转换成JSON）
            if(data.msg=="error"){
                alert("登录失败");
            }else{
                window.localStorage.setItem("uid",data.uid);
                window.localStorage.setItem("realname",data.realname);
                alert("登录成功,正在跳转……");
                window.location.href="main.html";

            }
        });
    };

});


a.controller("bctrl",function($scope,$http){});