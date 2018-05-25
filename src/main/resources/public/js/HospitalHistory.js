var app = angular.module('demo',[]);

app.controller('HospitalHistories',function ($http,$scope) {

    $scope.hospitalHistories = [];
    $http.get('/hospitalHistories/get').then(function (response) {
        //  $http.get('http://localhost:8080/api/students').then(function (response){
        $scope.hospitalHistories = response.data;
        //  console.log(response);
    });

    this.insertHospitalHistory = function add() {
        var patient = document.getElementById("Patient").value;
        var hospital = document.getElementById("Hospital").value;
        var req = {
            method: 'POST',
            url: '/hospitalHistories/insert',
            data: {
                patientId: patient,
                hospitalId: hospital
            }
        };
        console.log(req);
        $http(req).then(function (resp) {
            console.log(resp);
            window.location.reload();
        })
    };

    this.startUpdatingHospitalHistory = function startUpdate(id, cabinetNumber, cabinetClinic, clinicId) {
        document.getElementById("CabinetIdUPD").value = id;
        document.getElementById("CabinetNumberUPD").value = cabinetNumber;
        document.getElementById("CabinetClinicUPD").value = cabinetClinic;
        clinic_id = clinicId;
    };

    this.updateHospitalHistory = function update() {
        var id = document.getElementById("CabinetIdUPD").value;
        var cabinetNumber = document.getElementById("CabinetNumberUPD").value;
        var req = {
            method: 'POST',
            url: '/hospitalHistories/update?id=' + id,
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

    this.deleteHospitalHistory = function del(id) {
        $http.get('/hospitalHistories/delete?id=' + id).then(function () {
            window.location.reload();
        });
    };
});
