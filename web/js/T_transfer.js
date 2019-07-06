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

    $scope.x1 = "";

    $scope.$watch("x1", function (newvalue, oldvalue, scope) {
        var f = $http.get("Transfer?type=e&dno=" + newvalue);
        f.success(function (data) {
            $scope.employees = data.employees;
        });

    });


});