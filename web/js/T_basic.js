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
                window.location.href = "categories_list.jsp";

            } else {
                alert("插入失败");
            }
        });
    };

    $scope.list = [];

    $scope.init = function () {
        //var uid=window.localStorage.getItem("uid");
        var f = $http.get("/PeopleManagerSystem/basic_listServlet?type=categories");
        //接收服务器servlet返回结果
        f.success(function (data) {//data代表服务器servlet返回的JSON对象(已将字符串转成JSON)
            $scope.list = data;
        });
    };

    $scope.init();
    
    $scope.delete = function (id) {
        var f = $http.get("/PeopleManagerSystem/categories_deleteServlet?id="+id);
        alert("删除成功");
        window.location.href = "categories_list.jsp";
    };
    
    $scope.update = function (id){
        window.localStorage.setItem("cadelid", id);
        window.location.href = "categories_update.jsp";
    };

});

b.controller("cadeltrl", function ($scope, $http) {
    $scope.id = "";
    $scope.jobTitle = "";
    $scope.postAllowance = "";

    $scope.init = function () {
        var id=window.localStorage.getItem("cadelid");
        var f = $http.get("/PeopleManagerSystem/categories_updateServlet?id=" + id);
        //接收服务器servlet返回结果
        f.success(function (data) {//data代表服务器servlet返回的JSON对象(已将字符串转成JSON)
            $scope.id = data.id;
            $scope.jobTitle = data.jobTitle;
            $scope.postAllowance = data.postAllowance;
        });
    };

    $scope.init();
    
    $scope.update = function(){
        var f = $http.post("/PeopleManagerSystem/categories_updateServlet?id=" + $scope.id
                +"&jobTitle="+$scope.jobTitle+"&postAllowance="+$scope.postAllowance);
        //接收服务器servlet返回结果
//        var f = $http({
//            url: "/PeopleManagerSystem/categories_updateServlet?id=" + id,
//            method: "post",
//            params: $scope.dept
//        });
        f.success(function (data) {//data代表服务器servlet返回的JSON对象(已将字符串转成JSON)
            if (data.msg === "success") {

                alert("更新成功");
                window.location.href = "categories_list.jsp";

            } else {
                alert("更新失败");
            }
        });
    }
});

b.controller("cultrl", function ($scope, $http) {
    $scope.name = "";

    $scope.add = function () {

        if ($scope.name === "") {
            alert("必须填写名称！");
            return false;
        }

        //连接servlet,向服务器发送request请求
        var f = $http.post("/PeopleManagerSystem/basic_addServlet?type=culture&name=" + $scope.name);
        //接收服务器servlet返回结果
        f.success(function (data) {//data代表服务器servlet返回的JSON对象(已将字符串转成JSON)
            if (data.msg === "success") {

                alert("插入成功");
                window.location.href = "culture_list.jsp";

            } else {
                alert("插入失败");
            }
        });
    };

    $scope.list = [];

    $scope.init = function () {
        //var uid=window.localStorage.getItem("uid");
        var f = $http.get("/PeopleManagerSystem/basic_listServlet?type=culture");
        //接收服务器servlet返回结果
        f.success(function (data) {//data代表服务器servlet返回的JSON对象(已将字符串转成JSON)
            $scope.list = data;
        });
    };

    $scope.init();

    $scope.update = function () {
        var f = $http.get("/PeopleManagerSystem/basic_updateServlet?type=culture");
        alert("人数已进行更新");
        window.location.href = "culture_list.jsp";
    };

});

b.controller("nationaltrl", function ($scope, $http) {
    $scope.name = "";

    $scope.add = function () {

        if ($scope.name === "") {
            alert("必须填写名称！");
            return false;
        }

        //连接servlet,向服务器发送request请求
        var f = $http.post("/PeopleManagerSystem/basic_addServlet?type=national&name=" + $scope.name);
        //接收服务器servlet返回结果
        f.success(function (data) {//data代表服务器servlet返回的JSON对象(已将字符串转成JSON)
            if (data.msg === "success") {

                alert("插入成功");
                window.location.href = "national_list.jsp";

            } else {
                alert("插入失败");
            }
        });
    };

    $scope.list = [];

    $scope.init = function () {
        //var uid=window.localStorage.getItem("uid");
        var f = $http.get("/PeopleManagerSystem/basic_listServlet?type=national");
        //接收服务器servlet返回结果
        f.success(function (data) {//data代表服务器servlet返回的JSON对象(已将字符串转成JSON)
            $scope.list = data;
        });
    };

    $scope.init();

    $scope.update = function () {
        var f = $http.get("/PeopleManagerSystem/basic_updateServlet?type=national");
        alert("人数已进行更新");
        window.location.href = "national_list.jsp";
    };
});