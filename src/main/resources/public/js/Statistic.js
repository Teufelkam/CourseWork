var app = angular.module('demo',[]);

app.controller('Statistics',function ($http,$scope) {

    $scope.statistics = [];
    $http.get('/statistics/get').then(function (response) {
        //  $http.get('http://localhost:8080/api/students').then(function (response){
        $scope.statistics = response.data;
        //  console.log(response);
    });

    this.insertStatistic = function add() {
        var doctor = document.getElementById("Doctor").value;
        var operations = document.getElementById("Operations").value;
        var failedOperations = document.getElementById("FailedOperations").value;
        var req = {
            method: 'POST',
            url: '/statistics/insert',
            data: {
                doctorId: doctor,
                operationAmount: operations,
                failedOperationAmount: failedOperations
            }
        };
        console.log(req);
        $http(req).then(function (resp) {
            console.log(resp);
            window.location.reload();
        })
    };

    this.startUpdatingStatistic = function startUpdate(id, doctorId, operationAmount, failedOperationAmount) {
        document.getElementById("IdUPD").value = id;
        document.getElementById("DoctorUPD").value = doctorId;
        document.getElementById("OperationsUPD").value = operationAmount;
        document.getElementById("FailedOperationsUPD").value = failedOperationAmount;
    };

    this.updateStatistic = function update() {
        var id = document.getElementById("CabinetIdUPD").value;
        var cabinetNumber = document.getElementById("CabinetNumberUPD").value;
        var req = {
            method: 'POST',
            url: '/statistics/update?id=' + id,
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

    this.deleteStatistic = function del(id) {
        $http.get('/statistics/delete?id=' + id).then(function () {
            window.location.reload();
        });
    };
});
