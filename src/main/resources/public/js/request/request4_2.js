var app = angular.module("demo", [])

app.controller("AppCtrl", function ($http, $scope){

    $http.get('/hospitals/get').then(function (response) {
        var hospitals = response.data;
        var selector = document.getElementById("Hospital");
        $(selector).empty();
        for (var i = 0; i < hospitals.length; i++) {
            var option = document.createElement("option");
            option.text = hospitals[i].name;
            option.value = hospitals[i].id;
            selector.add(option);
        }
    });

    var scienceRank=document.getElementById("ScienceRank").value;
    var index;
    var hospital_id = 1;
    $scope.request4_2 = [];
    $http.get('/request4_2?scienceRank='+scienceRank + '&hospital_id=' + hospital_id).then(function (response){
        $scope.request4_2 = response.data;
        // console.log(response);
    });

    this.update_request = function add() {
        scienceRank = document.getElementById("ScienceRank").value;
        index = document.getElementById("Hospital").selectedIndex;
        hospital_id = document.getElementById("Hospital").options[index].value;

        $http.get('/request4_2?scienceRank='+scienceRank + '&hospital_id=' + hospital_id).then(function (response){
            $scope.request4_2=response.data;
        });
    };


});