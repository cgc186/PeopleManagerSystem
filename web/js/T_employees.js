var e = angular.module("employees", []);

e.controller("listctrl", function ($scope, $http) {
    $scope.uname = "";
    $scope.upwd = "";

    $scope.cc = function () {

        if ($scope.uname === "") {
            alert("必须填写用户名！");
            return false;
        }
        if ($scope.upwd === "") {
            alert("必须填写密码！");
            return false;
        }
        if ($scope.uname.length > 20 || $scope.uname.length < 1) {
            alert("用户名请输入1-20位字符");
            return false;
        }
        if ($scope.upwd.length > 20 || $scope.upwd.length < 1) {
            alert("密码请输入1-20位字符");
            return false;
        }

        //连接servlet,向服务器发送request请求
        var f = $http.get("/PeopleManagerSystem/login?uname=" + $scope.uname + "&upwd=" + $scope.upwd);
        //接收服务器servlet返回结果
        f.success(function (data) {//data代表服务器servlet返回的JSON对象(已将字符串转成JSON)
            if (data.msg === "success") {

                alert("登录成功");
                window.location.href = "/PeopleManagerSystem/index.jsp";

            } else {
                alert("登录失败");
            }
        });
    };

});

e.controller("addctrl", function ($scope, $http) {
    $scope.employee={
        eno:"",
        ename:"",
        esal:"",
        esex:"",
        eage:"",
        etel:"",
        enation:"",
        etype:"",
        ein_date:"",
        eculture:"",
        dno:""
    };
    
    $scope.add = function(){
        var f = $http({
            url:"Employees_addServlet?isQuit=false",
            method:"post",
            params:$scope.employee
        });
        //接收服务器servlet返回结果
        f.success(function (data) {//data代表服务器servlet返回的JSON对象(已将字符串转成JSON)
            if (data.msg === "success") {

                alert("插入成功");
                window.location.href = "Employees_listServlet";

            } else {
                alert("插入失败");
            }
        });
    };
});