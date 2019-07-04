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
                window.location.href = "/PeopleManagerSystem/Dept_listServlet";

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

                alert("添加成功");
                window.location.href = "/PeopleManagerSystem/Dept_listServlet";

            } else {
                alert("添加失败");
            }
        });
    };

});
a.controller("upctrl", function ($scope, $http) {
    f.success(function (data) {//data代表服务器servlet返回的JSON对象(已将字符串转成JSON)
            if (data.msg === "success") {

                alert("添加成功");
                window.location.href = "/PeopleManagerSystem/Dept_listServlet";

            } else {
                alert("添加失败");
            }
        });
});

