var app = angular.module('demo',[]);

app.controller('Doctors',function ($http,$scope) {

    $scope.doctors = [];
    $http.get('/doctors/get').then(function (response) {
        //  $http.get('http://localhost:8080/api/students').then(function (response){
        $scope.doctors = response.data;
        //  console.log(response);
    });

    this.insertDoctor = function add() {
        var doctorName = document.getElementById("DoctorName").value;
        var doctorSurname = document.getElementById("DoctorSurname").value;
        var doctorType = document.getElementById("DoctorType").value;
        var doctorCareerStartYear = document.getElementById("DoctorCareerStartYear").value;
        var doctorScienceRank = document.getElementById("DoctorScienceRank").value;
        var req = {
            method: 'POST',
            url: '/doctors/insert',
            data: {
                name: doctorName,
                surname: doctorSurname,
                type: doctorType,
                careerStartYear: doctorCareerStartYear,
                scienceRank: doctorScienceRank
            }
        };
        console.log(req);
        $http(req).then(function (resp) {
            console.log(resp);
            window.location.reload();
        })
    };

    this.startUpdatingDoctor = function startUpdate(id, name, surname, type, scienceRank, careerStartYear) {
        document.getElementById("IdUPD").value = id;
        document.getElementById("NameUPD").value = name;
        document.getElementById("SurnameUPD").value = surname;
        document.getElementById("TypeUPD").value = type;
        document.getElementById("ScienceRankUPD").value = scienceRank;
        document.getElementById("CareerStartYearUPD").value = careerStartYear;
    };

    this.updateDoctor = function update() {
        var id = document.getElementById("IdUPD").value;
        var name = document.getElementById("NameUPD").value;
        var surname = document.getElementById("SurnameUPD").value;
        var type = document.getElementById("TypeUPD").value;
        var scienceRank = document.getElementById("ScienceRankUPD").value;
        var careerStartYear = document.getElementById("CareerStartYearUPD").value;
        var req = {
            method: 'POST',
            url: '/doctors/update?id=' + id,
            data: {
                name: name,
                surname: surname,
                type: type,
                scienceRank: scienceRank,
                careerStartYear: careerStartYear
            }
        };
        console.log(req);
        $http(req).then(function (resp) {
            console.log(resp);
            window.location.reload();
        })
    };

    this.deleteDoctor = function del(id) {
        $http.get('/doctors/delete?id=' + id).then(function () {
            window.location.reload();
        });
    };
});
