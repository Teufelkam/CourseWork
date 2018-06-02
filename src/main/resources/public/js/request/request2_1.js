var app = angular.module("demo", [])

app.controller("AppCtrl", function ($http, $scope){
    var type='Прибиральниця';

    $scope.request2_1 = [];
    $http.get('/request2_1?type='+type).then(function (response){
        $scope.request2_1 = response.data;
        // console.log(response);
    });

    this.update_request = function add() {
        type = document.getElementById("TypeOfWorker").value;
        $http.get('/request2_1?type='+type).then(function (response){
            $scope.request2_1=response.data;
            console.log(response);
        });
    };
});