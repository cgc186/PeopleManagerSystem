var s = angular.module("security", []);

s.controller("listtrl", function ($scope, $http) {
    $scope.securitylist = [];

    $scope.init = function () {
        //var uid=window.localStorage.getItem("uid");
        var f = $http.post("/PeopleManagerSystem/security_list");
        //接收服务器servlet返回结果
        f.success(function (data) {//data代表服务器servlet返回的JSON对象(已将字符串转成JSON)
            $scope.securitylist = data;
        });
    };

    $scope.init();

    

    
});


s.controller("addctrl", function ($scope, $http) {
    $scope.security = {
        id: "",
        name: "",
        eno: "",
        number: "",
        state: "",
        starttime: "",
        endtime: "",
        month: "",
        esal: ""
    };

    $scope.employeelist = [];
    $scope.getALL = function () {
        var f = $http.get("security_add");
        //接收服务器servlet返回结果
        f.success(function (data) {
            $scope.employeelist = data;
        });
    };

    $scope.getALL();

    $scope.e = {
        eno: "",
        ename: "",
        esal: "",
        esex: "",
        eage: "",
        etel: "",
        enational: "",
        etype: "",
        ein_date: "",
        eculture: "",
        dno: ""
    };
    $scope.$watch('security.eno', function (newvalue, oldvalue, scope) {
        if (newvalue === oldvalue) {
        } else {
            var f = $http.get("getEdata?eno=" + $scope.security.eno);
            f.success(function (data) {
                $scope.e = data;
                $scope.security.name = $scope.e.ename;
                $scope.security.esal = $scope.e.esal;
            });
        }
    });

    $scope.add = function () {
        
        var d1 = new Date(Date.parse($scope.security.starttime));
        var d2 = new Date(Date.parse($scope.security.endtime));

        var d3 = new Date(Date.parse("1999-01-01"));

        if (d3 > d1 || d3 > d2) {
            alert("时间不能小于1991-01-01！");
            return false;
        }

        if (d1 > d2) {
            alert("起保时间不能大于停保时间！");
            return false;
        }
        
        var f = $http({
            url: "security_add",
            method: "post",
            params: $scope.security
        });
        //接收服务器servlet返回结果
        f.success(function (data) {//data代表服务器servlet返回的JSON对象(已将字符串转成JSON)
            if (data.msg === "success") {

                alert("添加成功");
                window.location.href = "/PeopleManagerSystem/security_list.jsp";
            } else {
                alert("添加失败");
            }
        });
    };
});