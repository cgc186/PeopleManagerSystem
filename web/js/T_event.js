var e = angular.module("event", []);

e.controller("etrl", function ($scope, $http) {
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

e.controller("search",function($scope, $http){
    $scope.eventlist = [];

    $scope.init = function () {
        //var uid=window.localStorage.getItem("uid");
        var f = $http.get("/PeopleManagerSystem/T_event_search");
        //接收服务器servlet返回结果
        f.success(function (data) {//data代表服务器servlet返回的JSON对象(已将字符串转成JSON)
            $scope.eventlist = data;
        });
    };

    $scope.init();
    
    $scope.begintime="";
    $scope.endtime="";
    
    $scope.event=[];
    
    $scope.search = function () {
        if ($scope.begintime === "") {
            alert("必须填写起始时间！");
            return false;
        }
        if ($scope.endtime === "") {
            alert("必须填写末尾时间！");
            return false;
        }
        
        //var uid=window.localStorage.getItem("uid");
        var f = $http.post("/PeopleManagerSystem/T_event_search?begintime="+$scope.begintime+"&endtime="+$scope.endtime);
        //接收服务器servlet返回结果
        f.success(function (data) {//data代表服务器servlet返回的JSON对象(已将字符串转成JSON)
            $scope.event = data;
        });
    };
});