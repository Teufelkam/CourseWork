var app = angular.module("demo", [])

app.controller("AppCtrl", function ($http, $scope){
    var scienceRank='CANDIDATE';

    $scope.request4_1 = [];
    $http.get('/request4_1?scienceRank='+scienceRank).then(function (response){
        $scope.request4_1 = response.data;
        // console.log(response);
    });

    this.update_request = function add() {
        scienceRank = document.getElementById("ScienceRank").value;
        $http.get('/request4_1?scienceRank='+scienceRank).then(function (response){
            $scope.request4_1=response.data;
            console.log(response);
        });
    };
});