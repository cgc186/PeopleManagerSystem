var a = angular.module("user", []);

a.controller("actrl", function ($scope, $http) {
    $scope.uname = "";
    $scope.upwd = "";

    $scope.cc = function () {
        //连接servlet,向服务器发送request请求
        var f = $http.get("Login_Servlet?uname=" + $scope.uname + "&upwd=" + $scope.upwd);
        //接收服务器servlet返回结果
        f.success(function (data) {//data代表服务器servlet返回的JSON对象(已将字符串转成JSON)
            if (data.msg === "success") {
                var myurl = "index.jsp";
                window.location.assign(encodeURI(myurl));
                location.href="index.jsp";
            } else {
                alert("登录失败");
            }
        });
    };

});

a.controller("bctrl", function ($scope, $http) {

});