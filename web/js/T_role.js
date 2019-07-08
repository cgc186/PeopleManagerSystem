var r = angular.module("role", []);
r.controller("rolelist", function ($scope, $http) {

    $scope.role = [];
    $scope.init1 = function () {
        var f = $http.get("Role_list");
        f.success(function (data) {
            $scope.role = data;
        });
    };
    $scope.init1();

    $scope.update = function (rid) {
        window.localStorage.setItem("rid", rid);
        window.location.href = "###.jsp";
    };

    $scope.delete = function (rid) {
        if (confirm("确实要删除吗？")) {
            var rid = window.localStorage.getItem("rid");
            var f = $http.get("/PeopleManagerSystem/Role_delete?rid=" +rid);
            
            alert("删除成功");
            window.location.href = "employees_list.jsp";
        } else {
            alert("已经取消了删除操作");
        }
    };

    $scope.sele = function (rid) {
        window.localStorage.setItem("rid", rid);
        window.location.href = "role_userlist.html";
    };
});

r.controller("addctrl", function ($scope, $http) {
    $scope.role = {
        rid: "",
        rolename: ""
    };
    $scope.cc = function () {
        if ($scope.role.rid === "") {
            alert("必须填写角色编号！");
            return false;
        }
        if ($scope.role.rolename === "") {
            alert("必须填写角色名称！");
            return false;
        }
        
        //连接servlet,向服务器发送request请求
        var f = $http({
            url: "Role_insert",
            method: "post",
            params: $scope.role
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


r.controller("update", function ($scope, $http) {
    $scope.menu = [];
    $scope.getl = function () {
        var rid = window.localStorage.getItem("rid");
        var f = $http.get("Role_update?rid=" + rid);
        f.success(function (data) {//data代表服务器servlet返回的JSON对象(已将字符串转成JSON)
            $scope.menu = data;
        });
    };
    $scope.getl();
});
r.controller("userlistbyrid", function ($scope, $http) {
    $scope.user = [];
    $scope.getl = function () {
        var rid = window.localStorage.getItem("rid");
        var f = $http.get("Role_userlist?rid=" + rid);
        f.success(function (data) {//data代表服务器servlet返回的JSON对象(已将字符串转成JSON)
            $scope.user = data;
        });
    };
    $scope.getl();
});


