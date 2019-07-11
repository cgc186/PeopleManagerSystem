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

    $scope.update = function (id) {
        var x = prompt("输入续签年数: ", "0");
        alert(x);
        var f = $http.post("/PeopleManagerSystem/labor_update?time=" + x + "&id=" + id);
        f.success(function (data) {//data代表服务器servlet返回的JSON对象(已将字符串转成JSON)
            if (data.msg === "success") {
                alert("续签成功");
                window.location.href = "/PeopleManagerSystem/labor_list.jsp";
            } else {
                alert("续签失败");
            }
        });
    };

    $scope.delete = function (id, eno, releaseTime) {
        if (releaseTime === "") {
            var uid = window.localStorage.getItem("uid");
            if (confirm("确实要解约吗？")) {
                var f = $http.post("/PeopleManagerSystem/labor_delete?id=" + id + "&eno=" + eno + "&uid=" + uid);
                f.success(function (data) {//data代表服务器servlet返回的JSON对象(已将字符串转成JSON)
                    if (data.msg === "success") {
                        alert("解约成功");
                        window.location.href = "/PeopleManagerSystem/labor_list.jsp";
                    } else {
                        alert("解约失败");
                    }
                });
            } else {
                alert("已经取消了删除操作");
            }
        }
        alert("该员工已不在员工列表中");

    };
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