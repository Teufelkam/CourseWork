var app = angular.module('demo',[]);

app.controller('Clinics',function ($http,$scope) {

    $scope.clinics = [];
    $http.get('/clinics/get').then(function (response) {
        //  $http.get('http://localhost:8080/api/students').then(function (response){
        $scope.clinics = response.data;
        //  console.log(response);
    });

    this.insertClinic = function add() {
        var clinicName = document.getElementById("ClinicName").value;
        var clinicAddress = document.getElementById("ClinicAddress").value;
        var clinicHospital = document.getElementById("ClinicHospital").value;
        var req = {
            method: 'POST',
            url: '/clinics/insert',
            data: {
                name: clinicName,
                address: clinicAddress,
                hospitalId: clinicHospital
            }
        };
        console.log(req);
        $http(req).then(function (resp) {
            console.log(resp);
            window.location.reload();
        })
    };
    this.startUpdatingClinic = function startUpdate(id, name, address, hospitalId) {
        document.getElementById("IdUPD").value = id;
        document.getElementById("NameUPD").value = name;
        document.getElementById("AddressUPD").value = address;
        if (hospitalId != null) {
            document.getElementById("HospitalUPD").value = hospitalId;
        }
        else document.getElementById("HospitalUPD").value = null;
    };

    this.updateClinic = function update() {
        var id = document.getElementById("IdUPD").value;
        var name = document.getElementById("NameUPD").value;
        var address = document.getElementById("AddressUPD").value;
        var hospitalId = document.getElementById("HospitalUPD").value;
        var req = {
            method: 'POST',
            url: '/clinics/update?id=' + id,
            data: {
                name: name,
                address: address,
                hospitalId: hospitalId
            }
        };
        console.log(req);
        $http(req).then(function (resp) {
            console.log(resp);
            window.location.reload();
        })
    };

    this.deleteClinic = function del(id) {
        $http.get('/clinics/delete?id=' + id).then(function () {
            window.location.reload();
        });
    };
});

