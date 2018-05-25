var app = angular.module('demo',[]);

app.controller('ClinicHistories',function ($http,$scope) {

    $scope.clinicHistories = [];
    $http.get('/clinicHistories/get').then(function (response) {
        //  $http.get('http://localhost:8080/api/students').then(function (response){
        $scope.clinicHistories = response.data;
        //  console.log(response);
    });

    this.insertClinicHistory = function add() {
        var historyClinic = document.getElementById("HistoryClinic").value;
        var historyPatient = document.getElementById("HistoryPatient").value;
        var req = {
            method: 'POST',
            url: '/clinicHistories/insert',
            data: {
                patientId: historyPatient,
                clinicId: historyClinic
            }
        };
        console.log(req);
        $http(req).then(function (resp) {
            console.log(resp);
            window.location.reload();
        })
    };

    this.startUpdatingClinicHistory = function startUpdate(id, cabinetNumber, cabinetClinic, clinicId) {
        document.getElementById("CabinetIdUPD").value = id;
        document.getElementById("CabinetNumberUPD").value = cabinetNumber;
        document.getElementById("CabinetClinicUPD").value = cabinetClinic;
        clinic_id = clinicId;
    };

    this.updateClinicHistory = function update() {
        var id = document.getElementById("CabinetIdUPD").value;
        var cabinetNumber = document.getElementById("CabinetNumberUPD").value;
        var req = {
            method: 'POST',
            url: '/clinicHistories/update?id=' + id,
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

    this.deleteClinicHistory = function del(id) {
        $http.get('/clinicHistories/delete?id=' + id).then(function () {
            window.location.reload();
        });
    };
});
