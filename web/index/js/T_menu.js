var a = angular.module("menu", []);

a.controller("mctrl", function ($scope, $http) {
    $scope.menus = [];
    $scope.index="";
    $scope.init = function () {
        var uid = window.localStorage.getItem("uid");
        var f = $http.get("/PeopleManagerSystem/T_menuServlet?uid=" + uid + "&mid=0");
        //接收服务器servlet返回结果
        f.success(function (data) {//data代表服务器servlet返回的JSON对象(已将字符串转成JSON)
            $scope.menus = data;
        });
    };

    $scope.init();

    $scope.setSid = function (sid) {
        alert(sid);
        window.localStorage.setItem("sid", sid);
    };
});

a.controller("sctrl", function ($scope, $http) {
    $scope.smenus = [];
    $scope.init = function () {
        var uid = window.localStorage.getItem("uid");
        var sid = window.localStorage.getItem("sid");
        var f = $http.get("/PeopleManagerSystem/T_menuServlet?uid=" + uid + "&mid="+sid);
        //接收服务器servlet返回结果
        f.success(function (data) {//data代表服务器servlet返回的JSON对象(已将字符串转成JSON)
            $scope.smenus = data;
        });
    };

    $scope.init();


});