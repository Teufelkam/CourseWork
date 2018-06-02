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

    var type=document.getElementById("TypeOfDoctor").value;
    var index;
    var hospital_id = 1;
    $scope.request1_3 = [];
    $http.get('/request1_3?type='+type + '&hospital_id=' + hospital_id).then(function (response){
        $scope.request1_3 = response.data;
        // console.log(response);
    });

    this.update_request = function add() {
        type = document.getElementById("TypeOfDoctor").value;
        index = document.getElementById("Hospital").selectedIndex;
        hospital_id = document.getElementById("Hospital").options[index].value;

        $http.get('/request1_3?type='+type + '&hospital_id=' + hospital_id).then(function (response){
            $scope.request1_3=response.data;
        });
    };


});