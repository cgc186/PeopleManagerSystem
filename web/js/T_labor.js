var l = angular.module("labor", []);

l.controller("listtrl", function ($scope, $http) {
    $scope.laborlist = [];

    $scope.init = function () {
        //var uid=window.localStorage.getItem("uid");
        var f = $http.post("/PeopleManagerSystem/labor_list");
        //接收服务器servlet返回结果
        f.success(function (data) {//data代表服务器servlet返回的JSON对象(已将字符串转成JSON)
            $scope.laborlist = data;
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
        if (releaseTime !== null) {
            alert("该员工已不在员工列表中");
            return false;
        }
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

    };
});


l.controller("addctrl", function ($scope, $http) {
    $scope.labor = {
        id: "",
        eno: "",
        category: "",
        dno: "",
        startTime: "",
        msal: "",
        endTime: ""
    };

    $scope.employeelist = [];
    $scope.categorieslist = [];
    $scope.deptlist = [];
    $scope.getALL = function () {
        var f = $http.get("labor_add");
        //接收服务器servlet返回结果
        f.success(function (data) {
            $scope.employeelist = data.employeeslist;
            $scope.categorieslist = data.categorieslist;
            $scope.deptlist = data.deptlist;
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
    $scope.$watch('labor.eno', function (newvalue, oldvalue, scope) {
        if (newvalue === oldvalue) {
        } else {
            var f = $http.get("getEdata?eno=" + $scope.labor.eno);
            f.success(function (data) {
                $scope.e = data;
                $scope.labor.category = $scope.e.etype;
                $scope.labor.dno = $scope.e.dno;
                $scope.labor.startTime = $scope.e.ein_date;
                $scope.labor.msal = $scope.e.esal;
            });
        }
    });

    $scope.add = function () {
        var f = $http({
            url: "labor_add",
            method: "post",
            params: $scope.labor
        });
        //接收服务器servlet返回结果
        f.success(function (data) {//data代表服务器servlet返回的JSON对象(已将字符串转成JSON)
            if (data.msg === "success") {

                alert("添加成功");
                window.location.href = "/PeopleManagerSystem/labor_list.jsp";

            } else if (data.msg === "notEmpty") {
                alert("该员工已有劳动合同");
            } else if (data.msg === "error") {
                alert("添加失败");
            }
        });
    };
});