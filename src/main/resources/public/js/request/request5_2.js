var app = angular.module("demo", [])

app.controller("AppCtrl", function ($http, $scope) {
    var hospital_id;
    var corps_id;
    var department_id;
    var ward_id;
    var cot_id;
    var index;

    function hospital() {
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
    }
    function corps() {
        $http.get('/corps/get').then(function (response) {
            console.log('LOLLL');
            var corps = response.data;
            var selector = document.getElementById("Corps");
            index = document.getElementById("Hospital").selectedIndex;
            hospital_id = document.getElementById("Hospital").options[index].value;

            console.log(index);
            $(selector).empty();
            for (var i = 0; i < corps.length; i++) {
                if(corps[i].hospitalId = hospital_id) {
                    var option = document.createElement("option");
                    option.text = corps[i].name;
                    option.value = corps[i].id;
                    selector.add(option);
                }
            }
        });
    }

    function department() {
        $http.get('/departments/get').then(function (response) {
            var departments = response.data;
            var selector = document.getElementById("Department");
            index = document.getElementById("Corps").selectedIndex;
            console.log(index);
            corps_id = document.getElementById("Corps").options[index].value;

            $(selector).empty();
            for (var i = 0; i < departments.length; i++) {
                if(departments[i].corpsId = corps_id) {
                    var option = document.createElement("option");
                    option.text = departments[i].type;
                    option.value = departments[i].id;
                    selector.add(option);
                }
            }
        });
    }
    function ward() {
        $http.get('/wards/get').then(function (response) {
            var wards = response.data;
            var selector = document.getElementById("Ward");
            index = document.getElementById("Department").selectedIndex;
            department_id = document.getElementById("Department").options[index].value;

            $(selector).empty();
            for (var i = 0; i < wards.length; i++) {
                if(wards[i].departmentId = department_id) {
                    var option = document.createElement("option");
                    option.text = wards[i].number;
                    option.value = wards[i].id;
                    selector.add(option);
                }
            }
        });
    }

    function cot() {
        $http.get('/cots/get').then(function (response) {
            var cots = response.data;
            var selector = document.getElementById("Cot");
            index = document.getElementById("Ward").selectedIndex;
            ward_id = document.getElementById("Ward").options[index].value;

            $(selector).empty();
            for (var i = 0; i < cots.length; i++) {
                if(cots[i].wardId = ward_id) {
                    var option = document.createElement("option");
                    option.text = cots[i].number;
                    option.value = cots[i].id;
                    selector.add(option);
                }
            }
        });
    }
    $('Hospital').onchange(corps());

    hospital();


    // $http.get('/departments/get').then(function (response) {
    //     var departments = response.data;
    //     var selector = document.getElementById("Departments");
    //     $(selector).empty();
    //     for (var i = 0; i < departments.length; i++) {
    //         if(departments[i].corpsId = corps_id) {
    //             var option = document.createElement("option");
    //             option.text = departments[i].name;
    //             option.value = departments[i].id;
    //             selector.add(option);
    //         }
    //     }
    // });
    // $scope.request5_2 = [];
    // $http.get('/request5_2?cot_id=' + cot_id).then(function (response){
    //     $scope.request5_2 = response.data;
    //     // console.log(response);
    // });
    //
    // this.update_request = function add() {
    //     index = document.getElementById("Hospital").selectedIndex;
    //     hospital_id = document.getElementById("Hospital").options[index].value;
    //
    //     $http.get('/request5_1?hospital_id=' + hospital_id).then(function (response){
    //         $scope.request5_2=response.data;
    //     });
    // };


});