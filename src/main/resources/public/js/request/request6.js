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

    var index;
    var cotsAmount;
    var wardsAmount;
    var hospitalId = 1;
    $scope.request6 = [];
    $http.get('/request6?hospitalId=' + hospitalId).then(function (response){
        $scope.request6 = response.data;
        var hospital = response.data;
        for(var i = 0; i < hospital.corps.length; i++)
        {
            for(var j = 0; j < hospital.corps[i].departments.length; j++){
                wardsAmount+= hospital.corps[i].departments[j].wards.length;
                for(var k = 0; k < hospital.corps[i].departments[j].wards.length; k++)
                {
                    cotsAmount+= hospital.corps[i].departments[j].wards[k].cots.length;
                }
            }
        }
        console.log(wardsAmount);
        console.log(cotsAmount);
        document.getElementById("wardsAmount").value = wardsAmount;
        document.getElementById("cotsAmount").value = cotsAmount;

        // console.log(response);
    });

    this.update_request = function add() {
        index = document.getElementById("Hospital").selectedIndex;
        hospital_id = document.getElementById("Hospital").options[index].value;

        $http.get('/request6?hospitalId=' + hospitalId).then(function (response){
            $scope.request6=response.data;
            var hospital = response.data;
            for(var i = 0; i < hospital.corps.length; i++)
            {
                for(var j = 0; j < hospital.corps[i].departments.length; j++){
                    wardsAmount+= hospital.corps[i].departments[j].wards.length;
                    for(var k = 0; k < hospital.corps[i].departments[j].wards.length; k++)
                    {
                        cotsAmount+= hospital.corps[i].departments[j].wards[k].cots.length;
                    }
                }
            }
            document.getElementById("wardsAmount").value = wardsAmount;
            document.getElementById("cotsAmount").value = cotsAmount;
        });
    };


});