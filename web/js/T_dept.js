var a = angular.module("dept", []);

a.controller("addctrl", function ($scope, $http) {
    $scope.dept = {
        dno: "",
        dname: "",
        dtype: "",
        dcost: "",
        dinsurance: ""
    };
    $scope.cc = function () {
        if ($scope.dept.dno === "") {
            alert("必须填写部门编号！");
            return false;
        }
        if ($scope.dept.dname === "") {
            alert("必须填写部门名称！");
            return false;
        }
        if ($scope.dept.dtype === "") {
            alert("必须填写部门类型");
            return false;
        }
        if ($scope.dept.dcost === "") {
            alert("必须填写部门花销");
            return false;
        }
        if ($scope.dept.dinsurance === "") {
            alert("必须填写保险基数");
            return false;
        }
        //连接servlet,向服务器发送request请求
        var f = $http({
            url: "Dept_addServlet",
            method: "post",
            params: $scope.dept
        });
        //接收服务器servlet返回结果
        f.success(function (data) {//data代表服务器servlet返回的JSON对象(已将字符串转成JSON)
            if (data.msg === "success") {

                alert("添加成功");
                window.location.href = "/PeopleManagerSystem/dept_list.jsp";

            } else {
                alert("添加失败");
            }
        });
    };

});

a.controller("upctrl", function ($scope, $http) {
    $scope.dept = {
        dno: "",
        dname: "",
        dtype: "",
        dcost: "",
        dinsurance: ""
    };
    
    $scope.getl = function () {
        var dno = window.localStorage.getItem("dno");
        var f = $http.get("Dept_updateServlet?dno=" + dno);
        //接收服务器servlet返回结果
        f.success(function (data) {//data代表服务器servlet返回的JSON对象(已将字符串转成JSON)
            $scope.dept = data;
        });
    };
    $scope.getl();
    $scope.cc = function () {
        if ($scope.dept.dno === "") {
            alert("必须填写部门编号！");
            return false;
        }
        if ($scope.dept.dname === "") {
            alert("必须填写部门名称！");
            return false;
        }
        if ($scope.dept.dtype === "") {
            alert("必须填写部门类型");
            return false;
        }
        if ($scope.dept.dcost === "") {
            alert("必须填写部门花销");
            return false;
        }
        if ($scope.dept.dinsurance === "") {
            alert("必须填写保险基数");
            return false;
        }
        //连接servlet,向服务器发送request请求
        var f = $http({
            url: "Dept_updateServlet",
            method: "post",
            params: $scope.dept
        });
        //接收服务器servlet返回结果
        f.success(function (data) {//data代表服务器servlet返回的JSON对象(已将字符串转成JSON)
            if (data.msg === "success") {

                alert("更新成功！");
                window.location.href = "/PeopleManagerSystem/dept_list.jsp";

            } else {
                alert("更新失败！");
            }
        });
    };

});

a.controller("listctrl", function ($scope, $http) {
    $scope.dept = [];
    $scope.init1 = function () {
        var f = $http.get("Dept_listServlet");
        f.success(function (data) {
            $scope.dept = data;
        });
    };
    $scope.init1();
    $scope.up = function (dno) {
        window.localStorage.setItem("dno", dno);
        window.location.href = "dept_update.jsp";
    };
    $scope.delete = function (dno) {
        var f = $http.get("/PeopleManagerSystem/Dept_deleServlet?dno=" + dno);
        alert("删除成功");
        window.location.href = "dept_list.jsp";
    };
    $scope.numberup = function () {
        var f = $http.get("/PeopleManagerSystem/Dept_numberUpdate");
        alert("人数更新成功");
        window.location.href = "dept_list.jsp";
    };
});
