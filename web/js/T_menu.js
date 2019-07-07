var a = angular.module("menu", []);

a.controller("mctrl", function ($scope, $http) {
    $scope.fmenus = [];
    $scope.smenu = [];
    
    $scope.init = function () {
        var uid=window.localStorage.getItem("uid");
        var f = $http.get("/PeopleManagerSystem/T_menuServlet?uid="
                + uid +"&mid=0");
        //接收服务器servlet返回结果
        f.success(function (data) {
            $scope.fmenus = data;
        });
    };

    $scope.init();
    
    $scope.mid = "0";
    
    $scope.$watch("x1",);
});