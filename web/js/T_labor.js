var e = angular.module("labor", []);

e.controller("listtrl", function ($scope, $http) {
    $scope.eventlist = [];

    $scope.init = function () {
        //var uid=window.localStorage.getItem("uid");
        var f = $http.post("/PeopleManagerSystem/T_event_list");
        //接收服务器servlet返回结果
        f.success(function (data) {//data代表服务器servlet返回的JSON对象(已将字符串转成JSON)
            $scope.eventlist = data;
        });
    };

    $scope.init();

});