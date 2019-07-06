var e = angular.module("employees", []);


e.controller("employ", function ($scope, $http) {
    $scope.employee = {
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

    $scope.employ = [];
    $scope.init1 = function () {
        var f = $http.get("Employees_listServlet?isQuit=false");
        f.success(function (data) {
            $scope.employ = data;
        });
    };
    $scope.init1();

    $scope.add = function () {
        var f = $http({
            url: "Employees_addServlet?isQuit=false",
            method: "post",
            params: $scope.employee
        });
        //接收服务器servlet返回结果
        f.success(function (data) {//data代表服务器servlet返回的JSON对象(已将字符串转成JSON)
            if (data.msg === "success") {

                alert("插入成功");
                window.location.href = "employees_list.jsp";

            } else {
                alert("插入失败");
            }
        });
    };
    $scope.update = function (eno) {
        window.localStorage.setItem("eno", eno);
        window.location.href = "employees_update.jsp";
    };

    $scope.delete = function (eno) {
        var f = $http.get("/PeopleManagerSystem/Employees_deleServlet?eno=" + eno);
        alert("删除成功");
        window.location.href = "employees_list.jsp";
    };

    $scope.trans = function (eno) {
        window.localStorage.setItem("eno", eno);
        window.location.href = "employees_transfer.jsp";
    }
});


e.controller("upctrl", function ($scope, $http) {
    $scope.employee = {
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

    $scope.nationlist = [];
    $scope.culturelist = [];
    $scope.categorieslist = [];
    $scope.deptlist = [];
    $scope.getl = function () {
        var eno = window.localStorage.getItem("eno");
        var f = $http.get("Employees_updateServlet?eno=" + eno + "&isQuit=" + false);
        //接收服务器servlet返回结果
        f.success(function (data) {//data代表服务器servlet返回的JSON对象(已将字符串转成JSON)
            $scope.nationlist = data.nationlist;
            $scope.culturelist = data.culturelist;
            $scope.categorieslist = data.categorieslist;
            $scope.deptlist = data.deptlist;
            $scope.employee = data.employ;

        });
    };

    $scope.getl();
    
    $scope.cul="";

    $scope.update = function () {

        var f = $http({
            url: "Employees_updateServlet?isQuit=false",
            method: "post",
            params: $scope.employee
        });
        //接收服务器servlet返回结果
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


e.controller("transferctrl", function ($scope, $http) {
    $scope.employee = {
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
    
    $scope.dno = "";

    $scope.deptlist = [];
    $scope.getl = function () {
        var eno = window.localStorage.getItem("eno");
        var f = $http.get("/PeopleManagerSystem/Employee_transfer?eno=" + eno);

        //接收服务器servlet返回结果
        f.success(function (data) {
            $scope.deptlist = data.deptlist;
            $scope.employee = data.employ;
            $scope.dno = $scope.employee.dno;
        });
    };

    $scope.getl();
    
    $scope.transfer = function () {
        alert();
        var f = $http.post("/PeopleManagerSystem/Employee_transfer?eno=" + $scope.employee.eno+"&dno="+$scope.dno);
        
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