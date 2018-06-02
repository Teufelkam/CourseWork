var app = angular.module("demo", [])

app.controller("AppCtrl", function ($http, $scope){

    $http.get('/clinics/get').then(function (response) {
        var clinics = response.data;
        var selector = document.getElementById("Clinic");
        $(selector).empty();
        for (var i = 0; i < clinics.length; i++) {
            var option = document.createElement("option");
            option.text = clinics[i].name;
            option.value = clinics[i].id;
            selector.add(option);
        }
    });

    var type=document.getElementById("TypeOfDoctor").value;
    var index;
    var clinic_id = 2;
    $scope.request1_2 = [];
    $http.get('/request1_2?type='+type + '&clinic_id=' + clinic_id).then(function (response){
        $scope.request1_2 = response.data;
        // console.log(response);
    });

    this.update_request = function add() {
        type = document.getElementById("TypeOfDoctor").value;
        index = document.getElementById("Clinic").selectedIndex;
        clinic_id = document.getElementById("Clinic").options[index].value;

        $http.get('/request1_2?type='+type + '&clinic_id=' + clinic_id).then(function (response){
            $scope.request1_2=response.data;
        });
    };


});