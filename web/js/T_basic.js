var b = angular.module("basic", []);

b.controller("catrl", function ($scope, $http) {
    $scope.name = "";
    $scope.postAllowance = "";

    $scope.add = function () {

        if ($scope.name === "") {
            alert("必须填写名称！");
            return false;
        }
        if ($scope.postAllowance === "") {
            alert("必须填写薪资！");
            return false;
        }

        //连接servlet,向服务器发送request请求
        var f = $http.post("/PeopleManagerSystem/basic_addServlet?type=categories&name=" + $scope.name + "&postAllowance=" + $scope.postAllowance);
        //接收服务器servlet返回结果
        f.success(function (data) {//data代表服务器servlet返回的JSON对象(已将字符串转成JSON)
            if (data.msg === "success") {

                alert("插入成功");
                window.location.href = "/PeopleManagerSystem/basic_listServlet?type=categories";

            } else {
                alert("插入失败");
            }
        });
    };

});

b.controller("cultrl", function ($scope, $http) {
    $scope.name = "";

    $scope.addcul = function () {

        if ($scope.name === "") {
            alert("必须填写名称！");
            return false;
        } else {
            //连接servlet,向服务器发送request请求
            var f = $http.post("/PeopleManagerSystem/basic_addServlet?type=culture&name=" + $scope.name);
            //接收服务器servlet返回结果
            f.success(function (data) {//data代表服务器servlet返回的JSON对象(已将字符串转成JSON)
                if (data.msg === "success") {

                    alert("插入成功");
                    window.location.href = "/PeopleManagerSystem/basic_listServlet?type=culture";

                } else {
                    alert("插入失败");
                }
            });
        }
    };

});

b.controller("nationaltrl", function ($scope, $http) {
    $scope.name = "";

    $scope.addnational = function () {

        if ($scope.uname === "") {
            alert("必须填写名称！");
            return false;
        } else {
            //连接servlet,向服务器发送request请求
            var f = $http.post("/PeopleManagerSystem/basic_addServlet?type=national&name=" + $scope.name);
            //接收服务器servlet返回结果
            f.success(function (data) {//data代表服务器servlet返回的JSON对象(已将字符串转成JSON)
                if (data.msg === "success") {

                    alert("插入成功");
                    window.location.href = "/PeopleManagerSystem/basic_listServlet?type=national";

                } else {
                    alert("插入失败");
                }
            });
        }


    };

});