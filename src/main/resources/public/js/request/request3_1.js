var app = angular.module("demo", [])

app.controller("AppCtrl", function ($http, $scope){
    var operationAmount = -1;

    $scope.request3_1 = [];
    $http.get('/request3_1?operationAmount='+operationAmount).then(function (response){
        $scope.request3_1 = response.data;
        // console.log(response);
    });

    this.update_request = function add() {
        operationAmount = document.getElementById("OperationAmount").value;
        $http.get('/request3_1?operationAmount='+operationAmount).then(function (response){
            $scope.request3_1=response.data;
            console.log(response);
        });
    };
});