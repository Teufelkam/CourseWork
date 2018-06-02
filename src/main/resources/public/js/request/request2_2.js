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

    var type=document.getElementById("TypeOfWorker").value;
    var index;
    var hospital_id = 1;
    $scope.request2_2 = [];
    $http.get('/request2_2?type='+type + '&hospital_id=' + hospital_id).then(function (response){
        $scope.request2_2 = response.data;
        // console.log(response);
    });

    this.update_request = function add() {
        type = document.getElementById("TypeOfWorker").value;
        index = document.getElementById("Hospital").selectedIndex;
        hospital_id = document.getElementById("Hospital").options[index].value;

        $http.get('/request2_2?type='+type + '&hospital_id=' + hospital_id).then(function (response){
            $scope.request2_2=response.data;
        });
    };


});