var app = angular.module('demo',[]);

app.controller('Wards',function ($http,$scope) {

    $scope.wards = [];
    $http.get('/wards/get').then(function (response) {
        //  $http.get('http://localhost:8080/api/students').then(function (response){
        $scope.wards = response.data;
        //  console.log(response);
    });

    this.insertWard = function add() {
        var number = document.getElementById("Number").value;
        var department = document.getElementById("Department").value;
        var req = {
            method: 'POST',
            url: '/wards/insert',
            data: {
                number: number,
                departmentId: department,
            }
        };
        console.log(req);
        $http(req).then(function (resp) {
            console.log(resp);
            window.location.reload();
        })
    };

    this.startUpdatingWard = function startUpdate(id, departmentId, number) {
        document.getElementById("IdUPD").value = id;
        document.getElementById("DepartmentUPD").value = departmentId;
        document.getElementById("NumberUPD").value = number;
    };

    this.updateWard = function update() {
        var id = document.getElementById("IdUPD").value;
        var department = document.getElementById("DepartmentUPD").value;
        var number = document.getElementById("NumberUPD").value;
        var req = {
            method: 'POST',
            url: '/wards/update?id=' + id,
            data: {
                number: number,
                departmentId: department
            }
        };
        console.log(req);
        $http(req).then(function (resp) {
            console.log(resp);
            window.location.reload();
        })
    };

    this.deleteWard = function del(id) {
        $http.get('/wards/delete?id=' + id).then(function () {
            window.location.reload();
        });
    };
});
