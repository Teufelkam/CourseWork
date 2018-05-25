var app = angular.module('demo',[]);

app.controller('Corps',function ($http,$scope) {

    $scope.corps = [];
    $http.get('/corps/get').then(function (response) {
        //  $http.get('http://localhost:8080/api/students').then(function (response){
        $scope.corps = response.data;
        //  console.log(response);
    });

    this.insertCorp = function add() {
        var corpNumber = document.getElementById("CorpNumber").value;
        var corpHospital = document.getElementById("CorpHospital").value;
        var req = {
            method: 'POST',
            url: '/corps/insert',
            data: {
                hospitalId: corpHospital,
                number: corpNumber
            }
        };
        console.log(req);
        $http(req).then(function (resp) {
            console.log(resp);
            window.location.reload();
        })
    };

    this.startUpdatingCorp = function startUpdate(id, number, hospitalId) {
        document.getElementById("IdUPD").value = id;
        document.getElementById("NumberUPD").value = number;
        document.getElementById("HospitalUPD").value = hospitalId;
    };

    this.updateCorp = function update() {
        var id = document.getElementById("IdUPD").value;
        var number = document.getElementById("NumberUPD").value;
        var hospitalId = document.getElementById("HospitalUPD").value;
        var req = {
            method: 'POST',
            url: '/corps/update?id=' + id,
            data: {
                number: number,
                hospitalId: hospitalId
            }
        };
        console.log(req);
        $http(req).then(function (resp) {
            console.log(resp);
            window.location.reload();
        })
    };

    this.deleteCorp = function del(id) {
        $http.get('/corps/delete?id=' + id).then(function () {
            window.location.reload();
        });
    };
});
