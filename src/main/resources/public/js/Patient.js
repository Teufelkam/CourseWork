var app = angular.module('demo',[]);

app.controller('Patients',function ($http,$scope) {

    $scope.patients = [];
    $http.get('/patients/get').then(function (response) {
        //  $http.get('http://localhost:8080/api/students').then(function (response){
        $scope.patients = response.data;
        //  console.log(response);
    });

    this.insertPatient = function add() {
        var name = document.getElementById("Name").value;
        var surname = document.getElementById("Surname").value;
        var address = document.getElementById("Address").value;
        var req = {
            method: 'POST',
            url: '/patients/insert',
            data: {
                name: name,
                surname: surname,
                address: address
            }
        };
        console.log(req);
        $http(req).then(function (resp) {
            console.log(resp);
            window.location.reload();
        })
    };

    this.startUpdatingPatient = function startUpdate(id, name, surname, address, clinicDoctorId, hospitalDoctorId, cotId) {
        document.getElementById("IdUPD").value = id;
        document.getElementById("NameUPD").value = name;
        document.getElementById("SurnameUPD").value = surname;
        document.getElementById("CotUPD").value = cotId;
        document.getElementById("AddressUPD").value = address;
        document.getElementById("ClinicDoctorUPD").value = clinicDoctorId;
        document.getElementById("HospitalDoctorUPD").value = hospitalDoctorId;
    };

    this.updatePatient = function update() {
        var id = document.getElementById("IdUPD").value;
        var name = document.getElementById("NameUPD").value;
        var surname = document.getElementById("SurnameUPD").value;
        var cot = document.getElementById("CotUPD").value;
        var address =document.getElementById("AddressUPD").value;
        var clinicDoctor = document.getElementById("ClinicDoctorUPD").value;
        var hospitalDoctor = document.getElementById("HospitalDoctorUPD").value;
        var req = {
            method: 'POST',
            url: '/patients/update?id=' + id,
            data: {
                name: name,
                surname: surname,
                cotId: cot,
                address: address,
                clinicDoctorId: clinicDoctor,
                hospitalDoctorId: hospitalDoctor
            }
        };
        console.log(req);
        $http(req).then(function (resp) {
            console.log(resp);
            window.location.reload();
        })
    };

    this.deletePatient = function del(id) {
        $http.get('/patients/delete?id=' + id).then(function () {
            window.location.reload();
        });
    };
});
