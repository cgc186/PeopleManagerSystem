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
        window.location.href = "role_update.html";
    };

    $scope.delete = function (rid) {
        if (confirm("确实要删除吗？")) {
            var f = $http.get("/PeopleManagerSystem/Role_delete?rid=" + rid);
            alert("删除成功");
            window.location.href = "role_list.html";
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
                window.location.href = "/PeopleManagerSystem/role_list.html";

            } else {
                alert("添加失败");
            }
        });
    };

});

//查看和更改角色所拥有的权限
r.controller("update", function ($scope, $http) {
    $scope.role_menu = [];
    $scope.all_menu = [];
    var rid = window.localStorage.getItem("rid");
    $scope.getl = function () {
        var f = $http.get("Role_update?rid=" + rid);
        f.success(function (data) {//data代表服务器servlet返回的JSON对象(已将字符串转成JSON)
            $scope.role_menu = data.role_menu;
            $scope.all_menu = data.all_menu;
        });
    };
    $scope.getl();
    $scope.delete = function (mid) {
        if (confirm("确实要删除吗？")) {
            var f = $http.get("Role_menudelete", {params: {
                    "rid": rid,
                    "mid": mid
                }});
            alert("删除成功");
            window.location.href = "role_update.html";
        } else {
            alert("已经取消了删除操作");
        }
    };

});
r.controller("addmenu", function ($scope, $http) {
    $scope.all_menu = [];
    $scope.getl = function () {
        var rid = window.localStorage.getItem("rid");
        var f = $http.get("Role_update?rid=" + rid);
        f.success(function (data) {//data代表服务器servlet返回的JSON对象(已将字符串转成JSON)
            $scope.all_menu = data.all_menu;
        });
    };
    $scope.getl();
    $scope.selected = [];
    var rid = window.localStorage.getItem("rid");
    $scope.cc = function () {
        //连接servlet,向服务器发送request请求
        var f = $http.get("Role_menuinsert", {params: {
                "rid": rid,
                "mid": $scope.selected
            }});
        //接收服务器servlet返回结果
        f.success(function (data) {//data代表服务器servlet返回的JSON对象(已将字符串转成JSON)
            if (data.msg === "success") {

                alert("添加成功");
                window.location.href = "/PeopleManagerSystem/role_update.html";

            } else {
                alert("添加失败");
            }
        });
    };
});
r.controller("adduser", function ($scope, $http) {
    $scope.user = [];
    $scope.getl = function () {
        var f = $http.get("Role_getalluser");
        f.success(function (data) {//data代表服务器servlet返回的JSON对象(已将字符串转成JSON)
            $scope.user = data;
        });
    };
    $scope.getl();
    $scope.selected = [];
    var rid = window.localStorage.getItem("rid");
    $scope.cc = function () {
        //连接servlet,向服务器发送request请求
        var f = $http.get("Role_userinsert", {params: {
                "rid": rid,
                "uid": $scope.selected
            }});
        //接收服务器servlet返回结果
        f.success(function (data) {//data代表服务器servlet返回的JSON对象(已将字符串转成JSON)
            if (data.msg === "success") {
                alert("添加成功");
                window.location.href = "/PeopleManagerSystem/role_userlist.html";
            } else {
                alert("添加失败");
            }
        });
    };
});



//得到角色下的所有用户
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
    $scope.delete = function (uid) {
        var rid = window.localStorage.getItem("rid");
        if (confirm("确实要删除吗？")) {
            var f = $http.get("Role_userdelete", {params: {
                    "rid": rid,
                    "uid": uid
                }});
            alert("删除成功");
            window.location.href = "role_userlist.html";
        } else {
            alert("已经取消了删除操作");
        }
    };
});


