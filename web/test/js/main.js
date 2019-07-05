var a=angular.module("main",[]);

a.controller("mctrl",function($scope,$http){
    $scope.menus=[];

    $scope.init1=function(){
        var uid=window.localStorage.getItem("uid");
        var f=$http.get("/PeopleManagerSystem/T_menuServlet?uid="+uid);
        f.success(function(data){
            $scope.menus=data;
        });
    };

    $scope.init1();

});