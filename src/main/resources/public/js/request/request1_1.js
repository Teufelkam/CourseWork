var app = angular.module("demo", [])

app.controller("AppCtrl", function ($http, $scope){
    var type='SURGEON';

    $scope.request1_1 = [];
    $http.get('/request1_1?type='+type).then(function (response){
        $scope.request1_1 = response.data;
        // console.log(response);
    });

    this.update_request = function add() {
        type = document.getElementById("TypeOfDoctor").value;
        $http.get('/request1_1?type='+type).then(function (response){
            $scope.request1_1=response.data;
            console.log(response);
        });
    };
});