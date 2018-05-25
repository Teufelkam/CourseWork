var app = angular.module('demo',[]);

app.controller('ClinicSurveys',function ($http,$scope) {

    $scope.clinicSurveys = [];
    $http.get('/clinicSurveys/get').then(function (response) {
        //  $http.get('http://localhost:8080/api/students').then(function (response){
        $scope.clinicSurveys = response.data;
        //  console.log(response);
    });

    this.insertClinicSurvey = function add() {
        var history = document.getElementById("History").value;
        var doctor = document.getElementById("Doctor").value;
        var type = document.getElementById("Type").value;
        var date = document.getElementById("Date").value;
        var description = document.getElementById("Description").value;
        var req = {
            method: 'POST',
            url: '/clinicSurveys/insert',
            data: {
                clinicHistoryId: history,
                doctorId: doctor,
                type: type,
                date: date,
                description: description
            }
        };
        console.log(req);
        $http(req).then(function (resp) {
            console.log(resp);
            window.location.reload();
        })
    };

    this.startUpdatingClinicSurvey = function startUpdate(id, historyId, doctorId, type, date, description) {
        document.getElementById("IdUPD").value = id;
        document.getElementById("HistoryUPD").value = historyId;
        document.getElementById("DoctorUPD").value = doctorId;
        document.getElementById("TypeUPD").value = type;
        document.getElementById("DateUPD").value = date;
        document.getElementById("DescriptionUPD").value = description;
    };

    this.updateClinicSurvey = function update() {
        var id = document.getElementById("IdUPD").value;
        var history = document.getElementById("HistoryUPD").value;
        var doctor = document.getElementById("DoctorUPD").value;
        var type = document.getElementById("TypeUPD").value;
        var date = document.getElementById("DateUPD").value;
        var description = document.getElementById("DescriptionUPD").value;
        var req = {
            method: 'POST',
            url: '/clinicSurveys/update?id=' + id,
            data: {
                clinicHistoryId: history,
                doctorId: doctor,
                type: type,
                date: date,
                description: description
            }
        };
        console.log(req);
        $http(req).then(function (resp) {
            console.log(resp);
            window.location.reload();
        })
    };

    this.deleteClinicSurvey = function del(id) {
        $http.get('/clinicSurveys/delete?id=' + id).then(function () {
            window.location.reload();
        });
    };
});
