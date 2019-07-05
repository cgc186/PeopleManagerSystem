var a = angular.module("menu", []);

a.controller("mctrl", function ($scope, $http) {
    $scope.menus = [];
    $scope.test = "test";
    $scope.init = function () {
        //var uid=window.localStorage.getItem("uid");
        var uid = 1;
        var f = $http.get("/PeopleManagerSystem/T_menuServlet?uid=" + uid);
        //接收服务器servlet返回结果
        f.success(function (data) {//data代表服务器servlet返回的JSON对象(已将字符串转成JSON)
            $scope.menus = data;
        });
    };

    $scope.init();
});

a.controller("bctrl", function ($scope, $http) {

});