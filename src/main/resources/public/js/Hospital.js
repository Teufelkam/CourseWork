var app = angular.module('demo',[]);

app.controller('Hospitals',function ($http,$scope) {

    $scope.hospitals = [];
    $http.get('/hospitals/get').then(function (response) {
        //  $http.get('http://localhost:8080/api/students').then(function (response){
        $scope.hospitals = response.data;
        //  console.log(response);
    });

    this.insertHospital = function add() {
        var name = document.getElementById("Name").value;
        var address = document.getElementById("Address").value;
        var req = {
            method: 'POST',
            url: '/hospitals/insert',
            data: {
                name: name,
                address: address
            }
        };
        console.log(req);
        var time = performance.now();
        $http(req).then(function (resp) {
            time = performance.now() - time;
            console.log('Додавання нового запису = ', time);
            alert("--------");
            window.location.reload();
        })
    };

    this.startUpdatingHospital = function startUpdate(id, name, address) {
        document.getElementById("IdUPD").value = id;
        document.getElementById("NameUPD").value = name;
        document.getElementById("AddressUPD").value = address;
    };

    this.updateHospital = function update() {
        var id = document.getElementById("IdUPD").value;
        var name = document.getElementById("NameUPD").value;
        var address = document.getElementById("AddressUPD").value;
        var req = {
            method: 'POST',
            url: '/hospitals/update?id=' + id,
            data: {
                name: name,
                address: address
            }
        };
        var time = performance.now();
        console.log(req);
        $http(req).then(function (resp) {
            time = performance.now() - time;
            console.log('Оновлення запису = ', time);
            alert("--------");
            console.log(resp);
            window.location.reload();
        })
    };

    this.deleteHospital = function del(id) {
        var time = performance.now();
        $http.get('/hospitals/delete?id=' + id).then(function () {
            time = performance.now() - time;
            console.log('Видалення запису = ', time);
            alert("--------");
            window.location.reload();
        });
    };
});
