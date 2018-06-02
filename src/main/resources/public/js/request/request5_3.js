var app = angular.module("demo", [])

app.controller("AppCtrl", function ($http, $scope){

    $http.get('/doctors/get').then(function (response) {
        var doctors = response.data;
        var selector = document.getElementById("Doctor");
        $(selector).empty();
        for (var i = 0; i < doctors.length; i++) {
            var option = document.createElement("option");
            option.text = doctors[i].name + ' ' + doctors[i].surname;
            option.value = doctors[i].id;
            selector.add(option);
        }
    });

    var index;
    var doctorId = 1;
    $scope.request5_3 = [];
    $http.get('/request5_3?doctorId=' + doctorId).then(function (response){
        $scope.request5_3 = response.data;
        // console.log(response);
    });

    this.update_request = function add() {
        index = document.getElementById("Doctor").selectedIndex;
        doctorId = document.getElementById("Doctor").options[index].value;

        $http.get('/request5_3?doctorId=' + doctorId).then(function (response){
            $scope.request5_3=response.data;
        });
    };


});