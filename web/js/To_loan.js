var a = angular.module("ss", []);

a.controller("actrl", function ($scope, $http) {
    $scope.deptlist = [];
    $scope.employees = [];

    $scope.init = function () {
        var f = $http.get("Transfer?type=dept");
        
        f.success(function (data) {
            $scope.deptlist = data;
            
        });
    };

    $scope.init();

    $scope.x1 = "";

    $scope.$watch("x1", function (newvalue, oldvalue, scope) {
        var f = $http.get("Transfer?type=e&dno=" + newvalue);
        f.success(function (data) {
            $scope.employees = data;
        });

    });


});