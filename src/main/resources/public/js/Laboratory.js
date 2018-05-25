var app = angular.module('demo',[]);

app.controller('Laboratories',function ($http,$scope) {

    $scope.laboratories = [];
    $http.get('/laboratories/get').then(function (response) {
        //  $http.get('http://localhost:8080/api/students').then(function (response){
        $scope.laboratories = response.data;
        //  console.log(response);
    });

    this.insertLaboratory = function add() {
        var type = document.getElementById("Type").value;
        var address = document.getElementById("Address").value;
        var req = {
            method: 'POST',
            url: '/laboratories/insert',
            data: {
                type: type,
                address: address
            }
        };
        console.log(req);
        $http(req).then(function (resp) {
            console.log(resp);
            window.location.reload();
        })
    };

    this.startUpdatingLaboratory = function startUpdate(id, address, type) {
        document.getElementById("IdUPD").value = id;
        document.getElementById("AddressUPD").value = address;
        document.getElementById("TypeUPD").value = type;
    };

    this.updateLaboratory = function update() {
        var id = document.getElementById("IdUPD").value;
        var address = document.getElementById("AddressUPD").value;
        var type = document.getElementById("TypeUPD").value;
        var req = {
            method: 'POST',
            url: '/laboratories/update?id=' + id,
            data: {
                type: type,
                address: address
            }
        };
        console.log(req);
        $http(req).then(function (resp) {
            console.log(resp);
            window.location.reload();
        })
    };

    this.deleteLaboratory = function del(id) {
        $http.get('/laboratories/delete?id=' + id).then(function () {
            window.location.reload();
        });
    };
});
