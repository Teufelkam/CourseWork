var app = angular.module('demo',[]);

app.controller('Corps',function ($http,$scope) {

    $scope.cots = [];
    $http.get('/cots/get').then(function (response) {
        //  $http.get('http://localhost:8080/api/students').then(function (response){
        $scope.cots = response.data;
        //  console.log(response);
    });

    this.insertCot = function add() {
        var clinicName = document.getElementById("ClinicName").value;
        var clinicAddress = document.getElementById("ClinicAddress").value;
        var clinicHospital = document.getElementById("ClinicHospital").value;
        var req = {
            method: 'POST',
            url: '/cots/insert',
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

    this.startUpdatingCot = function startUpdate(id, cabinetNumber, cabinetClinic, clinicId) {
        document.getElementById("CabinetIdUPD").value = id;
        document.getElementById("CabinetNumberUPD").value = cabinetNumber;
        document.getElementById("CabinetClinicUPD").value = cabinetClinic;
        clinic_id = clinicId;
    };

    this.updateCot = function update() {
        var id = document.getElementById("CabinetIdUPD").value;
        var cabinetNumber = document.getElementById("CabinetNumberUPD").value;
        var req = {
            method: 'POST',
            url: '/cots/update?id=' + id,
            data: {
                number: cabinetNumber,
                clinic_id: clinic_id
            }
        };
        console.log(req);
        $http(req).then(function (resp) {
            console.log(resp);
            window.location.reload();
        })
    };

    this.deleteCot = function del(id) {
        $http.get('/cots/delete?id=' + id).then(function () {
            window.location.reload();
        });
    };
});
