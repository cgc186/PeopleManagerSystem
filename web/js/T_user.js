var a = angular.module("user", []);


a.controller("actrl", function ($scope, $http) {
    $scope.uname = "";
    $scope.upwd = "";

    $scope.cc = function () {

        if ($scope.uname === "") {
            alert("必须填写用户名！");
            return false;
        }
        if ($scope.upwd === "") {
            alert("必须填写密码！");
            return false;
        }
        if ($scope.uname.length > 20 || $scope.uname.length < 1) {
            alert("用户名请输入1-20位字符");
            return false;
        }
        if ($scope.upwd.length > 20 || $scope.upwd.length < 1) {
            alert("密码请输入1-20位字符");
            return false;
        }
        //连接servlet,向服务器发送request请求
        var f = $http.get("/PeopleManagerSystem/login_Servlet?uname=" + $scope.uname + "&upwd=" + $scope.upwd);
        //接收服务器servlet返回结果
        f.success(function (data) {//data代表服务器servlet返回的JSON对象(已将字符串转成JSON)
            if (data.msg === "error") {
                alert("登录失败");
            } else if (data.msg === "input") {
                alert("账号已登录");
            } else {
                window.localStorage.setItem("uid", data.uid);
                alert("登录成功,正在跳转......");
                window.location.href = "/PeopleManagerSystem/index/index.html";
            }
        });
    };

});


a.controller("regctl", function ($scope, $http) {
    $scope.uname = "";
    $scope.upwd = "";
    $scope.rupwd = ";";

    $scope.reg = function () {

        if ($scope.uname === "") {
            alert("必须填写用户名！");
            return false;
        }
        if ($scope.upwd === "" || $scope.rupwd === "") {
            alert("必须填写密码！");
            return false;
        }
        if ($scope.uname.length > 20 || $scope.uname.length < 1) {
            alert("用户名请输入1-20位字符");
            return false;
        }
        if ($scope.upwd.length > 20 || $scope.upwd.length < 1) {
            alert("密码请输入1-20位字符");
            return false;
        }
        if ($scope.rupwd.length > 20 || $scope.rupwd.length < 1) {
            alert("密码请输入1-20位字符");
            return false;
        }
        if ($scope.upwd !== $scope.rupwd) {
            alert("两次密码必须相等");
            return false;
        }
        //连接servlet,向服务器发送request请求
        var f = $http.get("/PeopleManagerSystem/Reg_Servlet?uname=" + $scope.uname + "&upwd=" + $scope.upwd);
        //接收服务器servlet返回结果
        f.success(function (data) {//data代表服务器servlet返回的JSON对象(已将字符串转成JSON)
            if (data.msg === "error") {
                alert("注册失败");
            } else if (data.msg === "input") {
                alert("账号已存在");
            } else {
                alert("注册成功,正在跳转......");
                window.location.href = "/PeopleManagerSystem/login.jsp";
            }
        });
    };
});