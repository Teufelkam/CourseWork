var app = angular.module('demo',[]);

app.controller('LaboratorySurveys',function ($http,$scope) {

    $scope.laboratorySurveys = [];
    $http.get('/laboratorySurveys/get').then(function (response) {
        //  $http.get('http://localhost:8080/api/students').then(function (response){
        $scope.laboratorySurveys = response.data;
        //  console.log(response);
    });

    this.insertLaboratorySurvey = function add() {
        var hospital = document.getElementById("Hospital").value;
        var laboratory = document.getElementById("Laboratory").value;
        var description = document.getElementById("Description").value;
        var type = document.getElementById("Type").value;
        var date = document.getElementById("Date").value;
        var req = {
            method: 'POST',
            url: '/laboratorySurveys/insert',
            data: {
                hospitalId: hospital,
                laboratoryId: laboratory,
                description: description,
                date: date,
                type: type
            }
        };
        console.log(req);
        $http(req).then(function (resp) {
            console.log(resp);
            window.location.reload();
        })
    };

    this.startUpdatingLaboratorySurvey = function startUpdate(id, laboratoryId, hospitalId, date, type, description) {
        document.getElementById("IdUPD").value = id;
        document.getElementById("LaboratoryUPD").value = laboratoryId;
        document.getElementById("HospitalUPD").value = hospitalId;
        document.getElementById("DateUPD").value = date;
        document.getElementById("TypeUPD").value = type;
        document.getElementById("DescriptionUPD").value = description;
    };

    this.updateLaboratorySurvey = function update() {
        var id = document.getElementById("IdUPD").value;
        var laboratory = document.getElementById("LaboratoryUPD").value;
        var hospital = document.getElementById("HospitalUPD").value;
        var date = document.getElementById("DateUPD").value;
        var type = document.getElementById("TypeUPD").value;
        var description = document.getElementById("DescriptionUPD").value;
        var req = {
            method: 'POST',
            url: '/laboratorySurveys/update?id=' + id,
            data: {
                laboratoryId: laboratory,
                hospitalId: hospital,
                date: date,
                type: type,
                description: description
            }
        };
        console.log(req);
        $http(req).then(function (resp) {
            console.log(resp);
            window.location.reload();
        })
    };

    this.deleteLaboratorySurvey = function del(id) {
        $http.get('/laboratorySurveys/delete?id=' + id).then(function () {
            window.location.reload();
        });
    };
});