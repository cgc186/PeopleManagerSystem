var l = angular.module("trans", []);

l.controller("transtrl", function ($scope, $http) {
    $scope.deptlist = [];
    $scope.employees = [];
    $scope.text = "eee";

    $scope.init = function () {
        var f = $http.get("Transfer?type=dept");

        f.success(function (data) {
            $scope.deptlist = data.deptlist;

        });
    };

    $scope.init();

    $scope.x1 = "0";
    $scope.x2 = "0";
    $scope.b2 = false;
    
    $scope.dno = "0";

    $scope.$watch("x1", function (newvalue, oldvalue, scope) {
        if (newvalue === "0") {
            $scope.b2 = false;
            $scope.x2 = "0";
        } else {
            var f = $http.get("Transfer?type=e&dno=" + newvalue);
            f.success(function (data) {
                $scope.employees = data.employees;
                $scope.b2 = true;
                $scope.x2 = "0";
            });
        }


    });
    
    $scope.trans = function() {
        if ($scope.x2 === "0") {
            alert("必须选择员工！");
            return false;
        }
        if ($scope.x1 === "" || $scope.dno === "0") {
            alert("必须选择部门！");
            return false;
        }
        var uid=window.localStorage.getItem("uid");
        
        var f = $http.post("/PeopleManagerSystem/Employee_transfer?eno=" + $scope.x2 + "&dno=" + $scope.dno+"&uid="+uid);

        f.success(function (data) {//data代表服务器servlet返回的JSON对象(已将字符串转成JSON)
            if (data.msg === "success") {

                alert("更新成功");
                window.location.href = "employees_list.jsp";

            } else {
                alert("更新失败");
            }
        });
    };


});

l.controller("listctrl", function ($scope, $http) {
    $scope.transfer = [];
    $scope.test = "22";
    $scope.init= function () {
        var f = $http.get("transfer_listServlet");
        f.success(function (data) {
            $scope.transfer = data;
        });
    };
    $scope.init();
});