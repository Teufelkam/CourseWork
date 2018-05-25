var app = angular.module('demo',[]);

app.controller('Workers',function ($http,$scope) {

    $scope.workers = [];
    $http.get('/workers/get').then(function (response) {
        //  $http.get('http://localhost:8080/api/students').then(function (response){
        $scope.workers = response.data;
        //  console.log(response);
    });

    this.insertWorker = function add() {
        var name = document.getElementById("Name").value;
        var surname = document.getElementById("Surname").value;
        var specialization = document.getElementById("Specialization").value;
        var hospital = document.getElementById("Hospital").value;
        var clinic = document.getElementById("Clinic").value;
        var req = {
            method: 'POST',
            url: '/workers/insert',
            data: {
                name: name,
                surname: surname,
                type: specialization,
                hospitalId: hospital,
                clinicId: clinic
            }
        };
        console.log(req);
        $http(req).then(function (resp) {
            console.log(resp);
            window.location.reload();
        })
    };

    this.startUpdatingWorker = function startUpdate(id, name, surname, type, clinicId, hospitalId) {
        document.getElementById("IdUPD").value = id;
        document.getElementById("NameUPD").value = name;
        document.getElementById("SurnameUPD").value = surname;
        document.getElementById("SpecializationUPD").value = type;
        document.getElementById("ClinicUPD").value = clinicId;
        document.getElementById("HospitalUPD").value = hospitalId;
    };

    this.updateWorker = function update() {
        var id = document.getElementById("IdUPD").value;
        var name = document.getElementById("NameUPD").value;
        var surname = document.getElementById("SurnameUPD").value;
        var type = document.getElementById("SpecializationUPD").value;
        var clinic = document.getElementById("ClinicUPD").value;
        var hospital = document.getElementById("HospitalUPD").value;
        var req = {
            method: 'POST',
            url: '/workers/update?id=' + id,
            data: {
                name: name,
                surname: surname,
                type: type,
                clinicId: clinic,
                hospitalId: hospital
            }
        };
        console.log(req);
        $http(req).then(function (resp) {
            console.log(resp);
            window.location.reload();
        })
    };

    this.deleteWorker = function del(id) {
        $http.get('/workers/delete?id=' + id).then(function () {
            window.location.reload();
        });
    };
});
