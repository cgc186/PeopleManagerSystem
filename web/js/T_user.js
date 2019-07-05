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
        var f = $http.get("/PeopleManagerSystem/login?uname=" + $scope.uname + "&upwd=" + $scope.upwd);
        //接收服务器servlet返回结果
        f.success(function (data) {//data代表服务器servlet返回的JSON对象(已将字符串转成JSON)
            if (data.msg === "error") {
                alert("登录失败");
            } else {
                window.localStorage.setItem("uid", data.uid);
                window.localStorage.setItem("realname", data.realname);
                alert("登录成功,正在跳转......");
                window.location.href = "/PeopleManagerSystem/index/index.html"
                //window.location.href = "/PeopleManagerSystem/index.jsp";
                //window.location.href = "/PeopleManagerSystem/test/main.html";
            }
        });
    };

});

a.controller("bctrl", function ($scope, $http) {

});