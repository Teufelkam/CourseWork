var app = angular.module("demo", [])

app.controller("AppCtrl", function ($http, $scope){

    $scope.requestOSAD = [];
    $http.get('/requestOSAD').then(function (response){
        $scope.requestOSAD = response.data;
        // console.log(response);
    });

});