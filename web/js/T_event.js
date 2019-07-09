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

e.controller("search", function ($scope, $http) {
    $scope.time = [];
    $scope.type = [];

    $scope.init = function () {
        //var uid=window.localStorage.getItem("uid");
        var f = $http.get("/PeopleManagerSystem/T_event_search");
        //接收服务器servlet返回结果
        f.success(function (data) {//data代表服务器servlet返回的JSON对象(已将字符串转成JSON)
            $scope.time = data.time;
            $scope.type = data.type;
        });
    };

    $scope.init();

    $scope.begintime = "";
    $scope.endtime = "";
    $scope.type = "";

    $scope.c1 = true;
    $scope.c2 = true;

    $scope.event = [];

    $scope.search = function () {
        if ($scope.c1 === false && $scope.c2 === false) {
            alert("请至少选择一项");
            return false;
        }
        var url = "";

        if ($scope.c1 === true) {
            if ($scope.begintime === "") {
                alert("必须选择起始时间！");
                return false;
            }
            if ($scope.endtime === "") {
                alert("必须选择末尾时间！");
                return false;
            }
            var d1 = new Date(Date.parse($scope.begintime));
            var d2 = new Date(Date.parse($scope.endtime));

            if (d1 > d2) {
                alert("起始时间不能大于末尾时间！");
                return false;
            }
        }

        if ($scope.c2 === true) {
            if ($scope.type === "") {
                alert("必须选择类型！");
                return false;
            }
        }

        if ($scope.c1 === true && $scope.c2 === false) {
            url = "/PeopleManagerSystem/T_event_search?mode=1&begintime=" + $scope.begintime + "&endtime=" + $scope.endtime;
        } else if ($scope.c1 === false && $scope.c2 === false) {
            url = "/PeopleManagerSystem/T_event_search?mode=2&type=" + $scope.type;
        } else {
            url = "/PeopleManagerSystem/T_event_search?mode=3&begintime=" + $scope.begintime + "&endtime=" + $scope.endtime + "&type=" + $scope.type;
        }

        //var uid=window.localStorage.getItem("uid");
        var f = $http.post(url);
        //接收服务器servlet返回结果
        f.success(function (data) {//data代表服务器servlet返回的JSON对象(已将字符串转成JSON)
            $scope.event = data;
        });
    };
});